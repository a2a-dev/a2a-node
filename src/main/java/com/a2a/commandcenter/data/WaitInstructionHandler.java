package com.a2a.commandcenter.data;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.model.data.UIInstruction.ActionParameter;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.a2a.commandcenter.ui.A2aAProcessor;
import com.commandcenter.action.CCLogUtil;

public class WaitInstructionHandler
        extends A2aAProcessor<ActionParameter, ActionResult> {
    public WaitInstructionHandler(A2aCommandCenterModel model) {
        super(model);
    }

    @Override
    public ActionResult process(ActionParameter input) {
        try {
            Thread.sleep(Long.parseLong(input.getValue()));
        } catch (NumberFormatException | InterruptedException e) {
            CCLogUtil.verbose("Error in WaitInstructionHandler");
        }
        ActionResult actionResult = new ActionResult();
        actionResult.setSuccess(true);
        return actionResult;
    }
}
