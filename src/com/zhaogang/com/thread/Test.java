package com.zhaogang.com.thread;

/**
 * 
 * <pre>
 * run ,start的区别：start才能真正的达到多线程的目的
 * </pre>
 *
 * @author hao.gao
 * @version $Id: Test.java, v 0.1 2017年5月26日 下午4:25:33 hao.gao Exp $
 */
public class Test {

    public static void test1(){
        System.out.println("test1：begin");
        Thread t1=new ThreadDemo();
        t1.start();//异步
        System.out.println("test1:end");
    }
    
    
    public static void test2(){
        System.out.println("test2:begin");
        Thread t2=new ThreadDemo();
        t2.run();
        System.out.println("test2:end");
    }
    
    public static void main(String[] args) {
        test1();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        test2();
    }
}
