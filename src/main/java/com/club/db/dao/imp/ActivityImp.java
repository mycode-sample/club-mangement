/**
 * 
 */
package com.club.db.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.club.db.dao.ActivityDao;
import com.club.item.Activity;

/**
 * @author Function
 *
 */
public class ActivityImp implements ActivityDao{
	Connection con;
	/**
	 * 
	 */
	public ActivityImp() {
		super();
		con=new DateBase().getCon();
	}

	@Override
	public int add(Activity admin) {
		String id=admin.getActivityId();
		String club=admin.getActivityClubId();
		short status=admin.getActivityStatus();
		String name=admin.getActivityName();
		String sql="INSERT INTO `club`.`activities`\r\n" + 
				"(`activity_id`,\r\n" + 
				"`activity_club_id`,\r\n" + 
				"`activity_status`,\r\n" + 
				"`activity_name`)\r\n" + 
				"VALUES\r\n" + 
				"(?,\r\n" + 
				"?,\r\n" + 
				"?,\r\n" + 
				"?);\r\n";
		PreparedStatement pre;
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1,id);
			pre.setString(2,club);
			pre.setShort(3,status);
			pre.setString(4,name);
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
		String sql="DELETE FROM `club`.`activities`\r\n" + 
				"WHERE activity_id=?;";
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
	public int update(String id, Activity admin) {
		String club=admin.getActivityClubId();
		short status=admin.getActivityStatus();
		String name=admin.getActivityName();
		String sql="UPDATE `club`.`activity`\r\n" + 
				"SET\r\n" + 
				"`activity_id` = ?,\r\n" + 
				"`activity_club_id` = ?,\r\n" + 
				"`activity_status` = ?,\r\n" + 
				"`activity_name` = ?\r\n" + 
				"WHERE `activity_id` = ?;";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1,id);
			pre.setString(2,club);
			pre.setShort(3,status);
			pre.setString(4,name);
			int n=pre.executeUpdate();
			pre.close();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Activity> queryAll() {
		List<Activity> activity=new ArrayList<Activity>();
		String sql="SELECT `activity`.`activity_id`,\r\n" + 
				"    `activity`.`activity_club_id`,\r\n" + 
				"    `activity`.`activity_status`,\r\n" + 
				"    `activity`.`activity_name`\r\n" + 
				"FROM `club`.`activity`;";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			ResultSet res=pre.executeQuery();
			while(res.next()) {
				String id=res.getString(1);
				String club=res.getString(2);
				short status=res.getShort(3);
				String name=res.getString(4);
				Activity temp=new Activity(id,club,status,name);
				activity.add(temp);
			}
			res.close();
			pre.close();
			return activity;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Activity retrieve(String id) {
		String sql="SELECT `activity`.`activity_id`,\r\n" + 
				"    `activity`.`activity_club_id`,\r\n" + 
				"    `activity`.`activity_status`,\r\n" + 
				"    `activity`.`activity_name`\r\n" + 
				"FROM `club`.`activity`"
				+ "where `activity`.`activity_id`=?;\r\n";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1,id);
			ResultSet res=pre.executeQuery();
			res.next();
			String club=res.getString(2);
			short status=res.getShort(3);
			String name=res.getString(4);
			Activity temp=new Activity(id,club,status,name);
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
		con.close();
		super.finalize();
	}

}
