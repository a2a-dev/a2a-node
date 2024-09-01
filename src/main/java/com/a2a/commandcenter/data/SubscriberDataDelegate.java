package com.a2a.commandcenter.data;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.a2a.commandcenter.model.data.NodeInit;
import com.a2a.commandcenter.model.data.ServerInit;
import com.commandcenter.action.IAction.IDataAction.DataAction;

public class SubscriberDataDelegate extends DataAction<IA2aCCDelegates, A2aCommandCenterModel, NodeInit, ServerInit> {

    public SubscriberDataDelegate(A2aCommandCenterModel model) {
        super(model);

    }

    @Override
    public ServerInit process(NodeInit input) {
        return getDelegates().getDataDelegate().registerNode(input);
    }

}
