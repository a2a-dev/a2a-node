package com.commandcenter;

import java.util.Collection;

import com.commandcenter.IAction.CommandCenterAction;
import com.commandcenter.IProcessor.IHandler;
import com.commandcenter.IWorkflowOrchestrator.ICommandCenterDelegates;
import com.commandcenter.IWorkflowOrchestrator.ICommandCenterModel;

public interface IWorkflowOrchestrator<M extends ICommandCenterModel<D>, D extends ICommandCenterDelegates>
        extends ICommandCenter<M, CommandCenterAction, Void, Void>, IHandler<M, CommandCenterAction> {

    public static interface ICommandCenterDelegates {

    }

    public static interface ICommandCenterModel<D extends ICommandCenterDelegates> {

    }

    public abstract static class WorkflowOrchestrator<M extends ICommandCenterModel<D>, D extends ICommandCenterDelegates>
            extends CommandCenter<M, CommandCenterAction, Void, Void>
            implements IWorkflowOrchestrator<M, D> {

        private final D delegates;

        public WorkflowOrchestrator(M model, D delegates) {
            super(model);
            this.delegates = delegates;
        }

        @Override
        public D getDelegates() {
            return delegates;
        }

        protected abstract Collection<Class<? extends ICommandCenter<M, ? extends IAction, ?, ?>>> getCommandCenters();

        @Override
        public <P extends IProcessor<M, ?, ?, ?>> P register(Class<P> commandClass) {
            try {

                return commandClass.getConstructor(getModel().getClass()).newInstance(getModel());

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public Collection<Class<? extends IProcessor<M, CommandCenterAction, ?, ?>>> getProcessors() {
            return (Collection) getCommandCenters();
        }

        @Override
        public IProcessor<M, ?, ?, ?> getParent() {
            return null;
        }
    }
}
