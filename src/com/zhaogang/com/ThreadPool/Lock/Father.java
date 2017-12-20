package com.zhaogang.com.ThreadPool.Lock;

import java.util.concurrent.locks.Lock;

public class Father implements Runnable {

    BankCard bankCard=null;
    Lock lock=null;
    
    public Father(BankCard bankCard,Lock lock) {
       this.bankCard=bankCard;
       this.lock=lock;
    }
    
    @Override
    public void run() {
    
       try {
         while(true){
             lock.lock();
             System.out.print("父亲存钱，现在余额"+bankCard.getBalance()+"\t");
             bankCard.setBalance(bankCard.getBalance()+500);
             System.out.println("父亲存入500元，现在余额："+bankCard.getBalance());
             lock.unlock();
             Thread.sleep(3*1000);
         }
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }

}
