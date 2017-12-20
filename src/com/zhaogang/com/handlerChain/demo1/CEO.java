package com.zhaogang.com.handlerChain.demo1;

/**
 * CEO批准55%以内的折扣，超出拒绝
 * @author hao.gao
 *
 */
public class CEO extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		if(discount<=0.55){
			System.out.format("%s批准折扣：%.2f%n",this.getClass().getName(),discount);
		}
		else{
			System.out.format("%s拒绝折扣：%.2f%n",this.getClass().getName(),discount);
		}
	}

}
