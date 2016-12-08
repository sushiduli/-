package com.my.socket.senser;

import java.io.*;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1979687103870586387L;
	private String name;
	private String pass;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}