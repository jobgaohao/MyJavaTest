package com.zhaogang.com.templatePattern;

import java.util.Date;

public abstract class Worker {

    protected String name;
    
    public boolean isNeedPrintDate(){
        return false;
    }
    
    public Worker(String name){
        this.name=name;
    }
    
    public final void workOneDay(){
        System.out.println("--------------work start------------------------");
        enterCompany();
        computerOn();
        work();
        cumputerOff();
        exitCompany();
        System.out.println("--------------work end------------------------");
    }

    /**
     * 
     * <pre>
     * 关闭电脑
     * </pre>
     *
     */
    private void cumputerOff() {
      System.out.println(name+"关闭电脑");
    }

    /**
     * 
     * <pre>
     * 工作
     * </pre>
     *
     */
    public abstract void work();

    /**
     * 
     * <pre>
     * 打开电脑
     * </pre>
     *
     */
    private void computerOn() {
      System.out.println(name+"打开电脑");
    }

    /**
     * 
     * <pre>
     * 进入公司
     * </pre>
     *
     */
    private void enterCompany() {
      System.out.println(name+"进入公司");
    }
    
    /**
     * 
     * <pre>
     * 进入公司
     * </pre>
     *
     */
    private void exitCompany() 
    {
       if(isNeedPrintDate()){
           System.out.print(new Date().toLocaleString()+"-->");
       }
       System.out.println(name+"离开公司");
    }
}
