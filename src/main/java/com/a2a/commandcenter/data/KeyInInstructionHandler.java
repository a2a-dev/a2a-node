package com.a2a.commandcenter.data;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.model.data.UIInstruction.ActionParameter;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.a2a.commandcenter.ui.A2aAProcessor;

public class KeyInInstructionHandler
        extends A2aAProcessor<ActionParameter, ActionResult> {

    public KeyInInstructionHandler(A2aCommandCenterModel model) {
        super(model);
    }

    @Override
    public ActionResult process(ActionParameter input) {

        return getDelegates().getUIActionDelegator().doKeyIn(input);
    }

}
