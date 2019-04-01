package com.club.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.club.db.dao.imp.AdministratorImp;
import com.club.db.dao.imp.StudentImp;
import com.club.item.Administrator;
import com.club.item.Student;
import com.club.tools.Log;

/**
 * Servlet implementation class AdminJump
 */
public class AdminJump extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static Logger log=Logger.getLogger(AdminJump.class.getName());
    @Override
	public void init() throws ServletException {
    	PropertyConfigurator.configure("D:/project/eclipse/club-mangement/conf.properties");
		super.init();
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public AdminJump() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
//		获取管理员页面的跳转请求
		log.info("获取管理员页面跳转请求");
		String adminType=request.getParameter("type");
		String id=request.getParameter("id");
		
//		根据跳转请求跳转到相应的页面
		switch(adminType) {
		case "updatePasswordPage":{
			//管理员/个人中心/修改密码->修改密码
			response.sendRedirect("admin/updatePassword.jsp");
			log.info("管理员/个人中心/修改密码:修改密码跳转完成");
			break;
		}
		case "updateUsernamePage":{
			//管理员/个人中心/修改用户名->修改用户名
			response.sendRedirect("admin/updateUsername.jsp");
			log.info("管理员/个人中心/修改用户名:修改用户名 跳转完成");
			break;
		}
		case "retrieveDepartmentPage":{
			//管理员/学生管理/学院列表
			response.sendRedirect("admin/retrieveDepartment.jsp");
			log.info("管理员/学生管理/学院列表 跳转完成");
			break;
		}
		case "updateStudentPage":{
//			修改学生信息
			String studentId=request.getParameter("studentId");
			log.info("学生id:"+studentId);
			StudentImp db=new StudentImp();
			Student stu=db.retrieve(studentId);
			request.getSession().setAttribute("student","stu");
			log.info("获取学生信息完成，即将跳转到修改页面");
			response.sendRedirect("admin/updateStudent.jsp");
			break;
		}
		default:{
			log.error("页面跳转请求参数错误");
			break;
		}
		}
	}

}
