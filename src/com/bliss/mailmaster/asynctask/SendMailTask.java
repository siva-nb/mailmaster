package com.bliss.mailmaster.asynctask;

import org.apache.log4j.Logger;

import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.bliss.mailmaster.dao.CampaignDAO;
import com.bliss.mailmaster.dao.MailTransactionDAO;
import com.bliss.mailmaster.dao.impl.CampaignDAOImpl;
import com.bliss.mailmaster.mongodb.impl.MailTransactionDAOImpl;
import com.bliss.mailmaster.utils.Constants;
import com.bliss.mailmaster.utils.MailManager;
import com.bliss.mailmaster.utils.MongoDBManager;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class SendMailTask {

	private int campaignId;
	
	MongoDBManager mongoDBManager;
	
	DBCollection dbCollection;
	
	Logger logger = Logger.getLogger(SendMailTask.class);
	
	MailTransactionDAO mailTransaction = null;
	
	CampaignDAO campaignDAO = null;
	
	DBObject emailDBObject;
	
	MailManager mailManager;
	
	int userId;
	
	Content subject;
	Content textBody;
	Body body;
	Message message;
	Destination destination;
	SendEmailRequest mailRequest;
	
	public SendMailTask(int campaignId, int userId){
		this.campaignId =  campaignId;
		this.userId = userId;
		mailManager = MailManager.getMailerInstance();
	}
	
	private void sendMail(String title, String content, String to){
		subject = new Content().withData(title);
		textBody = new Content().withData(content); 
        body = new Body().withHtml(textBody);
        
        message = new Message().withSubject(subject).withBody(body);
        
        destination = new Destination().withToAddresses(new String[]{to});
        
        mailRequest = new SendEmailRequest().withSource(Constants.SENDER_EMAIL).withDestination(destination).withMessage(message);
        
		mailManager.sendMail(mailRequest);
	}
	
	public void execute() {
		mailTransaction = new MailTransactionDAOImpl();
		
		DBCursor emailTrnCursor = mailTransaction.getAllContactDetails(campaignId);
		
		campaignDAO = new CampaignDAOImpl();
		
		String result = campaignDAO.fetchRawCampaignContent(campaignId);
		
		String[] campaignComponent = result.split(Constants.DELIMITER);
		
		logger.info("Send Mail Task : Title "+ campaignComponent[0] + "Content "+campaignComponent[1]);
		
		while(emailTrnCursor.hasNext()){
			emailDBObject = emailTrnCursor.next();
			emailDBObject.get(Constants.CAMPAIGN_ID);
			emailDBObject.get(Constants.MAIL_STATUS);
			emailDBObject.get(Constants.EMAIL_ID);
			
			sendMail(campaignComponent[0],campaignComponent[1], String.valueOf(emailDBObject.get(Constants.EMAIL_ID)));
			
			updateCredits();
			
		}
		
		emailTrnCursor.close();
		mailTransaction.closeMongoDB();
		
	}
	
	private void updateCredits(){
		campaignDAO.updateCredits(userId);
	}

}
