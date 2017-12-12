package com.zhaogang.com.ThreadPool;

import java.util.List;
import java.util.Vector;

/**
 * 
 * <pre>
 * 线程池
 * </pre>
 *
 * @author hao.gao
 * @version $Id: ThreadPool.java, v 0.1 2017年12月6日 下午4:35:40 hao.gao Exp $
 */
public class ThreadPool {

    private static ThreadPool instance=null;
    //空闲的线程队列
    private List<PThread> idleThreads;
    //已有的线程总数
    private int threadCounter;
    private boolean isShutDown=false;
    
    private ThreadPool(){
        this.idleThreads=new Vector<>(5);
        threadCounter=0;
    }
    
    public int getCreatedThreadsCount(){
        return threadCounter;
    }
    
    /**
     * 
     * <pre>
     * 获得线程池实例
     * </pre>
     *
     * @return
     */
    public synchronized static ThreadPool getInstance(){
        if(instance==null){
            instance=new ThreadPool();
        }
        return instance;
    }
    
    /**
     * 
     * <pre>
     * 将线程放入池中
     * </pre>
     *
     * @param repoolingThread
     */
    protected synchronized void repool(PThread repoolingThread){
        if(!isShutDown){
            idleThreads.add(repoolingThread);
        }
        else{
            repoolingThread.shutdown();
        }
    }
    
    /**
     * 
     * <pre>
     * 停止池中的所有线程
     * </pre>
     *
     */
    public synchronized void shutdown(){
        isShutDown=true;
        for (int threadIndex = 0; threadIndex < idleThreads.size(); threadIndex++) {
            PThread idleThread=(PThread)idleThreads.get(threadIndex);
            idleThread.shutdown();
        }        
    }
    
    /**
     * 
     * <pre>
     * 执行任务
     * </pre>
     *
     * @param target
     */
    public synchronized void start(Runnable target){
        PThread thread=null;
        //如果有空闲线程直接使用
        if(idleThreads.size()>0){
            int lastIndex=idleThreads.size()-1;
            thread=(PThread)idleThreads.get(lastIndex);
            idleThreads.remove(lastIndex);
            thread.setTarget(target);
        }
        else{
            //没有空闲线程，则创建新线程
            threadCounter++;
            //创建线程
            thread=new PThread(target,"PThread #"+threadCounter, this);
            //启动这个线程
            thread.start();
        }
    }       
}

