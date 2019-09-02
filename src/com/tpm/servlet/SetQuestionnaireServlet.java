package com.tpm.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.tools.corba.se.idl.StringGen;
import com.tpm.dao.QnaireAndQuestionDao;
import com.tpm.dao.QuestionnaireDao;
import com.tpm.entity.Questionnaire;

/**
 * Servlet implementation class SetQuestionnaireServlet
 */
@WebServlet("/SetQuestionnaireServlet")
public class SetQuestionnaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//String Tihaochuan = request.getParameter("Tihaoquan");
		//String statuschuan = request.getParameter("statuschuan");
		
		String Tihaochuan="120,121,105,106,107";
		String statuschuan="1,0,1,0,1";
		String adminID="123123";
		Questionnaire questionnaire =new Questionnaire();
		questionnaire.setAdminID("admin123");		
		questionnaire.setName("�����������㿴�ü�");
//		questionnaire.setAdminID(adminID);
//		questionnaire.setEndtime(request.getParameter("endtime"));
//		questionnaire.setName(request.getParameter("nameOfqnaire"));
//		questionnaire.setStarttime(request.getParameter("starttime"));
//		questionnaire.setStatus(Integer.parseInt(request.getParameter("statusOfqnaire")));
		QuestionnaireDao questionnaireDao = new QuestionnaireDao();
		int QnaireID=questionnaireDao.addQuestionnaire(questionnaire); //���ʾ�������
		System.out.println(QnaireID);
		//�������ʾ���Ŀ��ϵ���в��룬
		String tihaozu[]=Tihaochuan.split(",");
		String statuszu[] = statuschuan.split(",");
		int lengthOfti=tihaozu.length;
		
		int tihao[]=new int[lengthOfti];
		int status[]=new int[statuszu.length]; 
		for(int i=0;i<lengthOfti;i++)
		{
			QnaireAndQuestionDao qnaireAndQ= new QnaireAndQuestionDao();
			tihao[i]=Integer.parseInt(tihaozu[i]);
			status[i]=Integer.parseInt(statuszu[i]);
			int aa=tihao[i];
			int bb=status[i];
			qnaireAndQ.addQuestion(QnaireID,aa,bb);
			System.out.println(tihao[i]+"    "+status[i]);
		}	
		
	}

}
