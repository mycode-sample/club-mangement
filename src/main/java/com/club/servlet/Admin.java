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

/**
 * Servlet implementation class Admin
 */
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log=Logger.getLogger(Admin.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        PropertyConfigurator.configure("D:/project/eclipse/club-mangement/conf.properties");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */

    //管理员导航栏菜单
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
//		前台点击链接或者按钮，通过type属性确定请求类型，通过id属性确定要处理的对象id
		String type=request.getParameter("type");
		String id=request.getParameter("id");
		switch(type) {	
		
//		查询所有成员
		case "retrieveStudent":{
			//管理员/学生管理/学生列表
			StudentImp db=new StudentImp();
			List<Student> student=db.queryAll();
			request.getSession().setAttribute("student",student);
			log.info("学生列表返回前端完成，即将跳转页面");
			response.sendRedirect("admin/retrieveStudent.jsp");
			break;
		}
		case "retrieveDepartment":{
			//管理员/学生管理/学院列表
			log.info("学院列表返回前端完成，即将跳转页面");
			response.sendRedirect("admin/retrieveDepartment.jsp");
			break;
		}case "retrieveProfession":{
			//管理员/学生管理/专业列表
			log.info("专业返回前端完成，即将跳转页面");
			response.sendRedirect("admin/retrieveProfession.jsp");
			break;
		}
		
//		修改信息
//		修改管理员密码
		case "updatePassword":{
			String password=request.getParameter("password");
			AdministratorImp db=new AdministratorImp();
			Administrator admin=db.retrieve(id);
			admin.setAdministratorPassword(password);
			db.update(admin.getAdministratorId(),admin);
			log.info("管理员密码修改成功,跳转到管理员首页");
			response.sendRedirect("admin/admin.jsp");
			
		}
//		修改管理员用户名
		case "updateUsername":{
			String username=request.getParameter("username");
			AdministratorImp db=new AdministratorImp();
			Administrator admin=db.retrieve(id);
			admin.setAdministratorName(username);
			db.update(admin.getAdministratorId(),admin);
			log.info("管理员用户名修改成功,跳转到管理员首页");
			response.sendRedirect("admin/admin.jsp");
			break;
		}
		
		default:{
			log.error("页面请求类型输入错误");
			break;
		}
		}
	}

}
