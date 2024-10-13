package com.a2a;

import java.util.function.Consumer;

import com.a2a.commandcenter.IA2aOrchestrator.Ia2aDataDelegate;
import com.a2a.commandcenter.model.data.Session.SessionInfo;
import com.a2a.commandcenter.model.data.Session.SessionInit;
import com.a2a.commandcenter.model.data.UIInstruction;

public class TestA2aDataDelegate implements Ia2aDataDelegate {

    @Override
    public SessionInfo registerPollerFunction(Consumer<UIInstruction> pollerFunction, SessionInit sessionInit) {
       System.out.println("registerPollerFunction");
        return new SessionInfo();
    }

    @Override
    public Boolean closeSession(SessionInit input) {
        return true;
    }

   

}
