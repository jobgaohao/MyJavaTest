package com.zhaogang.com.ThreadPool.Lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    public static void main(String[] args) {
        BankCard bankCard=new BankCard();
        Lock lock=new ReentrantLock();
        ExecutorService pool=Executors.newCachedThreadPool();
        Son son=new Son(bankCard, lock);
        Father father=new Father(bankCard, lock);
        pool.execute(son);  
        pool.execute(father); 
    }
}
