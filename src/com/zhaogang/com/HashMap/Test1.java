package com.zhaogang.com.HashMap;

import java.util.HashMap;
import java.util.Hashtable;

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
		hm.put(null,40);
		System.out.println(hm.size());
		System.out.println(hm.containsKey("aa"));
		System.out.println(hm.containsKey("dd")); 
		for (String key : hm.keySet()) {
			System.out.println(hm.get(key));
		} 
		@SuppressWarnings("unchecked")
		HashMap<String,Integer> hm1=(HashMap<String, Integer>) hm.clone();
		for (String key : hm1.keySet()) {
			System.out.println("hm1-->"+key);
		} 
		
		System.out.println("-------------------------");
		TestHasTable();
    }	
    
    
    public static void TestHasTable(){
    	Hashtable ht=new Hashtable<>();
    	//ht.put(null, null);
    }
    
}
