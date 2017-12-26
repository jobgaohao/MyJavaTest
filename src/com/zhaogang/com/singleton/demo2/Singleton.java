package com.zhaogang.com.singleton.demo2;

/**
 * 单例模式【饿汉】
 * @author hao.gao
 *
 */
public class Singleton {
	private Singleton(){}
	private static Singleton  instance=new Singleton();
	public static Singleton getInstance(){
		return instance;
	}
	
}
