package com.bliss.mailmaster.response;

import java.util.List;

import com.bliss.mailmaster.vo.CampaignGroupVO;

public class ListCampaignResponse extends BasicResponse{
	private List<CampaignGroupVO> campaigns;

	public List<CampaignGroupVO> getCampaigns() {
		return campaigns;
	}

	public void setCampaigns(List<CampaignGroupVO> campaigns) {
		this.campaigns = campaigns;
	}
	
}
