package com.a2a.commandcenter.model.data;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.a2a.commandcenter.model.data.UIInstruction.ActionParameter;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.commandcenter.action.IAction.IDataAction.DataAction;

public class RightCLickHandler
        extends DataAction<IA2aCCDelegates, A2aCommandCenterModel, ActionParameter, ActionResult> {

    public RightCLickHandler(A2aCommandCenterModel model) {
        super(model);

    }

    @Override
    public ActionResult process(ActionParameter input) {
        RightClickInstruction rightClickInstruction = parseRightClickInstruction(input);
        getDelegates().getUIDelegate().processRightClick(rightClickInstruction).thenAccept(result -> {
            go(ActionResultDataHandler.class, result);
        });
        return null;

    }

    private RightClickInstruction parseRightClickInstruction(ActionParameter input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'parseRightClickInstruction'");
    }

}
