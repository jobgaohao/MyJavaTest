package com.zhaogang.com.observer.javaObserver;

/**
 * 
 * <pre>
 * jdk 提供的观察者模式
 * </pre>
 *
 * @author hao.gao
 * @version $Id: Test.java, v 0.1 2017年12月15日 下午2:13:27 hao.gao Exp $
 */
public class Test {

    public static void main(String[] args) {
        //创建一个目标
        ConcreteWeatherSubject subject=new ConcreteWeatherSubject();
        //创建观察者
        ConcreteObserver girl=new ConcreteObserver();
        girl.setObserverName("黄明女朋友");
        
        ConcreteObserver mum=new ConcreteObserver();
        mum.setObserverName("黄明妈妈");
        
        //注册观察者
        subject.addObserver(girl);
        subject.addObserver(mum);
        //发布消息
        subject.setContent("今天下雨了，气温3度，注意保暖。");
    }
}
