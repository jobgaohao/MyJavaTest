package com.zhaogang.com.annotation;

/**
 * 
 * <pre>
 * 解析注解
 * </pre>
 *
 * @author hao.gao
 * @version $Id: Test3.java, v 0.1 2017年7月20日 下午4:49:22 hao.gao Exp $
 */
public class Test3 {
    public static void main(String[] args) {
        try {
            //使用类加载器加载类
            Class c=Class.forName("com.zhaogang.com.annotation.Test2");
            //判断类上面是否有注解
            boolean isExit=c.isAnnotationPresent(MyAnnotation.class);
            if(isExit){
                //拿到注解
                MyAnnotation myAnnotation=(MyAnnotation)c.getAnnotation(MyAnnotation.class);
                System.out.println("age: "+myAnnotation.age());
                System.out.println("遗失类型: "+myAnnotation.loseType().GetDesc());
                System.out.println("author: "+myAnnotation.author());
                System.out.println("nullable: "+myAnnotation.nullable());
                System.out.println("myAnnotationOneMember: "+myAnnotation.myAnnotationOneMember().value());
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
