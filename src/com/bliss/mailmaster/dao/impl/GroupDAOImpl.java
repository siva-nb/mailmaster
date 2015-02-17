package com.bliss.mailmaster.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

import com.bliss.mailmaster.dao.GroupDAO;
import com.bliss.mailmaster.utils.Constants;
import com.bliss.mailmaster.utils.DatabaseManager;
import com.bliss.mailmaster.utils.SQL;

public class GroupDAOImpl implements GroupDAO {

	Connection dbConnection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	Logger logger = Logger.getLogger(GroupDAOImpl.class);

	/**
	 * Inserts a new Group in DB
	 * @param groupName
	 * @param groupDesc
	 * @return Equals 1 if successful, ERROR_RESPONSE in case of error
	 */

	@Override
	public int addNewGroup(String groupName, String groupDesc) {
		int no_of_affected_rows;
		try {
			dbConnection = DatabaseManager.getConnection();
			logger.info("Add New Group: Database connected");
			
			preparedStatement = dbConnection.prepareStatement(SQL.ADD_NEW_GROUP);
			preparedStatement.setString(1, groupName);
			preparedStatement.setString(2, groupDesc);
			
			no_of_affected_rows = preparedStatement.executeUpdate();
			
			return no_of_affected_rows;
			
		}catch (SQLException e) {
			logger.fatal("Add New Group: SQLException "+e.getMessage(), e);
			return Constants.ERROR_RESPONSE;
		} catch (NamingException e) {
			e.printStackTrace();
			logger.fatal("Add New Group: NamingException "+e.getMessage(),e);
			return Constants.ERROR_RESPONSE;
		}finally{
			try {
				DatabaseManager.closeConnection(dbConnection);
			} catch (SQLException e) {
				logger.fatal("Add New Group: SQLException "+e.getMessage(), e);
				return Constants.ERROR_RESPONSE;
			}
		}
	}

	@Override
	public int deleteGroup(int groupId) {
		return 0;
	}

	@Override
	public List<String> listAllGroups() {
		try{
			dbConnection = DatabaseManager.getConnection();
			
			preparedStatement = dbConnection.prepareStatement(SQL.SELECT_ALL_GROUP);
			resultSet = preparedStatement.executeQuery();
			
		}catch(SQLException e){
			logger.fatal("List All Groups : SQLException"+e.getMessage(), e);
		} catch (NamingException e) {
			logger.fatal("List All Groups : NamingException"+e.getMessage(), e);
		} finally{
			try {
				DatabaseManager.closeConnection(dbConnection);
			} catch (SQLException e) {
				logger.fatal("List All Groups: SQLException "+e.getMessage(), e);
			}
		}
		return null;
	}

}
