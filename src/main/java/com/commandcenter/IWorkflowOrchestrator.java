package com.commandcenter;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.commandcenter.action.IAction.ICommandCenterAction;
import com.commandcenter.action.IProcessor;
import com.commandcenter.action.IProcessor.IHandler;

public interface IWorkflowOrchestrator<D extends IDelegates, M extends IModel<D>>
        extends ICommandCenter<D, M, Void>, IHandler<D, M> {

    public abstract static class WorkflowOrchestrator<D extends IDelegates, M extends IModel<D>>
            extends CommandCenter<D, M, Void>
            implements IWorkflowOrchestrator<D, M> {

        private final D delegates;
        private Map<Class<? extends IProcessor<D, M, ?, ?>>, Object> register;
        private final Collection<CompletableFuture<?>> threads = new LinkedList<>();

        public WorkflowOrchestrator(M model, D delegates) {
            super(model);
            this.delegates = delegates;
        }

        @Override
        public Collection<CompletableFuture<?>> getThreads() {
            return threads;
        }

        @Override
        public D getDelegates() {
            return delegates;
        }

        @Override
        public <P extends IProcessor<D, M, ?, ?>> P getHandler(
                Class<P> clazz) {
            try {
                if (getRegister().containsKey(clazz)) {
                    return (P) register.get(clazz);
                }
                P newInstance = clazz.getConstructor(getModel().getClass()).newInstance(getModel());
                newInstance.setParent(this);
                newInstance.register();
                register.put(clazz, newInstance);
                return newInstance;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public Map<Class<? extends IProcessor<D, M, ?, ?>>, Object> getRegister() {
            if (register == null) {
                register = new HashMap<>();
            }
            return register;
        }

        protected abstract Collection<Class<? extends ICommandCenterAction<D, M, ?>>> getCommandCenters();

        @Override
        public IProcessor<D, M, ?, ?> getParent() {
            return null;
        }

        // @Override
        // public Collection<Class<? extends ICommandCenterAction<D, M, ?>>>
        // getProcessors() {
        // return getCommandCenters();
        // }
    }
}