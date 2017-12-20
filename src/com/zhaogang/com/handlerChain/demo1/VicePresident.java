package com.zhaogang.com.handlerChain.demo1;

/**
 * 销售副总，可以批准50%以内的折扣
 * @author hao.gao
 *
 */
public class VicePresident extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		if(discount<=0.5){
			System.out.format("%s批准折扣：%.2f%n",this.getClass().getName(),discount);
		}
		else{
			successor.processDiscount(discount);
		}
	}

}
