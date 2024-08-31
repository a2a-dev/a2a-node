package com.a2a;

import com.a2a.IA2aOrchestrator.Ia2aDataDelegate;
import com.a2a.IA2aOrchestrator.Ia2aUIDelegate;
import com.commandcenter.ICommandCenterDelegates;

public interface IA2aCCDelegates extends ICommandCenterDelegates {
    Ia2aUIDelegate getUIDelegate();

    Ia2aDataDelegate getDataDelegate();
}