package com.bliss.mailmaster.action;

import org.apache.log4j.Logger;

import com.bliss.mailmaster.response.JsonResponse;
import com.bliss.mailmaster.service.ContactService;
import com.bliss.mailmaster.utils.MailMasterException;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class ListContactsAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	Logger logger = Logger.getLogger(ListContactsAction.class);
	
	private int param_groupid;
	private int param_page_no;
	
	private String jsonString;
	
	public String invokeListContacts()
	{
		logger.info("Invoke List Contacts");
		
		try{
			listContact();
		}catch(MailMasterException e){
			logger.fatal(e.getMessage(), e);
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	private void listContact() throws MailMasterException
	{
		ContactService contactService = new ContactService();
		JsonResponse jsonResponse = contactService.fetchContactByGroup(param_groupid, param_page_no);
		jsonString = jsonResponse.getJsonList();
		logger.debug("List Contacts "+jsonResponse.getJsonList());
	}

	public int getParam_groupid() {
		return param_groupid;
	}

	public void setParam_groupid(int param_groupid) {
		this.param_groupid = param_groupid;
	}

	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}

	public int getParam_page_no() {
		return param_page_no;
	}

	public void setParam_page_no(int param_page_no) {
		this.param_page_no = param_page_no;
	}
}
