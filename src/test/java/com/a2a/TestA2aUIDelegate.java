package com.a2a;

import com.a2a.commandcenter.IA2aOrchestrator.Ia2aUIDelegate;
import com.a2a.commandcenter.IUIActionDelegator;

public class TestA2aUIDelegate implements Ia2aUIDelegate {

    @Override
    public void createLayout() {
        System.out.println("Creating layout-----------------");
    }

    @Override
    public IUIActionDelegator getUIActionDelegator() {
        // TODO Auto-generated method stub
        return new TestA2aUIActionDelegator();
    }

}
