package com.commandcenter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.commandcenter.action.IProcessor;
import com.commandcenter.action.IAction.ICommandCenterAction;
import com.commandcenter.action.IProcessor.IHandler;

public interface IWorkflowOrchestrator<D extends ICommandCenterDelegates, M extends ICommandCenterModel<D>>
        extends ICommandCenter<D, M, ICommandCenterAction<D, M, ?>, Void>, IHandler<D, M> {

    public static interface IUIDelegate {

    }

    public static interface IDataDelegate {

    }

    public abstract static class WorkflowOrchestrator<D extends ICommandCenterDelegates, M extends ICommandCenterModel<D>>
            extends CommandCenter<D, M, ICommandCenterAction<D, M, ?>, Void>
            implements IWorkflowOrchestrator<D, M> {
        private final D delegates;
        private Map<Class<? extends IProcessor<D, M, ?, ?>>, Object> register = new HashMap<>();

        public WorkflowOrchestrator(M model, D delegates) {
            super(model);
            this.delegates = delegates;
        }

        @Override
        public D getDelegates() {
            return delegates;
        }

        @Override
        public <P extends IProcessor<D, M, ?, ?>> P getHandler(
                Class<P> clazz) {
            try {
                if (register.containsKey(clazz)) {
                    return (P) register.get(clazz);
                }
                P newInstance = clazz.getConstructor(getModel().getClass()).newInstance(getModel());
                newInstance.setParent(this);
                register.put(clazz, newInstance);
                return newInstance;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        protected abstract Collection<Class<? extends ICommandCenterAction<D, M, ?>>> getCommandCenters();

        @Override
        public IProcessor<D, M, ?, ?> getParent() {
            return null;
        }

        @Override
        public Collection<Class<? extends ICommandCenterAction<D, M, ?>>> getProcessors() {
            return getCommandCenters();
        }

    }
}