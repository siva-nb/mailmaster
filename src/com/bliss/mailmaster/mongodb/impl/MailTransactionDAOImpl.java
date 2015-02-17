package com.bliss.mailmaster.mongodb.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

import com.bliss.mailmaster.dao.MailTransactionDAO;
import com.bliss.mailmaster.utils.Constants;
import com.bliss.mailmaster.utils.DatabaseManager;
import com.bliss.mailmaster.utils.MongoDBManager;
import com.bliss.mailmaster.utils.SQL;
import com.bliss.mailmaster.utils.Constants.MailStatus;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class MailTransactionDAOImpl implements MailTransactionDAO {

	MongoDBManager mongoManager;

	Connection dbConnection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	BasicDBObject basicdbObject;

	Logger logger = Logger.getLogger(MailTransactionDAOImpl.class);

	private void populateContactFromCampaignId(int campaignId){

		try{

			dbConnection = DatabaseManager.getConnection();

			preparedStatement = dbConnection.prepareStatement(SQL.SELECT_CAMPAIGN_CONTACTS);
			preparedStatement.setInt(1, MailStatus.NASCENT.getValue());
			preparedStatement.setInt(2, campaignId);

			resultSet = preparedStatement.executeQuery();


			logger.debug("Select Contacts By Group : Successfully queried");

			populateMongoDB();

		}catch(SQLException | NamingException e){
			logger.fatal("Async Send Mail: SQLException "+e.getMessage(), e);
		}finally{
			try{
				closeGracefully();
			}catch(SQLException e){
				logger.fatal("Async Send Mail: SQLException "+e.getMessage(), e);
			}
		}
	}

	private void populateMongoDB()
	{
		DBCollection mailMasterCollection = mongoManager.getCollection(Constants.MAILMASTER_EMAIL_COLLECTION);

		try {
			if(resultSet != null){

				int campaignIndex = resultSet.findColumn("campaignId");
				int mailStatusIndex = resultSet.findColumn("mailStatus");
				int emailIndex = resultSet.findColumn("email");

				while (resultSet.next()) {
					basicdbObject = new BasicDBObject();

					basicdbObject.put(Constants.CAMPAIGN_ID,resultSet.getInt(campaignIndex));
					basicdbObject.put(Constants.MAIL_STATUS,resultSet.getInt(mailStatusIndex));
					basicdbObject.put(Constants.EMAIL_ID,resultSet.getString(emailIndex));

					mailMasterCollection.insert(basicdbObject);
				}

				logger.debug("Populate Mongo : Added all necessary records");
			}

		} catch (SQLException e) {
			logger.fatal("Init Mail Campaign : "+e.getMessage());
			e.printStackTrace();
		}finally{
			mongoManager.closeClient();
		}
	}

	@Override
	public int initMailCampaign(int campaignId) {
		mongoManager = new MongoDBManager();

		logger.info("Init Mail Campaign : Using MailMaster Collection");

		populateContactFromCampaignId(campaignId);

		return 0;
	}

	@Override
	public int updateMailStatus(int campaignId, int contactId, int mailStatus) {
		return 0;
	}



	private void closeGracefully() throws SQLException
	{
		DatabaseManager.closeConnection(dbConnection);

		if(preparedStatement != null){
			preparedStatement.close();
		}

		if(resultSet != null){
			resultSet.close();
		}
	}

	@Override
	public DBCursor getAllContactDetails(int campaignId) {
		
		mongoManager = new MongoDBManager();
		
		DBCollection dbCollection = mongoManager.getCollection(Constants.MAILMASTER_EMAIL_COLLECTION);
		
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put(Constants.CAMPAIGN_ID, campaignId);
		
		DBCursor dbCursor = dbCollection.find(whereQuery);
		logger.debug("Get Contact Details : Querying Email contents Complete");
		
		if(dbCursor == null){
			logger.fatal("Get Contact Details : Result Set is null");	
		}
		
		return dbCursor;
		
	}
	
	@Override
	public void closeMongoDB() {
		mongoManager.closeClient();
		logger.debug("Close Mongo : Closed");
	}


}
