package com.club.item;

public class Profession {
	String professionId;
	String professionname;
	String professionDepartmentId;
	/**
	 * 
	 */
	public Profession() {
		super();
	}
	/**
	 * @param professionId
	 * @param professionname
	 * @param professionDepartmentId
	 */
	public Profession(String professionId, String professionname, String professionDepartmentId) {
		super();
		this.professionId = professionId;
		this.professionname = professionname;
		this.professionDepartmentId = professionDepartmentId;
	}
	public String getProfessionId() {
		return professionId;
	}
	public String getProfessionName() {
		return professionname;
	}
	public String getProfessionDepartmentId() {
		return professionDepartmentId;
	}
	public void setProfessionId(String professionId) {
		this.professionId = professionId;
	}
	public void setProfessionname(String professionname) {
		this.professionname = professionname;
	}
	public void setProfessionDepartmentId(String professionDepartmentId) {
		this.professionDepartmentId = professionDepartmentId;
	}
	
}
