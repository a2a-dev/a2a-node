package com.a2a;

import com.a2a.commandcenter.IUIActionDelegator;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.a2a.commandcenter.model.ui.ClickInstruction;

public class TestA2aUIActionDelegator implements IUIActionDelegator {

    @Override
    public ActionResult doRightClick(ClickInstruction rightClickInstruction) {
        System.out.println("Right click action");
        return null;
    }

    @Override
    public ActionResult doDoubleClick(ClickInstruction clickInstruction) {
        System.out.println("Double click action");
        return null;
    }

}
