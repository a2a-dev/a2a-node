package com.a2a.commandcenter.ui.instruction.flow;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.model.data.UIInstruction;
import com.a2a.commandcenter.model.data.UIInstruction.A2aControlBlock;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;

public class SkipFlowHandler extends FlowHandler {
    public SkipFlowHandler(A2aCommandCenterModel model) {
        super(model);
    }

    @Override
    public ActionResult process(A2aControlBlock[] input) {
        throw new UnsupportedOperationException("Unimplemented method 'process'");
    }

}
