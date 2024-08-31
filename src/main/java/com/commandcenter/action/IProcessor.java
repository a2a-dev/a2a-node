package com.commandcenter.action;

import com.commandcenter.ICommandCenterDelegates;
import com.commandcenter.ICommandCenterModel;

public interface IProcessor<D extends ICommandCenterDelegates, M extends ICommandCenterModel<D>, I, O> {

    public O process(I input);

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

    public abstract static class Processor<D extends ICommandCenterDelegates, M extends ICommandCenterModel<D>, I, O>
            implements IProcessor<D, M, I, O> {

        private final M model;
        private IProcessor<D, M, ?, ?> parent;

        @Override
        public void setParent(IProcessor<D, M, ?, ?> parent) {
            // TODO Auto-generated method stub
            IProcessor.super.setParent(parent);
            this.parent = parent;
        }

        public Processor(M model) {
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

        public abstract static class Handler<D extends ICommandCenterDelegates, M extends ICommandCenterModel<D>>
                extends Processor<D, M, Void, Void>
                implements IHandler<D, M> {
            public Handler(M model) {
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

        public abstract static class Producer<D extends ICommandCenterDelegates, M extends ICommandCenterModel<D>, O>
                extends Processor<D, M, Void, O>
                implements IProducer<D, M, O> {
            public Producer(M model) {
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

        public abstract static class Consumer<D extends ICommandCenterDelegates, M extends ICommandCenterModel<D>, I>
                extends Processor<D, M, I, Void>
                implements IConsumer<D, M, I> {
            public Consumer(M model) {
                super(model);
            }
        }
    }
}
