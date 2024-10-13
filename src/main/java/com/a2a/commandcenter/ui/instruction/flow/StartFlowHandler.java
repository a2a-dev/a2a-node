package com.a2a.commandcenter.ui.instruction.flow;

import java.util.List;
import java.util.Map;

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
        Map<String, List<A2aControlBlock>> controlBlocksByName = getModel().getControlBlocksByName();
        if (input.getControlBlocks() != null) {
            controlBlocksByName.put(input.flowName, input.getControlBlocks());
        }

        List<A2aControlBlock> blocks = controlBlocksByName.get(input.flowName);
        getModel().getActionBlocksByName().putAll(input.getActionBlocks());

        blocks.forEach(actionBlock -> {
            goSync(ActionBlockHandler.class, actionBlock);
        });

        ActionResult ar = new ActionResult();
        ar.setActionName(input.flowName);
        ar.success = true;
        ar.session = getModel().getSessionId();
        return ar;

    }

}
