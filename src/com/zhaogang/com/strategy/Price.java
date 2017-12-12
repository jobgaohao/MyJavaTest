package com.zhaogang.com.strategy;

public class Price {

    //拥有一个具体的策略对象
    private MemberStrategy strategy;
    
    /**
     * 构造函数，传入一个具体的实现
     * @param strategy
     */
    public Price(MemberStrategy strategy){
        this.strategy=strategy;
    }
    
    /**
     * 
     * <pre>
     * 计算图书的价格
     * </pre>
     *
     * @param 图书的价格
     * @return 计算出打折后的图书价格
     */
    public double quote(double booksPrice){
        return this.strategy.calPrice(booksPrice);
    }
    
    /**
     * 
     * <pre>
     * 打印价格
     * </pre>
     *
     * @param booksPrice
     */
    public void print(double booksPrice){        
        System.out.println("图书的最终价格为："+quote(booksPrice));
        System.out.println("--------------------------------");
    }
    
}
