package com.a2a.commandcenter.ui.instruction.flow;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.model.data.UIInstruction;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;

public class RestartFlowHandler extends FlowHandler {

    public RestartFlowHandler(A2aCommandCenterModel model) {
        super(model);

    }

    @Override
    public ActionResult process(UIInstruction input) {
        throw new UnsupportedOperationException("Unimplemented method 'process'");
    }

}
