package com.a2a.commandcenter.ui.instruction.action;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.a2a.commandcenter.model.data.Session.SessionEnd;
import com.commandcenter.action.IAction.IDataAction.DataAction;

public abstract class AUICloseDelegate
        extends DataAction<IA2aCCDelegates, A2aCommandCenterModel, SessionEnd, SessionEnd> {

    public AUICloseDelegate(A2aCommandCenterModel model) {
        super(model);
    }

}
