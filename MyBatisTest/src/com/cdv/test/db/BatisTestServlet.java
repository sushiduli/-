package com.cdv.test.db;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.cdv.test.db.model.User;
import com.cdv.test.db.model.UserMapper;


public class BatisTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	private UserMapper _mpUser;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = "admin";
		User user = _mpUser.getUserByUserId(userId);
        if (user == null) {
           System.out.println("获取失败：userId=="+userId);
        }else{
        	System.out.println("获取用户成功：用户手机号=="+user.getCellphone());
        }
        
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
