package com.a2a.commandcenter.ui.instruction.flow;

import java.util.Arrays;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.model.data.UIInstruction.A2aControlBlock;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.a2a.commandcenter.ui.instruction.action.ActionBlockHandler;

public class StartFlowHandler extends FlowHandler {

    public StartFlowHandler(A2aCommandCenterModel model) {
        super(model);
    }

    @Override
    public ActionResult process(A2aControlBlock[] input) {

        Arrays.stream(input).forEach(actionBlock -> {
            goSync(ActionBlockHandler.class, actionBlock);
        });
        return null;

    }

}
