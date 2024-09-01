package com.commandcenter.action;

import java.util.concurrent.CompletableFuture;

import com.commandcenter.ICommandCenterDelegates;
import com.commandcenter.ICommandCenterModel;

public interface IProcessor<D extends ICommandCenterDelegates, M extends ICommandCenterModel<D>, I, O> {

    public O process(I input);

    public default <P extends IProcessor<D, M, W, R>, W, R> CompletableFuture<R> go(Class<P> actionType) {
        return go(actionType, null);
    }

    public default <P extends IProcessor<D, M, W, R>, W, R> CompletableFuture<R> go(Class<P> actionType, W with) {
        return CompletableFuture.supplyAsync(() -> goSync(actionType, with));
    }

    public default <P extends IProcessor<D, M, W, R>, W, R> R goSync(Class<P> actionType) {
        return goSync(actionType, null);
    }

    public default <P extends IProcessor<D, M, W, R>, W, R> R goSync(Class<P> actionType, W with) {
        return getHandler(actionType).process(with);
    }

    public default D getDelegates() {
        if (getModel() != null) {
            return getParent().getDelegates();
        } else {
            throw new IllegalStateException("getDelegates() method is expected to be overridden in the root ");
        }
    }

    default <H extends IProcessor<D, M, ?, ?>> H getHandler(
            Class<H> clazz) {
        if (getParent() != null) {
            return getParent().getHandler(clazz);
        } else {
            throw new IllegalStateException("getDelegates() method is expected to be overridden in the root ");
        }
    }

    public default M getModel() {
        if (getParent() != null) {
            return getParent().getModel();
        } else {
            throw new IllegalStateException("getDelegates() method is expected to be overridden in the root ");
        }
    }

    IProcessor<D, M, ?, ?> getParent();

    default void setParent(IProcessor<D, M, ?, ?> parent) {
        if (getParent() != null) {
            throw new IllegalStateException("Parent is already set");
        }
    }

    public abstract static class AProcessor<D extends ICommandCenterDelegates, M extends ICommandCenterModel<D>, I, O>
            implements IProcessor<D, M, I, O> {

        private final M model;
        private IProcessor<D, M, ?, ?> parent;

        @Override
        public void setParent(IProcessor<D, M, ?, ?> parent) {
            // TODO Auto-generated method stub
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

    public static interface IHandler<D extends ICommandCenterDelegates, M extends ICommandCenterModel<D>>
            extends IConsumer<D, M, Void> {
        public void handle();

        @Override
        default void consume(Void input) {
            handle();
        }

        public abstract static class AHandler<D extends ICommandCenterDelegates, M extends ICommandCenterModel<D>>
                extends AProcessor<D, M, Void, Void>
                implements IHandler<D, M> {
            public AHandler(M model) {
                super(model);
            }
        }
    }

    public static interface IProducer<D extends ICommandCenterDelegates, M extends ICommandCenterModel<D>, O>
            extends IProcessor<D, M, Void, O> {
        public O produce();

        @Override
        public default O process(Void input) {
            return produce();
        }

        public abstract static class AProducer<D extends ICommandCenterDelegates, M extends ICommandCenterModel<D>, O>
                extends AProcessor<D, M, Void, O>
                implements IProducer<D, M, O> {
            public AProducer(M model) {
                super(model);
            }
        }
    }

    public static abstract interface IConsumer<D extends ICommandCenterDelegates, M extends ICommandCenterModel<D>, I>
            extends IProcessor<D, M, I, Void> {
        public void consume(I input);

        @Override
        public default Void process(I input) {
            consume(input);
            return null;
        }

        public abstract static class AConsumer<D extends ICommandCenterDelegates, M extends ICommandCenterModel<D>, I>
                extends AProcessor<D, M, I, Void>
                implements IConsumer<D, M, I> {
            public AConsumer(M model) {
                super(model);
            }
        }
    }
}
