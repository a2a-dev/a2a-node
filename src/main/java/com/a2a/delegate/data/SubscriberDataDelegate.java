package com.a2a.delegate.data;

import com.a2a.A2aCommandCenterModel;
import com.a2a.IA2aCCDelegates;
import com.a2a.model.data.NodeInit;
import com.a2a.model.data.ServerInit;
import com.commandcenter.action.IAction.IDataAction.DataDelegate;

public class SubscriberDataDelegate extends DataDelegate<IA2aCCDelegates, A2aCommandCenterModel, NodeInit, ServerInit> {

    public SubscriberDataDelegate(A2aCommandCenterModel model) {
        super(model);

    }

    @Override
    public ServerInit process(NodeInit input) {
        return getDelegates().getDataDelegate().registerNode(input);
    }

}
