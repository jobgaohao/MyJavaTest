package com.zhaogang.com.thread.demo1;

/**
 * 
 * <pre>
 * 按照指定的方式有序交叉运行
 * A打印完1，然后B打印1，2，3，最后再回到A继续打印2，3
 * 
 * 
 * 1.首先创建一个A 和 B共享的对象锁 lock=new Object();
 * 2.当A得到锁后，先打印1，然后调用lock.wait()方法，交出锁的控制权，进入wait状态
 * 3.对B而言，由于最开始得到了锁，导致B无法执行；直到A调用lock.wait()释放控制权后，B才得到了锁
 * 4.B在得到锁后打印，1，2，3 然后调用lock.notify()方法，唤醒正在wait的A
 * 5.A被唤醒后,继续打印剩下的2，3
 * 
 * 
 * 
 * </pre>
 *
 * @author hao.gao
 * @version $Id: Print3.java, v 0.1 2017年10月20日 上午9:58:12 hao.gao Exp $
 */
public class Print3 {

    public static void main(String[] args) {
        final Object lock=new Object();
        Thread A=new Thread(new Runnable() {            
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("A 1");
                    try {
                        lock.wait();
                        System.out.println("A 2");
                        System.out.println("A 3");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }                                       
                }
            }
        });
        
        Thread B=new Thread(new Runnable() {            
            @Override
            public void run() {
                synchronized(lock){
                    System.out.println("B 1");
                    System.out.println("B 2");
                    System.out.println("B 3");
                    lock.notify();                    
                }
            }
        });
        A.start();
        B.start();
    }
}
