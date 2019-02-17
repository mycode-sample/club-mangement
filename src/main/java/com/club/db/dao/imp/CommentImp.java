package com.club.db.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.club.db.dao.CommentDao;
import com.club.item.Comment;

public class CommentImp implements CommentDao{
	Connection con;
	/**
	 * 
	 */
	public CommentImp() {
		super();
		con=new DateBase().getCon();
	}

	@Override
	public int add(Comment admin) {
		String id=admin.getCommentId();
		String activity=admin.getCommentActivitiesId();
		String user=admin.getCommentUserId();
		int floor=admin.getCommentFloor();
		String content=admin.getCommentContent();
		String sql="INSERT INTO `club`.`comment`\r\n" + 
				"(`comment_id`,\r\n" + 
				"`comment_activity_id`,\r\n" + 
				"`comment_user_id`,\r\n" + 
				"`comment_floor`,\r\n" + 
				"`comment_content`)\r\n" + 
				"VALUES\r\n" + 
				"(?,\r\n" + 
				"?,\r\n" + 
				"?,\r\n" + 
				"?,\r\n" + 
				"?);\r\n";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1,id);
			pre.setString(2,activity);
			pre.setString(3,user);
			pre.setInt(4,floor);
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
		String sql="DELETE FROM `club`.`comment`\r\n" + 
				"WHERE `comment`.`comment_id`=?;\r\n" ;
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
	public int update(String id, Comment admin) {
		String activity=admin.getCommentActivitiesId();
		String user=admin.getCommentUserId();
		int floor=admin.getCommentFloor();
		String content=admin.getCommentContent();
		String sql="UPDATE `club`.`comment`\r\n" + 
				"SET\r\n" + 
				"`comment_id` = ?,\r\n" + 
				"`comment_activity_id` = ?,\r\n" + 
				"`comment_user_id` = ?,\r\n" + 
				"`comment_floor` = ?,\r\n" + 
				"`comment_content` = ?\r\n" + 
				"WHERE `comment_id` = ?;\r\n";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1,id);
			pre.setString(2,activity);
			pre.setString(3,user);
			pre.setInt(4,floor);
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
	public List<Comment> queryAll() {
		List<Comment> comment=new ArrayList<Comment>();
		String sql="SELECT `comment`.`comment_id`,\r\n" + 
				"    `comment`.`comment_activity_id`,\r\n" + 
				"    `comment`.`comment_user_id`,\r\n" + 
				"    `comment`.`comment_floor`,\r\n" + 
				"    `comment`.`comment_content`\r\n" + 
				"FROM `club`.`comment`;\r\n";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			ResultSet res=pre.executeQuery();
			while(res.next()) {
				String id=res.getString(1);
				String activity=res.getString(2);
				String user=res.getString(3);
				int floor=res.getInt(4);
				String content=res.getString(5);
				Comment temp=new Comment(id,activity,user,floor,content);
				comment.add(temp);
			}
			res.close();
			pre.close();
			return comment;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Comment retrieve(String id) {
		String sql="SELECT `comment`.`comment_id`,\r\n" + 
				"    `comment`.`comment_activity_id`,\r\n" + 
				"    `comment`.`comment_user_id`,\r\n" + 
				"    `comment`.`comment_floor`,\r\n" + 
				"    `comment`.`comment_content`\r\n" + 
				"FROM `club`.`comment`"
				+ "where `comment`.`comment_activity_id`=?;\r\n";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			ResultSet res=pre.executeQuery();
			res.next();
			String activity=res.getString(2);
			String user=res.getString(3);
			int floor=res.getInt(4);
			String content=res.getString(5);
			Comment temp=new Comment(id,activity,user,floor,content);
			res.close();
			pre.close();
			return temp;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		con.close();
		super.finalize();
	}

}
