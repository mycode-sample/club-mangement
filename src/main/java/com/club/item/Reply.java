package com.club.item;

public class Reply {
	String replyId;
	String replyCommentId;
	String replyUserId;
	String replyReciverUser;
	String replyContent;
	/**
	 * 
	 */
	public Reply() {
		super();
	}
	/**
	 * @param replyId
	 * @param replyCommentId
	 * @param replyUserId
	 * @param replyReciverUser
	 * @param replyContent
	 */
	public Reply(String replyId, String replyCommentId, String replyUserId, String replyReciverUser,
			String replyContent) {
		super();
		this.replyId = replyId;
		this.replyCommentId = replyCommentId;
		this.replyUserId = replyUserId;
		this.replyReciverUser = replyReciverUser;
		this.replyContent = replyContent;
	}
	public String getReplyId() {
		return replyId;
	}
	public String getReplyCommentId() {
		return replyCommentId;
	}
	public String getReplyUserId() {
		return replyUserId;
	}
	public String getReplyReciverUser() {
		return replyReciverUser;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}
	public void setReplyCommentId(String replyCommentId) {
		this.replyCommentId = replyCommentId;
	}
	public void setReplyUserId(String replyUserId) {
		this.replyUserId = replyUserId;
	}
	public void setReplyReciverUser(String replyReciverUser) {
		this.replyReciverUser = replyReciverUser;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	
}
