package com.club.item;

public class Activity {
	
	/**
	 * 
	 */
	public Activity() {
		super();
	}
	/**
	 * @param activitiesId
	 * @param activitiesClubId
	 * @param activitiesStatus
	 */
	public Activity(String activitiesId, String activitiesClubId, short activitiesStatus) {
		super();
		this.activitiesId = activitiesId;
		this.activitiesClubId = activitiesClubId;
		this.activitiesStatus = activitiesStatus;
	}
	
	String activitiesId;//活动id
	String activitiesClubId;//活动所属社团
	short  activitiesStatus;//活动状态,-1,0,1
	
	public String getActivitiesId() {
		return activitiesId;
	}
	public String getActivitiesClubId() {
		return activitiesClubId;
	}
	public short getActivitiesStatus() {
		return activitiesStatus;
	}
	public void setActivitiesId(String activitiesId) {
		this.activitiesId = activitiesId;
	}
	public void setActivitiesClubId(String activitiesClubId) {
		this.activitiesClubId = activitiesClubId;
	}
	public void setActivitiesStatus(short activitiesStatus) {
		this.activitiesStatus = activitiesStatus;
	}
	
	
	
}
