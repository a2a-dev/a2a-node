package com.a2a.commandcenter.data;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.a2a.commandcenter.model.data.UIInstruction.ActionParameter;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.a2a.commandcenter.model.ui.PointerInstruction;
import com.a2a.commandcenter.ui.Random;
import com.commandcenter.action.IProcessor.AProcessor;

public class LeftClickInstructionHandler
        extends AProcessor<IA2aCCDelegates, A2aCommandCenterModel, ActionParameter, ActionResult> {

    public LeftClickInstructionHandler(A2aCommandCenterModel model) {
        super(model);

    }

    @Override
    public ActionResult process(ActionParameter input) {
        PointerInstruction clickInstruction = new PointerInstruction();
        clickInstruction.setPoint(Random.point(input.getLocation()));
        return getDelegates().getUIActionDelegator().doLeftClick(clickInstruction);
    }

}
