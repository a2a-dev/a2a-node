package com.a2a.ui;

import com.a2a.commandcenter.IUIActionDelegator;
import com.a2a.commandcenter.model.data.UIInstruction.ActionParameter;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.a2a.commandcenter.model.ui.PointerInstruction;

public class A2aUIActionDelegator implements IUIActionDelegator {

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doMouseMove'");
    }

    @Override
    public ActionResult doLeftClick(PointerInstruction clickInstruction) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doLeftClick'");
    }

    @Override
    public ActionResult doKeyIn(ActionParameter input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doKeyIn'");
    }

    @Override
    public ActionResult doDnD(ActionParameter input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doDnD'");
    }

    @Override
    public ActionResult doRead(ActionParameter input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doRead'");
    }

    @Override
    public ActionResult doScreenShot(ActionParameter input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doScreenShot'");
    }

}
