package com.zhaogang.com.ThreadPool;

public class MyThread implements Runnable{

   protected String name;
   
   public MyThread(){}
   
   public MyThread(String name){
       this.name=name;
   }

   @Override
   public void run() {
       try {           
          Thread.sleep(10000);          
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
   }   
}
