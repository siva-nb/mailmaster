package com.bliss.mailmaster.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.apache.log4j.Logger;

import com.bliss.mailmaster.dao.ContactsDAO;
import com.bliss.mailmaster.utils.Constants;
import com.bliss.mailmaster.utils.DatabaseManager;
import com.bliss.mailmaster.utils.SQL;
import com.bliss.mailmaster.vo.ContactsUploadVO;
import com.bliss.mailmaster.vo.ContactsVO;

public class ContactsDAOImpl implements ContactsDAO{

	Connection dbConnection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	Logger logger = Logger.getLogger(ContactsDAOImpl.class);

	/**
	 * Inserts a Single contact in DB
	 * @param groupId
	 * @param contactsvo
	 * @return Equals 1 if successful, ERROR_RESPONSE in case of error
	 */
	@Override
	public int addNewContact(ContactsVO contactsvo) {
		int no_of_affected_rows;
		try{
			dbConnection = DatabaseManager.getConnection();

			logger.info("Add New Contact: Database connected");

			preparedStatement = dbConnection.prepareStatement(SQL.ADD_NEW_CONTACT);
			preparedStatement.setString(1, contactsvo.getFirstName());
			preparedStatement.setString(2, contactsvo.getLastName());
			preparedStatement.setString(3, contactsvo.getEmail());
			preparedStatement.setInt(4, contactsvo.getGroupId());
			preparedStatement.setInt(5, contactsvo.getStatus());

			no_of_affected_rows = preparedStatement.executeUpdate();

			return no_of_affected_rows;

		}catch(SQLException | NamingException e){
			logger.fatal("Add New Contact: SQLException "+e.getMessage(), e);
			return Constants.ERROR_RESPONSE;
		}finally{
			try{
				closeGracefully();
			}catch(SQLException e){
				logger.fatal("Add New Contact: SQLException "+e.getMessage(), e);
				return Constants.ERROR_RESPONSE;
			}
		}
	}

	@Override
	public int addNewContact(int groupid, List<ContactsVO> contactsvo) {
		return 0;
	}

	public int[] bulkUploadContacts(List<ContactsUploadVO> contactList) throws SQLException
	{
		int[] results = null;
		int counter = 0;
		final int batchSize = 250;
		
		try{
			dbConnection = DatabaseManager.getConnection();

			dbConnection.setAutoCommit(false);

			logger.info("Bulk Upload Contacts : Database connected");

			preparedStatement = dbConnection.prepareStatement(SQL.ADD_NEW_CONTACT);
			
			for(ContactsUploadVO contact : contactList){
				logger.info("Bulk Upload Contacts : Inserting "+contact.getContact_email());
				
				preparedStatement.setString(1, contact.getContact_firstname());
				if(contact.getContact_lastname() == null){
					preparedStatement.setNull(2,java.sql.Types.VARCHAR);
				}else{
					preparedStatement.setString(2, contact.getContact_lastname());
				}
				preparedStatement.setString(3, contact.getContact_email());
				preparedStatement.setInt(4, 1);
				preparedStatement.setInt(5, Constants.ACTIVE_USER);

				preparedStatement.addBatch();
				
				 if(++counter % batchSize == 0) {
					 preparedStatement.executeBatch();
				    }
			}

			results = preparedStatement.executeBatch();

			dbConnection.commit();
		}catch(SQLException e){
			dbConnection.rollback();
			e.printStackTrace();
		}catch(NamingException e1){
			e1.printStackTrace();
		}finally{
			closeGracefully();
		}
		return results;
	}

	@Override
	public int deleteGroup(int groupId) {
		return 0;
	}

	@Override
	public List<ContactsVO> listContactsByGroup(int groupid, int pageid) {
		List<ContactsVO> contactList = null;
		ContactsVO contactsvo;
		int offset;
		try{

			dbConnection = DatabaseManager.getConnection();

			logger.info("List Contact By Group: Database connected");

			offset = pageid * Constants.CONTACT_PAGE_SIZE; 
			
			preparedStatement = dbConnection.prepareStatement(SQL.SELECT_CONTACT_BY_GROUP);
			preparedStatement.setInt(1, groupid);
			preparedStatement.setInt(2, offset);

			resultSet = preparedStatement.executeQuery();
			
			contactList = new ArrayList<ContactsVO>();
			while (resultSet.next()) {
				contactsvo = new ContactsVO();		
				contactsvo.setContactId(resultSet.getInt(SQL.COL_TBL_CONTACT_ID));
				contactsvo.setFirstName(resultSet.getString(SQL.COL_TBL_CONTACT_FNAME));
				contactsvo.setLastName(resultSet.getString(SQL.COL_TBL_CONTACT_LNAME));
				contactsvo.setEmail(resultSet.getString(SQL.COL_TBL_CONTACT_EMAIL));
				//			contactsvo.setStatus(resultSet.getInt(SQL.COL_TBL_CONTACT_STATUS));
				contactsvo.setGroupId(resultSet.getInt(SQL.COL_TBL_CONTACT_GRP_ID));

				contactList.add(contactsvo);
			}

		}catch(SQLException | NamingException e){
			logger.fatal("List Contact By Group: SQLException "+e.getMessage(), e);
			contactList = null;
		}finally{
			try{
				closeGracefully();
			}catch(SQLException e){
				logger.fatal("List Contact By Group: SQLException "+e.getMessage(), e);
				contactList = null;
			}
		}
		return contactList;
	}

	private void closeGracefully() throws SQLException
	{
		DatabaseManager.closeConnection(dbConnection);

		if(preparedStatement != null){
			preparedStatement.close();
		}

		if(resultSet != null){
			resultSet.close();
		}
	} 
}
