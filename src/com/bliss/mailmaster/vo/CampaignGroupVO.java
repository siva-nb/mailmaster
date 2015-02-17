package com.bliss.mailmaster.vo;

public class CampaignGroupVO {
	
	private int campaignId;
	private int groupId;
	private String campaignName;
	private String groupName;
	private String groupDescription;
	private int campaignStatus;
	
	public int getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupDescription() {
		return groupDescription;
	}
	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}
	public int getCampaignStatus() {
		return campaignStatus;
	}
	public void setCampaignStatus(int campaignStatus) {
		this.campaignStatus = campaignStatus;
	}
}
