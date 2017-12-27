package com.zhaogang.com.ThreadPool.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量： semapore控制资源的访问个数
 * @author hao.gao
 *
 */
public class SemaphoreTest {
   public static void main(String[] args) {
	   System.out.println("-----------------------begin");
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
						System.out.println("accessing:"+no);
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
	   System.out.println("-----------------------end");
   }
}
