/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.a2a.commandcenter;

import java.util.function.Consumer;

import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.a2a.commandcenter.model.data.NodeInit;
import com.a2a.commandcenter.model.data.PollerConfig;
import com.a2a.commandcenter.model.data.ServerInit;
import com.a2a.commandcenter.model.data.UIInstruction;
import com.commandcenter.ICommandCenterDelegates;
import com.commandcenter.ICommandCenterModel;
import com.commandcenter.IWorkflowOrchestrator;

/**
 *
 * @author Senthu
 */

public interface IA2aOrchestrator extends IWorkflowOrchestrator<IA2aCCDelegates, A2aCommandCenterModel> {

    public static interface IA2aCommandCenterModel extends ICommandCenterModel<IA2aCCDelegates> {
    }

    public static interface IA2aCCDelegates extends ICommandCenterDelegates {

        public Ia2aUIDelegate getUIDelegate();

        public Ia2aDataDelegate getDataDelegate();

        public IUIActionDelegator getUIActionDelegator();

    }

    public interface Ia2aUIDelegate {
        void createLayout();

    }

    public interface Ia2aDataDelegate {

        ServerInit registerNode(NodeInit input);

        void registerPollerFunction(Consumer<UIInstruction> pollerFunction, PollerConfig pollerConfig);

    }
}
