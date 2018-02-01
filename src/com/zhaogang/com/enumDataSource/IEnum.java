package com.zhaogang.com.enumDataSource;

public interface IEnum {

	Integer getValue();//获取对用的主键
	String getName();//获取对应的内容
	IEnum getEnumByVal(Integer val);
	String getEnumToStr();
}
