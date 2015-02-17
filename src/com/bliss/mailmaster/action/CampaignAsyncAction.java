package com.bliss.mailmaster.action;

import com.bliss.mailmaster.UserAware;
import com.bliss.mailmaster.service.CampaignService;
import com.bliss.mailmaster.utils.MailMasterException;
import com.bliss.mailmaster.vo.UserVO;
import com.opensymphony.xwork2.ActionSupport;

public class CampaignAsyncAction extends ActionSupport implements UserAware{

	private static final long serialVersionUID = 1L;

	private int param_campaign_id;
	
	UserVO userProfile;
	
	public String invokeAsyncTask()
	{
		CampaignService campaignService = new CampaignService();
		try {
			campaignService.asyncSendMail("campaignName", param_campaign_id,userProfile.getUserid(), userProfile.getCredit());
		} catch (MailMasterException e) {
			return "ERROR";
		}
		return "SUCCESS";
	}

	public int getParam_campaign_id() {
		return param_campaign_id;
	}

	public void setParam_campaign_id(int param_campaign_id) {
		this.param_campaign_id = param_campaign_id;
	}

	@Override
	public void setUser(UserVO uservo) {
		userProfile = uservo;
	}
}
