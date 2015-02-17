package com.bliss.mailmaster.action;

import java.util.Map;

import org.apache.log4j.Logger;

import com.bliss.mailmaster.service.CampaignService;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializer;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class CreateCampaignAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private String param_campaignName;
	private String param_campaignContent;
	private int param_campaignStatus;
	private int param_campaignGroupId;
	
	private Map<String,Integer> jsonResponse;
	
	Logger logger = Logger.getLogger(CreateCampaignAction.class);
	
	public String invokeCreateCampaign(){
		return "SUCCESS";
	}
	
	public String invokePostCampaign(){
	
		logger.info("Init Campaign : Start");
		
		CampaignService campaignService = new CampaignService();
		param_campaignStatus = 1;
		setJsonResponse(campaignService.addNewCampaign(param_campaignName, 1, param_campaignContent, param_campaignStatus, param_campaignGroupId, 1));
		
		logger.info("Init Campaign : Ends");
		return Action.SUCCESS;
	}


	public void setParam_campaignName(String param_campaignName) {
		this.param_campaignName = param_campaignName;
	}

	public void setParam_campaignContent(String param_campaignContent) {
		this.param_campaignContent = param_campaignContent;
	}

	public void setParam_campaignStatus(int param_campaignStatus) {
		this.param_campaignStatus = param_campaignStatus;
	}

	public void setParam_campaignGroupId(int param_campaignGroupId) {
		this.param_campaignGroupId = param_campaignGroupId;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public Map<String,Integer> getJsonResponse() {
		return jsonResponse;
	}

	public void setJsonResponse(Map<String,Integer> jsonResponse) {
		this.jsonResponse = jsonResponse;
	}
}
