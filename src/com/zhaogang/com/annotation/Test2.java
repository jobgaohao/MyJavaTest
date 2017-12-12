package com.zhaogang.com.annotation;

/**
 * 
 * <pre>
 * 注解的用法
 * </pre>
 *
 * @author hao.gao
 * @version $Id: Test2.java, v 0.1 2017年7月20日 下午4:49:47 hao.gao Exp $
 */


@MyAnnotation(author="张三",
                age=20, 
                loseType = ELoseType.loseapply, 
                myAnnotationOneMember = @MyAnnotationOneMember("武汉"), 
                nullable = false, 
                style = Person.class
                )
public class Test2 {

   
}
