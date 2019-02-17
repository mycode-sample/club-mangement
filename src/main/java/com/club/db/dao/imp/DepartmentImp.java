package com.club.db.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.club.db.dao.DepartmentDao;
import com.club.item.Department;

public class DepartmentImp implements DepartmentDao{
	Connection con;

	/**
	 * 
	 */
	public DepartmentImp() {
		super();
		con=new DateBase().getCon();
	}

	@Override
	public int add(Department admin) {
		String id=admin.getDepartmentId();
		String name=admin.getDepartmentName();
		String logo=admin.getDepartmentLogo();
		String sql="INSERT INTO `club`.`department`\r\n" + 
				"(`department_id`,\r\n" + 
				"`department_name`,\r\n" + 
				"`department_logo`)\r\n" + 
				"VALUES\r\n" + 
				"(?,\r\n" + 
				"?,\r\n" + 
				"?);\r\n";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1,id);
			pre.setString(2,name);
			pre.setString(3,logo);
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
		String sql="DELETE FROM `club`.`department`\r\n" + 
				"WHERE `department`.`department_id`=?;\r\n";
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
	public int update(String id, Department admin) {
		String name=admin.getDepartmentName();
		String logo=admin.getDepartmentLogo();
		String sql="UPDATE `club`.`department`\r\n" + 
				"SET\r\n" + 
				"`department_id` = ?,\r\n" + 
				"`department_name` = ?,\r\n" + 
				"`department_logo` = ?\r\n" + 
				"WHERE `department_id` = ?;\r\n";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1,id);
			pre.setString(2,name);
			pre.setString(3,logo);
			int n=pre.executeUpdate();
			pre.close();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}		
	}

	@Override
	public List<Department> queryAll() {
		List<Department> department=new ArrayList<Department>();
		String sql="SELECT `department`.`department_id`,\r\n" + 
				"    `department`.`department_name`,\r\n" + 
				"    `department`.`department_logo`\r\n" + 
				"FROM `club`.`department`;\r\n";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			ResultSet res=pre.executeQuery();
			while(res.next()) {
				String id=res.getString(1);
				String name=res.getString(2);
				String logo=res.getString(3);
				Department temp=new Department(id,name,logo);
				department.add(temp);
			}
			res.close();
			pre.close();
			return department;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Department retrieve(String id) {
		String sql="SELECT `department`.`department_id`,\r\n" + 
				"    `department`.`department_name`,\r\n" + 
				"    `department`.`department_logo`\r\n" + 
				"FROM `club`.`department`;\r\n"
				+ "where `department`.`department_id`=?";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1,id);
			ResultSet res=pre.executeQuery();
			res.next();
			String name=res.getString(2);
			String logo=res.getString(3);
			Department temp=new Department(id,name,logo);
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
