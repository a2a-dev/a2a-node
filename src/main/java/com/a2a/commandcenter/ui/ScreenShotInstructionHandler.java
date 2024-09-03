package com.a2a.commandcenter.ui;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.model.data.UIInstruction.ActionParameter;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;

public class ScreenShotInstructionHandler
        extends A2aAProcessor<ActionParameter, ActionResult> {

    public ScreenShotInstructionHandler(A2aCommandCenterModel model) {
        super(model);
    }

    @Override
    public ActionResult process(ActionParameter input) {

        return getDelegates().getUIActionDelegator().doScreenShot(input);
    }

}
