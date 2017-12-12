package com.zhaogang.com.thread;

public  class SynchronizedDemo {
 
    public synchronized void synchronizedMethod(){
        System.out.println("begin calling synchronizedMethod");
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.print(e.getMessage());
        }
        System.out.println("finish calling synchronizedMethod");
    }
    
    
    public void generalMethod(){
        System.out.println("call generalMethod");    
    }
}
