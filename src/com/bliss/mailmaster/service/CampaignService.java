package com.bliss.mailmaster.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.bliss.mailmaster.asynctask.MailMasterJob;
import com.bliss.mailmaster.asynctask.MailMasterTask;
import com.bliss.mailmaster.asynctask.WorkerThread;
import com.bliss.mailmaster.dao.CampaignDAO;
import com.bliss.mailmaster.dao.impl.CampaignDAOImpl;
import com.bliss.mailmaster.response.ListCampaignResponse;
import com.bliss.mailmaster.utils.Constants;
import com.bliss.mailmaster.utils.MailMasterException;
import com.bliss.mailmaster.vo.CampaignGroupVO;
import com.bliss.mailmaster.vo.CampaignVO;
import com.google.gson.JsonObject;

public class CampaignService {
	private Logger logger = Logger.getLogger(CampaignService.class);
	
	private CampaignDAO campaignDAO = null;
	
	private WorkerThread mWorkerThread;
	
	private ExecutorService mThreadPoolExecutor;
	
	public Map<String, Integer> addNewCampaign(String name, int contentId, String content, int status, int groupId, int loginId){
		
		int insertFlag;
		
		Map<String, Integer> responseMap = new HashMap<String, Integer>();
		
		campaignDAO = new CampaignDAOImpl();
		
		CampaignVO campaignVO =	fillCampaignDetails(name, contentId, content, status, groupId, loginId);
		
		logger.info("Add New Campaign : CampaignDetails is built");
		
		insertFlag  = campaignDAO.addNewCampaign(campaignVO);
		
		if(insertFlag == 1){
			logger.debug("Add New Campaign : CampaignDetails insertion successfully");
			responseMap.put(Constants.RESPONSE_PARAM_STATUS, Constants.RESPONSE_STATUS_OK);
			
		}else{
			logger.debug("Add New Campaign : CampaignDetails insertion not successfully");
			responseMap.put(Constants.RESPONSE_PARAM_STATUS, Constants.RESPONSE_STATUS_ERROR);
		}
		
		logger.info("Add New Campaign : Returning");
		
		return responseMap;
	}
	
	private CampaignVO fillCampaignDetails(String name, int contentId, String content, int status, int groupId, int loginId){
		CampaignVO campaignVO = new CampaignVO();
		
		campaignVO.setCampaignName(name);
		campaignVO.setCampaignContent(content);
		campaignVO.setContentId(contentId);
		campaignVO.setStatus(status);
		campaignVO.setGroupId(groupId);
		campaignVO.setUserId(loginId);
		
		return campaignVO;
	}

	public void asyncSendMail(String campaignName, int campaignId, int userid, int emailCredits) throws MailMasterException{
		
		logger.info("Async Send Mail : Begin "+campaignId);
		
		MailMasterJob mailMasterJob = new MailMasterJob();
		mailMasterJob.setTaskName(campaignName);
		mailMasterJob.setCampaignId(campaignId);
		
		MailMasterTask mailMasterTask = new MailMasterTask(mailMasterJob, emailCredits, userid);
		
		mWorkerThread = WorkerThread.getInstance();
		mThreadPoolExecutor = mWorkerThread.getThreadPoolExecutor();
		
		mThreadPoolExecutor.execute(mailMasterTask);
		
		
		logger.info("Async Send Mail : End "+campaignId);
	}
	
	public ListCampaignResponse listCampaigns(int pageid) throws MailMasterException{
		logger.info("List Campaigns : Begins");

		ListCampaignResponse campaignResponse = new ListCampaignResponse();

		List<CampaignGroupVO> campaignList = null;
		
		campaignDAO = new CampaignDAOImpl();
		campaignList = campaignDAO.fetchCampaignForDashboard(pageid);
		
		if(campaignList == null){
			campaignResponse.setCampaigns(null);
			campaignResponse.setStatusCode(Constants.RESPONSE_STATUS_ERROR);
		}else{
			campaignResponse.setCampaigns(campaignList);
			campaignResponse.setStatusCode(Constants.RESPONSE_STATUS_OK);
		}
		
		logger.info("List Campaigns : End");
		return campaignResponse;
	}
}
