package com.lgp.test.dao;

import java.util.List;

import com.lgp.test.pojo.UserInfo;


public interface UserMapper {

	    public int insert(UserInfo user);
     
	    public int update(UserInfo user);
	   
	    public int delete(String userName);
	   
	    public List<UserInfo> selectAll();
	   
	    public int countAll();
	   
	    public UserInfo find(String userName);
}
