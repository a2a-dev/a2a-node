package com.commandcenter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;

import com.commandcenter.action.IAction.ICommandCenterAction;
import com.commandcenter.action.IAction.Lazy;
import com.commandcenter.action.IProcessor;

public interface ICommandCenter<D extends ICommandCenterDelegates, M extends ICommandCenterModel<D>, I>
        extends ICommandCenterAction<D, M, I> {
    <P extends IProcessor<D, M, ?, ?>> Collection<Class<P>> getProcessors();

    public <P extends IProcessor<D, M, W, R>, W, R> R goSync(Class<P> commandClass, W with);

    public default <P extends IProcessor<D, M, W, R>, W, R> CompletableFuture<R> go(Class<P> commandClass) {
        return go(commandClass, null);
    }

    public default <P extends IProcessor<D, M, W, R>, W, R> CompletableFuture<R> go(Class<P> commandClass, W with) {
        return CompletableFuture.supplyAsync(() -> goSync(commandClass, with));

    }

    public default <P extends IProcessor<D, M, W, R>, W, R> R goSync(Class<P> commandClass) {
        return goSync(commandClass, null);
    }

    public abstract static class CommandCenter<D extends ICommandCenterDelegates, M extends ICommandCenterModel<D>, I>
            extends Consumer<D, M, I>
            implements ICommandCenter<D, M, I> {

        public CommandCenter(M model) {
            super(model);
            getProcessors().stream().filter(c -> isNotLazy(c)).forEach(p -> getHandler(p));

        }

        @Override
        public <P extends IProcessor<D, M, W, R>, W, R> R goSync(Class<P> commandClass, W with) {
            return getHandler(commandClass).process(null);
        }

        private boolean isNotLazy(Class<IProcessor<D, M, ?, ?>> c) {
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
