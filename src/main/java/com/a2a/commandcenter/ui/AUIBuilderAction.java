package com.a2a.commandcenter.ui;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.commandcenter.action.IAction.IUIDesignAction.UIDesignAction;
import com.commandcenter.action.IProcessor.IHandler;

public class AUIBuilderAction extends UIDesignAction<IA2aCCDelegates, A2aCommandCenterModel, Void, Void>
        implements IHandler<IA2aCCDelegates, A2aCommandCenterModel> {

    public AUIBuilderAction(A2aCommandCenterModel model) {
        super(model);
    }

    @Override
    public void handle() {
        getDelegates().getUIDelegate().createLayout();
    }

}