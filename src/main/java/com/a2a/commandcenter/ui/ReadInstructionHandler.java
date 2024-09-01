package com.a2a.commandcenter.ui;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.a2a.commandcenter.model.data.UIInstruction.ActionParameter;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.commandcenter.action.IProcessor.AProcessor;

public class ReadInstructionHandler
        extends AProcessor<IA2aCCDelegates, A2aCommandCenterModel, ActionParameter, ActionResult> {

    public ReadInstructionHandler(A2aCommandCenterModel model) {
        super(model);
        // TODO Auto-generated constructor stub
    }

    @Override
    public ActionResult process(ActionParameter input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'process'");
    }

}
