package com.a2a.commandcenter;

import java.util.Arrays;
import java.util.Collection;

import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.commandcenter.IWorkflowOrchestrator.WorkflowOrchestrator;
import com.commandcenter.action.IProcessor;
import com.commandcenter.action.IAction.ICommandCenterAction;

public final class A2aOrchestrator extends WorkflowOrchestrator<IA2aCCDelegates, A2aCommandCenterModel>
        implements IA2aOrchestrator {

    private static A2aOrchestrator INSTANCE = null;

    public static A2aOrchestrator getInstance(IA2aCCDelegates delegates) {
        if (INSTANCE == null) {
            INSTANCE = new A2aOrchestrator(delegates);
        }
        return INSTANCE;
    }

    private A2aOrchestrator(IA2aCCDelegates delegates) {
        super(new A2aCommandCenterModel(), delegates);
    }

    @Override
    public void handle() {
        goSync(A2aDataCommandCenter.class);
        // thenAccept(data -> {
        goSync(A2aUiDesignCommandCenter.class);

        // });

    }

    @Override
    protected Collection<Class<? extends ICommandCenterAction<IA2aCCDelegates, A2aCommandCenterModel, ?>>> getCommandCenters() {
        return Arrays.asList(A2aDataCommandCenter.class, A2aUiDesignCommandCenter.class);

    }

}