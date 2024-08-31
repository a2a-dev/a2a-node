/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.a2a;

import com.a2a.model.data.NodeInit;
import com.a2a.model.data.ServerInit;
import com.commandcenter.ICommandCenterModel;
import com.commandcenter.IWorkflowOrchestrator;

/**
 *
 * @author Senthu
 */

public interface IA2aOrchestrator extends IWorkflowOrchestrator<IA2aCCDelegates, A2aCommandCenterModel> {

    public interface Ia2aUIDelegate extends IUIDelegate {
        void createLayout();

    }

    public interface Ia2aDataDelegate extends IDataDelegate {

        ServerInit registerNode(NodeInit input);
    }

    public static interface IA2aCommandCenterModel extends ICommandCenterModel<IA2aCCDelegates> {
    }

}
