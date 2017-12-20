package com.zhaogang.com.handlerChain.demo1;

/**
 * 销售总监，可以批准40%以内的折扣
 * @author hao.gao
 *
 */
public class Director extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		if(discount<=0.4){
			System.out.format("%s批准折扣：%.2f%n",this.getClass().getName(),discount);
		}
		else{
			successor.processDiscount(discount);
		}		
	}
  
}
