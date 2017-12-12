package com.zhaogang.com.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
public class Test4 {

    public static void main(String[] args) {
        Filter f1=new Filter();
        f1.setPkid(1002L);
        String sql1=query(f1);
        System.out.println(sql1);
        
        Filter f2=new Filter();
        f2.setName("张三");
        f2.setPkid(1001L);
        String sql2=query(f2);
        System.out.println(sql2);
        
        Filter f3=new Filter();
        f3.setEmail("aa@163.com,bb@163.com,cc@qq.com");
        String sql3=query(f3);
        System.out.println(sql3);
    }
    
    public static String query(Object filter){
        StringBuilder sqlStrBuilder = new StringBuilder();
        //1.获取到Class
        Class<? extends Object> c = filter.getClass();
        //判断是否包含Table类型的注解
        if(!c.isAnnotationPresent(Table.class)){
            return null;
        }
        //2.获取到table的名字
        Table t = (Table)c.getAnnotation(Table.class);
        String tableName = t.value();
        //加入 where 1=1 ，是为了防止未来如果没有条件的情况下也不会报错
        sqlStrBuilder.append("select * from ").append(tableName).append(" where 1=1");
        
        Field[] fArray = c.getDeclaredFields();   //获取类属性的所有字段，
        //3.遍历所有的字段
        for (Field field : fArray) { 
            //4.处理每个字段对应的sql
            //判断是否包含Column类型的注解
            if(!field.isAnnotationPresent(Column.class)){
                continue;
            }
            //4.1.拿到字段上面注解的值，即Column注解的值
            Column column = field.getAnnotation(Column.class);
            String columnName = column.columnName(); //注解对应的DB列名称 
            //4.2.拿到字段的名
            String filedName = field.getName();
            //获取相应字段的getXXX()方法
            String getMethodName = "get" + filedName.substring(0, 1).toUpperCase()
                    + filedName.substring(1);
            //字段的值
            Object fieldValue = null;//属性有int、String等，所以定义为Object类
            try {
                Method getMethod = c.getMethod(getMethodName);
                fieldValue = getMethod.invoke(filter);//通过代理获取字段的值
            } catch (Exception e) {
                e.printStackTrace();
            } 
            
            //4.3.拼接sql
            if(fieldValue==null || (fieldValue instanceof Integer && (Integer)fieldValue==0)){
                continue;
            }
            sqlStrBuilder.append(" and ").append(columnName);
            if(fieldValue instanceof String){
                //region 包含逗号的代表数据
                if(((String)fieldValue).contains(",")){
                    String[] values = ((String)fieldValue).split(",");
                    sqlStrBuilder.append(" ").
                    append(column.searchType().GetDesc()).
                    append(" (");
                    for (String v : values) {
                        sqlStrBuilder.append("'").append(v).append("'").append(",");
                    }
                    sqlStrBuilder.deleteCharAt(sqlStrBuilder.length()-1);
                    sqlStrBuilder.append(")");
                }
                else{
                    sqlStrBuilder.append(" ").
                    append(column.searchType().GetDesc()).
                    append("'").
                    append(fieldValue).
                    append("'");
                }
             //endregion
            }
            else if(fieldValue instanceof Integer){
                sqlStrBuilder.append(column.searchType().GetDesc()).
                append(fieldValue);
            }
            else if(fieldValue instanceof Long){
                sqlStrBuilder.append(column.searchType().GetDesc()).
                append(fieldValue);
            }
        }
        return sqlStrBuilder.toString();
    }
}
