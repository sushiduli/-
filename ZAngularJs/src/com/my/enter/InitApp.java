package com.my.enter;

import java.sql.SQLException;

public class InitApp {

	public static void main(String[] args) {
		try {
			CommonDao.crateTable();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
