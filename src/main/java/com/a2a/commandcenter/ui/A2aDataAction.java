package com.a2a.commandcenter.ui;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.commandcenter.action.IAction.IDataAction.DataAction;

public abstract class A2aDataAction<I, O> extends DataAction<IA2aCCDelegates, A2aCommandCenterModel, I, O> {

    public A2aDataAction(A2aCommandCenterModel model) {
        super(model);
    }
}
