package com.commandcenter.action;

import java.util.Collection;
import java.util.Collections;

import com.commandcenter.IModel;
import com.commandcenter.IDelegates;

public interface IAction<D extends IDelegates, M extends IModel<D>, I, O>
        extends IProcessor<D, M, I, O> {

    @Override
    default public Collection<Class<? extends IProcessor<D, M, ?, ?>>> getProcessors() {
        return Collections.emptyList();
    }

    public static abstract class UIAction<D extends IDelegates, M extends IModel<D>, I, O>
            extends AProcessor<D, M, I, O> implements IAction<D, M, I, O> {

        public UIAction(M model) {
            super(model);
        }

    }

    public static interface IUIDesignAction<D extends IDelegates, M extends IModel<D>, I, O>
            extends IAction<D, M, I, O> {
        public static abstract class UIDesignAction<D extends IDelegates, M extends IModel<D>, I, O>
                extends AProcessor<D, M, I, O> implements IUIDesignAction<D, M, I, O> {

            public UIDesignAction(M model) {
                super(model);
            }
        }
    }

    public static interface ICommandCenterAction<D extends IDelegates, M extends IModel<D>, I>
            extends IConsumer<D, M, I>, IAction<D, M, I, Void> {
        public static abstract class CommandCenterAction<D extends IDelegates, M extends IModel<D>, I>
                extends AConsumer<D, M, I> implements ICommandCenterAction<D, M, I> {

            public CommandCenterAction(M model) {
                super(model);
            }
        }
    }

    public static interface IDataAction<D extends IDelegates, M extends IModel<D>, I, O>
            extends IAction<D, M, I, O> {

        public static abstract class DataAction<D extends IDelegates, M extends IModel<D>, I, O>
                extends AProcessor<D, M, I, O> implements IDataAction<D, M, I, O> {
            public DataAction(M model) {
                super(model);
            }
        }
    }
}
