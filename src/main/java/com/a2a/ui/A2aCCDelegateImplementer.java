package com.a2a.ui;

import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.a2a.commandcenter.IA2aOrchestrator.Ia2aUIDelegate;
import com.a2a.commandcenter.delegate.A2aDataGCPImplementer;
import com.a2a.commandcenter.IUIActionDelegator;

public class A2aCCDelegateImplementer implements IA2aCCDelegates {

    private A2aDataGCPImplementer a2aDataGCPImplementer;
    private A2aUIActionDelegator a2aUIActionImplementer;
    private A2aUIImplementer a2aUIImplementer;

    public A2aCCDelegateImplementer() {
        a2aUIImplementer = new A2aUIImplementer();
        a2aUIActionImplementer = new A2aUIActionDelegator();
        a2aDataGCPImplementer = new A2aDataGCPImplementer();
    }

    @Override
    public A2aDataGCPImplementer getDataDelegate() {
        return a2aDataGCPImplementer;
    }

    @Override
    public IUIActionDelegator getUIActionDelegator() {
        return a2aUIActionImplementer;
    }

    @Override
    public Ia2aUIDelegate getUIDelegate() {
        return a2aUIImplementer;
    }
}
