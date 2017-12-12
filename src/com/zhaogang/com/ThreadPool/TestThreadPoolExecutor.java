package com.zhaogang.com.ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 
 * <pre>
 * java 线程池测试
 * 线程池中的线程数目大于5时，把任务放入到任务缓存队列里面，当任务队列满后，创建新的线程。
 * 任务超过后，就会抛出任务拒绝异常
 * </pre>
 *
 * @author hao.gao
 * @version $Id: TestThreadPoolExecutor.java, v 0.1 2017年12月7日 下午2:00:41 hao.gao Exp $
 */
public class TestThreadPoolExecutor {

    public static void main(String[] args) {
        ThreadPoolExecutor executor=new ThreadPoolExecutor(10,10, 200, TimeUnit.MICROSECONDS, new ArrayBlockingQueue<Runnable>(5));
        for (int i = 0; i < 15; i++) {
            MyTask myTask=new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目"+executor.getPoolSize()+",队列中等待的任务数目："+executor.getQueue().size()+",已经执行完成的任务数目："+executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
}
