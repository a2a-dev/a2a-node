package com.a2a.commandcenter.data;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.IA2aWorkflow.IA2aCCDelegates;
import com.a2a.commandcenter.model.data.UIInstruction;
import com.commandcenter.action.IProcessor.IConsumer.AConsumer;

public class InstructionProcessor
        extends AConsumer<IA2aCCDelegates, A2aCommandCenterModel, UIInstruction> {

    public InstructionProcessor(A2aCommandCenterModel model) {
        super(model);
    }

    @Override
    public void consume(UIInstruction input) {
        go(input.getAction().getHandlerType(), input);
    }

}
