package com.zhaogang.com.ThreadPool;

/**
 * 
 * <pre>
 * 基本线程：与线程池配合使用
 * </pre>
 *
 * @author hao.gao
 * @version $Id: PThread.java, v 0.1 2017年12月6日 下午4:33:22 hao.gao Exp $
 */
public class PThread extends Thread {

    //线程池
    private ThreadPool pool;
    
    //任务
    private Runnable target;
    
    private boolean isShutDown=false;
    
    private boolean isIdle=false;
    
    public PThread(Runnable target,String name,ThreadPool pool){
        super(name);
        this.pool=pool;
        this.target=target;
    }
    
    public void run(){
        while(!isShutDown){
            isIdle=false;
            if(target!=null){
                //运行任务
                target.run();
            }
            isIdle=true;
            try {
                pool.repool(this);
                synchronized (this) {
                    wait();//线程空闲等待新的任务来
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
            isIdle=false;
        }
    }
    
    public synchronized void setTarget(Runnable newTarget){
        target=newTarget;
        notifyAll();
    }

    //关闭线程
    public void shutdown() {
      isShutDown=true;
      notifyAll();
    }
}
