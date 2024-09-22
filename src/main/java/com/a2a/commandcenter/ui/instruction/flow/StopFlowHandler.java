package com.a2a.commandcenter.ui.instruction.flow;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.model.data.UIInstruction;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;

public class StopFlowHandler
        extends FlowHandler {

    public StopFlowHandler(A2aCommandCenterModel model) {

        super(model);

    }

    @Override
    public ActionResult process(UIInstruction input) {

        getModel().getControlBlocksByName().get(input.flowName).forEach(block -> {
            block.setTerminate(true);
        });

        ActionResult actionResult = getSuccessResult(input);
        return actionResult;

    }

}
