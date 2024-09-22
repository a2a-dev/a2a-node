package com.a2a.commandcenter.ui.instruction;

import java.util.logging.Level;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.data.InstructionHandler;
import com.a2a.commandcenter.model.data.UIInstruction.A2aUIAction;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;

public class WaitInstructionHandler extends InstructionHandler {
    public WaitInstructionHandler(A2aCommandCenterModel model) {
        super(model);
    }

    @Override
    public ActionResult process(A2aUIAction input) {
        try {
            Thread.sleep(Long.parseLong(input.getActionParameter().getValue()));
        } catch (NumberFormatException | InterruptedException e) {
            getDelegates().getLogger().log(Level.FINE, "Error in WaitInstructionHandler");
        }
        ActionResult actionResult = new ActionResult();
        actionResult.setSuccess(true);
        actionResult.setRequestId(input.requestId);

        return actionResult;
    }
}
