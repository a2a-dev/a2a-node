package com.commandcenter;

import com.commandcenter.IWorkflowOrchestrator.ICommandCenterDelegates;
import com.commandcenter.IWorkflowOrchestrator.ICommandCenterModel;

public interface IProcessor<M extends ICommandCenterModel<? extends ICommandCenterDelegates>, A extends IAction, I, O> {

    public M getModel();

    public O process(I input);

    public default <D extends ICommandCenterDelegates> D getDelegates() {
        if (getParent() != null) {
            return getParent().getDelegates();
        } else {
            throw new IllegalStateException("getDelegates() method is expected to be overridden in the root ");
        }
    }

    IProcessor<? extends ICommandCenterModel<? extends ICommandCenterDelegates>, ?, ?, ?> getParent();

    public static class Processor<M extends ICommandCenterModel<? extends ICommandCenterDelegates>, A extends IAction, I, O>
            implements IProcessor<M, A, I, O> {

        private final M model;
        private IProcessor<M, ?, ?, ?> parent;

        public Processor(M model) {
            this.model = model;
        }

        @Override
        public M getModel() {
            return model;
        }

        @Override
        public O process(I input) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'process'");
        }

        @Override
        public IProcessor<M, ?, ?, ?> getParent() {
            return this.parent;
        }

    }

    public abstract static class Consumer<M extends ICommandCenterModel<? extends ICommandCenterDelegates>, A extends IAction, I>
            extends Processor<M, A, I, Void>
            implements IConsumer<M, A, I> {
        public Consumer(M model) {
            super(model);
        }
    }

    public abstract static interface IConsumer<M extends ICommandCenterModel<? extends ICommandCenterDelegates>, A extends IAction, I>
            extends IProcessor<M, A, I, Void> {
        public void consume(I input);

        @Override
        public default Void process(I input) {
            consume(input);
            return null;
        }
    }

    public abstract static class Producer<M extends ICommandCenterModel<? extends ICommandCenterDelegates>, A extends IAction, O>
            extends Processor<M, A, Void, O>
            implements IProducer<M, A, O> {
        public Producer(M model) {
            super(model);
        }
    }

    public abstract static interface IProducer<M extends ICommandCenterModel<? extends ICommandCenterDelegates>, A extends IAction, O>
            extends IProcessor<M, A, Void, O> {
        public O produce();

        @Override
        public default O process(Void input) {
            return produce();
        }
    }

    public static interface IHandler<M extends ICommandCenterModel<? extends ICommandCenterDelegates>, A extends IAction>
            extends IProcessor<M, A, Void, Void> {
        public void handle();

        @Override
        public default Void process(Void input) {
            handle();
            return null;
        }
    }

    public abstract static class Handler<M extends ICommandCenterModel<? extends ICommandCenterDelegates>, A extends IAction>
            extends Processor<M, A, Void, Void>
            implements IHandler<M, A> {
        public Handler(M model) {
            super(model);
        }
    }
}
