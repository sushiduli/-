package com.lgp.test.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lgp.test.dao.UserMapper;
import com.lgp.test.pojo.UserInfo;

public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// static ApplicationContext ctx=null;
   @Autowired
   UserMapper userMapper;
	 
    public UserInfoServlet() {
        super();
     //   ctx=new ClassPathXmlApplicationContext("beans.xml");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getParameter("action");
		// UserMapper userInfoDao = (UserMapper)ctx.getBean("userMapper");
		  if ("find".equals(action)) {
			  
			  System.out.println("��Ϣ��¼����"+userMapper.countAll());
			  UserInfo user = userMapper.find(request.getParameter("userId"));
			  if(user!=null){
				  System.out.println("�û���Ϣ��"+user.getUserId()+"=="+user.getUserHome()+"=="+user.getUserAddress());
			  }
			
		  }
		  
		  if ("insert".equals(action)) {
			  System.out.println("��Ϣ��¼����"+userMapper.countAll());
			  UserInfo user = new UserInfo();
			  user.setUserId(request.getParameter("userId"));
			  user.setUserHome(request.getParameter("userHome"));
			  user.setUserAddress(request.getParameter("userAddress"));
			  userMapper.insert(user);
			  System.out.println("���һ�����ݳɹ�==��Ϣ��¼����"+userMapper.countAll());
			  System.out.println("��Ӻ��û���Ϣ��"+user.getUserId()+"=="+user.getUserHome()+"=="+user.getUserAddress());
			  
			  
		  }
		  
		 if ("update".equals(action)) {
			  System.out.println("��Ϣ��¼����"+userMapper.countAll());
			  UserInfo user = new UserInfo();
			  user.setUserId(request.getParameter("userId"));
			  user.setUserHome(request.getParameter("userHome"));
			  user.setUserAddress(request.getParameter("userAddress"));
			  userMapper.update(user);
			  
			  System.out.println("�޸�һ�����ݳɹ�==��Ϣ��¼����"+userMapper.countAll()+"====");	  
		  }
		  
		  if ("delete".equals(action)) {
			  System.out.println("��Ϣ��¼����"+userMapper.countAll());
			  userMapper.delete(request.getParameter("userId"));
			  System.out.println("ɾ��һ�����ݳɹ�==��Ϣ��¼����"+userMapper.countAll()+"====");	  
		  }
		
		  response.sendRedirect("index.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
