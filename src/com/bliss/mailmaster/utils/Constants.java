package com.bliss.mailmaster.utils;

public class Constants {
	
	public static String PARAM_GROUP_NAME = "frm_group_name";
	public static String PARAM_GROUP_DESC = "frm_group_desc";
	
	public static String PARAM_CONTACT_ID = "frm_contact_id";
	public static String PARAM_CONTACT_FNAME = "frm_first_name";
	public static String PARAM_CONTACT_LNAME = "frm_last_name";
	public static String PARAM_CONTACT_EMAIL = "frm_contact_email";
	public static String PARAM_CONTACT_GROUPID = "frm_contact_grpid";
	public static String PARAM_CONTACT_STATUS = "frm_contact_status";
		
	public static String PARAM_REQUEST_ACTION = "action";
	public static String RESPONSE_PARAM_STATUS = "status";
	
	public static int ERROR_RESPONSE = -1;
	
	public static int RESPONSE_STATUS_OK = 200;
	public static int RESPONSE_STATUS_ERROR = 500;
	
	public static int ACTIVE_USER = 1;
	
	public static int CONTACT_PAGE_SIZE= 10;
	
	public static String FILE_NAME_INDEX = "index.txt";
	public static String FILE_NAME_CONTACTS = "contacts_mgmt.html";
	
	public static String CAMPAIGN_ID = "campaign_id";
	public static String MAIL_STATUS = "mail_status";
	public static String EMAIL_ID = "mail_id";
	
	public static String MAILMASTER_EMAIL_COLLECTION = "trn_email";
	
	public enum CampaignStatus{
		NASCENT(1),
		START (2),
		PROGRESS (3),
		COMPLETE (4),
		END	(5);
		
		private final int value;

	    private CampaignStatus(int value) {
	        this.value = value;
	    }

	    public int getValue() {
	        return value;
	    }
	}
	
	public enum MailStatus{
		NASCENT (1),
		SENT (2),
		UNSUBSCRIBE (3),
		OPEN(4);
		
		private final int value;
		
		private MailStatus(int value){
			this.value = value;
		}
		
		public int getValue(){
			return value;
		}
	}
	
	public static String DELIMITER = "~";
	
	public static String SESSION_USER = "session_user";
	
	public static String SENDER_EMAIL = "xyz@gmail.com";
}
