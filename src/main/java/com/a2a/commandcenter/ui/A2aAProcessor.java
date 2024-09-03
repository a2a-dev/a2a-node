package com.a2a.commandcenter.ui;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.commandcenter.action.IProcessor.AProcessor;

public abstract class A2aAProcessor<I,O>
        extends AProcessor<IA2aCCDelegates, A2aCommandCenterModel,I,O> {

    public A2aAProcessor(A2aCommandCenterModel model) {
        super(model);
    }
}
