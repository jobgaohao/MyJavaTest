package com.zhaogang.com.strategy;

/**
 * 
 * <pre>
 * 初级会员折扣类
 * </pre>
 *
 * @author hao.gao
 * @version $Id: PrimaryMemberStrategy.java, v 0.1 2017年12月12日 下午3:26:05 hao.gao Exp $
 */
public class PrimaryMemberStrategy implements MemberStrategy {

    @Override
    public double calPrice(double booksPrice) {        
        System.out.println("对于初级会员没有折扣");
        return booksPrice;
    }
    
    

}
