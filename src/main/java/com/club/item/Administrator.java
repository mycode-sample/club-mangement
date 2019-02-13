package com.club.item;

public class Administrator {
	
	/**
	 * 
	 */
	public Administrator() {
		super();
	}
	/**
	 * @param administratorId
	 * @param administratorName
	 * @param administratorPassword
	 */
	public Administrator(String administratorId, String administratorName, String administratorPassword) {
		super();
		this.administratorId = administratorId;
		this.administratorName = administratorName;
		this.administratorPassword = administratorPassword;
	}
	String administratorId;//管理员id
	String administratorName;
	String administratorPassword;
	
	public String getAdministratorId() {
		return administratorId;
	}
	public String getAdministratorName() {
		return administratorName;
	}
	public String getAdministratorPassword() {
		return administratorPassword;
	}
	public void setAdministratorId(String administratorId) {
		this.administratorId = administratorId;
	}
	public void setAdministratorName(String administratorName) {
		this.administratorName = administratorName;
	}
	public void setAdministratorPassword(String administratorPassword) {
		this.administratorPassword = administratorPassword;
	}
}
