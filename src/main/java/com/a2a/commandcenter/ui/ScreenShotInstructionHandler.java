package com.a2a.commandcenter.ui;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.data.InstructionHandler;
import com.a2a.commandcenter.model.data.UIInstruction.A2aUIAction;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;

public class ScreenShotInstructionHandler extends InstructionHandler {

    public ScreenShotInstructionHandler(A2aCommandCenterModel model) {
        super(model);
    }

    @Override
    public ActionResult process(A2aUIAction input) {

        return getDelegates().getUIActionDelegator().doScreenShot(input.getActionParameter());
    }

}
