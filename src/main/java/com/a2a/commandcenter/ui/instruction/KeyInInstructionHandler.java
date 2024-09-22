package com.a2a.commandcenter.ui.instruction;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.data.InstructionHandler;
import com.a2a.commandcenter.model.data.UIInstruction.A2aUIAction;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;

public class KeyInInstructionHandler extends InstructionHandler {

    public KeyInInstructionHandler(A2aCommandCenterModel model) {
        super(model);
    }

    @Override
    public ActionResult process(A2aUIAction input) {

        return getDelegates().getUIActionDelegator().doKeyIn(input.getActionParameter());
    }

}
