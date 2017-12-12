package com.zhaogang.com.thread.demo1;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 
 * <pre>
 * 子线程完成某件任务后，把得到的结果回传给主线程
 * 
 * 1.主线程调用futureTask.get()方法是阻塞主线程
 * 2.Callable内部开始执行，并返回预算结果
 * 3.futureTask.get()得到结果，主线程回复预算
 * 
 * 通过 FutureTask 和 Callable 可以直接在主线程获得子线程的运算结果，只不过需要阻塞主线程
 * </pre>
 *
 * @author hao.gao
 * @version $Id: Print6.java, v 0.1 2017年10月20日 下午1:47:39 hao.gao Exp $
 */
public class Print6 {
   public static void main(String[] args) {
    Callable<Integer> call=new Callable<Integer>(){
        @Override
        public Integer call() throws Exception {
            System.out.println("Task starts");
            Thread.sleep(1000);
            int result=0;
            for (int i = 0; i <=100; i++) {
                result+=i;
            }
            System.out.println("Task finished and return result");
            return result;
        }        
    };
    FutureTask<Integer> futureTask=new FutureTask<Integer>(call);
    new Thread(futureTask).start();
    try {
        System.out.println("Before futureTask.get()");
        System.out.println("result:"+futureTask.get());
        System.out.println("After futureTask.get()");
    } catch (Exception e) {
        e.printStackTrace();
    }
    
   }
}
