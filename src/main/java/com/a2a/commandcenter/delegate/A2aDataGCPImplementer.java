package com.a2a.commandcenter.delegate;

import java.util.function.Consumer;

import com.a2a.commandcenter.IA2aOrchestrator.Ia2aDataDelegate;
import com.a2a.commandcenter.model.data.PollerConfig;
import com.a2a.commandcenter.model.data.Session.SessionInit;
import com.a2a.commandcenter.model.data.UIInstruction;

public class A2aDataGCPImplementer implements Ia2aDataDelegate {

    @Override
    public void registerPollerFunction(Consumer<UIInstruction> pollerFunction, PollerConfig pollerConfig) {

    }

    @Override
    public SessionInit registerNode(SessionInit input) {
        return null;
    }

}
