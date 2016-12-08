package com.cdv.test.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class DBTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	@Autowired
	@Qualifier("ds")
	DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("开始数据库连接");
		Connection conn =null;
		PreparedStatement ps = null;
		
		try {
			
			conn = ds.getConnection();
			
			ps = conn.prepareStatement("select 1 as id from dual");
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				System.out.println("数据库连接成功："+rs.getString("id"));
			}
			
		} catch (Exception e) {
			System.out.println("数据库连接失败："+e.getMessage());
		}finally {
	      try {
		    	 if(ps!=null){
					ps.close();
		    	 }
		    	 if(conn!=null){
		    		 conn.close();
		    	 }
			
			   } catch (SQLException e) {
					System.out.println("数据库关闭异常："+e.getMessage());
				}
			
		}
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
