package com.my.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {


	private static String username = "root";
	
	private static String pwd = "123456";
	
	private static String url = "jdbc:mysql://127.0.0.1:3306/test";
	
	private static Connection conn = null;
	
	private static Statement st = null;
	
	private static ResultSet rs = null;
	
	static Statement getConn(){
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, username, pwd);
		
			st  = conn.createStatement();
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return st;
	}
	
	
	static void closeDb(){
		try {
			if(rs!=null){
				rs.close();
			}
			if(st!=null){
				st.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}
	
}
