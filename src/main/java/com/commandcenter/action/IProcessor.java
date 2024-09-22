package com.commandcenter.action;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.logging.Level;

import com.commandcenter.IDelegates;
import com.commandcenter.IModel;

public interface IProcessor<D extends IDelegates, M extends IModel<D>, I, O> {

    O process(I input);

    Collection<Class<? extends IProcessor<D, M, ?, ?>>> getProcessors();

    default <P extends IProcessor<D, M, W, R>, W, R> CompletableFuture<R> go(Class<P> actionType) {
        return go(actionType, null);
    }

    default <P extends IProcessor<D, M, W, R>, W, R> CompletableFuture<R> go(Class<P> actionType, W with) {
        return go(actionType, with, false);
    }

    default <P extends IProcessor<D, M, W, R>, W, R> CompletableFuture<R> go(Class<P> actionType, W with,
            boolean expedite) {
        Executor executor = expedite ? getDelegates().getExpediteExecutor() : getDelegates().getExecutor();
        CompletableFuture<R> supplyAsync = CompletableFuture.supplyAsync(() -> goSync(actionType, with), executor);
        supplyAsync.exceptionally(
                (e) -> {
                    getDelegates().getLogger().log(Level.FINE,
                            "Exception in " + actionType.getName() + " " + e.getMessage());
                    e.printStackTrace();
                    return null;
                });
        getThreads().add(supplyAsync);
        return supplyAsync;
    }

    default Collection<CompletableFuture<?>> getThreads() {
        if (getParent() != null) {
            return getParent().getThreads();
        } else {
            throw new IllegalStateException("getThreads() method is expected to be overridden in the root ");
        }
    }

    default <P extends IProcessor<D, M, W, R>, W, R> R goSync(Class<P> actionType) {
        return goSync(actionType, null);
    }

    default <P extends IProcessor<D, M, W, R>, W, R> R goSync(Class<P> actionType, W with) {
        return getHandler(actionType).process(with);
    }

    default D getDelegates() {
        if (getModel() != null) {
            getDelegates().getLogger().log(Level.FINE,
                    "getDelegates() method is expected to be overridden in the root ");
            return getParent().getDelegates();
        } else {
            throw new IllegalStateException("getDelegates() method is expected to be overridden in the root ");
        }
    }

    default <H extends IProcessor<D, M, ?, ?>> H getHandler(
            Class<H> clazz) {
        if (getParent() != null) {
            getDelegates().getLogger().log(Level.FINE, "get Handler for " + clazz.getName());
            return getParent().getHandler(clazz);
        } else {
            throw new IllegalStateException("getHandler() method is expected to be overridden in the root ");
        }
    }

    default void register() {

    }

    default M getModel() {
        if (getParent() != null) {
            return getParent().getModel();
        } else {
            throw new IllegalStateException("getModel() method is expected to be overridden in the root ");
        }
    }

    IProcessor<D, M, ?, ?> getParent();

    default void setParent(IProcessor<D, M, ?, ?> parent) {
        if (getParent() != null) {
            throw new IllegalStateException("Parent is already set");
        }
    }

    public abstract static class AProcessor<D extends IDelegates, M extends IModel<D>, I, O>
            implements IProcessor<D, M, I, O> {

        private final M model;
        protected IProcessor<D, M, ?, ?> parent;

        @Override
        public void setParent(IProcessor<D, M, ?, ?> parent) {

            IProcessor.super.setParent(parent);
            this.parent = parent;
        }

        public AProcessor(M model) {
            this.model = model;
        }

        @Override
        public M getModel() {
            return model;
        }

        @Override
        public IProcessor<D, M, ?, ?> getParent() {
            return this.parent;
        }
    }

    public static interface IHandler<D extends IDelegates, M extends IModel<D>>
            extends IConsumer<D, M, Void> {
        public void handle();

        @Override
        default void consume(Void input) {
            handle();
        }

        public abstract static class AHandler<D extends IDelegates, M extends IModel<D>>
                extends AProcessor<D, M, Void, Void>
                implements IHandler<D, M> {
            public AHandler(M model) {
                super(model);
            }
        }
    }

    public static interface IProducer<D extends IDelegates, M extends IModel<D>, O>
            extends IProcessor<D, M, Void, O> {
        public O produce();

        @Override
        public default O process(Void input) {
            return produce();
        }

        public abstract static class AProducer<D extends IDelegates, M extends IModel<D>, O>
                extends AProcessor<D, M, Void, O>
                implements IProducer<D, M, O> {
            public AProducer(M model) {
                super(model);
            }
        }
    }

    public static abstract interface IConsumer<D extends IDelegates, M extends IModel<D>, I>
            extends IProcessor<D, M, I, Void> {
        public void consume(I input);

        @Override
        public default Void process(I input) {
            consume(input);
            return null;
        }

        public abstract static class AConsumer<D extends IDelegates, M extends IModel<D>, I>
                extends AProcessor<D, M, I, Void>
                implements IConsumer<D, M, I> {
            public AConsumer(M model) {
                super(model);
                getProcessors().stream().forEach(p -> getHandler(p));
            }
        }
    }

}
