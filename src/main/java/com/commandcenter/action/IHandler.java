package com.commandcenter.action;

import com.commandcenter.ICommandCenterDelegates;
import com.commandcenter.ICommandCenterModel;

public interface IHandler<M extends ICommandCenterModel<? extends ICommandCenterDelegates>>
        extends IProcessor<M, Void, Void> {
    public void handle();

    @Override
    public default Void process(Void input) {
        handle();
        return null;
    }

    public abstract static class Handler<M extends ICommandCenterModel<? extends ICommandCenterDelegates>>
            extends Processor<M, Void, Void>
            implements IHandler<M> {
        public Handler(M model) {
            super(model);
        }
    }
}