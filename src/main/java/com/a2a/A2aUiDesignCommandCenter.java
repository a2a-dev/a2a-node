package com.a2a;

import java.util.Arrays;
import java.util.Collection;

import com.a2a.delegate.data.AUICloseDelegate;
import com.a2a.delegate.ui.AUIBuilderDelegate;
import com.commandcenter.ICommandCenter.CommandCenter;
import com.commandcenter.action.IProcessor;

public class A2aUiDesignCommandCenter extends CommandCenter<IA2aCCDelegates, A2aCommandCenterModel, Void> {

    public A2aUiDesignCommandCenter(A2aCommandCenterModel model) {
        super(model);
    }

    @Override
    public Collection<Class<? extends IProcessor<IA2aCCDelegates, A2aCommandCenterModel, ?, ?>>> getProcessors() {
        return Arrays.asList(AUIBuilderDelegate.class, AUICloseDelegate.class);
    }

    @Override
    public void consume(Void input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'consume'");
    }

}