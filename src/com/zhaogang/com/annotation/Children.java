package com.zhaogang.com.annotation;



public class Children extends Person {

    @Override
    public void sayHi()  {
        System.out.println("Children sayHi");
    }

    @Deprecated
    public void sayHello() {
        System.out.println("hello");
    }
    
    @MyAnnotationOneMember("我是子类注解的元素:method")
    public String call(){
        return "";
    }

}
