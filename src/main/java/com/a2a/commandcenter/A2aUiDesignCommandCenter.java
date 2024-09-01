package com.a2a.commandcenter;

import java.util.Arrays;
import java.util.Collection;

import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.a2a.commandcenter.ui.AUIBuilderAction;
import com.commandcenter.ICommandCenter.CommandCenter;
import com.commandcenter.action.IAction.IUIDesignAction;

public class A2aUiDesignCommandCenter
        extends
        CommandCenter<IA2aCCDelegates, A2aCommandCenterModel, IUIDesignAction<IA2aCCDelegates, A2aCommandCenterModel, ?, ?>, Void> {

    public A2aUiDesignCommandCenter(A2aCommandCenterModel model) {
        super(model);
    }

    @Override
    public void consume(Void input) {
        System.out.println("A2aUiDesignCommandCenter.consume()");
        go(AUIBuilderAction.class);
    }

    @Override
    public Collection<Class<? extends IUIDesignAction<IA2aCCDelegates, A2aCommandCenterModel, ?, ?>>> getProcessors() {
        return Arrays.asList(AUIBuilderAction.class);
    }

}