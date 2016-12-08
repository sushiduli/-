package com.my.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MailClient {


	 public static void main(String args[]){    
	       
		    get();
	    }

	private static void get() {
	
		
		String patternStr = "[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+";
		long start = new Date().getTime();

		for(int i=2;i<=290;i++){
			String url = "http://tieba.baidu.com/p/2756554445?pn="+i;
			GetMail.GetContent(patternStr,url);
			System.out.println("==========="+i);
		}
		long end = new Date().getTime();
   
		System.out.println("共耗时："+(end-start)/1000+"s");
	}

	public static void send() {
		
		int succ = 0;
		
		int fail = 0;
		
		String from = "**@qq.com";
		
		String to = "";
		
		String subject = "123";
		
		String content ="456"; 
		
		String username ="***@qq.com";
		
		String password = "***";
		
		String smtp =  "smtp." + username.split("@")[1];
		
		ResultSet rs = null;
		try {
			Statement st = DbUtil.getConn();
			rs = st.executeQuery("SELECT email from email_from_web limit 0,100");
			while (rs.next()) {
				to = rs.getString("email");
				if(SendMail.send(smtp, from, to, subject, content, username, password)){
				    st.executeUpdate("update email_from_web set send_date = SYSDATE(), send_count = send_count+1 "
				    		+ "where email = '"+to+"'");
				    succ++;
				}else{
					fail++;
				};
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			DbUtil.closeDb();
		}
		
		
		System.out.println("成功发送邮件"+succ+"封,失败"+fail+"封！");
		
	}
	
	
}
