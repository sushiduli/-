package com.jboss.test.rest;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;


public class TestResteasy {

	public static void main(String[] args) {
		
		ResteasyClient _restClient =  (new ResteasyClientBuilder()).build();
		ResteasyWebTarget target = _restClient.target("http://10.7.6.7:8085/test/rest/post");
		Builder post = target.request().header("Content-Type", "application/json;charset=utf-8");
		post.accept(MediaType.APPLICATION_JSON);
		post.acceptEncoding("UTF-8");
		Response response =  post.post(Entity.entity(new MyUser("111", "666"), MediaType.APPLICATION_JSON));
		MyUser user = response.readEntity(MyUser.class);
		System.out.println(user.age);
	}
}
