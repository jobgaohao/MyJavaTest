package com.zhaogang.com.annotation;

@MyAnnotationOneMember("我是父类注解的元素：class")
public class Person {
        
    @MyAnnotationOneMember("我是父类注解的元素:method")
    public void sayHi() {
        System.out.println("Person sayHi");
    }      
}
