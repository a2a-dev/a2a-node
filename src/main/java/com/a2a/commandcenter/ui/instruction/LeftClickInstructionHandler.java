package com.a2a.commandcenter.ui.instruction;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.data.InstructionHandler;
import com.a2a.commandcenter.model.data.UIInstruction.A2aUIAction;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.a2a.commandcenter.model.ui.PointerInstruction;
import com.a2a.commandcenter.ui.Random;

public class LeftClickInstructionHandler
        extends InstructionHandler {

    public LeftClickInstructionHandler(A2aCommandCenterModel model) {
        super(model);
    }

    @Override
    public ActionResult process(A2aUIAction input) {
        PointerInstruction clickInstruction = new PointerInstruction();
        clickInstruction.setPoint(Random.point(input.getActionParameter().getLocation()));
        return getDelegates().getUIActionDelegator().doLeftClick(clickInstruction);
    }

}
