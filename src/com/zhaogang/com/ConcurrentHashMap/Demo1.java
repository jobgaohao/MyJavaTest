package com.zhaogang.com.ConcurrentHashMap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo1 {

	public static void main(String[] args) {
		demo1();
		demo2();
		demo3();
	}
	
	public  static void demo1(){
		final Map<String,Integer> count=new ConcurrentHashMap<>();
		final CountDownLatch endLatch=new CountDownLatch(2);
		Runnable task=new Runnable() {			
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					Integer value=count.get("a");
					if(null==value){
						count.put("a", 1);
					}
					else{
						count.put("a",value+1);
					}
				}
				endLatch.countDown();
				
			}
		};
		new Thread(task).start();
		new Thread(task).start();
		
		try {
			endLatch.await();
			System.out.println("demo1"+count);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public static void demo2(){
		final Map<String,Integer> count=new ConcurrentHashMap<>();
		final CountDownLatch endLatch=new CountDownLatch(2);
		Runnable task=new Runnable() {
			
			@Override
			public void run() {
				Integer oldValue,newValue;
				for (int i = 0; i < 5; i++) {
					while (true) {
						oldValue=count.get("a");
						if(null==oldValue){
							newValue=1;
							if(count.put("a", newValue)==null){
								break;
							}
						}
						else{
							newValue=oldValue+1;
							if(count.replace("a", oldValue, newValue)){
								break;
							}
						}
						
					}
				}
				endLatch.countDown();
			}
		};
		new Thread(task).start();
		new Thread(task).start();
		try {
			endLatch.await();
			System.out.println("demo2"+count);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	
	public static void demo3(){
		final Map<String,AtomicInteger> count=new ConcurrentHashMap<>();
		final CountDownLatch endLatch=new CountDownLatch(2);
		Runnable task=new Runnable() {
			
			@Override
			public void run() {
				AtomicInteger oldValue;
				for (int i = 0; i < 5; i++) {
					oldValue=count.get("a");
					if(null==oldValue){
						AtomicInteger zeroValue=new AtomicInteger(0);
						oldValue=count.putIfAbsent("a", zeroValue);
						if(null==oldValue){
							oldValue=zeroValue;
						}
					}
					oldValue.incrementAndGet();
				}
				endLatch.countDown();
			}
		};
		new Thread(task).start();
		new Thread(task).start();
		try {
			endLatch.await();
			System.out.println("demo3"+count);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
