package com.zhaogang.com.thread;

public class ThreadImp implements Runnable {

    @Override
    public void run() {
        try {
        System.out.println("begin threadImp");
        Thread.sleep(5000);
        System.out.println("end threadImp");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }    
}
