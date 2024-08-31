package com.a2a;

import com.a2a.IA2aOrchestrator.A2aCommandCenterModel;
import com.commandcenter.action.IProcessor.Processor;

public abstract class AUIBuilderDelegate extends Processor<A2aCommandCenterModel, Void, Void> {

    public AUIBuilderDelegate(A2aCommandCenterModel model) {
        super(model);
    }

}