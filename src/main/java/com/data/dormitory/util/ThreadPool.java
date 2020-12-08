package com.data.dormitory.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {


    protected static final Logger LOGGER = LoggerFactory.getLogger(ThreadPool.class);

    public static final int corePoolSize = 10;

    public static final int maximumPoolSize = 10;
    // 30 分钟
    public final static long keepAliveTime = 30L * 60L * 1000L;
    // 线程池
    private static ExecutorService sharedExecutor = null;
    // 比较重要的任务单独开线程池()
    private final static Map<String, ExclusiveThreadPoolExecutor> exclusiveExecutors = new HashMap<>();

    static void startThreadExecutor() {
        synchronized (ThreadPool.class) {
            if (sharedExecutor == null) {
                ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
                        60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
                executor.allowCoreThreadTimeOut(true);
                sharedExecutor = executor;
            }
        }
    }

    static void shutDownThreadExecutor() {
        if (sharedExecutor != null) {
            sharedExecutor.shutdown();
        }
        synchronized (exclusiveExecutors) {
            for (Map.Entry<String, ExclusiveThreadPoolExecutor> entry : exclusiveExecutors.entrySet()) {
                entry.getValue().shutdown();
            }
            exclusiveExecutors.clear();
        }
    }

    private static class ExclusiveThreadPoolExecutor extends ThreadPoolExecutor {

        long endTime = System.currentTimeMillis();

        private ExclusiveThreadPoolExecutor() {
            super(corePoolSize, maximumPoolSize,
                    60L, TimeUnit.SECONDS,
                    new LinkedBlockingQueue<>());
            this.allowCoreThreadTimeOut(true);
        }

        @Override
        protected void beforeExecute(Thread t, Runnable r) {
            super.beforeExecute(t, r);
            endTime = System.currentTimeMillis();
        }

        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            super.afterExecute(r, t);
            endTime = System.currentTimeMillis();
        }

        private boolean isIdleHandle() {
            // 当前没有任务，且空闲
            if (getActiveCount() <= 0 && endTime > 0 && (System.currentTimeMillis() - endTime) > keepAliveTime) {
                return true;
            }
            return false;
        }
    }

    public static void runThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        sharedExecutor.execute(runnable);
    }

    public static void runThreadExclusive(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        String key = runnable.getClass().getName();
        ExclusiveThreadPoolExecutor executor;
        synchronized (exclusiveExecutors) {
            executor = exclusiveExecutors.get(key);
            if (executor == null) {
                executor = new ExclusiveThreadPoolExecutor();
                exclusiveExecutors.put(key, executor);
                LOGGER.info("add new exclusive thread : {}", key);
            }
        }
        executor.execute(runnable);
        clearNoLongerRunThreadExclusive(executor);
    }

    /**
     * 清理长时间不运行的线程执行器
     */
    private static void clearNoLongerRunThreadExclusive(ExclusiveThreadPoolExecutor notRemoveExecutor) {
        synchronized (exclusiveExecutors) {
            List<String> keysToRemove = new ArrayList<>();
            for (Map.Entry<String, ExclusiveThreadPoolExecutor> entry : exclusiveExecutors.entrySet()) {
                ExclusiveThreadPoolExecutor service = entry.getValue();
                if (service == notRemoveExecutor) {
                    continue;
                }
                if (service != null && service.isIdleHandle()) {
                    keysToRemove.add(entry.getKey());
                    break;
                }
            }
            for (String keyToRemove : keysToRemove) {
                LOGGER.info("Remove run thread pool : {}", keysToRemove);
                ExclusiveThreadPoolExecutor removeHandle = exclusiveExecutors.remove(keyToRemove);
                removeHandle.shutdown();
            }
        }
    }

}
