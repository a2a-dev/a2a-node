package com.a2a.commandcenter.ui.instruction.flow;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.model.data.UIInstruction;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;

public class PauseFlowHandler
        extends FlowHandler {

    public PauseFlowHandler(A2aCommandCenterModel model) {
        super(model);

    }

    @Override
    public ActionResult process(UIInstruction input) {

        throw new UnsupportedOperationException("Unimplemented method 'process'");
    }

}
