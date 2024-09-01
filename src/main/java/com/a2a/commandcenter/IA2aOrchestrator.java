/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.a2a.commandcenter;

import java.util.concurrent.CompletableFuture;

import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.a2a.commandcenter.model.data.NodeInit;
import com.a2a.commandcenter.model.data.RightClickInstruction;
import com.a2a.commandcenter.model.data.ServerInit;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
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
        Ia2aUIDelegate getUIDelegate();

        Ia2aDataDelegate getDataDelegate();
    }

    public interface Ia2aUIDelegate extends IUIDelegate {
        void createLayout();

        CompletableFuture<ActionResult> processRightClick(RightClickInstruction rightClickInstruction);

    }

    public interface Ia2aDataDelegate extends IDataDelegate {

        ServerInit registerNode(NodeInit input);
    }
}
