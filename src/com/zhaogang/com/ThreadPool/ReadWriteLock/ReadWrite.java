package com.zhaogang.com.ThreadPool.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWrite {

    //共享数据，只能一个线程写数据，可以多个线程读数据
    private Object data=null;
    
    //创建一个读写锁
    ReadWriteLock rwlock=new ReentrantReadWriteLock();
    
    /**
     * 
     * <pre>
     * 写数据，多个线程不能同时写，所以必须上写锁
     * </pre>
     *
     */
    public void put(Object data){
        //上写锁
        rwlock.writeLock().lock();
        try {
            System.err.println(Thread.currentThread().getName()+"准备写数据!");
            Thread.sleep((long)(Math.random()*1000));
            this.data=data;
            System.out.println(Thread.currentThread().getName()+"写入数据："+data);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            rwlock.writeLock().unlock();
        }
    }
    
    /**
     * 
     * <pre>
     * 读数据：可以多个线程同时读
     * </pre>
     *
     */
    public void get(){
        rwlock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"准备读取数据!");
            Thread.sleep((long)(Math.random()*1000));
            System.out.println(Thread.currentThread().getName()+"读取数据为："+data);
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    
}
