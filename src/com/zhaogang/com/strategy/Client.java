package com.zhaogang.com.strategy;

/**
 * 
 * <pre>
 * 策略模式
 * 策略模式的中心：不是如何实现算法，而是如何组织，调用这些算法，从而让程序结构更灵活，具有更好的维护性和扩展性
 * 算法平等性：对于一系列具体的策略算法，大家的地位是完全一样的，正应为这个平等性，才能实现算法之间可相互替换，策略算法在实现上相互独立，相互之间没有依赖。
 *         策略算法是相同行为的不同实现
 * 
 * 优点：
 * 1.策略模式提供了管理相关的算法族的办法，避免代码重复
 * 2.使用策略模式可以避免使用多重条件（if-else）语句，多重条件语句不易维护，逻辑都混合在一起，原始落后
 * 
 * 缺点：
 * 1.客户端必须知道所有的策略类，并自行决定使用哪一个策略类，客户端知道算法或行为的情况
 * 2.策略模式把每个具体的策略实现都封装成为类，如果备选的策略很多，那么对象的数目就很多
 * </pre>
 *
 * @author hao.gao
 * @version $Id: Client.java, v 0.1 2017年12月12日 下午3:50:33 hao.gao Exp $
 */
public class Client {

    public static void main(String[] args) {
        MemberStrategy strategy=new AdvanceMemberStrategy();               
        Price price=new Price(strategy);
        price.print(300); 
        
        strategy=new IntermediateMemberStrategy();               
        price=new Price(strategy);
        price.print(300);
        
        strategy=new PrimaryMemberStrategy();               
        price=new Price(strategy);
        price.print(300);                
    }
}
