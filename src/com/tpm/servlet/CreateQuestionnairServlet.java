package com.tpm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tpm.dao.QnaireAndQuestionDao;
import com.tpm.dao.QuestionnaireDao;
import com.tpm.entity.Questionnaire;

/**
 * Servlet implementation class CreateQuestionnairServlet
 */
@WebServlet("/CreateQuestionnairServlet")
public class CreateQuestionnairServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String qlist=request.getParameter("qlist");
		String title=request.getParameter("title");//�ʾ����
		String tlist=request.getParameter("tlist");
		String []questionArr=qlist.split(",");		//����б�
		String []typeArr=tlist.split(",");			//��Ŀ�Ƿ�ش�			
		Questionnaire questionnaire =new Questionnaire();
		questionnaire.setAdminID("123456");		
		questionnaire.setName(title);
		QuestionnaireDao questionnaireDao = new QuestionnaireDao();
		int QnaireID=questionnaireDao.addQuestionnaire(questionnaire); //���ʾ�������
		System.out.println(QnaireID);
		//�������ʾ���Ŀ��ϵ���в��룬
		
		int lengthOfti=typeArr.length;		
		int tihao[]=new int[lengthOfti];	//����Ҫת����int
		for(int i=0;i<lengthOfti;i++)
		{
			int status=1;
			QnaireAndQuestionDao qnaireAndQ= new QnaireAndQuestionDao();
			tihao[i]=Integer.parseInt(questionArr[i]);
			if(typeArr[i].equals("yes")){
				status=1;
			}else{
				status=0;
			}			
			qnaireAndQ.addQuestion(QnaireID,tihao[i],status);
			
		}	
		response.getWriter().print("success");
	}

}
