package com.bliss.mailmaster.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import com.bliss.mailmaster.dao.ContactsDAO;
import com.bliss.mailmaster.dao.impl.ContactsDAOImpl;
import com.bliss.mailmaster.response.JsonResponse;
import com.bliss.mailmaster.utils.Constants;
import com.bliss.mailmaster.vo.ContactsUploadVO;
import com.bliss.mailmaster.vo.ContactsVO;
import com.google.gson.Gson;
import com.mysql.jdbc.StringUtils;

public class ContactService {
	private Logger logger = Logger.getLogger(ContactService.class);
	
	private ContactsDAO contactsDAO = null;
	
	public JSONObject addNewContact(int groupid, int status, String firstName, String lastName, String email)
	{
		
		int insertFlag;
		ContactsVO contactsvo = null;
		
		JSONObject jsonResponse = new JSONObject();
		
		if(groupid == 0)
		{
			logger.error("AddNewContact : Group Id is invalid");
			jsonResponse.put(Constants.RESPONSE_PARAM_STATUS, Constants.RESPONSE_STATUS_ERROR);
			return jsonResponse;
		}
		
		
		if(firstName == null || StringUtils.isEmptyOrWhitespaceOnly(firstName) || firstName.length() > 50)
		{
			logger.error("AddNewContact : firstName is invalid");
			jsonResponse.put(Constants.RESPONSE_PARAM_STATUS, Constants.RESPONSE_STATUS_ERROR);
			return jsonResponse;
		}
		
		if(email == null || StringUtils.isEmptyOrWhitespaceOnly(email) || email.length() > 100)
		{
			logger.error("AddNewContact : email is invalid");
			jsonResponse.put(Constants.RESPONSE_PARAM_STATUS, Constants.RESPONSE_STATUS_ERROR);
			return jsonResponse;
		}
		
		if(lastName != null && lastName.length() > 100)
		{
			logger.error("AddNewContact : lastName is invalid");
			jsonResponse.put(Constants.RESPONSE_PARAM_STATUS, Constants.RESPONSE_STATUS_ERROR);
			return jsonResponse;
		}
		
		if(lastName != null && StringUtils.isEmptyOrWhitespaceOnly(lastName))
		{
			lastName = null;
		}
		
		contactsDAO = new ContactsDAOImpl();
		
		contactsvo = buildContactDetails(groupid, status, firstName, lastName, email);
		
		insertFlag = contactsDAO.addNewContact(contactsvo);
		
		if(insertFlag == 1){
			jsonResponse.put(Constants.RESPONSE_PARAM_STATUS, Constants.RESPONSE_STATUS_OK);
		}else{
			jsonResponse.put(Constants.RESPONSE_PARAM_STATUS, Constants.RESPONSE_STATUS_ERROR);
		}
		
		return jsonResponse;
	}
	
	public ContactsVO buildContactDetails(int groupid, int status, String firstName, String lastName, String email)
	{
		ContactsVO contactsvo = new ContactsVO();
		
		contactsvo.setEmail(email);
		contactsvo.setFirstName(firstName);
		contactsvo.setLastName(lastName);
		contactsvo.setGroupId(groupid);
		contactsvo.setStatus(status);
		
		return contactsvo;
	}

	public JsonResponse fetchContactByGroup(int groupid, int pageno){

		List<ContactsVO> contactList = null;
		
		JsonResponse jsonResponse = new JsonResponse();
		
		Gson gson = new Gson();
		
		contactsDAO = new ContactsDAOImpl();
		contactList = contactsDAO.listContactsByGroup(groupid, pageno);
		
		if(contactList != null){
			jsonResponse.setStatusCode(Constants.RESPONSE_STATUS_OK);
			jsonResponse.setJsonList(gson.toJson(contactList).toString());
			
		}else{
			jsonResponse.setStatusCode(Constants.RESPONSE_STATUS_ERROR);
			jsonResponse.setStatusMsg("Error");
		}
		
		return jsonResponse;
	}

	public int addContactBulkUpload(List<ContactsUploadVO> contactList){
		int[] results = null;
		int insertCounter = 0;
		
		contactsDAO = new ContactsDAOImpl();
		
		try{
			results = contactsDAO.bulkUploadContacts(contactList);
			for(int result : results){
				if(result != 0)
				insertCounter++;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		logger.info("Inserted Successfully "+insertCounter);
		return insertCounter;
	}
}
