package com.bliss.mailmaster.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.bliss.mailmaster.service.UserService;
import com.bliss.mailmaster.utils.Constants;
import com.bliss.mailmaster.utils.MailMasterException;
import com.bliss.mailmaster.vo.UserVO;
import com.mysql.jdbc.StringUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = 1L;

	private Map<String, Object> sessionAttributes;
	
	public String invokeLogin() throws MailMasterException
	{
		UserService userService = new UserService();
		
		UserVO userVO = null;
		
		if(frm_username == null || StringUtils.isEmptyOrWhitespaceOnly(frm_username))
		{
			throw new MailMasterException("User Name is invalid");
		}
		
		if(frm_password == null || StringUtils.isEmptyOrWhitespaceOnly(frm_password))
		{
			throw new MailMasterException("Password is invalid");
		}
		
		try{
			userVO = userService.login(frm_username, frm_password);
			if(userVO != null)
			{
				sessionAttributes.put(Constants.SESSION_USER, userVO);
				return "SUCCESS";
			}
			else
			{
				return "INPUT";
			}
		}catch(MailMasterException e){
			return "ERROR";
		}
	}
	
	@Override
	public void setSession(Map<String, Object> sessionAttributes) {
		this.sessionAttributes = sessionAttributes;
	}
	
	private String frm_username;
	private String frm_password;

	public String getFrm_username() {
		return frm_username;
	}

	public void setFrm_username(String frm_username) {
		this.frm_username = frm_username;
	}

	public String getFrm_password() {
		return frm_password;	
	}

	public void setFrm_password(String frm_password) {
		this.frm_password = frm_password;
	}
}
