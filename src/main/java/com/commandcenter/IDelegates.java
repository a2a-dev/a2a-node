package com.commandcenter;

import java.util.concurrent.Executor;
import java.util.logging.Logger;

public interface IDelegates {

    Executor getExecutor();

    Executor getExpediteExecutor();

    Logger getLogger();

}
