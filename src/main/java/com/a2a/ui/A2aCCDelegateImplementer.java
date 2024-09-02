package com.a2a.ui;

import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.a2a.commandcenter.IA2aOrchestrator.Ia2aUIDelegate;
import com.a2a.commandcenter.IUIActionDelegator;

public class A2aCCDelegateImplementer implements IA2aCCDelegates {

    public A2aDataDelegateImplementer getDataDelegate() {
        return new A2aDataDelegateImplementer();
    }

    @Override
    public IUIActionDelegator getUIActionDelegator() {
        return new A2aUIActionDelegator();
    }

    @Override
    public Ia2aUIDelegate getUIDelegate() {
        return new A2aUIImplementer();
    }
}
