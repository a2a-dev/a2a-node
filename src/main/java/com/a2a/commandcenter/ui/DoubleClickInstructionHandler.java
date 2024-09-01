package com.a2a.commandcenter.ui;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.a2a.commandcenter.model.data.UIInstruction.ActionParameter;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.a2a.commandcenter.model.ui.ClickInstruction;
import com.commandcenter.action.IProcessor.AProcessor;

public class DoubleClickInstructionHandler
        extends AProcessor<IA2aCCDelegates, A2aCommandCenterModel, ActionParameter, ActionResult> {

    public DoubleClickInstructionHandler(A2aCommandCenterModel model) {
        super(model);
    }

    @Override
    public ActionResult process(ActionParameter input) {
        ClickInstruction clickInstruction = new ClickInstruction();
        clickInstruction.setPoint(Randomizer.getRandomPoint(input.getLocation()));
        return getDelegates().getUIDelegate().getUIActionDelegator().doDoubleClick(clickInstruction);
    }

}
