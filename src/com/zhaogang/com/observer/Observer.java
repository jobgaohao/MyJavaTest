package com.zhaogang.com.observer;

/**
 * 
 * <pre>
 * 观察者接口
 * </pre>
 *
 * @author hao.gao
 * @version $Id: Observer.java, v 0.1 2017年12月14日 下午8:02:40 hao.gao Exp $
 */
public interface Observer {

     /**
      * 
      * <pre>
      * 观察者规定的方法
      * </pre>
      *
      * @param hearMes
      */
     public void hearTelephone(String hearMes);
}
