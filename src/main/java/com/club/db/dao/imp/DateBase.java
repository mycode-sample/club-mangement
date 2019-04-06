package com.club.db.dao.imp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.club.tools.Log;
/*
 *  连接数据库，返回数据库连接
 */
public class DateBase {
	Connection con;
	static Logger log=Logger.getLogger(DateBase.class.getName());
	public Connection getCon() {
		try {
			Class.forName("com.mysql.jdbc.Driver");//加载旧版驱动
			Class.forName("com.mysql.cj.jdbc.Driver");//加载新版驱动
			log.info("数据库驱动加载完成");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/club","root","123456");
			log.info("数据连接获取完成");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public void close(Connection con) {
		try {
			con.close();
			log.info("数据库连接关闭完成");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void close(Connection con,Statement sql) {
		try {
			sql.close();
			con.close();
			log.info("数据库连接关闭完成");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void close(Connection con,Statement sql,ResultSet res) {
		try {
			res.close();
			sql.close();
			con.close();
			log.info("数据库连接关闭完成");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void close(Connection con,PreparedStatement pre) {
		try {
			pre.close();
			con.close();
			log.info("数据库连接关闭完成");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void close(Connection con,PreparedStatement sql,ResultSet res) {
		try {
			res.close();
			sql.close();
			con.close();
			log.info("数据库连接关闭完成");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void close(Statement sql) {
		try {
			sql.close();
			log.info("数据库连接关闭完成");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void close(Statement sql,ResultSet res) {
		try {
			res.close();
			sql.close();
			log.info("数据库连接关闭完成");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void close(PreparedStatement pre) {
		try {
			pre.close();
			log.info("数据库连接关闭完成");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void close(PreparedStatement sql,ResultSet res) {
		try {
			res.close();
			sql.close();
			log.info("数据库连接关闭完成");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public DateBase() {
		super();
//		初始化log输出格式
		PropertyConfigurator.configure("D:/project/eclipse/club-mangement/conf.properties");
	}
	
}
