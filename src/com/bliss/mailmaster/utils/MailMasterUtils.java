package com.bliss.mailmaster.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bliss.mailmaster.vo.ContactsVO;

public class MailMasterUtils {
	public static ContactsVO buildContactDetails(int groupid, int status, String firstName, String lastName, String email)
	{
		ContactsVO contactsvo = new ContactsVO();
		
		contactsvo.setEmail(email);
		contactsvo.setFirstName(firstName);
		contactsvo.setLastName(lastName);
		contactsvo.setGroupId(groupid);
		contactsvo.setStatus(status);
		
		return contactsvo;
	}
	
	public static boolean isValidEmail(String email){
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
	    Matcher m = p.matcher(email);
	    return m.matches();
	}
}
