package com.commandcenter;

import java.util.Collection;

import com.commandcenter.action.IHandler;
import com.commandcenter.action.IProcessor;

public interface IWorkflowOrchestrator<M extends ICommandCenterModel<D>, D extends ICommandCenterDelegates>
        extends ICommandCenter<M, Void, Void>, IHandler<M> {

    public abstract static class WorkflowOrchestrator<M extends ICommandCenterModel<D>, D extends ICommandCenterDelegates>
            extends CommandCenter<M, Void, Void>
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

        protected abstract Collection<Class<? extends ICommandCenter<M, ?, ?>>> getCommandCenters();

        @Override
        public <P extends IProcessor<M, ?, ?>> P register(Class<P> commandClass) {
            try {

                return commandClass.getConstructor(getModel().getClass()).newInstance(getModel());

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public Collection<Class<? extends IProcessor<M, ?, ?>>> getProcessors() {
            return (Collection) getCommandCenters();
        }

        @Override
        public IProcessor<M, ?, ?> getParent() {
            return null;
        }
    }
}
