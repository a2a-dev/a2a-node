package com.a2a.delegate.data;

import com.a2a.A2aCommandCenterModel;
import com.a2a.IA2aCCDelegates;
import com.a2a.model.data.NodeEnd;
import com.a2a.model.data.ServerEnd;
import com.commandcenter.action.IAction.IDataAction.DataDelegate;

public abstract class AUICloseDelegate
        extends DataDelegate<IA2aCCDelegates, A2aCommandCenterModel, NodeEnd, ServerEnd> {

    public AUICloseDelegate(A2aCommandCenterModel model) {
        super(model);
    }
}
