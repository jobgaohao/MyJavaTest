package com.zhaogang.com.ThreadPool.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * <pre>
 * 三个线程：线程名称分别为A，B，C，程序使用三个线程循环打印“ABC”10次后终止
 * </pre>
 *
 * @author hao.gao
 * @version $Id: ReentrantLockDemo1.java, v 0.1 2017年12月13日 下午5:44:40 hao.gao Exp $
 */
public class ReentrantLockDemo1 {

    static ReentrantLock lock=new ReentrantLock();
    private static String[] threadArr={"A","B","C"};
    
    public static void main(String[] args) {
        ReentrantLockDemo1 demo=new ReentrantLockDemo1();
        demo.startDemo();
    }
    
    public void startDemo(){
        System.out.println("---------------------------------");
        for (int i = 0; i < 10; i++) {
            for (String str : threadArr) {
                TestThread t=new TestThread(str, lock);
                t.start();
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                   e.printStackTrace();
                }
            }
            System.out.println("");
        }
        System.out.println("---------------------------------");
    }
     
}
