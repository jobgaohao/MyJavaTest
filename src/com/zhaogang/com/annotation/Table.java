package com.zhaogang.com.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})//class
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Table {

    //表名称
    String value();
}
