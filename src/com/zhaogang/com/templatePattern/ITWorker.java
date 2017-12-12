package com.zhaogang.com.templatePattern;

public class ITWorker extends Worker {

    public ITWorker(String name){
        super(name);
    }
    
    @Override
    public void work() {
        System.out.println(name+"写程序");
    }
    
    public boolean isNeedPrintDate(){
        return true;
    }

}
