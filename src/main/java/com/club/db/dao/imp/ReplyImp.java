package com.club.db.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.club.db.dao.ReplyDao;
import com.club.item.Reply;

public class ReplyImp implements ReplyDao{
	
	Connection con;

	/**
	 * 
	 */
	public ReplyImp() {
		super();
		con=new DateBase().getCon();
	}

	@Override
	public int add(Reply admin) {
		String id=admin.getReplyId();
		String comment=admin.getReplyCommentId();
		String user=admin.getReplyUserId();
		String reciver=admin.getReplyReciverUser();
		String content=admin.getReplyContent();
		String sql="INSERT INTO `club`.`reply`\r\n" + 
				"(`reply_id`,\r\n" + 
				"`reply_comment_id`,\r\n" + 
				"`reply_user_id`,\r\n" + 
				"`reply_reciver_user_id`,\r\n" + 
				"`reply_content`)\r\n" + 
				"VALUES\r\n" + 
				"(?,\r\n" + 
				"?,\r\n" + 
				"?,\r\n" + 
				"?,\r\n" + 
				"?);\r\n";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1,id);
			pre.setString(2,comment);
			pre.setString(3,user);
			pre.setString(4,reciver);
			pre.setString(5,content);
			int n=pre.executeUpdate();
			pre.close();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(String id) {
		String sql="DELETE FROM `club`.`reply`\r\n" + 
				"WHERE `reply`.`reply_id`=?;\r\n";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1,id);
			int n=pre.executeUpdate();
			pre.close();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(String id, Reply admin) {
		String comment=admin.getReplyCommentId();
		String user=admin.getReplyUserId();
		String reciver=admin.getReplyReciverUser();
		String content=admin.getReplyContent();
		String sql="UPDATE `club`.`reply`\r\n" + 
				"SET\r\n" + 
				"`reply_id` = ?,\r\n" + 
				"`reply_comment_id` = ?,\r\n" + 
				"`reply_user_id` = ?,\r\n" + 
				"`reply_reciver_user_id` = ?,\r\n" + 
				"`reply_content` =?\r\n" + 
				"WHERE `reply_id` = ?;\r\n";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1,id);
			pre.setString(2,comment);
			pre.setString(3,user);
			pre.setString(4,reciver);
			pre.setString(5,content);
			int n=pre.executeUpdate();
			pre.close();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}		
	}

	@Override
	public List<Reply> queryAll() {
		List<Reply> reply=new ArrayList<Reply>();
		String sql="SELECT `reply`.`reply_id`,\r\n" + 
				"    `reply`.`reply_comment_id`,\r\n" + 
				"    `reply`.`reply_user_id`,\r\n" + 
				"    `reply`.`reply_reciver_user_id`,\r\n" + 
				"    `reply`.`reply_content`\r\n" + 
				"FROM `club`.`reply`;\r\n";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			ResultSet res=pre.executeQuery();
			while(res.next()) {
				String id=res.getString(1);
				String comment=res.getString(2);
				String user=res.getString(3);
				String reciver=res.getString(4);
				String content=res.getString(5);
				Reply temp=new Reply(id,comment,user,reciver,content);
				reply.add(temp);
			}
			res.close();
			pre.close();
			return reply;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Reply retrieve(String id) {
		String sql="SELECT `reply`.`reply_id`,\r\n" + 
				"    `reply`.`reply_comment_id`,\r\n" + 
				"    `reply`.`reply_user_id`,\r\n" + 
				"    `reply`.`reply_reciver_user_id`,\r\n" + 
				"    `reply`.`reply_content`\r\n" + 
				"FROM `club`.`reply`\r\n" + 
				"	where WHERE `reply_id` = ?";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1,id);
			ResultSet res=pre.executeQuery();
			res.next();
			String comment=res.getString(2);
			String user=res.getString(3);
			String reciver=res.getString(4);
			String content=res.getString(5);
			Reply temp=new Reply(id,comment,user,reciver,content);
			return temp;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	protected void finalize() throws Throwable {
		con.close();
		super.finalize();
	}

}
