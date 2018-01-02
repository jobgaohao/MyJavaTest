package com.zhaogang.com.ThreadPool.DeadLock;

public class Lock1 implements Runnable {

	@Override
	public void run() {
		try {
			System.out.println("Lock1 running");
			while(true){
				synchronized(DeadLock.obj1){
					System.out.println("Lock1 lock obj1");
					Thread.sleep(3000);
					synchronized (DeadLock.obj2) {
						System.out.println("Lock1 lock obj2");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
