package com.zhaogang.com.ThreadPool;

public class Test {
    public static void main(String[] args) {
       
        noPool();
        
        hasPool();
    }
    
    public static void noPool(){
        long begin=System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            new Thread(new MyThread("testNOThreadPool"+Integer.toString(i))).start();
        }
        System.out.println("无线程池耗时："+(System.currentTimeMillis()-begin));
    }
    
    public static void hasPool(){
        long begin1=System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            ThreadPool.getInstance().start(new MyThread("testNOThreadPool"+Integer.toString(i)));
        }
        System.out.println("有线程池耗时："+(System.currentTimeMillis()-begin1));
    }
    
}
