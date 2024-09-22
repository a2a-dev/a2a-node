/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.a2a.commandcenter;

import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.logging.Logger;

import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.a2a.commandcenter.model.data.Session.SessionInfo;
import com.a2a.commandcenter.model.data.Session.SessionInit;
import com.a2a.commandcenter.model.data.UIInstruction;
import com.commandcenter.IModel;
import com.commandcenter.IDelegates;
import com.commandcenter.IWorkflowOrchestrator;

/**
 *
 * @author Senthu
 */

public interface IA2aOrchestrator extends IWorkflowOrchestrator<IA2aCCDelegates, A2aCommandCenterModel> {

    public static interface IA2aCommandCenterModel extends IModel<IA2aCCDelegates> {
    }

    public static interface IA2aCCDelegates extends IDelegates {

        public Ia2aUIDelegate getUIDelegate();

        public Ia2aDataDelegate getDataDelegate();

        public IUIActionDelegator getUIActionDelegator();

    }

    public interface Ia2aUIDelegate {
        void createLayout();

    }

    public interface Ia2aDataDelegate {

        SessionInfo registerPollerFunction(Consumer<UIInstruction> pollerFunction, SessionInit sessionInit);

        Boolean closeSession(SessionInit input);

    }

    public static abstract class A2aCCDelegates implements IA2aCCDelegates {

        @Override
        public Executor getExecutor() {
            return new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue<>(),
                    (runnable) -> new Thread(runnable, "A2aCCDelegates"));
        }

        @Override
        public Executor getExpediteExecutor() {
            return new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue<>(),
                    (runnable) -> new Thread(runnable, "A2aCCDelegates:Expedite"));
        }

        @Override
        public Logger getLogger() {
            return Logger.getLogger("A2aCCDelegates");
        }
    }
}
