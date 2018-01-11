package com.zhaogang.com.HashMap;

import java.util.HashMap;

/**
 * HashMap
 * @author hao.gao
 *
 */
public class Test1 {

    public static void main(String[] args) {
		HashMap<String,Integer> hm=new HashMap<>();
		hm.put("aa", 10);
		hm.put("bb", 20);
		hm.put("cc", 30);
		System.out.println(hm.size());
		System.out.println(hm.containsKey("aa"));
		System.out.println(hm.containsKey("dd")); 
		for (String key : hm.keySet()) {
			System.out.println(key);
		} 
		@SuppressWarnings("unchecked")
		HashMap<String,Integer> hm1=(HashMap<String, Integer>) hm.clone();
		for (String key : hm1.keySet()) {
			System.out.println("hm1-->"+key);
		} 
    }	
}
