package com.cdv.test.db.model;

public class Role {

	private String roleName;
	
	private String roleConfig;
	
	private int readOnly;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleConfig() {
		return roleConfig;
	}

	public void setRoleConfig(String roleConfig) {
		this.roleConfig = roleConfig;
	}

	public int getReadOnly() {
		return readOnly;
	}

	public void setReadOnly(int readOnly) {
		this.readOnly = readOnly;
	}


	
	
}
