package com.tpm.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tpm.dao.QnaireAndStuDao;
import com.tpm.dao.StudentDao;

/**
 * Servlet implementation class PublishQnaireServlet
 */
@WebServlet("/PublishQnaireServlet")
public class PublishQnaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String ID = request.getParameter("QnaireID");
		String []AllQnaireID=request.getParameterValues("checked");
		String xihao=request.getParameter("xihao");
		String gradehao = request.getParameter("gradehao");
		//int QnaireID = Integer.parseInt(ID);
		ArrayList<String>StuID=new ArrayList<String>();
		StudentDao studentDao=new StudentDao();
		StuID=studentDao.getAllStuID(xihao,gradehao);
		for (String allQnaireID : AllQnaireID) {		
			QnaireAndStuDao qnaireAndStuDao = new QnaireAndStuDao();
			for (String stuID : StuID) {
				qnaireAndStuDao.addQnaireAndStu(Integer.parseInt(allQnaireID), stuID, "200019/12/18", "200019/12/30");
			}
		}
		
		
	}

}
