package com.club.db.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import com.club.db.dao.StudentDao;
import com.club.item.Student;

public class StudentImp implements StudentDao{
	Connection con;
	/**
	 * 
	 */
	public StudentImp() {
		super();
		con=new DateBase().getCon();
	}

	@Override
	public int add(Student admin) {
		String id=admin.getStudentId();
		String department=admin.getStudentDepartmentId();
		String profession=admin.getStudentProfessionId();
		String name=admin.getStudentName();
		String pickname=admin.getStudentPickname();
		String password=admin.getStudentPassword();
		String sql="INSERT INTO `club`.`student`\r\n" + 
				"(`student_id`,\r\n" + 
				"`student_department_id`,\r\n" + 
				"`student_profession_id`,\r\n" + 
				"`student_name`,\r\n" + 
				"`student_pickname`,\r\n" + 
				"`student_password`)\r\n" + 
				"VALUES\r\n" + 
				"(?,\r\n" + 
				"?,\r\n" + 
				"?,\r\n" + 
				"?,\r\n" + 
				"?,\r\n" + 
				"?);\r\n" ;
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1,id);
			pre.setString(2,department);
			pre.setString(3,profession);
			pre.setString(4,name);
			pre.setString(5,pickname);
			pre.setString(6,password);
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
		String sql="DELETE FROM `club`.`student`\r\n" + 
				"WHERE `student`.`student_id`=?;\r\n";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1,id);
			int n=pre.executeUpdate();
			pre.close();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(String id, Student admin) {
		String department=admin.getStudentDepartmentId();
		String profession=admin.getStudentProfessionId();
		String name=admin.getStudentName();
		String pickname=admin.getStudentPickname();
		String password=admin.getStudentPassword();
		String sql="UPDATE `club`.`student`\r\n" + 
				"SET\r\n" + 
				"`student_id` = ?,\r\n" + 
				"`student_department_id` = ?,\r\n" + 
				"`student_profession_id` = ?,\r\n" + 
				"`student_name` = ?,\r\n" + 
				"`student_pickname` = ?,\r\n" + 
				"`student_password` = ?\r\n" + 
				"WHERE `student_id` = ?;\r\n";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1,id);
			pre.setString(2,department);
			pre.setString(3,profession);
			pre.setString(4,name);
			pre.setString(5,pickname);
			pre.setString(6,password);
			int n=pre.executeUpdate();
			pre.close();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Student> queryAll() {
		List<Student> student=new ArrayList<Student>();
		String sql="SELECT `student`.`student_id`,\r\n" + 
				"    `student`.`student_department_id`,\r\n" + 
				"    `student`.`student_profession_id`,\r\n" + 
				"    `student`.`student_name`,\r\n" + 
				"    `student`.`student_pickname`,\r\n" + 
				"    `student`.`student_password`\r\n" + 
				"FROM `club`.`student`;\r\n";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			ResultSet res=pre.executeQuery();
			while(res.next()) {
				String id=res.getString(1);
				String department=res.getString(2);
				String profession=res.getString(3);
				String name=res.getString(4);
				String pickname=res.getString(5);
				String password=res.getString(6);
				Student temp=new Student(id,department,profession,name,pickname,password);
				student.add(temp);
			}
			res.close();
			pre.close();
			return student;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Student retrieve(String id) {
		String sql="SELECT `student`.`student_id`,\r\n" + 
				"    `student`.`student_department_id`,\r\n" + 
				"    `student`.`student_profession_id`,\r\n" + 
				"    `student`.`student_name`,\r\n" + 
				"    `student`.`student_pickname`,\r\n" + 
				"    `student`.`student_password`\r\n" + 
				"FROM `club`.`student`\r\n" + 
				" where student_id=?";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1,id);
			ResultSet res=pre.executeQuery();
			res.next();
			String department=res.getString(2);
			String profession=res.getString(3);
			String name=res.getString(4);
			String pickname=res.getString(5);
			String password=res.getString(6);
			Student temp=new Student(id,department,profession,name,pickname,password);
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
