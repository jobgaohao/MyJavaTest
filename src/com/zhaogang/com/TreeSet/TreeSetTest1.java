package com.zhaogang.com.TreeSet;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest1 {

	public static void main(String[] args) {
		try {
			Set<String> set = new TreeSet<String>();			
			boolean a= set.add("a");
			System.out.println("添加set:"+a);	
			set.add("b");
			boolean b= set.add("b");
			System.out.println("添加set:"+b);			
			for (String str : set) {
				System.out.println(str);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
}
