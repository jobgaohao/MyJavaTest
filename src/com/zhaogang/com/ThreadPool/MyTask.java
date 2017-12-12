package com.zhaogang.com.ThreadPool;

public class MyTask implements Runnable {

    private int taskNum;
    
    public MyTask(int num){
        this.taskNum=num;
    }

    @Override
    public void run() {
      System.out.println("正在执行task:"+taskNum);
      try {
        Thread.currentThread().sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
        }
      System.out.println("task"+taskNum+"执行完毕");
    }       
}
