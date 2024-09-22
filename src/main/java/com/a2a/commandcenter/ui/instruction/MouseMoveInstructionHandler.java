package com.a2a.commandcenter.ui.instruction;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.data.InstructionHandler;
import com.a2a.commandcenter.model.data.UIInstruction.A2aUIAction;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.a2a.commandcenter.model.ui.PointerInstruction;
import com.a2a.commandcenter.ui.Random;

public class MouseMoveInstructionHandler
        extends InstructionHandler {

    public MouseMoveInstructionHandler(A2aCommandCenterModel model) {
        super(model);
        // TODO Auto-generated constructor stub
    }

    @Override
    public ActionResult process(A2aUIAction input) {
        PointerInstruction MoveInstruction = new PointerInstruction();
        MoveInstruction.setPoint(Random.point(input.getActionParameter().getLocation()));
        return getDelegates().getUIActionDelegator().doMouseMove(MoveInstruction);
    }

}
