package com.bliss.mailmaster.dao;

import java.util.List;

public interface GroupDAO {
	int addNewGroup(String groupName, String groupDesc); 
	int deleteGroup(int groupId);
	List<String> listAllGroups();
}
