package com.bliss.mailmaster.service;

import org.apache.log4j.Logger;

import com.bliss.mailmaster.dao.UserDAO;
import com.bliss.mailmaster.dao.impl.UserDAOImpl;
import com.bliss.mailmaster.utils.MailMasterException;
import com.bliss.mailmaster.utils.PasswordManager;
import com.bliss.mailmaster.vo.UserVO;

public class UserService {
	
	private Logger logger = Logger.getLogger(UserService.class);
	
	private UserDAO userDAO = null;
	
	public UserVO login(String username, String password) throws MailMasterException
	{
		
		String encryptedPassword = PasswordManager.getEncryptedPassword(password);
		
		if(encryptedPassword == null)
		{
			logger.debug("Login : Encrypted Password is either null or empty");
			throw new MailMasterException("Password processing failed");
		}
		
		userDAO = new UserDAOImpl();
		return userDAO.login(username, encryptedPassword);
	}
}
