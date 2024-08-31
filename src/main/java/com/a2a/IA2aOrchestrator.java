/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.a2a;

import java.util.Arrays;
import java.util.Collection;

import com.a2a.IA2aOrchestrator.A2aCommandCenterModel;
import com.a2a.IA2aOrchestrator.IA2aCCDelegates;
import com.commandcenter.ICommandCenter;
import com.commandcenter.ICommandCenterDelegates;
import com.commandcenter.ICommandCenterModel;
import com.commandcenter.IWorkflowOrchestrator;
import com.commandcenter.action.IProcessor;

/**
 *
 * @author Senthu
 */

public interface IA2aOrchestrator extends IWorkflowOrchestrator<A2aCommandCenterModel, IA2aCCDelegates> {

    public static interface IA2aUIDelegate {
    }

    public static interface IA2aDataDelegate {
    }

    public static interface IA2aCommandCenterModel extends ICommandCenterModel<IA2aCCDelegates> {
    }

    public static class A2aCommandCenterModel implements IA2aCommandCenterModel {
    }

    public static interface IA2aCCDelegates extends ICommandCenterDelegates {
        IA2aUIDelegate getUIDelegate();

        IA2aDataDelegate getDataDelegate();
    }

    public static class A2aOrchestrator
            extends WorkflowOrchestrator<A2aCommandCenterModel, IA2aCCDelegates>
            implements IA2aOrchestrator {

        public A2aOrchestrator(A2aCommandCenterModel model, IA2aCCDelegates delegates) {
            super(model, delegates);
        }

        @Override
        public void handle() {

        }

        @Override
        protected Collection<Class<? extends ICommandCenter<A2aCommandCenterModel, ?, ?>>> getCommandCenters() {
            return Arrays.asList(A2aUiDesignCommandCenter.class, A2aDataCommandCenter.class);
        }
    }

    public static class A2aUiDesignCommandCenter
            extends CommandCenter<A2aCommandCenterModel, Void, Void> {

        public A2aUiDesignCommandCenter(A2aCommandCenterModel model) {
            super(model);
        }

        @Override
        public Void process(Void input) {
            return null;
        }

        @Override
        public Collection<Class<? extends IProcessor<A2aCommandCenterModel, ?, ?>>> getProcessors() {
            return Arrays.asList(AUIBuilderDelegate.class);
        }

    }

    public static class A2aDataCommandCenter
            extends CommandCenter<A2aCommandCenterModel, Void, Void> {
        public A2aDataCommandCenter(A2aCommandCenterModel model) {
            super(model);
        }

        @Override
        public Void process(Void input) {
            return null;
        }

        @Override
        public Collection<Class<Collection<Class<? extends IProcessor<A2aCommandCenterModel, ?, ?>>>>> getProcessors() {
            return Arrays.asList();
        }

    }

}
