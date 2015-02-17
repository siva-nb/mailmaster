package com.bliss.mailmaster.action;

import org.apache.log4j.Logger;

import com.bliss.mailmaster.response.ListCampaignResponse;
import com.bliss.mailmaster.service.CampaignService;
import com.bliss.mailmaster.utils.MailMasterException;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class ListCampaignAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	Logger logger = Logger.getLogger(ListCampaignAction.class);
	
	private int param_page_no;
	
	private CampaignService campaignService;
	
	private ListCampaignResponse campaignResponse;
	
	public String invokeListCampaign()
	{
		logger.info("List Campaign : Invoke List Campaign");
		
		try{
			listCampaigns();
		}catch(MailMasterException e){
			logger.fatal(e.getMessage(), e);
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	private void listCampaigns() throws MailMasterException{
		campaignService = new CampaignService();
		setCampaignResponse(campaignService.listCampaigns(param_page_no));
	}

	public int getParam_page_no() {
		return param_page_no;
	}

	public void setParam_page_no(int param_page_no) {
		this.param_page_no = param_page_no;
	}

	public ListCampaignResponse getCampaignResponse() {
		return campaignResponse;
	}

	public void setCampaignResponse(ListCampaignResponse campaignResponse) {
		this.campaignResponse = campaignResponse;
	}
}
