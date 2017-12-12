package com.zhaogang.com.templatePattern;

public class Test {

    public static void main(String[] args) {
        
        Worker it1=new ITWorker("老王");
        it1.workOneDay();
        Worker it2=new ITWorker("小S");
        it2.workOneDay();
        Worker hr1=new HRWorker("媛媛");
        hr1.workOneDay();
        Worker qa1=new QAWorker("梦琦");
        qa1.workOneDay();
    }
}
