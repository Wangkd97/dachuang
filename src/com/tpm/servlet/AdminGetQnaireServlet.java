package com.tpm.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tpm.dao.QnaireAndStuDao;
import com.tpm.dao.QuestionnaireDao;
import com.tpm.entity.Questionnaire;

/**
 * Servlet implementation class AdminGetQnaireServlet
 */
@WebServlet("/AdminGetQnaireServlet")
public class AdminGetQnaireServlet extends HttpServlet {
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
		String QuestionnaireStatus = request.getParameter("QuestionnaireStatus");
		
		String AdminID="123456";
		
		int page=1;
		int num=0;
		QnaireAndStuDao qnaireAndStuDao= new QnaireAndStuDao();
		ArrayList<String >allGrade=qnaireAndStuDao.getAllGrade();
		QuestionnaireDao questionnaireDao=new QuestionnaireDao();
		ArrayList<Questionnaire>questionnairesList= new ArrayList<Questionnaire>();
		if(!AdminID.equals("")) {
			if (QuestionnaireStatus.equals("3")) {
				 num=questionnaireDao.getnumofQnaire(AdminID);
				questionnairesList = questionnaireDao.getAdminAllQnaireInfo(AdminID,page);
			}
			request.setAttribute("questionnaireList", questionnairesList);
			request.setAttribute("current_page", page);
			request.setAttribute("tail_page",num );
			request.setAttribute("allGrade", allGrade);
			//	request.setAttribute("questionnaireList", questionnairesList);
			request.getRequestDispatcher("/admin/questionNaire/Adminstrator/PublishQnaire.jsp").forward(request, response);
		}
		
	}
}


