package com.zhaogang.com.strategy;

/**
 * 
 * <pre>
 * 抽象折扣类
 * </pre>
 *
 * @author hao.gao
 * @version $Id: MemberStrategy.java, v 0.1 2017年12月12日 下午3:20:34 hao.gao Exp $
 */
public interface MemberStrategy {

    /**
     * 
     * <pre>
     * 计算图书的价格
     * </pre>
     *
     * @param  图书原价
     * @return 计算出打折后的价格
     */
    public double calPrice(double booksPrice);
}
