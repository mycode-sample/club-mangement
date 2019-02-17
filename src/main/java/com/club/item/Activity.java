package com.club.item;

public class Activity {
	
	String activityId;//活动id
	String activityClubId;//活动所属社团
	short  activityStatus;//活动状态,-1,0,1
	String activityName;
	/**
	 * 
	 */
	public Activity() {
		super();
	}
	/**
	 * @param activityId
	 * @param activityClubId
	 * @param activityStatus
	 * @param activityName
	 */
	public Activity(String activityId, String activityClubId, short activityStatus, String activityName) {
		super();
		this.activityId = activityId;
		this.activityClubId = activityClubId;
		this.activityStatus = activityStatus;
		this.activityName = activityName;
	}
	public String getActivityId() {
		return activityId;
	}
	public String getActivityClubId() {
		return activityClubId;
	}
	public short getActivityStatus() {
		return activityStatus;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	public void setActivityClubId(String activityClubId) {
		this.activityClubId = activityClubId;
	}
	public void setActivityStatus(short activityStatus) {
		this.activityStatus = activityStatus;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	
}
