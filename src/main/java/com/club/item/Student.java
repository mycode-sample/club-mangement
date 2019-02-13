package com.club.item;

public class Student {
	String studentId;
	String studentDepartmentId;
	String studentProfessionId;
	String studentName;
	String studentPickname;
	String studentPassword;
	/**
	 * 
	 */
	public Student() {
		super();
	}
	/**
	 * @param studentId
	 * @param studentDepartmentId
	 * @param studentProfessionId
	 * @param studentName
	 * @param studentPassword
	 */
	public Student(String studentId, String studentDepartmentId, String studentProfessionId, String studentName,
			String studentPassword) {
		super();
		this.studentId = studentId;
		this.studentDepartmentId = studentDepartmentId;
		this.studentProfessionId = studentProfessionId;
		this.studentName = studentName;
		this.studentPassword = studentPassword;
	}
	public String getStudentId() {
		return studentId;
	}
	public String getStudentDepartmentId() {
		return studentDepartmentId;
	}
	public String getStudentProfessionId() {
		return studentProfessionId;
	}
	public String getStudentName() {
		return studentName;
	}
	public String getStudentPickname() {
		return studentPickname;
	}
	public String getStudentPassword() {
		return studentPassword;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public void setStudentDepartmentId(String studentDepartmentId) {
		this.studentDepartmentId = studentDepartmentId;
	}
	public void setStudentProfessionId(String studentProfessionId) {
		this.studentProfessionId = studentProfessionId;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public void setStudentPickname(String studentPickname) {
		this.studentPickname = studentPickname;
	}
	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}
}
