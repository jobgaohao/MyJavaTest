package com.zhaogang.com.arrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 迭代器Iterator
 * 可以遍历并选择序列中的 对象，开发人员不需要了解序列的底层结构。
 * hasNext(),next(),remove()
 * @author hao.gao
 *
 */
public class Demo2 {

	public static void main(String[] args) {
		testIterator();
		test1();
	}
	
	
	/**
	 * 测试迭代器
	 */
	public static void testIterator(){
		List<String> list=new ArrayList<>();
		list.add("张三");
		list.add("李四");
		list.add("王五");
		list.add("张三");
		//构造一个迭代器
		Iterator<String> it=list.iterator();
		while(it.hasNext()){
			String name=it.next();
			System.out.println("迭代器---》"+name);
			if(name.indexOf("张三")>-1){
				it.remove();
			}
		}
		System.out.println(list);
	}
	
	public static void test1(){
		
	}
}
