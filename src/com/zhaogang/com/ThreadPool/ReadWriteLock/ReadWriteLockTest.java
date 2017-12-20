package com.zhaogang.com.ThreadPool.ReadWriteLock;

import java.util.Random;

/**
 * 
 * <pre>
 * 测试读写锁类
 * </pre>
 *
 * @author hao.gao
 * @version $Id: ReadWriteLockTest.java, v 0.1 2017年12月15日 下午4:42:17 hao.gao Exp $
 */
public class ReadWriteLockTest {

    public static void main(String[] args) {
        final ReadWrite readWrite=new ReadWrite();
        for (int i = 0; i < 3; i++) {
            //创建三个读线程
            new Thread(new Runnable() {                
                @Override
                public void run() {
                  readWrite.get();
                }
            }).start();
            
            //穿件三个写线程
            new Thread(new Runnable() {                
                @Override
                public void run() {
                    readWrite.put(new Random().nextInt(8));
                }
            }).start();
        }        
    }
}
