package com.bliss.mailmaster.dao;

import com.mongodb.DBCursor;

public interface MailTransactionDAO {
	public int initMailCampaign(int campaignId);
	public DBCursor getAllContactDetails(int campaignId);
	public int updateMailStatus(int campaignId, int contactId, int mailStatus);
	public void closeMongoDB();
	
}
