package com.zhaogang.com.strategy;

/**
 * 
 * <pre>
 * 高级会员折扣类
 * </pre>
 *
 * @author hao.gao
 * @version $Id: AdvanceMemberStrategy.java, v 0.1 2017年12月12日 下午3:31:26 hao.gao Exp $
 */
public class AdvanceMemberStrategy implements MemberStrategy {

    @Override
    public double calPrice(double booksPrice) {
        System.out.println("对于高级会员折扣为20%");
        return booksPrice*0.8;
    }

}
