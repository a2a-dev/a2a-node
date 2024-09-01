package com.a2a.commandcenter.data;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.a2a.commandcenter.model.data.UIInstruction;
import com.commandcenter.action.IAction.IDataAction.DataAction;

public class InstructionProcessor extends DataAction<IA2aCCDelegates, A2aCommandCenterModel, UIInstruction, Void> {

    public InstructionProcessor(A2aCommandCenterModel model) {
        super(model);
    }

    @Override
    public Void process(UIInstruction input) {
        return null;
    }
}
