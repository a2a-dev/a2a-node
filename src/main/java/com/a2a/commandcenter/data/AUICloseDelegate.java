package com.a2a.commandcenter.data;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.a2a.commandcenter.model.data.NodeEnd;
import com.a2a.commandcenter.model.data.ServerEnd;
import com.commandcenter.action.IAction.IDataAction.DataAction;

public abstract class AUICloseDelegate extends DataAction<IA2aCCDelegates, A2aCommandCenterModel, NodeEnd, ServerEnd> {
    
    public AUICloseDelegate(A2aCommandCenterModel model) {
        super(model);
    }
    
}
