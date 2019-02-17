package com.club.item;

public class Comment {
	String commentId;
	String commentActivitiesId;
	String commentUserId;
	int commentFloor;
	String commentContent;
	/**
	 * 
	 */
	public Comment() {
		super();
	}
	/**
	 * @param commentId
	 * @param commentActivitiesId
	 * @param commentUserId
	 * @param commentFloor
	 * @param commentContent
	 */
	public Comment(String commentId, String commentActivitiesId, String commentUserId, int commentFloor,
			String commentContent) {
		super();
		this.commentId = commentId;
		this.commentActivitiesId = commentActivitiesId;
		this.commentUserId = commentUserId;
		this.commentFloor = commentFloor;
		this.commentContent = commentContent;
	}
	
	public String getCommentId() {
		return commentId;
	}
	public String getCommentActivitiesId() {
		return commentActivitiesId;
	}
	public String getCommentUserId() {
		return commentUserId;
	}
	public int getCommentFloor() {
		return commentFloor;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public void setCommentActivitiesId(String commentActivitiesId) {
		this.commentActivitiesId = commentActivitiesId;
	}
	public void setCommentUserId(String commentUserId) {
		this.commentUserId = commentUserId;
	}
	public void setCommentFloor(int commentFloor) {
		this.commentFloor = commentFloor;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
}
