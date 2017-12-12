package com.zhaogang.com.thread.demo1;

/**
 * 
 * <pre>
 * B在A全部打印后开始
 * </pre>
 *
 * @author hao.gao
 * @version $Id: Print2.java, v 0.1 2017年10月20日 上午9:54:32 hao.gao Exp $
 */
public class Print2 {

    public static void main(String[] args) {
       final Thread A=new Thread(new Runnable() {            
            @Override
            public void run() {
                printNumber("A");   
            }
        });
        
        Thread B=new Thread(new Runnable() {            
            @Override
            public void run() {
                System.out.println("B开始等待A");
                try {
                    A.join();
                } catch (Exception e) {
                   e.printStackTrace();
                }
                printNumber("B");
            }            
        });
        B.start();
        A.start();        
    }
    
    
    private static void printNumber(String threadName){
        int i=0;
        while(i++<3){
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(threadName+" print: "+i);
        }
    }
}
