package com.a2a.commandcenter.ui.instruction.flow;

import java.util.List;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.model.data.UIInstruction;
import com.a2a.commandcenter.model.data.UIInstruction.A2aControlBlock;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.a2a.commandcenter.ui.instruction.action.ActionBlockHandler;

public class StartFlowHandler extends FlowHandler {

    public StartFlowHandler(A2aCommandCenterModel model) {
        super(model);
    }

    @Override
    public ActionResult process(UIInstruction input) {

        if (input.getControlBlocks() != null) {
            getModel().getControlBlocksByName().put(input.flowName, input.getControlBlocks());
        }

        List<A2aControlBlock> blocks = getModel().getControlBlocksByName().get(input.flowName);
        getModel().getActionBlocksByName().putAll(input.getActionBlocks());

        blocks.forEach(actionBlock -> {
            goSync(ActionBlockHandler.class, actionBlock);
        });

        ActionResult actionResult = new ActionResult();
        actionResult.setActionName(input.flowName);
        actionResult.success = true;
        actionResult.session = getModel().getSessionId();
        return actionResult;

    }

}
