package com.bliss.mailmaster.action;

import com.bliss.mailmaster.service.MailerService;
import com.opensymphony.xwork2.ActionSupport;

public class SendMailerAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;

	public String sendMail()
	{
		MailerService mailService = new MailerService();
		mailService.sendMail();
		
		return "SUCCESS";
	}
}
