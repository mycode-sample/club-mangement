package com.club.db.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.club.db.dao.ClubTypeDao;
import com.club.item.ClubType;

public class ClubTypeImp implements ClubTypeDao{
	Connection con;
	/**
	 * 
	 */
	public ClubTypeImp() {
		super();
		con=new DateBase().getCon();
	}

	@Override
	public int add(ClubType admin) {
		String id=admin.getClubTypeId();
		String name=admin.getClubTypeName();
		String introduction=admin.getClubTypeIntroduction();
		String sql="INSERT INTO `club`.`club_type`\r\n" + 
				"(`club_type_id`,\r\n" + 
				"`club_type_name`,\r\n" + 
				"`club_type_introduction`)\r\n" + 
				"VALUES\r\n" + 
				"(?,\r\n" + 
				"?,\r\n" + 
				"?);\r\n";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1,id);
			pre.setString(2,name);
			pre.setString(3,introduction);
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
		String sql="DELETE FROM `club`.`club_type`\r\n" + 
				"WHERE `club_type`.`club_type_id`=?;\r\n";
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
	public int update(String id, ClubType admin) {
		String name=admin.getClubTypeName();
		String introduction=admin.getClubTypeIntroduction();
		String sql="UPDATE `club`.`club_type`\r\n" + 
				"SET\r\n" + 
				"`club_type_id` = ?,\r\n" + 
				"`club_type_name` = ?,\r\n" + 
				"`club_type_introduction` = ?\r\n" + 
				"WHERE `club_type_id` = ?;\r\n";
		try {
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1,id);
			pre.setString(2,name);
			pre.setString(3,introduction);
			int n=pre.executeUpdate();
			pre.close();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}		
	}

	@Override
	public List<ClubType> queryAll() {
		List<ClubType> club=new ArrayList<ClubType>();
		String sql="SELECT `club_type`.`club_type_id`,\r\n" + 
				"    `club_type`.`club_type_name`,\r\n" + 
				"    `club_type`.`club_type_introduction`\r\n" + 
				"FROM `club`.`club_type`;\r\n";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			ResultSet res=pre.executeQuery();
			while(res.next()) {
				String id=res.getString(1);
				String name=res.getString(2);
				String introduction=res.getString(3);
				ClubType temp=new ClubType(id,name,introduction);
				club.add(temp);
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
	public ClubType retrieve(String id) {
		String sql="SELECT `club_type`.`club_type_id`,\r\n" + 
				"    `club_type`.`club_type_name`,\r\n" + 
				"    `club_type`.`club_type_introduction`\r\n" + 
				"FROM `club`.`club_type`"
				+ "where `club_type`.`club_type_id`=?;\r\n";
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1,id);
			ResultSet res=pre.executeQuery();
			res.next();
			String name=res.getString(2);
			String introduction=res.getString(3);
			ClubType temp=new ClubType(id,name,introduction);
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
