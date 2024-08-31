package com.commandcenter.action;

import com.commandcenter.ICommandCenterDelegates;
import com.commandcenter.ICommandCenterModel;

public abstract interface IProducer<M extends ICommandCenterModel<? extends ICommandCenterDelegates>, O>
        extends IProcessor<M, Void, O> {
    public O produce();

    @Override
    public default O process(Void input) {
        return produce();
    }

    public abstract static class Producer<M extends ICommandCenterModel<? extends ICommandCenterDelegates>, O>
            extends Processor<M, Void, O>
            implements IProducer<M, O> {
        public Producer(M model) {
            super(model);
        }
    }
}