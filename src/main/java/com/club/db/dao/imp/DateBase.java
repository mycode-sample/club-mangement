package com.club.db.dao.imp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.PropertyConfigurator;
/*
 *  连接数据库，返回数据库连接
 */
public class DateBase {
	Connection con;
	public Connection getCon() {
		PropertyConfigurator.configure("D:\\project\\eclipse\\club-mangement\\src\\main\\java\\com\\club\\conf\\log4j.xml");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/club","root","123456");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public void close(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void close(Connection con,Statement sql) {
		try {
			sql.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void close(Connection con,Statement sql,ResultSet res) {
		try {
			res.close();
			sql.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void close(Connection con,PreparedStatement pre) {
		try {
			pre.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void close(Connection con,PreparedStatement sql,ResultSet res) {
		try {
			res.close();
			sql.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void close(Statement sql) {
		try {
			sql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void close(Statement sql,ResultSet res) {
		try {
			res.close();
			sql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void close(PreparedStatement pre) {
		try {
			pre.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void close(PreparedStatement sql,ResultSet res) {
		try {
			res.close();
			sql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
