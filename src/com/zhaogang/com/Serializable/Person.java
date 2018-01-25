package com.zhaogang.com.Serializable;

import java.io.Serializable;

public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int age;
	private String name;
	private String sex;
	private String height;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
		
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	private void SayHello(){
		System.out.println("hi,my name is "+this.name);
	}
}
