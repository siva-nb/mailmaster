package com.bliss.mailmaster.vo;

public class CampaignVO {
	private int campaignId;
	private String campaignName;
	private String campaignContent;
	private int contentId;
	private int status;
	private int groupId;
	private int userId;

	public int getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCampaignContent() {
		return campaignContent;
	}
	public void setCampaignContent(String campaignContent) {
		this.campaignContent = campaignContent;
	}
}
