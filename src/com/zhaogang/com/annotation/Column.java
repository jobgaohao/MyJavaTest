package com.zhaogang.com.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})//列
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Column {

    //列名称
    public String columnName();
    
    //查询条件类型
    public ESearchType searchType();
}
