package com.jboss.rest.service.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


@Path("/rest")
public class RestServiceImpl extends RestService{

	@GET
	@Path("/test")
	public Response test()
	{
		String result = "ok you get it";

		return Response.status(200).entity(result).build();
	}
	
	
	
}
