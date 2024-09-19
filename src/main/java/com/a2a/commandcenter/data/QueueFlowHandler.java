package com.a2a.commandcenter.data;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.model.data.UIInstruction.A2aControlBlock;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.a2a.commandcenter.ui.instruction.flow.FlowHandler;

public class QueueFlowHandler extends FlowHandler {

    public QueueFlowHandler(A2aCommandCenterModel model) {
        super(model);
    }

    @Override
    public ActionResult process(A2aControlBlock[] input) {

        throw new UnsupportedOperationException("Unimplemented method 'process'");
    }

}
