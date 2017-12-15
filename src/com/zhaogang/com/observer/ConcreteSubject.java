package com.zhaogang.com.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <pre>
 * 具体的主题【demo:求职中心】
 * </pre>
 *
 * @author hao.gao
 * @version $Id: ConcreteSubject.java, v 0.1 2017年12月14日 下午8:10:34 hao.gao Exp $
 */
public class ConcreteSubject implements Subject {

    public String mes;
    
    public boolean changed;
    
    public List<Observer> observers;
    
    public ConcreteSubject(){
        mes="";
        changed=false;
        observers=new ArrayList<Observer>();
    }
    

    
    @Override
    public void addObserver(Observer obs) {
        if(!observers.contains(obs)){
            observers.add(obs);
        }
    }

    @Override
    public void deleteObserver(Observer obs) {
        if(observers.contains(obs)){
           observers.remove(obs); 
        }
    }

    @Override
    public void notifyObservers() {
        if(changed){
            for (Observer observer : observers) {
                observer.hearTelephone(this.mes);
            }
        }               
    }
    
    public void getNewMes(String str){
        if(str.equals(this.mes)){
            changed=false;
        }
        else{
            this.mes=str;
            changed=true;
            notifyObservers();
        }
    }

}
