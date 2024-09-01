package com.commandcenter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;

import com.commandcenter.action.IAction.ICommandCenterAction;
import com.commandcenter.action.IAction.Lazy;
import com.commandcenter.action.IProcessor;

public interface ICommandCenter<D extends ICommandCenterDelegates, M extends ICommandCenterModel<D>, T extends IProcessor<D, M, ?, ?>, I>
        extends ICommandCenterAction<D, M, I> {

    Collection<Class<? extends T>> getProcessors();

    public abstract static class CommandCenter<D extends ICommandCenterDelegates, M extends ICommandCenterModel<D>, T extends IProcessor<D, M, ?, ?>, I>
            extends AConsumer<D, M, I>
            implements ICommandCenter<D, M, T, I> {

        public CommandCenter(M model) {
            super(model);

        }

        @Override
        public void register() {
            getProcessors().stream().filter(c -> isNotLazy(c)).forEach(p -> getHandler(p));
        }

        private boolean isNotLazy(Class<? extends T> c) {
            return !Lazy.class.isAssignableFrom(c);
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
    }
}
