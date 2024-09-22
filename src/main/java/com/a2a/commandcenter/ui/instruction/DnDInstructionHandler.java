package com.a2a.commandcenter.ui.instruction;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.data.InstructionHandler;
import com.a2a.commandcenter.model.data.UIInstruction.A2aUIAction;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;

public class DnDInstructionHandler extends InstructionHandler {

    public DnDInstructionHandler(A2aCommandCenterModel model) {
        super(model);

    }

    @Override
    public ActionResult process(A2aUIAction input) {
        return getDelegates().getUIActionDelegator().doDnD(input.getActionParameter());
    }

}
