package com.commandcenter;

import com.commandcenter.IWorkflowOrchestrator.IDataDelegate;
import com.commandcenter.IWorkflowOrchestrator.IUIDelegate;

public interface ICommandCenterDelegates  {
    <D extends IUIDelegate> D getUIDelegate();

    <D extends IDataDelegate> D getDataDelegate();
}