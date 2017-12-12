package com.zhaogang.com.templatePattern;

public class HRWorker extends Worker {

    public HRWorker(String name){
        super(name);
    }
    
    @Override
    public void work() {
        System.out.println(name+"看简历打电话");
    }

}
