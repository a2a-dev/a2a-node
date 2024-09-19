package com.a2a.commandcenter.ui.instruction.flow;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.model.data.UIInstruction.A2aControlBlock;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.a2a.commandcenter.ui.A2aAProcessor;

public abstract class FlowHandler extends A2aAProcessor<A2aControlBlock[], ActionResult> {
    public FlowHandler(A2aCommandCenterModel model) {
        super(model);
    }
}