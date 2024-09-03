package com.a2a.commandcenter.data;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.model.data.UIInstruction.ActionParameter;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.a2a.commandcenter.model.ui.PointerInstruction;
import com.a2a.commandcenter.ui.A2aAProcessor;
import com.a2a.commandcenter.ui.Random;

public class DoubleClickInstructionHandler
        extends A2aAProcessor<ActionParameter, ActionResult> {

    public DoubleClickInstructionHandler(A2aCommandCenterModel model) {
        super(model);
    }

    @Override
    public ActionResult process(ActionParameter input) {
        PointerInstruction clickInstruction = new PointerInstruction();
        clickInstruction.setPoint(Random.point(input.getLocation()));
        return getDelegates().getUIActionDelegator().doDoubleClick(clickInstruction);
    }

}
