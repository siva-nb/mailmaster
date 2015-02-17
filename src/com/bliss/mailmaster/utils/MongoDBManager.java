package com.bliss.mailmaster.utils;

import java.net.UnknownHostException;

import org.apache.log4j.Logger;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoDBManager {

	Logger logger = Logger.getLogger(MongoDBManager.class);
	
	MongoClient mongoClient;
	DBCollection dbCollection;
	DB mailMasterDB;
	
	public MongoDBManager(){
		
		try {
			mongoClient = new MongoClient("localhost");
			mailMasterDB = mongoClient.getDB("mailmaster");
			
			logger.debug("MongoDB Manager : Connected to Mongo  DB");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public DBCollection getCollection(String collectionName){
		dbCollection = mailMasterDB.getCollection(collectionName);
		return dbCollection;
	}
	
	public void closeClient()
	{
		mongoClient.close();
	}
}
