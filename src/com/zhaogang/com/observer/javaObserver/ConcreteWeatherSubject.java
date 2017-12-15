package com.zhaogang.com.observer.javaObserver;

import java.util.Observable;

/**
 * 
 * <pre>
 * 天气目标的具体实现类
 * </pre>
 *
 * @author hao.gao
 * @version $Id: ConcreteWeatherSubject.java, v 0.1 2017年12月15日 下午1:20:05 hao.gao Exp $
 */
public class ConcreteWeatherSubject extends Observable {

    //天气情况内容
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.setChanged();//通知前，设置改变
        this.notifyObservers(content);//进行通知
    }
     
    
}
