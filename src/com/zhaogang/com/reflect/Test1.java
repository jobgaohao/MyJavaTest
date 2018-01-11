package com.zhaogang.com.reflect;

/**
 * 反射Demo 通过类名称找到方法，并调用方法
 * @author hao.gao
 *
 */
public class Test1 {	
   public static void main(String[] args) {
	   try {		     
			 Class c=Class.forName(Excel.class.getName());
			 OfficeAble oa=(OfficeAble)c.newInstance();
			 oa.start();
			 System.out.println("--------------");
		} catch (Exception e) {
		  e.printStackTrace();
		}
   }
}
