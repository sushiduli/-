package com.cdv.test.db.model;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {

	    public User getUserByUserId(@Param("userId") String userId);
	    public User getUserByEmail(@Param("email") String email);
	    public User getUserCellPhone(@Param("cellphone") String cellphone);

	    public Role getRole(@Param("roleName") String roleName);
	
}
