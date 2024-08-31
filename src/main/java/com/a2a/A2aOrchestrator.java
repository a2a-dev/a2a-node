package com.a2a;

import java.util.Arrays;
import java.util.Collection;

import com.a2a.delegate.ui.AUIBuilderDelegate;
import com.commandcenter.ICommandCenter;
import com.commandcenter.IWorkflowOrchestrator.WorkflowOrchestrator;

public class A2aOrchestrator extends WorkflowOrchestrator<IA2aCCDelegates, A2aCommandCenterModel>
        implements IA2aOrchestrator {

    public A2aOrchestrator(A2aCommandCenterModel model, IA2aCCDelegates delegates) {
        super(model, delegates);
    }

    @Override
    public void handle() {
        go(A2aDataCommandCenter.class).thenAccept(data -> {
            go(AUIBuilderDelegate.class);

        });

    }

    @Override
    protected Collection<Class<? extends ICommandCenter<IA2aCCDelegates, A2aCommandCenterModel, ?>>> getCommandCenters() {
        return Arrays.asList(A2aDataCommandCenter.class, A2aUiDesignCommandCenter.class);
    }

}