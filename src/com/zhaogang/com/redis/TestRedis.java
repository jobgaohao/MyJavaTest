package com.zhaogang.com.redis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class TestRedis {

	private Jedis jedis;
	
	public TestRedis(){
		jedis=RedisUtil.getJedis();
	}
	
	/**
	 * redis存储字符串
	 */
	public void testString(){
		//向key-->name中放入value-->张三
		jedis.set("name", "张三");
		System.out.println(jedis.get("name"));
		
		//拼接
		jedis.append("name", "是个好同学");
		System.out.println(jedis.get("name"));
        
		//删除某个键
		jedis.del("name");
		System.out.println(jedis.get("name"));
		
		//设置多个键值对
		jedis.mset("name","张三","age","25","QQ","329802836");
		jedis.incr("age");
		System.out.println(jedis.get("name")+"-"+jedis.get("age")+"-"+jedis.get("QQ"));
		
	}


	/**
	 * redis操作Map
	 */
	public void testMap(){
		Map<String,String> map=new HashMap<String,String>(); 
		map.put("name", "李四");
		map.put("age", "24");
		map.put("QQ", "321323213");
		jedis.hmset("user", map);
		
		//可变参数
		List<String> rsmap=jedis.hmget("user", "name","age","QQ");
		System.out.println(rsmap);
		
		jedis.hdel("user", "age");
		System.out.println(jedis.hmget("user", "age"));//因为删除了，所以返回的是null
		System.out.println(jedis.hlen("user"));//返回key为user的键中存放的值的个数
		System.out.println(jedis.exists("user"));//是否存在key为user的记录 返回true
		System.out.println(jedis.hkeys("user"));//返回map对象中的所以key
		System.out.println(jedis.hvals("user"));//返回map对象中的所以value
		
		Iterator<String> iter=jedis.hkeys("user").iterator();  
		while (iter.hasNext())
		{  
		       String key = iter.next();  
		       System.out.println(key+":"+jedis.hmget("user",key));  
		}  
	}
	
	
	/**
	 * jedis 操作list
	 */
	public void testList(){
		jedis.del("java framework");//移除所有内容
		System.out.println(jedis.lrange("java framework", 0, -1));
		//向key=java framework 里存放三条数据
		jedis.lpush("java framework", "spring");
		jedis.lpush("java framework", "struts");
		jedis.lpush("java framework", "hibernate");
		System.out.println(jedis.lrange("java framework", 0, -1));
		
		jedis.del("java framework");
		jedis.rpush("java framework","spring");  
		jedis.rpush("java framework","struts");  
		jedis.rpush("java framework","hibernate"); 
		System.out.println(jedis.lrange("java framework",0,-1));
	}
	
	
	public void testSet(){		
		//添加  
		jedis.sadd("fruit", "apple");
		jedis.sadd("fruit", "pear", "watermelon");
		jedis.sadd("fruit", "apple");
        //移除pear
		jedis.srem("fruit", "pear");         
        System.out.println(jedis.smembers("fruit"));//获取所有加入的value  
        System.out.println(jedis.scard("fruit"));//返回长度
        System.out.println(jedis.sismember("fruit", "pear"));//是否包含
        
        jedis.sadd("food", "bread", "milk","apple"); 
        System.out.println(jedis.sunion("fruit", "food"));//并集
        System.out.println(jedis.sdiff("food","fruit"));//差集
        
	}
	
	/**
	 * 操作set Sort
	 */
	public void testSetSort(){
		
		//jedis 排序  
        //注意，此处的rpush和lpush是List的操作。是一个双向链表（但从表现来看的）  
        jedis.del("a");//先清除数据，再加入数据进行测试  
        jedis.rpush("a", "1");  
        jedis.lpush("a","6");  
        jedis.lpush("a","3");  
        jedis.lpush("a","9");  
        System.out.println(jedis.lrange("a",0,-1));// [9, 3, 6, 1]  
        System.out.println(jedis.sort("a")); //[1, 3, 6, 9]  //输入排序后结果  
        System.out.println(jedis.lrange("a",0,-1));  
	}
}
