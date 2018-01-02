package com.zhaogang.com.ThreadPool.Semaphore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量： semapore控制资源的访问个数,是对锁的扩展
 * 无论是内部锁synchronized 还是重入锁ReentrantLock,一次只允许一个线程访问一个资源，而信号量却可以指定多个线程同时访问某一个资源。
 * 
 *  Semaphore是一种基于计数的信号量。
 *  它可以设定一个阈值，基于此，多个线程竞争获取许可信号，
 *  做完自己的申请后归还，超过阈值后，线程申请许可信号将会被阻塞。
 *  Semaphore可以用来构建一些对象池，资源池之类的，
 *  比如数据库连接池
 * 
 * @author hao.gao
 *
 */
public class SemaphoreTest {
   public static void main(String[] args) {
	  final SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   //线程池 
	   ExecutorService exec=Executors.newCachedThreadPool();
	   //设置信号量只能5个线程同时访问
	   final Semaphore semp=new Semaphore(5);
	   //模拟20个客户端访问
	   for (int index = 1; index <= 20; index++) {
		   final int no=index;
		   Runnable run=new Runnable() {
				@Override
				public void run() {		
					try {
						semp.acquire();//获取许可
						System.out.println("accessing:"+no+"   time:"+df.format(new Date()));
						Thread.sleep((long)(Math.random()*1000));
						semp.release();//释放许可
						System.out.println("信号量允许的线程数量："+semp.availablePermits());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
		};
		exec.execute(run);
	   }
	   exec.shutdown();	  
   }
}
