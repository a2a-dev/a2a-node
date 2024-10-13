package com.a2a.commandcenter.data;

import java.util.function.Consumer;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.model.data.Session.SessionInfo;
import com.a2a.commandcenter.model.data.Session.SessionInit;
import com.a2a.commandcenter.model.data.UIInstruction;

public class EventPoller extends A2aDataAction< SessionInit, SessionInfo> {

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
