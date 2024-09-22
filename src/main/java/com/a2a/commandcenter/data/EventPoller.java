package com.a2a.commandcenter.data;

import java.util.function.Consumer;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.a2a.commandcenter.model.data.Session.SessionInfo;
import com.a2a.commandcenter.model.data.Session.SessionInit;
import com.a2a.commandcenter.model.data.UIInstruction;
import com.commandcenter.action.IAction.IDataAction.DataAction;

public class EventPoller extends DataAction<IA2aCCDelegates, A2aCommandCenterModel, SessionInit, SessionInfo> {

    public EventPoller(A2aCommandCenterModel model) {
        super(model);
    }

    @Override
    public SessionInfo process(SessionInit input) {
        return getDelegates().getDataDelegate().registerPollerFunction(pollerFunction, input);

    }

    public Consumer<UIInstruction> pollerFunction = (input) -> {
        go(InstructionProcessor.class, input);
    };

}
