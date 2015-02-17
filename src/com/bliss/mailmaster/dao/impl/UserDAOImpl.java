package com.bliss.mailmaster.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

import com.bliss.mailmaster.dao.UserDAO;
import com.bliss.mailmaster.utils.DatabaseManager;
import com.bliss.mailmaster.utils.MailMasterException;
import com.bliss.mailmaster.utils.SQL;
import com.bliss.mailmaster.vo.UserVO;

public class UserDAOImpl implements UserDAO {
	Connection dbConnection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;


	Logger logger = Logger.getLogger(UserDAOImpl.class);

	UserVO userVO;
	
	/*
	 * Login Module -> Is a valid user
	 * Input : Username and md5 hashed password
	 * Returns : 
	 */
	
	@Override
	public UserVO login(String username, String encryptPassword) throws MailMasterException {
		try {
			dbConnection = DatabaseManager.getConnection();
			
			preparedStatement = dbConnection.prepareStatement(SQL.LOGIN_AUTH);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, encryptPassword);
			
			resultSet = preparedStatement.executeQuery();

			if(resultSet != null && resultSet.next()){
				logger.info("Login Valid User");
				
				userVO = buildUserVo();
				
				return userVO;
			}
			else{
				logger.info("Login : Invalid User");
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			logger.fatal("Login: SQLException "+e);
			throw new MailMasterException("Login: Internal Server Error");
		} catch (NamingException e) {
			e.printStackTrace();
			logger.fatal("Login: NamingException "+e);
			throw new MailMasterException("Login: Internal Server Error");
		}finally{
			try {
				DatabaseManager.closeConnection(dbConnection);
			} catch (SQLException e) {
				e.printStackTrace();
				logger.fatal("Login: SQLException "+e);
				throw new MailMasterException("Login: Internal Server Error");
			}
		}
	}
	
	private UserVO buildUserVo() throws SQLException{
		userVO = new UserVO();
		userVO.setUserid(resultSet.getInt(resultSet.findColumn("id")));
		userVO.setFirstName(resultSet.getString(resultSet.findColumn("firstname")));
		userVO.setLastName(resultSet.getString(resultSet.findColumn("lastname")));
		userVO.setCredit(resultSet.getInt(resultSet.findColumn("credit")));
		userVO.setType(resultSet.getInt(resultSet.findColumn("type")));
		
		return userVO;
	}

}
