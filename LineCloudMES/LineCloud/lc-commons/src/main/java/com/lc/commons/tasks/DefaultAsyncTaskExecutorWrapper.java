package com.lc.commons.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.task.AsyncTaskExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;


public class DefaultAsyncTaskExecutorWrapper implements AsyncTaskExecutor {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultAsyncTaskExecutorWrapper.class) ;

    private final AsyncTaskExecutor asyncTaskExecutor;

    /**
     * Creates new instance with given underlying executor.
     *
     * @param asyncTaskExecutor
     *            executor to be wrapped.
     */
    public DefaultAsyncTaskExecutorWrapper(final AsyncTaskExecutor asyncTaskExecutor) {
        this.asyncTaskExecutor = asyncTaskExecutor;
    }


    @Override
    public void execute(final Runnable task) {
        asyncTaskExecutor.execute(createWrappedTask(task));
    }

    @Override
    public void execute(final Runnable task,final long startTimeout) {
        asyncTaskExecutor.execute(createWrappedTask(task), startTimeout);
    }

    private Runnable createWrappedTask(Runnable task) {
    }


    @Override
    public Future<?> submit(Runnable task) {
        return asyncTaskExecutor.submit(createWrappedTask(task));
    }

    @Override
    public <T> Future<T> submit(final Callable<T> task) {
        return asyncTaskExecutor.submit(createWrappedTask(task));
    }

    private <T> Callable<T> createWrappedTask(final Callable<T> task) {
        return new Callable<T>() {
            @Override
            public T call() throws Exception {
                try {
                    return task.call();

                } catch (Exception ex) {
                    onException(ex);
                    throw ex;
                }
            }
        };

    }

    /**
     * This method is performed whenever executed task throws uncaught exception.
     *
     * @param ex
     *            exception thrown by task
     */

    protected void onException(final Exception ex) {
        if(LOGGER.isWarnEnabled()) {
            LOGGER.warn("发生了意外的异常",ex);
        }
    }


    private Runnable createWrappedTask(final Runnable task) {
        return new Runnable() {

            @Override
            public void run() {
                try {
                    task.run();
                } catch (Exception ex) {
                    onException(ex);
                    throw new RuntimeException(ex);
                }
            }
        };
    }
}
