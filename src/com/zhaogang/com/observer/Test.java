package com.zhaogang.com.observer;

public class Test {

    public static void main(String[] args) {
        ConcreteSubject jobCenter=new ConcreteSubject();//具体主题
        
        //创建观察者
        UniversityStudentObserver zhangsan=new UniversityStudentObserver("a.txt");
        ProgrammerObserver lisi=new ProgrammerObserver("b.txt");
        
        
        jobCenter.addObserver(zhangsan);
        jobCenter.addObserver(lisi);
        
        jobCenter.getNewMes("腾辉公司需要10个Java程序员。");      
        jobCenter.getNewMes("海景公司需要8个动画设计师。"); 
        jobCenter.getNewMes("仁海公司需要9个电工。");
        jobCenter.getNewMes("仁海公司需要9个电工。");
    }
}
