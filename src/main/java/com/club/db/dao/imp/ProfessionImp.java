package com.club.db.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.club.db.dao.ProfessionDao;
import com.club.item.Profession;

public class ProfessionImp implements ProfessionDao{
	Connection con;
	/**
	 * 
	 */
	public ProfessionImp() {
		super();
		con=new DateBase().getCon();
	}

	@Override
	public int add(Profession admin) {
		String id=admin.getProfessionId();
		String name=admin.getProfessionName();
		String departmentId=admin.getProfessionDepartmentId();
		String sql="INSERT INTO `club`.`profession`\r\n" + 
				"(`profession_id`,\r\n" + 
				"`profession_name`,\r\n" + 
				"`profession_department_id`)\r\n" + 
				"VALUES\r\n" + 
				"(?,\r\n" + 
				"?,\r\n" + 
				"?);\r\n";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1,id);
			pre.setString(2,name);
			pre.setString(3,departmentId);
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
		String sql="DELETE FROM `club`.`profession`\r\n" + 
				"WHERE `profession`.`profession_id`=?;\r\n";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			int n=pre.executeUpdate();
			pre.close();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(String id, Profession admin) {
		String name=admin.getProfessionName();
		String departmentId=admin.getProfessionDepartmentId();
		String sql="UPDATE `club`.`profession`\r\n" + 
				"SET\r\n" + 
				"`profession_id` = ?,\r\n" + 
				"`profession_name` = ?,\r\n" + 
				"`profession_department_id` = ?\r\n" + 
				"WHERE `profession_id` = ?;\r\n";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1,id);
			pre.setString(2,name);
			pre.setString(3,departmentId);
			int n=pre.executeUpdate();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Profession> queryAll() {
		List<Profession> profession=new ArrayList<Profession>();
		String sql="SELECT `profession`.`profession_id`,\r\n" + 
				"    `profession`.`profession_name`,\r\n" + 
				"    `profession`.`profession_department_id`\r\n" + 
				"FROM `club`.`profession`;\r\n";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			ResultSet res=pre.executeQuery();
			while(res.next()) {
				String id=res.getString(1);
				String name=res.getString(2);
				String departmentId=res.getString(3);
				Profession temp=new Profession(id,name,departmentId);
				profession.add(temp);
			}
			res.close();
			pre.close();
			return profession;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Profession retrieve(String id) {
		String sql="SELECT `profession`.`profession_id`,\r\n" + 
				"    `profession`.`profession_name`,\r\n" + 
				"    `profession`.`profession_department_id`\r\n" + 
				"FROM `club`.`profession`;\r\n"
				+ "where `profession`.`profession_id`=?";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1,id);
			ResultSet res=pre.executeQuery();
			res.next();
			String name=res.getString(2);
			String departmentId=res.getString(3);
			Profession temp=new Profession(id,name,departmentId);
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
