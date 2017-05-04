package com.jboss.rest.service;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import com.jboss.rest.service.init.Initializer;

public class JettyServer {

	
	public static void main(String[] args) throws Exception {
		String homedir = Initializer.getHomeDir();
		new Initializer().init();
		Server server = new Server(8085);
		server.setStopAtShutdown(true);
		server.setStopTimeout(300000);
		WebAppContext context = new WebAppContext(homedir+"/webapps", "/test");
		context.setDefaultsDescriptor(homedir+"/jetty/webdefault.xml");
		context.setDescriptor(homedir+"/resteasy/web.xml");
		server.setHandler(context);
		server.start();
		server.join();
	}
}
