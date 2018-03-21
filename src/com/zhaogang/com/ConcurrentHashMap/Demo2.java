package com.zhaogang.com.ConcurrentHashMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Demo2 {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}
	
	/**
	 * 给定一个数组，求出每个数据出现的次数并按照次数的由大到小排列出来。
	 * 我们选用HashMap来做，key存储数组元素，值存储出现的次数，
	 * 最后用Collections的sort方法对HashMap的值进行排序。	 
	 */
	public static void test1(){
		int data[]={ 2, 5, 2, 3, 5, 2, 3, 5, 2, 3, 5, 2, 3, 5, 2,7, 8, 8, 7, 8, 7, 9, 0 };
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		for (int i : data) {
			if(map.containsKey(i)){//判断HashMap 里是否存在
				map.put(i,map.get(i)+1);//已存在，值加一
			}else{
				map.put(i, 1);//不存在，新增
			}
		}
		
		//map 按值排序
		List<Map.Entry<Integer, Integer>> list=new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1,Map.Entry<Integer, Integer> o2){
				return (o2.getValue()-o1.getValue());
			}
		});
		
		for (Map.Entry<Integer, Integer> entry : list) {
			System.out.println(entry.getKey()+"-"+entry.getValue());
		}
	}
	
	
	/**
	 * 插入的HashMap的key相同时，会覆盖原有的value,且返回原value值，
	 */
	public static void test2(){
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		map.put("egg", 2);
		map.put("milk", 1);
		
		int egg=map.put("egg", 3);//key相同时，会覆盖原有的value,返回原value的值
		System.out.println(egg);//-->2
		System.out.println(map.get("egg"));
		System.out.println(map.get("milk"));
	}
	
	
	public static void test3(){
	   final HashMap map=new HashMap();
	   
	   Thread t1 = new Thread() { 
           public void run() { 
               for (int i = 0; i < 50000; i++) { 
                   map.put(new Integer(i), i); 
               } 
               System.out.println("t1 over"); 
           } 
       }; 

       Thread t2 = new Thread() { 
           public void run() { 
               for (int i = 0; i < 50000; i++) { 
                   map.put(new Integer(i), i); 
               } 

               System.out.println("t2 over"); 
           } 
       }; 

       t1.start(); 
       t2.start(); 
       
       try {
		Thread.sleep(1000*10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       System.out.println(map);
	}
	
}
