package com.lgp.db;

import java.sql.Connection;
import java.sql.SQLException;

import org.h2.jdbcx.JdbcConnectionPool;

public class ConnPool {

	private static ConnPool cp = null;
	
	private static JdbcConnectionPool jcp = null;
	
	
	private ConnPool(){
		String h2Path = System.getProperty("h2DbPath");
		jcp = JdbcConnectionPool.create("jdbc:h2:"+h2Path, "sa", "");
		jcp.setMaxConnections(10);
	}
	
	public static ConnPool getInstance(){
		
		if(cp==null){
			cp = new ConnPool();
		}
		return cp;
	}
	
	public Connection getConnection() throws SQLException{
		return jcp.getConnection();
	}
}
