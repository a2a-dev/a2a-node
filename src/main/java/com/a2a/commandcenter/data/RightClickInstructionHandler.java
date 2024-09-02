package com.a2a.commandcenter.data;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.a2a.commandcenter.model.data.UIInstruction.ActionParameter;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.a2a.commandcenter.model.ui.PointerInstruction;
import com.commandcenter.action.IAction.IDataAction.DataAction;

public class RightClickInstructionHandler
        extends DataAction<IA2aCCDelegates, A2aCommandCenterModel, ActionParameter, ActionResult> {

    public RightClickInstructionHandler(A2aCommandCenterModel model) {
        super(model);

    }

    @Override
    public ActionResult process(ActionParameter input) {
        PointerInstruction rightClickInstruction = parseRightClickInstruction(input);
        return getDelegates().getUIActionDelegator().doRightClick(rightClickInstruction);

    }

    private PointerInstruction parseRightClickInstruction(ActionParameter input) {
        PointerInstruction rightClickInstruction = (PointerInstruction) input;

        return rightClickInstruction;

    }

}
