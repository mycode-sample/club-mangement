package com.club.db;
import java.sql.*;
/*
 *  连接数据库，返回数据库连接
 */
public class DateBase {
	Connection con;
	public Connection getCon() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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
			con.close();
			sql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void close(Connection con,Statement sql,ResultSet res) {
		try {
			con.close();
			sql.close();
			res.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void close(Connection con,PreparedStatement pre) {
		try {
			con.close();
			pre.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
