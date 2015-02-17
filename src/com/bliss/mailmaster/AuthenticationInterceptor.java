package com.bliss.mailmaster;

import java.util.Map;

import org.apache.log4j.Logger;

import com.bliss.mailmaster.utils.Constants;
import com.bliss.mailmaster.vo.UserVO;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AuthenticationInterceptor implements Interceptor {
	
	private static final long serialVersionUID = 1L;

	Logger logger = Logger.getLogger(AuthenticationInterceptor.class);
	
	Map<String, Object> sessionAttributes = null;
	
	UserVO userVO = null;
	
	Action action;
	
	@Override
	public void destroy() {
	}

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		logger.info("Auth Intercept : Begins");
		
		sessionAttributes = actionInvocation.getInvocationContext().getSession();
		
		userVO = (UserVO) sessionAttributes.get(Constants.SESSION_USER);
		
		if(userVO == null){
			return Action.LOGIN;
		}else{
			action = (Action) actionInvocation.getAction();
			if(action instanceof UserAware){
				((UserAware) action).setUser(userVO);
			}
			logger.info("Auth Intercept : Ends");
			return actionInvocation.invoke();
		}
	}
	
	

}
