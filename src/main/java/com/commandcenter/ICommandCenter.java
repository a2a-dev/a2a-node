package com.commandcenter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;

import com.commandcenter.IAction.CommandCenterAction;
import com.commandcenter.IWorkflowOrchestrator.ICommandCenterDelegates;
import com.commandcenter.IWorkflowOrchestrator.ICommandCenterModel;

public interface ICommandCenter<M extends ICommandCenterModel<? extends ICommandCenterDelegates>, A extends IAction, I, O>
        extends IProcessor<M, CommandCenterAction, I, O> {

    <P extends IProcessor<M, ?, ?, ?>> P register(Class<P> commandClass);

    <P extends IProcessor<M, A, ?, ?>> Collection<Class<P>> getProcessors();

    public abstract static class CommandCenter<M extends ICommandCenterModel<? extends ICommandCenterDelegates>, A extends IAction, I, O>
            extends Processor<M, CommandCenterAction, I, O>
            implements ICommandCenter<M, A, I, O> {

        public CommandCenter(M model) {
            super(model);
        }

        public static Type findNthTypeParameter(Class<?> clazz, int n) {
            Type genericSuperclass = clazz.getGenericSuperclass();
            if (genericSuperclass instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
                Type[] typeArguments = parameterizedType.getActualTypeArguments();
                if (typeArguments.length > 0) {
                    return typeArguments[n - 1]; // Return the first type parameter
                }
            }
            return null;
        }

        @Override
        public <P extends IProcessor<M, ?, ?, ?>> P register(Class<P> commandClass) {
            try {
                return commandClass.getConstructor(getModel().getClass()).newInstance(getModel());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
}
