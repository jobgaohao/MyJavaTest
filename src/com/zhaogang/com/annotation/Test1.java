package com.zhaogang.com.annotation;

import java.lang.reflect.*;

public class Test1 {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        Children children=new Children();
        children.sayHi();
        children.sayHello();  
        
        //验证注解的继承性
        testAnnotationInherited();
        
    }
    
    
    /**
     * 
     * <pre>
     * 验证元注解
     * </pre>
     *
     */
    public static void testAnnotationInherited(){
        try {
            //使用类加载器加载类
            Class<?> c=Class.forName("com.zhaogang.com.annotation.Children");
            //判断类上面是否有注解
            boolean isExit=c.isAnnotationPresent(MyAnnotationOneMember.class);
            if(isExit){
                //拿到注解
                MyAnnotationOneMember myAnnotation=(MyAnnotationOneMember)c.getAnnotation(MyAnnotationOneMember.class);
                System.out.println("Value: "+myAnnotation.value());                
            }  
            
            Method[] methods=c.getMethods();
            for (Method method : methods) {
               boolean methodIsExit= method.isAnnotationPresent(MyAnnotationOneMember.class);
               if(methodIsExit){
                 //拿到注解
                 MyAnnotationOneMember myAnnotation=(MyAnnotationOneMember)method.getAnnotation(MyAnnotationOneMember.class);
                 System.out.println("Value: "+myAnnotation.value());
               }
               
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
