package com.zhaogang.com.templatePattern;

public class QAWorker extends Worker {

    public QAWorker(String name){
        super(name);
    }
    
    @Override
    public void work() {
        System.out.println(name+"写测试用例-提交BUG");
    }

}
