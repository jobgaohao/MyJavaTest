package com.zhaogang.com.ThreadPool.Lock;

import java.util.concurrent.locks.Lock;

/**
 * 
 * <pre>
 * 儿子类：花钱
 * </pre>
 *
 * @author hao.gao
 * @version $Id: Son.java, v 0.1 2017年12月15日 下午5:06:29 hao.gao Exp $
 */
public class Son implements Runnable {

    BankCard bankCard=null;
    Lock lock=null;
    
    public Son(BankCard bankCard,Lock lock){
        this.bankCard=bankCard;
        this.lock=lock;
    }
    
    
    @Override
    public void run() {     
        try {
            while(true){
                lock.lock();
                System.out.print("儿子要消费，现在余额："+bankCard.getBalance()+"\t");
                bankCard.setBalance(bankCard.getBalance()-2000);
                System.out.println("儿子要消费2000元，现在余额："+bankCard.getBalance());
                lock.unlock();
                Thread.sleep(1*1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }              
    }

}
