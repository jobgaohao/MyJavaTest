package com.zhaogang.com.strategy;

/**
 * 
 * <pre>
 * 中级会员折扣类
 * </pre>
 *
 * @author hao.gao
 * @version $Id: IntermediateMemberStrategy.java, v 0.1 2017年12月12日 下午3:26:24 hao.gao Exp $
 */
public class IntermediateMemberStrategy implements MemberStrategy {

    @Override
    public double calPrice(double booksPrice) {
        System.out.println("对于中级会员的折扣为10%");
        return booksPrice*0.9;
    }

}
