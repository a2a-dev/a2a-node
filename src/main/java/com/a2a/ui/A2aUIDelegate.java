package com.a2a.ui;

import com.a2a.commandcenter.IA2aOrchestrator.Ia2aUIDelegate;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.a2a.commandcenter.model.ui.RightClickInstruction;

public class A2aUIDelegate implements Ia2aUIDelegate {

    @Override
    public void createLayout() {
        System.out.println("Creating layout");
    }

    @Override
    public ActionResult processRightClick(RightClickInstruction rightClickInstruction) {

        return new ActionResult();

    }

}
