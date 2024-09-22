package com.a2a.commandcenter.ui.instruction;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.data.InstructionHandler;
import com.a2a.commandcenter.model.data.UIInstruction.A2aUIAction;
import com.a2a.commandcenter.model.data.UIInstruction.ActionParameter;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.a2a.commandcenter.model.ui.PointerInstruction;

public class RightClickInstructionHandler
        extends InstructionHandler {

    public RightClickInstructionHandler(A2aCommandCenterModel model) {
        super(model);
    }

    @Override
    public ActionResult process(A2aUIAction input) {
        PointerInstruction rightClickInstruction = parseRightClickInstruction(input.getActionParameter());
        return getDelegates().getUIActionDelegator().doRightClick(rightClickInstruction);
    }

    private PointerInstruction parseRightClickInstruction(ActionParameter input) {
        PointerInstruction rightClickInstruction = (PointerInstruction) input;
        return rightClickInstruction;
    }

}
