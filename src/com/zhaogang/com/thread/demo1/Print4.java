package com.zhaogang.com.thread.demo1;

import java.util.concurrent.CountDownLatch;

/**
 * 
 * <pre>
 * 四个线程ABCD,D等到ABC全部执行完毕后才执行，ABC是同步的
 * 
 * 1.创建一个计数器，设置初始值，CountdownLatch countDownLath=new CountdownLatch(2);
 * 2.在等待的线程里调用countDownLatch.await()方法，进入等待状态，知道计数值变为0
 * 3.在其他线程里调用countDownLatch.countDown()方法，该方法会将计数值减少1
 * 4.当其他线程的countDown()方法把技术值变成0是，线程里的countDownLatch.await()立即退出，执行后续代码
 * 
 * CountDownLatch 适用于一个线程去等待多个线程的情况。
 * </pre>
 *
 * @author hao.gao
 * @version $Id: Print4.java, v 0.1 2017年10月20日 上午11:01:21 hao.gao Exp $
 */
public class Print4 {

    
    public static void main(String[] args) {
        int worker=3;
        final CountDownLatch countDownLatch=new CountDownLatch(worker);
        new Thread(new Runnable() {            
            @Override
            public void run() {
                System.out.println("D iswaiting for other three threads");
                try {
                    countDownLatch.await();
                    System.out.println("ALL done,D starts working");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        
        for(char threadName='A';threadName<='C';threadName++){
            final String tN=String.valueOf(threadName);
            new Thread(new Runnable() {                
                @Override
                public void run() {
                  System.out.println(tN+" is working");
                  try {
                    Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                  System.out.println(tN+" finished");
                  countDownLatch.countDown();
                }
            }).start();
        }        
    }    
}
