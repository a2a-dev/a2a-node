package com.a2a;

import java.util.function.Consumer;

import com.a2a.commandcenter.IA2aOrchestrator.Ia2aDataDelegate;
import com.a2a.commandcenter.model.data.PollerConfig;
import com.a2a.commandcenter.model.data.Session.SessionInit;
import com.a2a.commandcenter.model.data.UIInstruction;

public class TestA2aDataDelegate implements Ia2aDataDelegate {

    @Override
    public SessionInit registerNode(SessionInit input) {
        System.out.println("Registering node--------------");
        return new SessionInit();
    }

    @Override
    public void registerPollerFunction(Consumer<UIInstruction> pollerFunction, PollerConfig pollerConfig) {
        // do nothing
    }

}
