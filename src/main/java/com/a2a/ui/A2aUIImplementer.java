package com.a2a.ui;

import com.a2a.commandcenter.IA2aOrchestrator.Ia2aUIDelegate;

public class A2aUIImplementer implements Ia2aUIDelegate {

    @Override
    public void createLayout() {
        System.out.println("Creating layout");
    }

}
