package com.cdv.test.mybatis;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyTestServlet extends HttpServlet {

    private static final long serialVersionUID = -3566985580136390941L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Yeah, it's a get test");

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Hello World, Getter");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Yeah, it's a post test");

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Hello World, Poster");
       // PrintWriter out = response.getWriter();  
        //  out.println("Hello,Spring.Servlet");
      //  response.sendRedirect("post.jsp");
    }
}
