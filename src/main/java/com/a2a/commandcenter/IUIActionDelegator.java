package com.a2a.commandcenter;

import com.a2a.commandcenter.model.data.UIInstruction.ActionParameter;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.a2a.commandcenter.model.ui.PointerInstruction;

public interface IUIActionDelegator {
    ActionResult doRightClick(PointerInstruction rightClickInstruction);

    ActionResult doDoubleClick(PointerInstruction clickInstruction);

    ActionResult doMouseMove(PointerInstruction clickInstruction);

    ActionResult doLeftClick(PointerInstruction clickInstruction);

    ActionResult doKeyIn(ActionParameter input);

    ActionResult doDnD(ActionParameter input);

    ActionResult doRead(ActionParameter input);

    ActionResult doScreenShot(ActionParameter input);
}
