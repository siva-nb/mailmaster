package com.bliss.mailmaster.utils;

public class MailMasterException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private String errorMsg;
	
	public String getErrorMsg() {
		return errorMsg;
	}

	public MailMasterException(String errorMsg){
		this.errorMsg = errorMsg;
	}
}
