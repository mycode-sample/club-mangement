package com.club.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.club.db.dao.imp.AdministratorImp;
import com.club.db.dao.imp.StudentImp;
import com.club.item.Administrator;
import com.club.item.Student;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String type=request.getParameter("user");
		switch(type) {
			case "club":{
				response.getWriter().println("this is club");
				break;
			}
			case "admin":{
				AdministratorImp admin=new AdministratorImp();
				Administrator user=admin.retrieve(username);
				String psw=user.getAdministratorPassword();
				if(user!=null&&password.equals(psw.toString())) {
					response.sendRedirect("admin/admin.jsp");
				}
				else {
					request.getRequestDispatcher("index.jsp").forward(request,response);
//					response.sendRedirect("index.jsp");
				}
				break;
			}
			case "teacher":{
				//todo
				break;
			}
			case "student":{
				StudentImp student=new StudentImp();
				Student stu=student.retrieve(username);
				String psw=stu.getStudentPassword();
				System.out.println(stu.getStudentName());
				System.out.println(stu.getStudentPassword());
				if(stu!=null&&password.equals(psw.toString())) {
					response.sendRedirect("student/student.jsp");
				}
				else {
					request.getRequestDispatcher("index.jsp").forward(request,response);
//					response.sendRedirect("index.jsp");
				}
				break;
			}
			default:break;
		}
	}


}
