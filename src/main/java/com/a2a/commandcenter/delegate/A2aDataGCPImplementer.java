package com.a2a.commandcenter.delegate;

import java.util.function.Consumer;

import com.a2a.commandcenter.IA2aOrchestrator.Ia2aDataDelegate;
import com.a2a.commandcenter.model.data.Session.SessionInfo;
import com.a2a.commandcenter.model.data.Session.SessionInit;
import com.a2a.commandcenter.model.data.UIInstruction;

public class A2aDataGCPImplementer implements Ia2aDataDelegate {

    @Override
    public SessionInfo registerPollerFunction(Consumer<UIInstruction> pollerFunction, SessionInit pollerConfig) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean closeSession(SessionInit input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'closeSession'");
    }

}
