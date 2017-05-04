package com.jboss.rest.service.impl;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.jboss.test.rest.MyUser;

@Path("/rest")
public class PostRestImpl {
	
	@POST
	@Path("/post")
	@Produces({MediaType.APPLICATION_JSON})
	public MyUser getUser( MyUser user){
		return new MyUser(user.age, user.name);
	}
}

