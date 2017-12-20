package com.zhaogang.com.handlerChain.demo1;

import java.util.Random;

public class Test1 {

	private PriceHandler priceHandler;
	
	public void setPriceHandler(PriceHandler priceHandler) {
		this.priceHandler = priceHandler;
	}
    
	public void requestDiscount(float diccount){
		priceHandler.processDiscount(diccount);
	}
	
	public static void main(String[] args) {
		Test1 test1=new Test1();
		test1.setPriceHandler(PriceHandler.createPriceHandler());
		
		Random rand=new Random();
		for (int i = 1; i <=100; i++) {
			System.out.print(i+":");
			test1.requestDiscount(rand.nextFloat());
		}
	}
}
