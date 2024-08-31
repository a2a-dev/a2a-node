package com.a2a;

import java.util.Arrays;
import java.util.Collection;

import com.a2a.delegate.data.EventPollerDataDelegate;
import com.a2a.delegate.data.SubscriberDataDelegate;
import com.commandcenter.ICommandCenter.CommandCenter;
import com.commandcenter.action.IProcessor;

public class A2aDataCommandCenter
        extends CommandCenter<IA2aCCDelegates, A2aCommandCenterModel, Void> {
    public A2aDataCommandCenter(A2aCommandCenterModel model) {
        super(model);
    }

    @Override
    public Collection<Class<? extends IProcessor<IA2aCCDelegates, A2aCommandCenterModel, ?, ?>>> getProcessors() {
        return Arrays.asList(SubscriberDataDelegate.class);
    }

    @Override
    public void consume(Void input) {
        go(EventPollerDataDelegate.class);
    }

}