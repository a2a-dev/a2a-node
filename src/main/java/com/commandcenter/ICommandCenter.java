package com.commandcenter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;

import com.commandcenter.action.IAction.CommandCenterAction;
import com.commandcenter.action.IProcessor;

public interface ICommandCenter<M extends ICommandCenterModel<? extends ICommandCenterDelegates>, I, O>
        extends CommandCenterAction<M, I, O> {

    <P extends IProcessor<M, ?, ?>> P register(Class<P> commandClass);

    <P extends IProcessor<M, ?, ?>> Collection<Class<P>> getProcessors();

    public abstract static class CommandCenter<M extends ICommandCenterModel<? extends ICommandCenterDelegates>, I, O>
            extends Processor<M, I, O>
            implements ICommandCenter<M, I, O> {

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
        public <P extends IProcessor<M, ?, ?>> P register(Class<P> commandClass) {
            try {
                return commandClass.getConstructor(getModel().getClass()).newInstance(getModel());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
}
