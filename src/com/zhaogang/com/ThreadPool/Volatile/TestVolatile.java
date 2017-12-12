package com.zhaogang.com.ThreadPool.Volatile;

/**
 * 
 * <pre>
 * 声明volatile的变量可以保证
 * a.其他线程对变量的修改，可以及时反映在当前线程
 * b.能够及时回写共享主内存中，被其他线程所见
 * 
 * 使用volatile修饰能够打印“stop thread”
 * 不使用volatile修饰，不会结束循环
 * </pre>
 *
 * @author hao.gao
 * @version $Id: TestVolatile.java, v 0.1 2017年12月7日 下午4:52:55 hao.gao Exp $
 */
public class TestVolatile extends Thread { 

    //private boolean stop=false;
    private volatile boolean stop=false;
    
    public void stopMe(){
        stop=true;
    }
    
    @Override
    public void run(){        
        System.out.println("run.....");
        int i=0;
        while(!stop){
            i++;             
        }
        System.out.println("stop thread,i="+i);        
    }
    
    public static void main(String[] args) throws InterruptedException {
        TestVolatile t=new TestVolatile();
        t.start();
        Thread.sleep(1000);
        t.stopMe();
        Thread.sleep(1000);        
    }
}
