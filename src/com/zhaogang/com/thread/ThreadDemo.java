package com.zhaogang.com.thread;

public class ThreadDemo extends Thread {

    @Override
    public void run(){
        System.out.println("ThreadDemo:begin");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        System.out.println("ThreadDemo:end");
    }
    
}
