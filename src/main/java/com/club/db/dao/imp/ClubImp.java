package com.club.db.dao.imp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.club.db.dao.ClubDao;
import com.club.item.Club;

public class ClubImp implements ClubDao{
	Connection con;
	/**
	 * 
	 */
	public ClubImp() {
		super();
		con=new DateBase().getCon();
	}

	@Override
	public int add(Club club) {
		String id=club.getClubId();
		String account=club.getClubAccount();
		String name=club.getClubName();
		Date registerTime=club.getClubRegisterdTime();
		String reviewer=club.getClubReviewerAdministratorId();
		String student=club.getClubStudentId();
		String department=club.getClubDepartmentId();
		String teacher=club.getClubTeacherId();
		String logo=club.getClubLogo();
		String slogn=club.getClubSlogn();
		String introduction=club.getClubIntroduction();
		String sql="INSERT INTO `club`.`club`\r\n" + 
				"(`club_id`,\r\n" + 
				"`club_account`,\r\n" + 
				"`club_name`,\r\n" + 
				"`club_registered_time`,\r\n" + 
				"`club_reviewer_administrator_id`,\r\n" + 
				"`club_student_id`,\r\n" + 
				"`club_department_id`,\r\n" + 
				"`club_teacher_id`,\r\n" + 
				"`club_logo`,\r\n" + 
				"`club_slogn`,\r\n" + 
				"`club_introduction`)\r\n" + 
				"VALUES\r\n" + 
				"?,\r\n" + 
				"?,\r\n" + 
				"?,\r\n" + 
				"?,\r\n" + 
				"?,\r\n" + 
				"?,\r\n" + 
				"?,\r\n" + 
				"?,\r\n" + 
				"?,\r\n" + 
				"?,\r\n" + 
				"?);";
		PreparedStatement pre;
		try {
			pre=con.prepareStatement(sql);
			pre.setString(1,id);
			pre.setString(2,account);
			pre.setString(3,name);
			pre.setDate(4,registerTime);
			pre.setString(5,reviewer);
			pre.setString(6,student);
			pre.setString(7,department);
			pre.setString(8,teacher);
			pre.setString(9,logo);
			pre.setString(10,slogn);
			pre.setString(11,introduction);
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
		String sql="DELETE FROM `club`.`club`\r\n" + 
				"WHERE `club`.`club_id`=?;";
		try {
			PreparedStatement pre = con.prepareStatement(sql);
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
	public int update(String id, Club club) {
		String id2=club.getClubId();
		String account=club.getClubAccount();
		String name=club.getClubName();
		Date registerTime=club.getClubRegisterdTime();
		String reviewer=club.getClubReviewerAdministratorId();
		String student=club.getClubStudentId();
		String department=club.getClubDepartmentId();
		String teacher=club.getClubTeacherId();
		String logo=club.getClubLogo();
		String slogn=club.getClubSlogn();
		String introduction=club.getClubIntroduction();
		String sql="UPDATE `club`.`club`\r\n" + 
				"SET\r\n" + 
				"`club_id` =?,\r\n" + 
				"`club_account` = ?,\r\n" + 
				"`club_name` = ?,\r\n" + 
				"`club_registered_time` = ?,\r\n" + 
				"`club_reviewer_administrator_id` = ?,\r\n" + 
				"`club_student_id` = ?,\r\n" + 
				"`club_department_id` = ?,\r\n" + 
				"`club_teacher_id` = ?,\r\n" + 
				"`club_logo` = ?,\r\n" + 
				"`club_slogn` = ?,\r\n" + 
				"`club_introduction` = ?\r\n" + 
				"WHERE `club_id` =?;";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1,id2);
			pre.setString(2,account);
			pre.setString(3,name);
			pre.setDate(4,registerTime);
			pre.setString(5,reviewer);
			pre.setString(6,student);
			pre.setString(7,department);
			pre.setString(8,teacher);
			pre.setString(9,logo);
			pre.setString(10,slogn);
			pre.setString(11,introduction);
			pre.setString(12,id);
			int n=pre.executeUpdate();
			pre.close();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Club> queryAll() {
		List<Club> club=new ArrayList<Club>();
		String sql="SELECT `club`.`club_id`,\r\n" + 
				"    `club`.`club_account`,\r\n" + 
				"    `club`.`club_name`,\r\n" + 
				"    `club`.`club_registered_time`,\r\n" + 
				"    `club`.`club_reviewer_administrator_id`,\r\n" + 
				"    `club`.`club_student_id`,\r\n" + 
				"    `club`.`club_department_id`,\r\n" + 
				"    `club`.`club_teacher_id`,\r\n" + 
				"    `club`.`club_logo`,\r\n" + 
				"    `club`.`club_slogn`,\r\n" + 
				"    `club`.`club_introduction`\r\n" + 
				"FROM `club`.`club`;";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			ResultSet res=pre.executeQuery();
			while(res.next()) {
				String id=res.getString(1);
				String account=res.getString(2);
				String name=res.getString(3);
				Date registerTime=res.getDate(4);
				String reviewer=res.getString(5);
				String student=res.getString(6);
				String department=res.getString(7);
				String teacher=res.getString(8);
				String logo=res.getString(9);
				String slogn=res.getString(10);
				String introduction=res.getString(11);
				Club user=new Club(id,account,name,registerTime,reviewer,student,department,teacher,logo,slogn,introduction);
				club.add(user);
			}
			res.close();
			pre.close();
			return club;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Club retrieve(String id) {
		String sql="SELECT `club`.`club_id`,\r\n" + 
				"    `club`.`club_account`,\r\n" + 
				"    `club`.`club_name`,\r\n" + 
				"    `club`.`club_registered_time`,\r\n" + 
				"    `club`.`club_reviewer_administrator_id`,\r\n" + 
				"    `club`.`club_student_id`,\r\n" + 
				"    `club`.`club_department_id`,\r\n" + 
				"    `club`.`club_teacher_id`,\r\n" + 
				"    `club`.`club_logo`,\r\n" + 
				"    `club`.`club_slogn`,\r\n" + 
				"    `club`.`club_introduction`\r\n" + 
				"FROM `club`.`club`;\r\n" + 
				"where `club`.`club_id`=?";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1,id);
			ResultSet res=pre.executeQuery();
			res.next();
			String account=res.getString(2);
			String name=res.getString(3);
			Date registerTime=res.getDate(4);
			String reviewer=res.getString(5);
			String student=res.getString(6);
			String department=res.getString(7);
			String teacher=res.getString(8);
			String logo=res.getString(9);
			String slogn=res.getString(10);
			String introduction=res.getString(11);
			Club user=new Club(id,account,name,registerTime,reviewer,student,department,teacher,logo,slogn,introduction);
			res.close();
			pre.close();
			return user;
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
