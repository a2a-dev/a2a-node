package com.a2a.commandcenter.ui;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.a2a.commandcenter.model.data.UIInstruction;
import com.a2a.commandcenter.model.data.UIInstruction.ActionParameter;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.commandcenter.action.IProcessor.AProcessor;

public class DoubleClickHandler
        extends AProcessor<IA2aCCDelegates, A2aCommandCenterModel, ActionParameter, ActionResult> {

    public DoubleClickHandler(A2aCommandCenterModel model) {
        super(model);

    }

    @Override
    public ActionResult process(ActionParameter input) {

        throw new UnsupportedOperationException("Unimplemented method 'process'");
    }

}
