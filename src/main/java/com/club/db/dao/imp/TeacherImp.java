package com.club.db.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.club.db.dao.TeacherDao;
import com.club.item.Teacher;

public class TeacherImp implements TeacherDao{
	Connection con;
	/**
	 * 
	 */
	public TeacherImp() {
		super();
		con=new DateBase().getCon();
	}

	@Override
	public int add(Teacher admin) {
		String id=admin.getTeacherId();
		String name=admin.getTeacherName();
		String pickname=admin.getTeacherPickname();
		String password=admin.getTeacherPassword();
		String department=admin.getTeacherDepartmentId();
		String sql="INSERT INTO `club`.`teacher`\r\n" + 
				"(`teacher_id`,\r\n" + 
				"`teacher_name`,\r\n" + 
				"`teacher_pickname`,\r\n" + 
				"`teacher_password`,\r\n" + 
				"`teacher_department_id`)\r\n" + 
				"VALUES\r\n" + 
				"(?,\r\n" + 
				"?,\r\n" + 
				"?,\r\n" + 
				"?,\r\n" + 
				"?);\r\n";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1,id);
			pre.setString(2,name);
			pre.setString(3,pickname);
			pre.setString(4,password);
			pre.setString(5,department);
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
		String sql="DELETE FROM `club`.`teacher`\r\n" + 
				"	WHERE `teacher_id` = ?;\r\n";
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
	public int update(String id, Teacher admin) {
		String name=admin.getTeacherName();
		String pickname=admin.getTeacherPickname();
		String password=admin.getTeacherPassword();
		String department=admin.getTeacherDepartmentId();
		String sql="UPDATE `club`.`teacher`\r\n" + 
				"SET\r\n" + 
				"`teacher_id` = ?,\r\n" + 
				"`teacher_name` = ?,\r\n" + 
				"`teacher_pickname` = ?,\r\n" + 
				"`teacher_password` = ?,\r\n" + 
				"`teacher_department_id` = ?\r\n" + 
				"WHERE `teacher_id` = ?;\r\n" ;
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1,id);
			pre.setString(2,name);
			pre.setString(3,pickname);
			pre.setString(4,password);
			pre.setString(5,department);
			int n=pre.executeUpdate();
			pre.close();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Teacher> queryAll() {
		List<Teacher> teacher=new ArrayList<Teacher>();
		String sql="SELECT `teacher`.`teacher_id`,\r\n" + 
				"    `teacher`.`teacher_name`,\r\n" + 
				"    `teacher`.`teacher_pickname`,\r\n" + 
				"    `teacher`.`teacher_password`,\r\n" + 
				"    `teacher`.`teacher_department_id`\r\n" + 
				"FROM `club`.`teacher`;\r\n";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			ResultSet res=pre.executeQuery();
			while(res.next()) {
				String id=res.getString(1);
				String name=res.getString(2);
				String pickname=res.getString(3);
				String password=res.getString(4);
				String department=res.getString(5);
				Teacher temp=new Teacher(id,name,pickname,password,department);
				teacher.add(temp);
			}
			res.close();
			pre.close();
			return teacher;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Teacher retrieve(String id) {
		String sql="SELECT `teacher`.`teacher_id`,\r\n" + 
				"    `teacher`.`teacher_name`,\r\n" + 
				"    `teacher`.`teacher_pickname`,\r\n" + 
				"    `teacher`.`teacher_password`,\r\n" + 
				"    `teacher`.`teacher_department_id`\r\n" + 
				"FROM `club`.`teacher`"
				+ "WHERE `teacher_id` = ?;\r\n";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1,id);
			ResultSet res=pre.executeQuery();
			res.next();
			String name=res.getString(2);
			String pickname=res.getString(3);
			String password=res.getString(4);
			String department=res.getString(5);
			Teacher temp=new Teacher(id,name,pickname,password,department);
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
