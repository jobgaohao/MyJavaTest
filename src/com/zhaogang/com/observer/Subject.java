package com.zhaogang.com.observer;

/**
 * 
 * <pre>
 * 主题：定义增加、删除、通知 观察者
 * </pre>
 *
 * @author hao.gao
 * @version $Id: Subject.java, v 0.1 2017年12月14日 下午8:04:45 hao.gao Exp $
 */
public interface Subject {

    /**
     * 
     * <pre>
     * 新增观察者
     * </pre>
     *
     * @param obs
     */
    public void addObserver(Observer obs);
    
    /**
     * 
     * <pre>
     * 删除观察者
     * </pre>
     *
     * @param obs
     */
    public void deleteObserver(Observer obs);
    
    /**
     * 
     * <pre>
     * 通知观察者
     * </pre>
     *
     */
    public void notifyObservers();
}
