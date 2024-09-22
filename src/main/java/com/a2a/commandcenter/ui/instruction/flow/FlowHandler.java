package com.a2a.commandcenter.ui.instruction.flow;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.model.data.UIInstruction;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.a2a.commandcenter.ui.A2aDataAction;

public abstract class FlowHandler extends A2aDataAction<UIInstruction, ActionResult> {
    public FlowHandler(A2aCommandCenterModel model) {
        super(model);

    }

    protected ActionResult getSuccessResult(UIInstruction input) {
        ActionResult actionResult = new ActionResult();
        actionResult.setActionName(input.flowName);
        actionResult.success = true;
        actionResult.requestId = input.requestId;
        actionResult.session = getModel().getSessionId();
        return actionResult;
    }
}