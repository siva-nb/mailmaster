package com.bliss.mailmaster.dao;

import java.util.List;

import com.bliss.mailmaster.vo.CampaignGroupVO;
import com.bliss.mailmaster.vo.CampaignVO;

public interface CampaignDAO {
	int addNewCampaign(CampaignVO campaignVO);
	int updateCampaignStatus(int campaignId, int status);
	String fetchRawCampaignContent(int campaignId);
	int updateCredits(int userid);
	List<CampaignGroupVO> fetchCampaignForDashboard(int pageid);
}
