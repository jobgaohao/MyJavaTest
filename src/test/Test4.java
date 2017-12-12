package test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Test4 {

    public Integer count=0;
    
    public static void main(String[] args) {
        final Test4 test4=new Test4();
        Executor executoer=Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            executoer.execute(new Runnable() {
                
                @Override
                public void run() {
                 test4.count++;
                }                                               
            });
        }
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(test4.count);
    }
}
