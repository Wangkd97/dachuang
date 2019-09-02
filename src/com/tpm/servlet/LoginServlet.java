package com.tpm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.RequestFacade;

import com.sun.deploy.nativesandbox.comm.Request;
import com.tpm.dao.StudentDao;
import com.tpm.entity.Student;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setCharacterEncoding("utf-8");
		 
//		 String xihao=request.getParameter("xihao");//系号
//		 String ID=request.getParameter("ID");
//		 String pwd=request.getParameter("pwd");
		 //String xihao="2001";
		 String xihao="";
		 String ID="131123";
		 String pwd="131123";
		 StudentDao studentDao=new StudentDao();
		 if (xihao.equals("")) {	 //这是登陆	 
			 Student student=studentDao.getStuinfo(ID);
			 
				 if(student.getPwd().equals(pwd)) {
					 System.out.println("登陆成功");
					 request.setAttribute("ifsuccess", 1);
						request.getRequestDispatcher("/admin/questionNaire/student/myStudent.jsp").forward(request, response);
				 }else {			
						 //在这重定向
					 System.out.println("登录失败");
					request.setAttribute("ifsuccess", 0);
					request.getRequestDispatcher("/admin/questionNaire/questionManager/questionList.jsp").forward(request, response);
				 }
			 }
		 else {
			//String name =request.getParameter("name");
			//String sex = request.getParameter("sex");
			 String name="老王";
			 String sex = "M";
			 String nianji="2016级";
			Student student =new Student();
			student.setID(ID);
			student.setName(name);
			student.setPwd(pwd);
			student.setSex(sex);
			student.setXihao(xihao);
			student.setNianji(nianji);
			Student stu = studentDao.getStuinfo(ID);
			String panduan=stu.getXihao();
			System.out.println(stu.getPwd()+"asd");
			if(panduan.equals("cuowu")) {   //判断有没有重复
				studentDao.addStu(student);
				System.out.println("成功");
				request.setAttribute("ifsuccess", 1);
				request.getRequestDispatcher("/admin/questionNaire/student/myStudent.jsp").forward(request, response);
			}else 
			{
				System.out.println("失败");
				request.setAttribute("ifsuccess", 0);
				request.getRequestDispatcher("/admin/questionNaire/student/doneQuestionnairList.jsp").forward(request, response);
			}
			
		}
		 

	}
}
