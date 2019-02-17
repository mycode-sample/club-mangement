package com.club.db.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.club.db.dao.AdministratorDao;
import com.club.item.Administrator;

public class AdministratorImp implements AdministratorDao{
	static Logger logger=Logger.getLogger(AdministratorImp.class);
	Connection con;
	/**
	 * 
	 */
	public AdministratorImp() {
		super();
		con=new DateBase().getCon();
	}

	@Override
	public int add(Administrator admin) {
		String sql="INSERT INTO `club`.`administrator`\r\n" + 
				"(`administrator_id`,\r\n" + 
				"`administrator_name`,\r\n" + 
				"`administrator_password`)\r\n" + 
				"VALUES\r\n" + 
				"(?,\r\n" + 
				"?,\r\n" + 
				"?);\r\n";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			String id=admin.getAdministratorId();
			String name=admin.getAdministratorName();
			String password=admin.getAdministratorPassword();
			pre.setString(1,id);
			pre.setString(2,name);
			pre.setString(3,password);
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
		String sql="DELETE FROM `club`.`administrator`\r\n" + 
				"WHERE `administrator`.`administrator_id`=?";
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
	public int update(String user, Administrator admin) {
		String sql="UPDATE `club`.`administrator`\r\n" + 
				"SET\r\n" + 
				"`administrator_id` = ?,\r\n" + 
				"`administrator_name` = ?,\r\n" + 
				"`administrator_password` = ?\r\n" + 
				"WHERE `administrator_id` = ?;\r\n";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			String id=admin.getAdministratorId();
			String name=admin.getAdministratorName();
			String password=admin.getAdministratorPassword();
			pre.setString(1,id);
			pre.setString(2,name);
			pre.setString(3,password);
			pre.setString(4,user);
			int n=pre.executeUpdate();
			pre.close();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Administrator> queryAll() {
		List<Administrator> admin=new ArrayList<Administrator>();
		try {
			Statement sql=con.createStatement();
			ResultSet res=sql.executeQuery("SELECT `administrator`.`administrator_id`,\r\n" + 
					"    `administrator`.`administrator_name`,\r\n" + 
					"    `administrator`.`administrator_password`\r\n" + 
					"FROM `club`.`administrator`;\r\n");
			while(res.next()) {
				String id=res.getString(1);
				String name=res.getString(2);
				String password=res.getString(3);
				Administrator user=new Administrator(id,name,password);
				admin.add(user);
			}
			res.close();
			sql.close();
			return admin;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Administrator retrieve(String id) {
		Administrator admin;
		ResultSet res;
		String sql="SELECT `administrator`.`administrator_id`,\r\n" + 
				"    `administrator`.`administrator_name`,\r\n" + 
				"    `administrator`.`administrator_password`\r\n" + 
				"FROM `club`.`administrator`"
				+ "where `administrator`.`administrator_id`=?;\r\n";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1,id);
			res=pre.executeQuery();
			res.next();
			String name=res.getString(2);
			String password=res.getString(3);
			admin=new Administrator(id,name,password);
			res.close();
			pre.close();
			return admin;
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
