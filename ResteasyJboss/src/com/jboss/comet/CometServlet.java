package com.jboss.comet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.continuation.ContinuationSupport;
import org.eclipse.jetty.continuation.Continuation; 

@WebServlet(asyncSupported = true)
public class CometServlet extends HttpServlet {

	private static final long serialVersionUID = -5813841480549331019L;

	private static final long TIME_OUT = 30000;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		
		Continuation continuation = ContinuationSupport.getContinuation(req); 

		    if (continuation.isInitial()) {
		    	continuation.setTimeout(TIME_OUT);
				continuation.suspend();
		    }
		    else {
		      response.setContentType("text/html");
		      response.setStatus(HttpServletResponse.SC_OK);
		      response.getWriter().println("<h1>Hello World!</h1>");
		    }
		  }
}
