package com.club.item;

public class ClubType {
	String clubTypeId;
	String clubTypeName;
	String clubTypeIntroduction;
	/**
	 * 
	 */
	public ClubType() {
		super();
	}
	/**
	 * @param clubTypeId
	 * @param clubTypeName
	 * @param clubTypeIntroduction
	 */
	public ClubType(String clubTypeId, String clubTypeName, String clubTypeIntroduction) {
		super();
		this.clubTypeId = clubTypeId;
		this.clubTypeName = clubTypeName;
		this.clubTypeIntroduction = clubTypeIntroduction;
	}
	
	public String getClubTypeId() {
		return clubTypeId;
	}
	public String getClubTypeName() {
		return clubTypeName;
	}
	public String getClubTypeIntroduction() {
		return clubTypeIntroduction;
	}
	public void setClubTypeId(String clubTypeId) {
		this.clubTypeId = clubTypeId;
	}
	public void setClubTypeName(String clubTypeName) {
		this.clubTypeName = clubTypeName;
	}
	public void setClubTypeIntroduction(String clubTypeIntroduction) {
		this.clubTypeIntroduction = clubTypeIntroduction;
	}
}
