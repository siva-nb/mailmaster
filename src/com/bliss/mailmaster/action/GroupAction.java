package com.bliss.mailmaster.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bliss.mailmaster.service.GroupService;
import com.bliss.mailmaster.utils.CacheManager;
import com.bliss.mailmaster.utils.Constants;


public class GroupAction extends HttpServlet {
	
	private static final long serialVersionUID = -7109399755874511199L;
	
	CacheManager mMemcached;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Map<String, String> valuesMap = new HashMap<String, String>();
		valuesMap.put("title", "Contacts From Map");
		valuesMap.put("val_group_name", "PHP");
		
		mMemcached = CacheManager.getInstance();
		Object myObject = mMemcached.get(Constants.FILE_NAME_CONTACTS);
		
		resp.getWriter().print((String)myObject);  
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		
		GroupService groupService = new GroupService();
		resp.getWriter().println(groupService.addNewGroup(req.getParameter(Constants.PARAM_GROUP_NAME), req.getParameter(Constants.PARAM_GROUP_DESC)));
	}
}
