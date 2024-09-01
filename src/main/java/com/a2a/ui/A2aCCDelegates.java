package com.a2a.ui;

import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;

public class A2aCCDelegates implements IA2aCCDelegates {

    @Override
    public A2aUIDelegate getUIDelegate() {
        return new A2aUIDelegate();
    }

    @Override
    public A2aDataDelegate getDataDelegate() {
        return new A2aDataDelegate();
    }
}
