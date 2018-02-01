package com.zhaogang.com.enumDataSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class test {

	public static void main(String[] args) {
	 	String json= findCommonComboxByName(DataSourceType.class);
	 	System.out.println("json"+json); 
	 	String json1=findJsonByEnum(DataSourceType.class);
	 	System.out.println("json1"+json1);
	 	System.out.println("json2"+makeJsonStr());
	}
	
	
	@SuppressWarnings("unchecked")
	public static  String findJsonByEnum(Class clazz) {
		try {
			Method method=clazz.getMethod("getEnumToStr"); 
			String json= method.invoke(clazz.getEnumConstants()[0], null).toString();
			return json;
		} catch (Exception e) {
			return e.getMessage();
		}
		
	}
	
	
	public static <T> String findCommonComboxByName(Class<T> clazz) {
		Class<T>[] intefrfaces =  (Class<T>[]) clazz.getInterfaces();
		if(intefrfaces==null || intefrfaces.length!=1){
			return "";
		}
		
		Class<T> inte = intefrfaces[0];
		if(inte.getName().indexOf("IEnum")==-1){
			return "";
		}
		Method m;
		Object o = null;
		try {
			m = clazz.getMethod("getEnumToStr", null); 
			if(m!=null){
			    o = m.invoke(clazz.getEnumConstants()[0], null);
			}
		} catch(Exception e){
		    e.getMessage();
		}
		if(o!=null){
		    return o.toString(); 
		}
		return "";
	}
	
	public static String makeJsonStr(){
		JSONArray jsonArray=new JSONArray();
		for (int i = 1; i<= 10; i++) {
			JSONObject object =new JSONObject();
			object.put("key", "i"+1);
			object.put("values",i);
			jsonArray.add(object);	
		}	
		return jsonArray.toJSONString();
	}
}
