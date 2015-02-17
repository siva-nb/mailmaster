package com.bliss.mailmaster.dao;

import java.sql.SQLException;
import java.util.List;

import com.bliss.mailmaster.vo.ContactsUploadVO;
import com.bliss.mailmaster.vo.ContactsVO;

public interface ContactsDAO {
	int addNewContact(ContactsVO contactsvo);
	int addNewContact(int groupid, List<ContactsVO> contactsvo);
	int deleteGroup(int groupId);
	List<ContactsVO> listContactsByGroup(int groupid, int pageid);
	int[] bulkUploadContacts(List<ContactsUploadVO> contactList) throws SQLException;
}
