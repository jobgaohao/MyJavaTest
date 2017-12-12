package com.zhaogang.com.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public final class RedisUtil {

	/**
	 * redis服务器ip
	 */
	private static String ADDR="127.0.0.1";
	
	/**
	 * redis端口号
	 */
	private static int PORT=6379;
	
    /**
     * 访问密码
     */
	private static String AUTH = "admin";
	
	/**
	 * 可连接实力的最大数目：默认值为8
	 * 如果赋值-1，则表示不限制，如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted（耗尽）
	 */	
	private static int MAX_ACTIVE=1024;
	
	/**
	 * 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也为8
	 */
	private static int MAX_IDLE=200;
	
	/**
	 * 等待可用的最大连时间，单位为毫秒，默认值为-1表示永不超时，如果等待超时，则直接抛出jedisConnectionException
	 */
	private static int MAX_WAIT=10000;
	
	private static int TIMEOUT=10000;
	
	/**
	 * 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
	 */
	private static boolean TEST_ON_BORROW=true; 
	
	private static JedisPool jedisPool = null;
	
	/**
	 * 初始化redis链接池
	 */
	static {
		try {
			JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxActive(MAX_ACTIVE);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWait(MAX_WAIT);
            config.setTestOnBorrow(TEST_ON_BORROW);
            jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * 获取jedis实例
	 */
	 public synchronized static Jedis getJedis() {
	        try {
	            if (jedisPool != null) {
	                Jedis resource = jedisPool.getResource();
	                return resource;
	            } else {
	                return null;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	 }
	 
	 /**
	  * 释放jedis资源
	  * @param jedis
	  */
	 public static void returnResourcce(final Jedis jedis){
		 if(jedis!=null){
			 jedisPool.returnResource(jedis);
		 }
	 }
}
