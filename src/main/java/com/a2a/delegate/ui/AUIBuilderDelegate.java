package com.a2a.delegate.ui;

import com.a2a.A2aCommandCenterModel;
import com.a2a.IA2aCCDelegates;
import com.commandcenter.action.IAction.IUIDesignAction;
import com.commandcenter.action.IProcessor.IHandler.Handler;

public abstract class AUIBuilderDelegate extends Handler<IA2aCCDelegates, A2aCommandCenterModel>
        implements IUIDesignAction<IA2aCCDelegates, A2aCommandCenterModel, Void, Void> {

    public AUIBuilderDelegate(A2aCommandCenterModel model) {
        super(model);
    }

    @Override
    public void handle() {
        getDelegates().getUIDelegate().createLayout();
    }

}