package com.a2a.commandcenter;

import java.util.Arrays;
import java.util.Collection;

import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.a2a.commandcenter.data.EventPoller;
import com.a2a.commandcenter.data.SubscriberDataDelegate;
import com.commandcenter.ICommandCenter.CommandCenter;
import com.commandcenter.action.IAction.IDataAction;

public class A2aDataCommandCenter
        extends
        CommandCenter<IA2aCCDelegates, A2aCommandCenterModel, IDataAction<IA2aCCDelegates, A2aCommandCenterModel, ?, ?>, Void> {
    public A2aDataCommandCenter(A2aCommandCenterModel model) {
        super(model);
    }

    @Override
    public void consume(Void input) {
        go(SubscriberDataDelegate.class);
        go(EventPoller.class);
    }

    @Override
    public Collection<Class<? extends IDataAction<IA2aCCDelegates, A2aCommandCenterModel, ?, ?>>> getProcessors() {
        return Arrays.asList(SubscriberDataDelegate.class);
    }

}