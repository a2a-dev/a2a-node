package com.a2a.commandcenter.data;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.a2a.commandcenter.model.data.UIInstruction.ActionParameter;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.a2a.commandcenter.model.ui.RightClickInstruction;
import com.commandcenter.action.IAction.IDataAction.DataAction;

public class RightClickInstructionHandler
        extends DataAction<IA2aCCDelegates, A2aCommandCenterModel, ActionParameter, ActionResult> {

    public RightClickInstructionHandler(A2aCommandCenterModel model) {
        super(model);

    }

    @Override
    public ActionResult process(ActionParameter input) {
        RightClickInstruction rightClickInstruction = parseRightClickInstruction(input);
        return getDelegates().getUIDelegate().processRightClick(rightClickInstruction);

    }

    private RightClickInstruction parseRightClickInstruction(ActionParameter input) {
        RightClickInstruction rightClickInstruction = (RightClickInstruction) input;

        return rightClickInstruction;

    }

}
