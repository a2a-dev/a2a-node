package com.a2a.commandcenter.ui.instruction.action;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.model.data.UIInstruction.A2aControlBlock;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.a2a.commandcenter.ui.A2aAProcessor;

public class ActionBlockHandler extends A2aAProcessor<A2aControlBlock, ActionResult> {
    public ActionBlockHandler(A2aCommandCenterModel model) {
        super(model);
    }

    @Override
    public ActionResult process(A2aControlBlock input) {
        throw new UnsupportedOperationException("Unimplemented method 'process'");
    }
}
