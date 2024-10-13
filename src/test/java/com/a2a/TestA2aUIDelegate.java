package com.a2a;

import com.a2a.commandcenter.IA2aWorkflow.Ia2aUIDelegate;

public class TestA2aUIDelegate implements Ia2aUIDelegate {

    @Override
    public void createLayout() {
        System.out.println("Creating layout-----------------");
    }

}
