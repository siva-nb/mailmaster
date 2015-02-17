package com.bliss.mailmaster.dao;

import com.bliss.mailmaster.utils.MailMasterException;
import com.bliss.mailmaster.vo.UserVO;

public interface UserDAO {
	UserVO login(String username, String password) throws MailMasterException;
}
