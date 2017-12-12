package com.zhaogang.com.thread.demo1;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * 
 * <pre>
 * 三个运动员各自准备，等待三个人都准备好后，再一起跑：线程建相互等待的效果
 * 
 * 1.先创建一个CyclicBarrier对象，设置同事等待的线程数，CyclicBarrier cyclicBarrier=new CyclicBarrier(3);
 * 2.这些线程同时开始自己做准备，自身准备完毕后，需要等待别人准备完毕，调用cyclicBarrier.await(),开始等待别人
 * 3.当指定的同时等待的线程数都调用了cyclicBarrier.await()时候，就意味着这些线程都准备完毕这样线程才能够同事继续执行
 * </pre>
 *
 * @author hao.gao
 * @version $Id: Print5.java, v 0.1 2017年10月20日 上午11:33:17 hao.gao Exp $
 */
public class Print5 {
    
    public static void main(String[] args) {
          int runner=3;
          final CyclicBarrier cyclicBarrier=new CyclicBarrier(runner);
          final Random random=new Random();
          for(char runnerName='A';runnerName<='C';runnerName++){
              final String rN=String.valueOf(runnerName);
              new Thread(new Runnable() {                
                @Override
                public void run() {
                    long prepareTime=random.nextInt(10000)+100;
                    System.out.println(rN+" is preparing for time:"+prepareTime);
                    try {
                        Thread.sleep(prepareTime);
                        System.out.println(rN+" is prepared,waiting for others");
                        cyclicBarrier.await();//当前运动员准备完毕，等待别人准备好
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(rN+" starts running");//所有运动员准备好了，一起开
                }
            }).start();
          }
    }
}
