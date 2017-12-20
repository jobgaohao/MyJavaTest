package com.zhaogang.com.handlerChain.demo1;

/**
 * 销售经理可以批准30%以内的折扣
 * @author hao.gao
 *
 */
public class Manager extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		if(discount<0.3){
			System.out.format("%s批准折扣：%.2f%n",this.getClass().getName(),discount);
		}
		else{
			successor.processDiscount(discount);
		}
	}

}
