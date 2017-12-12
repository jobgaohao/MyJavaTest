package com.zhaogang.com.annotation;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MyAnnotation {
    //String desc(int a) throws IOException;//1.成员以无参无异常方式声明
    ELoseType loseType();
    String author();  
    public boolean nullable() ;
    public long[] enumeratel() default {};
    MyAnnotationOneMember myAnnotationOneMember();
    int age() default 18;//可以用default为成员指定一个默认值
    Class<Person> style() ;//Class
}
