package com.zhaogang.com.singleton.demo1;

/**
 * 单例模式【懒汉】
 * 后加载对象，缺点：多线程不安全
 * @author hao.gao
 *
 */
public class Singleton {
   
	private Singleton(){}
	private static Singleton instance;
	
	public static Singleton getInstance(){
		if(instance==null){
			instance=new Singleton();			
		}
		return instance;
	}
	
}
