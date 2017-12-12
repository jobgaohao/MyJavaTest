package com.zhaogang.com.thread.demo1;

/**
 * 
 * <pre>
 * A,B 同时打印
 * </pre>
 *
 * @author hao.gao
 * @version $Id: Print1.java, v 0.1 2017年10月20日 上午9:17:55 hao.gao Exp $
 */
public class Print1 {

    
    public static void main(String[] args) {
        Thread a=new Thread(new Runnable() {                         
            @Override
            public void run() {
                printNumber("A");                
            }
        });
        
        Thread b=new Thread(new Runnable() {            
            @Override
            public void run() {
                printNumber("B"); 
            }
        });
        
        a.start();
        b.start();              
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
