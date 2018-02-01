package com.zhaogang.com.enumDataSource;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class EnumsUtil {

	public static IEnum getEnumByVal(Integer val,IEnum[] values){
		if(val==null){
			return null;
		}
		IEnum result=null;
		for (IEnum iEnum : values) {
			if(val.equals(iEnum.getValue())){
				result=iEnum;
				break;
			}
		}
		return result;
	}
	
	public static String getEnumToJsonStr(IEnum[] values){
		JSONArray jsonArray=new JSONArray();
		for (IEnum x : values) {
			JSONObject json=new JSONObject();
			json.put("value", x.getValue());
			json.put("name",x.getName());
			jsonArray.add(json);
		}
		return jsonArray.toJSONString();
	}
	
	
}
