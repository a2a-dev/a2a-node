package com.a2a;

import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.a2a.commandcenter.IA2aOrchestrator.Ia2aDataDelegate;
import com.a2a.commandcenter.IA2aOrchestrator.Ia2aUIDelegate;

public class TestA2aCCDelegates implements IA2aCCDelegates {

    @Override
    public Ia2aUIDelegate getUIDelegate() {
        return new TestA2aUIDelegate();
    }

    @Override
    public Ia2aDataDelegate getDataDelegate() {
        return new TestA2aDataDelegate();
    }

}
