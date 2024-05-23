package example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @Author liusc
 * @Date 2024/3/27 21:29
 * @Version 1.0
 */
public class Test {


    /**
     * @param corePoolSize 核心线程池大小
     * @param maximumPoolSize 最大线程池大小
     * @param keepAliveTime 超过corePoolSize数目的空闲线程最大存活时间
     * @param unit            keepAliveTime 参数的时间单位
     * @param workQueue       用于在执行任务时保存任务的队列
     * @param threadFactory   创建新线程的工厂
     * @param handler         当 Executor 已经关闭或任务已被拒绝时使用的处理程序
     */
    public void ThreadPoolExecutor(
            int corePoolSize,
            int maximumPoolSize,
            long keepAliveTime,
            TimeUnit unit,
            BlockingQueue<Runnable> workQueue,
            ThreadFactory threadFactory,
            RejectedExecutionHandler handler) {


    }
}

