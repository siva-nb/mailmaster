package com.bliss.mailmaster.action;

import com.bliss.mailmaster.UserAware;
import com.bliss.mailmaster.vo.UserVO;
import com.opensymphony.xwork2.ActionSupport;

public class WelcomeAction extends ActionSupport implements UserAware{
	
	private static final long serialVersionUID = 1L;
	
	UserVO uservo = null;
	
	public String invokeWelcome(){
		System.out.println("Hi "+uservo.getFirstName());
		return "SUCCESS";
	}

	@Override
	public void setUser(UserVO uservo) {
		this.uservo = uservo;
	}
	
	
	
}
