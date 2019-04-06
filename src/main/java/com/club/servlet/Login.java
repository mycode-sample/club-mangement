package com.club.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.club.db.dao.imp.AdministratorImp;
import com.club.db.dao.imp.ClubImp;
import com.club.db.dao.imp.ClubTypeImp;
import com.club.db.dao.imp.StudentImp;
import com.club.item.Administrator;
import com.club.item.Club;
import com.club.item.Student;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log=Logger.getLogger(Login.class.getClass());
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	@Override
	public void init() throws ServletException {
		PropertyConfigurator.configure("D:/project/eclipse/club-mangement/conf.properties");
		super.init();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
//		获取登录用户名，密码，用户类型
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String type=request.getParameter("user");
//		根据用户类型跳转到对应页面
		switch(type) {
			case "club":{
				log.info("社团");
				response.getWriter().println("this is club");
				break;
			}
			case "admin":{
				log.info("管理员登录请求");
				AdministratorImp admin=new AdministratorImp();
				Administrator user=admin.retrieve(username);
				if(user==null) {
					log.info("管理员用户名错误");
					request.getRequestDispatcher("index.jsp").forward(request,response);
					break;
				}
				String psw=user.getAdministratorPassword();
				if(user!=null&&password.equals(psw.toString())) {
					log.info("管理员登录成功");
					request.getSession().setAttribute("user",user);
					response.sendRedirect("admin/admin.jsp");
					log.info("管理员登录成功，页面跳转完成");
				}
				else {
					request.getRequestDispatcher("index.jsp").forward(request,response);
					log.info("管理员登录失败，回到首页");
				}
				break;
			}
			case "teacher":{
				log.info("老师");
				response.getWriter().println("this is teacher");
				break;
			}
			case "student":{
				log.info("学生");
				StudentImp student=new StudentImp();
				Student stu=student.retrieve(username);
				if(stu==null) {
					request.getRequestDispatcher("index.jsp").forward(request,response);
					break;
				}
				String psw=stu.getStudentPassword();
				if(stu!=null&&password.equals(psw.toString())) {
					response.sendRedirect("student/student.jsp");
				}
				else {
					request.getRequestDispatcher("index.jsp").forward(request,response);
				}
				break;
			}
			default:break;
		}
	}


}
