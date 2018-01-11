package com.zhaogang.com.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;


/**
 * 泛型是编译时起作用，运行时不起作用
 * @author hao.gao
 *
 */
public class Test2 {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ArrayList<String> li = new ArrayList<String>();
		li.add("苹果");
		//li.add(10);//使用泛型，因此编译的时候没有通过，运行时能够通过呢？？？
	    Class c1=li.getClass();
	    Method m;
		try {
			m = c1.getMethod("add", Object.class);
			m.invoke(li, 10);
		    System.out.println(li.size());
		    System.out.println(li);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	}
}
