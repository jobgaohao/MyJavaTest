package com.zhaogang.com.singleton.demo3;

public class Singleton {

	private Singleton(){}
	
	private static class SinglethonHolder{
	   private static final Singleton instance=new Singleton();
	}
		
	public static final Singleton getInstance(){
		return SinglethonHolder.instance;
	}
}
