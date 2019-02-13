package com.club.item;

import java.util.Date;

public class Club {
	
	String clubId;
	String clubAccount;
	String clubName;
	Date clubRegisterdTime;
	String clubReviewerAdministratorId;
	String clubStudentId;
	String clubDepartmentId;
	String clubTeacherId;
	String clubLogo;
	String clubSlogn;
	String clubIntroduction;

	/**
	 * @param clubId
	 * @param clubAccount
	 * @param clubName
	 * @param clubRegisterdTime
	 * @param clubReviewerAdministratorId
	 * @param clubStudentId
	 * @param clubDepartmentId
	 * @param clubTeacherId
	 * @param clubLogo
	 * @param clubSlogn
	 * @param clubIntroduction
	 */
	public Club(String clubId, String clubAccount, String clubName, Date clubRegisterdTime,
			String clubReviewerAdministratorId, String clubStudentId, String clubDepartmentId, String clubTeacherId,
			String clubLogo, String clubSlogn, String clubIntroduction) {
		super();
		this.clubId = clubId;
		this.clubAccount = clubAccount;
		this.clubName = clubName;
		this.clubRegisterdTime = clubRegisterdTime;
		this.clubReviewerAdministratorId = clubReviewerAdministratorId;
		this.clubStudentId = clubStudentId;
		this.clubDepartmentId = clubDepartmentId;
		this.clubTeacherId = clubTeacherId;
		this.clubLogo = clubLogo;
		this.clubSlogn = clubSlogn;
		this.clubIntroduction = clubIntroduction;
	}

	/**
	 * 
	 */
	public Club() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getClubId() {
		return clubId;
	}

	public String getClubAccount() {
		return clubAccount;
	}

	public String getClubName() {
		return clubName;
	}

	public Date getClubRegisterdTime() {
		return clubRegisterdTime;
	}

	public String getClubReviewerAdministratorId() {
		return clubReviewerAdministratorId;
	}

	public String getClubStudentId() {
		return clubStudentId;
	}

	public String getClubDepartmentId() {
		return clubDepartmentId;
	}

	public String getClubTeacherId() {
		return clubTeacherId;
	}

	public String getClubLogo() {
		return clubLogo;
	}

	public String getClubSlogn() {
		return clubSlogn;
	}

	public String getClubIntroduction() {
		return clubIntroduction;
	}

	public void setClubId(String clubId) {
		this.clubId = clubId;
	}

	public void setClubAccount(String clubAccount) {
		this.clubAccount = clubAccount;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public void setClubRegisterdTime(Date clubRegisterdTime) {
		this.clubRegisterdTime = clubRegisterdTime;
	}

	public void setClubReviewerAdministratorId(String clubReviewerAdministratorId) {
		this.clubReviewerAdministratorId = clubReviewerAdministratorId;
	}

	public void setClubStudentId(String clubStudentId) {
		this.clubStudentId = clubStudentId;
	}

	public void setClubDepartmentId(String clubDepartmentId) {
		this.clubDepartmentId = clubDepartmentId;
	}

	public void setClubTeacherId(String clubTeacherId) {
		this.clubTeacherId = clubTeacherId;
	}

	public void setClubLogo(String clubLogo) {
		this.clubLogo = clubLogo;
	}

	public void setClubSlogn(String clubSlogn) {
		this.clubSlogn = clubSlogn;
	}

	public void setClubIntroduction(String clubIntroduction) {
		this.clubIntroduction = clubIntroduction;
	}
	
	
	
}
