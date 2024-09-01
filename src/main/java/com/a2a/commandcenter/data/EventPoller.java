package com.a2a.commandcenter.data;

import java.util.function.Consumer;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.a2a.commandcenter.model.data.PollerConfig;
import com.a2a.commandcenter.model.data.UIInstruction;
import com.commandcenter.action.IAction.IDataAction.DataAction;

public class EventPoller extends DataAction<IA2aCCDelegates, A2aCommandCenterModel, Void, Void> {

    public EventPoller(A2aCommandCenterModel model) {
        super(model);
    }

    String topicName = "your-topic-name";
    String registrationToken = "your-device-registration-token";

    @Override
    public Void process(Void input) {

        PollerConfig pollerConfig = new PollerConfig();
        getDelegates().getDataDelegate().registerPollerFunction(pollerFunction, pollerConfig);

        return null;
    }

    public Consumer<UIInstruction> pollerFunction = (input) -> {
        go(InstructionProcessor.class, input);

    };
}
