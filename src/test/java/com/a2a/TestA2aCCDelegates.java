package com.a2a;

import java.util.concurrent.Executor;
import java.util.logging.Logger;

import com.a2a.commandcenter.IA2aOrchestrator.A2aCCDelegates;
import com.a2a.commandcenter.IA2aOrchestrator.Ia2aDataDelegate;
import com.a2a.commandcenter.IA2aOrchestrator.Ia2aUIDelegate;
import com.a2a.commandcenter.IUIActionDelegator;

public class TestA2aCCDelegates extends A2aCCDelegates {

    @Override
    public Ia2aUIDelegate getUIDelegate() {

        return new TestA2aUIDelegate();
    }

    @Override
    public Ia2aDataDelegate getDataDelegate() {
        return new TestA2aDataDelegate();
    }

    @Override
    public IUIActionDelegator getUIActionDelegator() {
        return new TestA2aUIActionDelegator();
    }

    @Override
    public Executor getExecutor() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getExecutor'");
    }

    @Override
    public Executor getExpediteExecutor() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getExpediteExecutor'");
    }

    @Override
    public Logger getLogger() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLogger'");
    }

}
