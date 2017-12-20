package com.zhaogang.com.handlerChain.demo1;

/**
 *价格处理人，负责申请客户折扣申请 
 * @author hao.gao
 *
 */
public abstract class PriceHandler {
    
	/**
	 * 直接后继，用于传递请求
	 */
	protected PriceHandler successor;

	public void setSuccessor(PriceHandler successor) {
		this.successor = successor;
	}
     
	/**
	 * 处理折扣请求
	 * @param discount:折扣
	 */
	public abstract void processDiscount(float discount);	
     
	/**
	 * 创建PriceHandler工厂方法
	 * @return
	 */
	public static PriceHandler createPriceHandler(){
		//创建对象
		PriceHandler salesman=new Salesman();
		PriceHandler manager=new Manager();
		PriceHandler director=new Director();
		PriceHandler vp=new VicePresident();
		PriceHandler ceo=new CEO();
		
		//指定直接后继
		salesman.setSuccessor(manager);
		manager.setSuccessor(director);
		director.setSuccessor(vp);
		vp.setSuccessor(ceo);
		
		return salesman;
	}
}
