package com.club.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.club.db.dao.imp.StudentImp;

/**
 * Servlet implementation class AdminStudentUpdate
 */
public class AdminStudentUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminStudentUpdate() {
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
		switch (type) {
		case "deleteStudent":{
			String id=request.getParameter("studentId");
			StudentImp db=new StudentImp();
			if(db.delete(id)==0) {
				System.out.println("ok");
			}
			break;
		}
		default:{
			System.out.println("参数错误");
			break;
		}
		}
	}

}
