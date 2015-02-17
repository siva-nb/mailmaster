package com.bliss.mailmaster.service;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import com.bliss.mailmaster.dao.GroupDAO;
import com.bliss.mailmaster.dao.impl.GroupDAOImpl;
import com.bliss.mailmaster.utils.Constants;
import com.mysql.jdbc.StringUtils;

public class GroupService {
	private Logger logger = Logger.getLogger(GroupService.class);
	
	private GroupDAO groupDAO = null;
	
	/**
	 * Validates the params and passes to data layer
	 * @param groupName
	 * @param groupDesc
	 * @return JSON response with appropriate results	
	 */
	
	public JSONObject addNewGroup(String groupName, String groupDesc){
		int insertFlag;
		JSONObject jsonResponse = new JSONObject();
		
		if(groupName == null || StringUtils.isEmptyOrWhitespaceOnly(groupName) || groupName.length() > 50)
		{
			logger.error("AddNewGroup : Username is invalid");
			jsonResponse.put(Constants.RESPONSE_PARAM_STATUS, Constants.RESPONSE_STATUS_ERROR);
			return jsonResponse;
		}
		
		if(groupDesc == null || StringUtils.isEmptyOrWhitespaceOnly(groupDesc) || groupDesc.length() > 100)
		{
			logger.error("AddNewGroup : Password is invalid");
			jsonResponse.put(Constants.RESPONSE_PARAM_STATUS, Constants.RESPONSE_STATUS_ERROR);
			return jsonResponse;
		}
		
		groupDAO = new GroupDAOImpl();
		insertFlag = groupDAO.addNewGroup(groupName, groupDesc);
		if(insertFlag == 1){
			jsonResponse.put(Constants.RESPONSE_PARAM_STATUS, Constants.RESPONSE_STATUS_OK);
		}else{
			jsonResponse.put(Constants.RESPONSE_PARAM_STATUS, Constants.RESPONSE_STATUS_ERROR);
		}
		
		return jsonResponse;
	}
	
	
}
