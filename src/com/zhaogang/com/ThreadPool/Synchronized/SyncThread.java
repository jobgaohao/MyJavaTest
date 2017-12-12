package com.zhaogang.com.ThreadPool.Synchronized;

public class SyncThread implements Runnable {

    private static int count;
    
    public SyncThread() {
        count=0;
    }
    
    
    public static void main(String[] args) {
       
        //线程访问同一个对象
        SyncThread syncThread = new SyncThread();
        Thread thread1 = new Thread(syncThread, "SyncThread1");
        Thread thread2 = new Thread(syncThread, "SyncThread2");
        thread1.start();
        thread2.start();
           
        
        /*
        //线程访问两个对象
        Thread thread1 = new Thread(new SyncThread(), "SyncThread1");
        Thread thread2 = new Thread(new SyncThread(), "SyncThread2");
        thread1.start();
        thread2.start();
        **/
    }
    
    
    @Override
    public synchronized void run() {             
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+":"+(count++));
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }            
    }
    
    public int getCount(){
        return count;
    }

}
