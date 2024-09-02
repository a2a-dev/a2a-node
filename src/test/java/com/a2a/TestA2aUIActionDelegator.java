package com.a2a;

import com.a2a.commandcenter.IUIActionDelegator;
import com.a2a.commandcenter.model.data.UIInstruction.ActionParameter;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.a2a.commandcenter.model.ui.PointerInstruction;

public class TestA2aUIActionDelegator implements IUIActionDelegator {

    @Override
    public ActionResult doRightClick(PointerInstruction rightClickInstruction) {
        System.out.println("Right click action");
        return null;
    }

    @Override
    public ActionResult doDoubleClick(PointerInstruction clickInstruction) {
        System.out.println("Double click action");
        return null;
    }

    @Override
    public ActionResult doMouseMove(PointerInstruction clickInstruction) {
        System.out.println("Mouse move action");
        return null;
    }

    @Override
    public ActionResult doLeftClick(PointerInstruction clickInstruction) {
        System.out.println("Left click action");
        return null;
    }

    @Override
    public ActionResult doKeyIn(ActionParameter input) {
        System.out.println("Key in action");
        return null;
    }

    @Override
    public ActionResult doDnD(ActionParameter input) {
        System.out.println("Drag and drop action");
        return null;
    }

    @Override
    public ActionResult doRead(ActionParameter input) {
        System.out.println("Read action");
        return null;
    }

    @Override
    public ActionResult doScreenShot(ActionParameter input) {
        System.out.println("Screenshot action");
        return null; 
    }

}
