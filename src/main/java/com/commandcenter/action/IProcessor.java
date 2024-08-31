package com.commandcenter.action;

import com.commandcenter.ICommandCenterDelegates;
import com.commandcenter.ICommandCenterModel;

public interface IProcessor<M extends ICommandCenterModel<? extends ICommandCenterDelegates>, I, O> {

    public M getModel();

    public O process(I input);

    public default <D extends ICommandCenterDelegates> D getDelegates() {
        if (getParent() != null) {
            return getParent().getDelegates();
        } else {
            throw new IllegalStateException("getDelegates() method is expected to be overridden in the root ");
        }
    }

    IProcessor<? extends ICommandCenterModel<? extends ICommandCenterDelegates>, ?, ?> getParent();

    public abstract static class Processor<M extends ICommandCenterModel<? extends ICommandCenterDelegates>, I, O>
            implements IProcessor<M, I, O> {

        private final M model;
        private IProcessor<M, ?, ?> parent;

        public Processor(M model) {
            this.model = model;
        }

        @Override
        public M getModel() {
            return model;
        }

        @Override
        public IProcessor<M, ?, ?> getParent() {
            return this.parent;
        }
    }
}
