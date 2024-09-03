package com.a2a.commandcenter.model.data;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.model.data.UIInstruction.ActionParameter;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.a2a.commandcenter.ui.A2aAProcessor;

public class ReadInstructionHandler
        extends A2aAProcessor<ActionParameter, ActionResult> {

    public ReadInstructionHandler(A2aCommandCenterModel model) {
        super(model);
        // TODO Auto-generated constructor stub
    }

    @Override
    public ActionResult process(ActionParameter input) {
        return getDelegates().getUIActionDelegator().doRead(input);
    }

}
