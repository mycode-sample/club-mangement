package com.club.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.club.db.dao.imp.AdministratorImp;
import com.club.db.dao.imp.StudentImp;
import com.club.item.Administrator;
import com.club.item.Student;

/**
 * Servlet implementation class AdminImp
 */
public class AdminImp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminImp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String type=request.getParameter("adminType");
		String id=request.getParameter("id");
		switch(type) {
		case "updatePassword":{
			String password=request.getParameter("password");
			AdministratorImp db=new AdministratorImp();
			Administrator admin=db.retrieve(id);
			admin.setAdministratorPassword(password);
			db.update(admin.getAdministratorId(),admin);
		}
		case "updateUsername":{
			String username=request.getParameter("username");
			AdministratorImp db=new AdministratorImp();
			Administrator admin=db.retrieve(id);
			admin.setAdministratorName(username);
			db.update(admin.getAdministratorId(),admin);
			break;
		}
		case "deleteStudent":{
			break;
		}
		case "retrieveDepartment":{
			break;
		}
		case "retrieveProfession":{
			break;
		}
		default:{
			System.out.println("参数错误");
			break;
		}
		}
	}

}
