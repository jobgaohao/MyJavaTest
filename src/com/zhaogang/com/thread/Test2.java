package com.zhaogang.com.thread;

/**
 * join():指定的线程加入到当前线程，可以讲两个交替执行的线程合并为顺序执行的线程。
 * <pre>
 * 
 * </pre>
 *
 * @author hao.gao
 * @version $Id: Test2.java, v 0.1 2017年5月26日 下午5:53:26 hao.gao Exp $
 */
public class Test2 {

    public static void main(String[] args) {
        Thread t=new Thread(new ThreadImp());
        t.start();
        
        try {
            //t.join(1000);
            if(t.isAlive()){
                System.out.println("t has not finished"); 
            }
            else{
                System.out.println("t has finished");
            }
            
            System.out.println("joinFinish");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
