package com.a2a;

import com.a2a.IA2aOrchestrator.A2aCommandCenterModel;
import com.commandcenter.IAction.UIDesignDelegate;
import com.commandcenter.IProcessor.Processor;

public abstract class AUIBuilderDelegate extends Processor<A2aCommandCenterModel, UIDesignDelegate, Void, Void> {

    public AUIBuilderDelegate(A2aCommandCenterModel model) {
        super(model);
    }

}