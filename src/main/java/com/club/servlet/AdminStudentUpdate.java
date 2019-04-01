package com.club.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.club.db.dao.imp.StudentImp;
import com.club.item.Student;

/**
 * Servlet implementation class AdminStudentUpdate
 */

//管理员操作学生
public class AdminStudentUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log=Logger.getLogger(AdminStudentUpdate.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminStudentUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		response.setContentType("text/html; charset=UTF-8");
//		获取管理员操作的类型
		String type=request.getParameter("type");
		switch (type) {
		case "deleteStudent":{
//			删除学生
			String id=request.getParameter("studentId");
			StudentImp db=new StudentImp();
			db.delete(id);
			log.info("学生删除完成");
			break;
		}
		case "updateStudent":{
//			修改学生信息
			String id=request.getParameter("studentId");
			log.info(id);
			StudentImp db=new StudentImp();
			Student stu=db.retrieve(id);
			request.getSession().setAttribute("student","stu");
			log.info("获取学生信息完成，即将跳转到修改页面");
			response.sendRedirect("admin/updateStudent.jsp");
			break;
		}
		default:{
			log.error("学生信息修改请求参数错误");
			break;
		}
		}
	}

}
