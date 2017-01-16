package com.lgp.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CommonDao {

	
	public static void CreateTable(){
	
		 Statement statement = null;
		
		 Connection connection = null;
		
		 ResultSet rs = null;
		 try {

			connection = ConnPool.getInstance().getConnection();
			
			DatabaseMetaData metaData = connection.getMetaData();
			
			 rs = metaData.getTables(null, null, "tablename", new String[]{"Table"});
			if(rs.next()){
				
			}else{
				statement = connection.createStatement();	
				statement.execute("Create Table testtable (c1 varchar(20),c2 int, PRIMARY KEY(c2))");
			}
		} catch (Throwable e) {
			System.out.println(".........");
		}finally {
			try {
				releaseConnection(connection, statement, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public static void addInfo(String c1 ,int c2){
		 Statement statement = null;
			
		 Connection connection = null;
		
		 ResultSet rs = null;
		 try {

			connection = ConnPool.getInstance().getConnection();
			statement = connection.createStatement();	
			boolean flag = statement.execute("insert into testtable values ("+c1+","+c2+")");
			System.out.println(flag);
		} catch (Throwable e) {
			System.out.println("........."+e.getMessage());
		}finally {
			try {
				releaseConnection(connection, statement, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	private static void releaseConnection(Connection conn, Statement stmt,
			ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}


	public static void getTableData() {
		 PreparedStatement statement = null;
			
		 Connection connection = null;
		
		 ResultSet rs = null;
		 try {

			connection = ConnPool.getInstance().getConnection();
			statement = connection.prepareStatement("Select * from testtable");	
			rs = statement.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString(1)+"===="+rs.getInt(2));
			}
		} catch (Throwable e) {
			System.out.println("........."+e.getMessage());
		}finally {
			try {
				releaseConnection(connection, statement, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
