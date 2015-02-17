package com.bliss.mailmaster.utils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;

public class MailManager {
	public static MailManager mailManager;
	
	private AWSCredentials awsCredential;
	private AmazonSimpleEmailService awsEmailClient;
	
	
	private MailManager(){
		awsCredential =  new BasicAWSCredentials("SecretKey", "AccessKey");
		awsEmailClient = new AmazonSimpleEmailServiceClient(awsCredential);
		Region usWest2 = Region.getRegion(Regions.US_WEST_2);
		awsEmailClient.setRegion(usWest2);
	}
	
	public static MailManager getMailerInstance(){
		if(mailManager == null){
			synchronized (MailManager.class) {
				if(mailManager == null){
					mailManager = new MailManager();
				}
			}
		}
		return mailManager;
	}
	
	public void sendMail(SendEmailRequest mailRequest){
		awsEmailClient.sendEmail(mailRequest);
	}
}
