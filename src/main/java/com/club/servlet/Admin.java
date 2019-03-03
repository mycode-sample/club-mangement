package com.club.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.club.db.dao.imp.StudentImp;
import com.club.item.Student;

/**
 * Servlet implementation class Admin
 */
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String type=request.getParameter("type");
		String id=request.getParameter("id");
		switch(type) {
		case "updatePassword":{
			response.sendRedirect("admin/updatePassword.jsp");
			break;
		}
		case "updateUsername":{
			response.sendRedirect("admin/updateUsername.jsp");
			break;
		}
		case "retrieveStudent":{
			StudentImp db=new StudentImp();
			List<Student> student=db.queryAll();
			request.getSession().setAttribute("student",student);
			response.sendRedirect("admin/retrieveStudent.jsp");
			break;
		}
		case "retrieveDepartment":{
			response.sendRedirect("admin/retrieveDepartment.jsp");
			break;
		}case "retrieveProfession":{
			response.sendRedirect("admin/retrieveProfession.jsp");
			break;
		}
		default:{
			System.out.println("参数错误");
			break;
		}
		}
	}

}
