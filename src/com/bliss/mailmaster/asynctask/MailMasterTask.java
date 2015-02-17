package com.bliss.mailmaster.asynctask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.bliss.mailmaster.dao.CampaignDAO;
import com.bliss.mailmaster.dao.ContactsDAO;
import com.bliss.mailmaster.dao.MailTransactionDAO;
import com.bliss.mailmaster.dao.impl.CampaignDAOImpl;
import com.bliss.mailmaster.dao.impl.ContactsDAOImpl;
import com.bliss.mailmaster.mongodb.impl.MailTransactionDAOImpl;
import com.bliss.mailmaster.utils.Constants.CampaignStatus;
import com.bliss.mailmaster.utils.DatabaseManager;

public class MailMasterTask implements Runnable  {

	MailMasterJob mMailMasterJob;

	Connection dbConnection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	Logger logger =Logger.getLogger(MailMasterTask.class);
	
	CampaignDAO campaignDAO = new CampaignDAOImpl();
	
	MailTransactionDAO mailTransaction = new MailTransactionDAOImpl();
	
	SendMailTask sendMailTask = null;
	
	int credit;
	
	int userId;
	
	public MailMasterTask(MailMasterJob mailMasterJob, int credit, int userId){
		this.mMailMasterJob = mailMasterJob;
		sendMailTask = new SendMailTask(mMailMasterJob.getCampaignId(), userId);
		this.credit = credit;
		this.userId = userId;
	}

	@Override
	public void run() {
		performBackgroundTask();
		sendMailTask.execute();
	}
	


	private void performBackgroundTask()
	{
		logger.debug("Background Task : "+mMailMasterJob.getTaskName());
		
		campaignDAO.updateCampaignStatus(mMailMasterJob.getCampaignId(), CampaignStatus.START.getValue());
		
		mailTransaction.initMailCampaign(mMailMasterJob.getCampaignId());
		
	}

}
