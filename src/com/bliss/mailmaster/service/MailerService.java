package com.bliss.mailmaster.service;

import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.bliss.mailmaster.utils.MailManager;

public class MailerService {
	MailManager mailManager;
	
	private static final String TO = "nbsiva90@gmail.com";
	private static final String FROM = "nbsiva90@gmail.com";
	private static final String BODY = "Hello World!";
	private static final String SUBJECT = "Hello World!";
	
	public String sendMail()
	{
		mailManager = MailManager.getMailerInstance();

		Content subject = new Content().withData(SUBJECT);
        Content textBody = new Content().withData(BODY); 
        Body body = new Body().withText(textBody);
        
        Message message = new Message().withSubject(subject).withBody(body);
        
        Destination destination = new Destination().withToAddresses(new String[]{TO});
        
        SendEmailRequest mailRequest = new SendEmailRequest().withSource(FROM).withDestination(destination).withMessage(message);
        
		mailManager.sendMail(mailRequest);
		
		return "success";
	}
}
