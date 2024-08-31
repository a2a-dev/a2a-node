package com.commandcenter.action;

import com.commandcenter.ICommandCenterDelegates;
import com.commandcenter.ICommandCenterModel;

public abstract interface IConsumer<M extends ICommandCenterModel<? extends ICommandCenterDelegates>, I>
        extends IProcessor<M, I, Void> {
    public void consume(I input);

    @Override
    public default Void process(I input) {
        consume(input);
        return null;
    }

    public abstract static class Consumer<M extends ICommandCenterModel<? extends ICommandCenterDelegates>, I>
            extends Processor<M, I, Void>
            implements IConsumer<M, I> {
        public Consumer(M model) {
            super(model);
        }
    }
}