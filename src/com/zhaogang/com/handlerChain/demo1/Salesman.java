package com.zhaogang.com.handlerChain.demo1;

/**
 * 责任链模式
 * 销售员可以批准5%以内的折扣
 * @author hao.gao
 *
 */
public class Salesman  extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		if(discount<=0.05){
			System.out.format("%s批准折扣：%.2f%n",this.getClass().getName(),discount);
		}
		else{
			successor.processDiscount(discount);
		}
	}
}
