package com.a2a.commandcenter.ui.instruction.action;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.a2a.commandcenter.model.data.Session.SessionInit;
import com.commandcenter.action.IAction.IDataAction.DataAction;

public class UICloseDelegate
        extends DataAction<IA2aCCDelegates, A2aCommandCenterModel, SessionInit, Boolean> {
    public UICloseDelegate(A2aCommandCenterModel model) {
        super(model);
    }

    @Override
    public Boolean process(SessionInit input) {
        return getDelegates().getDataDelegate().closeSession(input);

    }
}
