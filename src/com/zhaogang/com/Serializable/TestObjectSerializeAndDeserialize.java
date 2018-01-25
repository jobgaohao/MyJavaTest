package com.zhaogang.com.Serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.MessageFormat;

/**
 * Java 序列化，反序列化Demo
 * @author hao.gao
 *
 */
public class TestObjectSerializeAndDeserialize {

	public static void main(String[] args) throws Exception {
		//SerializePerson();	
		Person p=DeserializePerson();
		System.out.println(MessageFormat.format("name={0},age={1},sex={2},height={3}", 
				p.getName(),p.getAge(),p.getSex(),p.getHeight()));
		
	}
		
	private static void SerializePerson() throws FileNotFoundException,IOException{		
		Person person=new Person();
		person.setName("张三");
		person.setAge(18);
		person.setSex("男");
		person.setHeight("175cm");
		ObjectOutputStream oo=new ObjectOutputStream(new FileOutputStream(new File("E:/Person.txt")));
		oo.writeObject(person);
		oo.close();
		System.out.println("Person对象序列化成功");
	}
		
	public static Person DeserializePerson() throws Exception,IOException{
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream(new File("E:/Person.txt")));
		Person person=(Person)ois.readObject();
		System.out.println("Person对象反序列化成功");
		return person;
	}
}
