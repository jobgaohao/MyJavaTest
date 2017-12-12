package com.zhaogang.com.thread;

/***
 * 
 * synchronized:Java语言的关键字，当它用来修饰一个方法或者一个代码块的时候，能够保证在同一时刻最多只有一个线程执行该段代码
 * <pre>
 * 当一个线程进入一个对象的一个synchronized()方法后，其他线程是否能够进入此对象的其他方法？
 * 答案：取决于方法本身，如果该方法是非sychronized，那是可以访问的
 * </pre>
 *
 * @author hao.gao
 * @version $Id: Test1.java, v 0.1 2017年5月26日 下午4:44:50 hao.gao Exp $
 */
public class Test1 {

    static final SynchronizedDemo t=new SynchronizedDemo();
    
    public static void main(String[] args) {
        Thread t1=new Thread(){
          public void run(){
              t.synchronizedMethod();
          }  
        };
        
        
        Thread t2=new Thread(){
          public void run(){
              t.generalMethod();
          }  
        };
        
        t1.start();
        t2.start();
    }
}
