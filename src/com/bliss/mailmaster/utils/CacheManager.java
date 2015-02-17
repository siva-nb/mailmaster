package com.bliss.mailmaster.utils;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.log4j.Logger;

import net.spy.memcached.MemcachedClient;

public class CacheManager {
	private static CacheManager mInstance = null;
	private MemcachedClient mMemcachedClient = null;

	static Logger logger = Logger.getLogger(CacheManager.class);
	
	private CacheManager() throws IOException
	{
		mMemcachedClient = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
	}
	
	public static synchronized CacheManager getInstance() throws IOException
	{
		logger.info("CacheManager Init");
		
		if(mInstance == null)
		{
			logger.info("Creating new Cache Instance");
			mInstance = new CacheManager();
		}
		return mInstance;
	}
	
	public void add(String key, int expr,  Object value){
		mMemcachedClient.add(key,expr, value);
	}
	
	public Object get(String key){
		return mMemcachedClient.get(key);
	}
	
	public void clear()
	{
		mMemcachedClient.flush();
	}
}
