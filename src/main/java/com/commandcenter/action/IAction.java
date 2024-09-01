package com.commandcenter.action;

import com.commandcenter.ICommandCenterDelegates;
import com.commandcenter.ICommandCenterModel;
import com.commandcenter.action.IProcessor.IConsumer;

public interface IAction {

    public static interface Lazy {
    }

    public static interface IUIAction<D extends ICommandCenterDelegates, M extends ICommandCenterModel<D>, I, O>
            extends IProcessor<D, M, I, O> {

        public static abstract class UIAction<D extends ICommandCenterDelegates, M extends ICommandCenterModel<D>, I, O>
                extends Processor<D, M, I, O> implements IUIAction<D, M, I, O> {

            public UIAction(M model) {
                super(model);
            }

        }

    }

    public static interface IUIDesignAction<D extends ICommandCenterDelegates, M extends ICommandCenterModel<D>, I, O>
            extends IProcessor<D, M, I, O> {
        public static abstract class UIDesignAction<D extends ICommandCenterDelegates, M extends ICommandCenterModel<D>, I, O>
                extends Processor<D, M, I, O> implements IUIDesignAction<D, M, I, O> {

            public UIDesignAction(M model) {
                super(model);
            }

        }

    }

    public static interface ICommandCenterAction<D extends ICommandCenterDelegates, M extends ICommandCenterModel<D>, I>
            extends IConsumer<D, M, I> {
        public static abstract class CommandCenterAction<D extends ICommandCenterDelegates, M extends ICommandCenterModel<D>, I>
                extends Consumer<D, M, I> implements ICommandCenterAction<D, M, I> {

            public CommandCenterAction(M model) {
                super(model);
            }

        }
    }

    public static interface IDataAction<D extends ICommandCenterDelegates, M extends ICommandCenterModel<D>, I, O>
            extends IProcessor<D, M, I, O> {

        public static abstract class DataAction<D extends ICommandCenterDelegates, M extends ICommandCenterModel<D>, I, O>
                extends Processor<D, M, I, O> implements IDataAction<D, M, I, O> {

            public DataAction(M model) {
                super(model);
            }

        }

    }
}
