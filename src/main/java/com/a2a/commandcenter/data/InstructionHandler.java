package com.a2a.commandcenter.data;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.model.data.UIInstruction.A2aUIAction;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.a2a.commandcenter.ui.A2aDataAction;

public abstract class InstructionHandler extends A2aDataAction<A2aUIAction, ActionResult> {

    public InstructionHandler(A2aCommandCenterModel model) {
        super(model);
    }

}
