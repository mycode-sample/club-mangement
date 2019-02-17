package com.club.item;

public class Teacher {
	String teacherId;
	String teacherName;
	String teacherPickname;
	String teacherPassword;
	String teacherDepartmentId;
	/**
	 * 
	 */
	public Teacher() {
		super();
	}
	/**
	 * @param teacherId
	 * @param teacherName
	 * @param teacherPassword
	 * @param teacherDepartmentId
	 */
	public Teacher(String teacherId, String teacherName, String teacherPassword, String teacherDepartmentId) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherPassword = teacherPassword;
		this.teacherDepartmentId = teacherDepartmentId;
	}
	/**
	 * @param teacherId
	 * @param teacherName
	 * @param teacherPickname
	 * @param teacherPassword
	 * @param teacherDepartmentId
	 */
	public Teacher(String teacherId, String teacherName, String teacherPickname, String teacherPassword,
			String teacherDepartmentId) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherPickname = teacherPickname;
		this.teacherPassword = teacherPassword;
		this.teacherDepartmentId = teacherDepartmentId;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public String getTeacherPickname() {
		return teacherPickname;
	}
	public String getTeacherPassword() {
		return teacherPassword;
	}
	public String getTeacherDepartmentId() {
		return teacherDepartmentId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public void setTeacherPickname(String teacherPickname) {
		this.teacherPickname = teacherPickname;
	}
	public void setTeacherPassword(String teacherPassword) {
		this.teacherPassword = teacherPassword;
	}
	public void setTeacherDepartmentId(String teacherDepartmentId) {
		this.teacherDepartmentId = teacherDepartmentId;
	}
}
