package com.zhaogang.com.ThreadPool.DeadLock;

public class DeadLock {

	public static String obj1="obj1";
	public static String obj2="obj2";
	
	public static void main(String[] args) {
		Thread a=new Thread(new Lock1());
		Thread b=new Thread(new Lock2());
		a.start();
		b.start();
	}

}
