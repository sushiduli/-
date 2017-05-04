package com.jboss.test.rest;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.cdv.nsite.security.rest.type.LogonRequest;
import com.cdv.nsite.security.rest.type.LogonResponse;
import com.cdv.nsite.security.rest.type.PrincipalType;


public class RestEasy {
	
	public static void main(String[] args) {
		
		LogonRequest lr = new LogonRequest();
		lr.setPrincipal("admin");
		lr.setPassword("123456");
		lr.setPrincipalType(PrincipalType.UniqueName);
		ResteasyClient _restClient =  (new ResteasyClientBuilder()).build();
		ResteasyWebTarget target = _restClient.target("http://10.7.3.62:9080/es/api/nsite/security/logon");
		Builder post = target.request().header("Content-Type", "application/json;charset=utf-8");
		post.accept(MediaType.APPLICATION_JSON);
		post.acceptEncoding("UTF-8");
		Response response =  post.post(Entity.entity(lr, MediaType.APPLICATION_JSON));
		LogonResponse logon = response.readEntity(LogonResponse.class);
		
		_restClient =  (new ResteasyClientBuilder()).build();
		UriBuilder builder = UriBuilder.fromPath("http://10.7.3.62:9080/es/api/nsite/mobjects/get/assetDetails/byMoId")
				.replaceQueryParam("sid", logon.getSessionId())
				.replaceQueryParam("moId", "18B7C11E55A64903BE83A459CDDB89B5");
		target = _restClient.target(builder);
		target.queryParam("sid", logon.getSessionId());
		
		post = target.request().header("Content-Type", "application/json;charset=utf-8");
		post.accept(MediaType.APPLICATION_JSON);
		post.acceptEncoding("UTF-8");
		response =  post.get();
		System.out.println(response.getStatus());
	}
	
}
