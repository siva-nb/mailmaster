package com.bliss.mailmaster.utils;

public class SQL {
	
	public static String COL_TBL_CONTACT_ID = "id";
	public static String COL_TBL_CONTACT_FNAME = "firstname";
	public static String COL_TBL_CONTACT_LNAME = "lastname";
	public static String COL_TBL_CONTACT_EMAIL = "email";
	public static String COL_TBL_CONTACT_GRP_ID = "groupid";
	public static String COL_TBL_CONTACT_STATUS = "status";
	
	public static String COL_TBL_CAMPAIGN_ID = "id";
	public static String COL_TBL_CAMPAIGN_NAME = "name";
	public static String COL_TBL_CAMPAIGN_STATUS = "status";
	public static String COL_TBL_ALIAS_GRP_NAME = "groupname";
	public static String COL_TBL_GROUP_DESCRIPTION = "description";
	
	public static String ADD_NEW_GROUP = "INSERT INTO group_contact(name, description) VALUES (?,?)";
	public static String ADD_NEW_CONTACT = "INSERT INTO contact(firstname, lastname ,email, groupid, status) VALUES (?,?,?,?,?)";
	public static String ADD_NEW_CAMPAIGN = "INSERT INTO campaign(name, contentid, content, status, groupid, login_uid) VALUES (?,?,?,?,?,?)";
	public static String UPDATE_CAMPAIGN = "UPDATE campaign SET status = ? WHERE id = ?";
	public static String SELECT_CAMPAIGN_CONTACTS = "SELECT campaign.id as campaignId, ? as mailStatus, contact.email as email  FROM contact INNER JOIN campaign ON	contact.groupid = campaign.groupid AND campaign.id = ?";
	public static String SELECT_CONTACT_BY_GROUP = "SELECT id, firstname, lastname, email, groupid, status FROM contact WHERE groupid = ? AND status = 1 LIMIT ?,10";
	public static String SELECT_ALL_GROUP = "SELECT id, name, description FROM group_contact";
	public static String SELECT_CAMPAIGN_DETAILS = "SELECT name, content FROM campaign WHERE id = ?";
	public static String LOGIN_AUTH = "SELECT id, firstname, lastname, email, credit, type FROM user WHERE email = ? AND pword = ?";
	public static String UPDATE_CREDITS = "UPDATE user SET credit = credit - 1 WHERE id = ? AND credit > 0";
	public static String SELECT_LAST_CAMPAIGN_ID = "SELECT LAST_INSERT_ID()";
	public static String SELECT_CAMPAIGN_DASHBOARD = "SELECT C.id, C.name ,C.status, G.name as groupname, G.description, C.groupid FROM campaign C INNER JOIN group_contact G ON C.groupid  = G.id ORDER BY C.id DESC  LIMIT ?,10";
}
