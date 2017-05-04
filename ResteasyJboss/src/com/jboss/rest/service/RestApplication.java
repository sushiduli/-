package com.jboss.rest.service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.jboss.rest.service.impl.PostRestImpl;
import com.jboss.rest.service.impl.RestServiceImpl;

public class RestApplication extends Application
{
	private Set<Object> singletons = new HashSet<Object>();

	public RestApplication()
	{
		// 构造方法中注册REST服务类
		this.singletons.add(new RestServiceImpl());
		this.singletons.add(new PostRestImpl());
	}

	@Override
	public Set<Object> getSingletons()
	{
		return this.singletons;
	}
}
