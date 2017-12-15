package com.zhaogang.com.observer.javaObserver;

import java.util.Observable;
import java.util.Observer;

/**
 * 
 * <pre>
 * 观察者
 * </pre>
 *
 * @author hao.gao
 * @version $Id: ConcreteObserver.java, v 0.1 2017年12月15日 下午1:31:05 hao.gao Exp $
 */
public class ConcreteObserver implements Observer {

    private String observerName;//观察者名称变量
      
    public String getObserverName() {
        return observerName;
    }

    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(observerName+"收到了消息：目标传过来的是："+arg.toString());
        ConcreteWeatherSubject concreteWeatherSubject=(ConcreteWeatherSubject)o;
        System.out.println(observerName+"收到了消息，主动到目标对象去拿，消息是："+concreteWeatherSubject.getContent());
    }
    
    
    
    

}
