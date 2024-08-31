package com.commandcenter.action;

import com.commandcenter.ICommandCenterDelegates;
import com.commandcenter.ICommandCenterModel;

public interface IAction {

    public static interface DataDelegate<M extends ICommandCenterModel<? extends ICommandCenterDelegates>, I, O>
            extends IProcessor<M, I, O> {

    }

    public static interface UIDesignDelegate<M extends ICommandCenterModel<? extends ICommandCenterDelegates>, I, O>
            extends IProcessor<M, I, O> {

    }

    public static interface UIAction<M extends ICommandCenterModel<? extends ICommandCenterDelegates>, I, O>
            extends IProcessor<M, I, O> {

    }

    public static interface CommandCenterAction<M extends ICommandCenterModel<? extends ICommandCenterDelegates>, I, O>
            extends IProcessor<M, I, O> {

    }

}
