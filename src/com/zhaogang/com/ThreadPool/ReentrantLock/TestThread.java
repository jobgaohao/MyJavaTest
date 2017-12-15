package com.zhaogang.com.ThreadPool.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class TestThread extends Thread {

    private ReentrantLock lock;
    
    public TestThread(String str,ReentrantLock lock){
        super(str);
        this.lock=lock;
    }
    
    public void run(){
        try {
           lock.lockInterruptibly();
           System.out.print(Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
           lock.unlock();
        }
    }
}

