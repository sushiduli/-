package com.my.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetMail {
	
	 

	static void GetContent(String patternStr,String urlPath) {
		URL url;
		int responsecode;
		HttpURLConnection urlConnection;
		BufferedReader reader;
		String line;
		// 相当于埋好了陷阱匹配的地方就会掉下去  
	    Pattern pattern = Pattern.compile(patternStr);  
	     // 定义一个matcher用来做匹配  
 	    Matcher matcher = null;
		Statement st = DbUtil.getConn();
		
		try{
		    //生成一个URL对象，要获取源代码的网页地址为：http://www.sina.com.cn
		    url=new URL(urlPath);
		    //打开URL
		    urlConnection = (HttpURLConnection)url.openConnection();
		    //获取服务器响应代码
		    responsecode=urlConnection.getResponseCode();
		    if(responsecode==200){
		        //得到输入流，即获得了网页的内容 
		        reader=new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
		        while((line=reader.readLine())!=null){		 	        
		 	        // 定义一个matcher用来做匹配  
		 	        matcher = pattern.matcher(line);  
		 	        // 如果找到了  
		 	       if (matcher.find()) {  
		 	    	  
		 	    	  st.executeUpdate("insert into email_from_web (email,from_url,get_date) values ('"+matcher.group()+"',"
		 	    	  		+ "'"+urlPath+"',SYSDATE())");
		 	    	  System.out.println(matcher.group());
		 	    	  System.out.println("====是两个？=====");
		 	       }  
		        }
		    }
		    else{
		        System.out.println("获取不到网页的源码，服务器响应代码为："+responsecode);
		    }
		}
		catch(Exception e){
		    System.out.println("获取不到网页的源码,出现异常："+e);
		}finally {
			DbUtil.closeDb();
		}
	}

}
