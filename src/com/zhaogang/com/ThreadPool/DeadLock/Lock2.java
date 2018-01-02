package com.zhaogang.com.ThreadPool.DeadLock;

public class Lock2 implements Runnable {

	@Override
	public void run() {
		try {
			System.out.println("Lock2 running");
			while(true){
				synchronized (DeadLock.obj2) {
					System.out.println("Lock2 lock obj2");
					Thread.sleep(3000);
					synchronized (DeadLock.obj1) {
						System.out.println("Lock2 lock obj1");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
