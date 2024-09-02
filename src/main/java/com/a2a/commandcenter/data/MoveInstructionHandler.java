package com.a2a.commandcenter.data;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.a2a.commandcenter.model.data.UIInstruction.ActionParameter;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.a2a.commandcenter.model.ui.PointerInstruction;
import com.a2a.commandcenter.ui.Random;
import com.commandcenter.action.IProcessor.AProcessor;

public class MoveInstructionHandler
        extends AProcessor<IA2aCCDelegates, A2aCommandCenterModel, ActionParameter, ActionResult> {

    public MoveInstructionHandler(A2aCommandCenterModel model) {
        super(model);
        // TODO Auto-generated constructor stub
    }

    @Override
    public ActionResult process(ActionParameter input) {
        PointerInstruction MoveInstruction = new PointerInstruction();
        MoveInstruction.setPoint(Random.point(input.getLocation()));
        return getDelegates().getUIActionDelegator().doMouseMove(MoveInstruction);
    }

}
