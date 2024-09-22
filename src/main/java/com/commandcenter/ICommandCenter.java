package com.commandcenter;

import com.commandcenter.action.IAction.ICommandCenterAction;

public interface ICommandCenter<D extends IDelegates, M extends IModel<D>, I>
        extends ICommandCenterAction<D, M, I> {

    public abstract static class CommandCenter<D extends IDelegates, M extends IModel<D>, I>
            extends AConsumer<D, M, I>
            implements ICommandCenter<D, M, I> {

        public CommandCenter(M model) {
            super(model);

        }

    }
}
