package com.a2a.commandcenter;

import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.a2a.commandcenter.model.ui.ClickInstruction;

public interface IUIActionDelegator {
    ActionResult doRightClick(ClickInstruction rightClickInstruction);

    ActionResult doDoubleClick(ClickInstruction clickInstruction);
}
