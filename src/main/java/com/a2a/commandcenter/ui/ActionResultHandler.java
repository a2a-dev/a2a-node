package com.a2a.commandcenter.ui;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.a2a.commandcenter.model.data.UIInstruction.Rectangle;
import com.commandcenter.action.IAction.IUIAction.UIAction;

public class ActionResultHandler
        extends UIAction<IA2aCCDelegates, A2aCommandCenterModel, ActionResult, Rectangle> {

    public ActionResultHandler(A2aCommandCenterModel model) {
        super(model);

    }

    @Override
    public Rectangle process(ActionResult input) {

        throw new UnsupportedOperationException("Unimplemented method 'process'");
    }

}
