package com.a2a.commandcenter;

import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.a2a.commandcenter.data.EventPoller;
import com.a2a.commandcenter.model.data.Session.SessionInit;
import com.commandcenter.ICommandCenter.CommandCenter;

public class A2aDataCommandCenter
        extends
        CommandCenter<IA2aCCDelegates, A2aCommandCenterModel, SessionInit> {
    public A2aDataCommandCenter(A2aCommandCenterModel model) {
        super(model);
    }

    @Override
    public void consume(SessionInit input) {
        go(EventPoller.class).thenAccept(sessionInfo -> {
            getModel().setSessionInfo(sessionInfo);
        });
    }

}