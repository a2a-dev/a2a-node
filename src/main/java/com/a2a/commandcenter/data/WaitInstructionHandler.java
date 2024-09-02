package com.a2a.commandcenter.data;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.a2a.commandcenter.model.data.UIInstruction.ActionParameter;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.commandcenter.action.CCLogUtil;
import com.commandcenter.action.IProcessor.AProcessor;

public class WaitInstructionHandler
        extends AProcessor<IA2aCCDelegates, A2aCommandCenterModel, ActionParameter, ActionResult> {
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
