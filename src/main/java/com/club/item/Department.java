package com.club.item;

public class Department {
	String departmentId;
	String departmentName;
	String departmentLogo;
	/**
	 * 
	 */
	public Department() {
		super();
	}
	/**
	 * @param departmentId
	 * @param departmentName
	 * @param departmentLogo
	 */
	public Department(String departmentId, String departmentName, String departmentLogo) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentLogo = departmentLogo;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public String getDepartmentLogo() {
		return departmentLogo;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public void setDepartmentLogo(String departmentLogo) {
		this.departmentLogo = departmentLogo;
	}
	
}
