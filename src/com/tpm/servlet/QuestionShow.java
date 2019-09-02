package com.tpm.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tpm.dao.ChooseCardDao;
import com.tpm.dao.FileQuestionDao;
import com.tpm.dao.FillCardDao;
import com.tpm.dao.QuestionDao;
import com.tpm.entity.*;

/**
 * Servlet implementation class QuestionPreview
 */
@WebServlet("/QuestionShow")
public class QuestionShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String questionId=request.getParameter("questionId");
		
		QuestionDao questionDao =new QuestionDao();
//		//����ʱʹ��
//		questionId="105";//��ѡ��
//		questionId="115";//��ѡ��
//		questionId="118";//��ѡ�����
//		questionId="119";//���������
//		questionId="120";//���������
		Question question=questionDao.getTi(Integer.parseInt(questionId));
		
		if(question!=null){
			if(question.getLeixing().equals("��ѡ��")){
				ChooseCardDao chooseCardDao=new ChooseCardDao();
				ArrayList<Choose_card> clist=chooseCardDao.getXzt(question.getTihao());
				request.setAttribute("clist", clist);
				request.setAttribute("question", question);
				request.getRequestDispatcher("/admin/questionNaire/questionManager/single_choose.jsp").forward(request, response);
			}else if(question.getLeixing().equals("��ѡ��")){
				ChooseCardDao chooseCardDao=new ChooseCardDao();
				ArrayList<Choose_card> clist=chooseCardDao.getXzt(question.getTihao());
				request.setAttribute("clist", clist);
				request.setAttribute("question", question);
				request.getRequestDispatcher("/admin/questionNaire/questionManager/mult_choose.jsp").forward(request, response);
			}else if(question.getLeixing().equals("���������")){
				request.setAttribute("question", question);
				request.getRequestDispatcher("/admin/questionNaire/questionManager/single_fill.jsp").forward(request, response);
	
			}else if(question.getLeixing().equals("���������")){						
				ArrayList<Fill_card>flist=new FillCardDao().getTiankongka(question.getTihao());
				request.setAttribute("question", question);		
				request.setAttribute("flist", flist);		
				request.getRequestDispatcher("/admin/questionNaire/questionManager/mult_fill.jsp").forward(request, response);
			}else if(question.getLeixing().equals("�ļ��ϴ���")){
					
				File_question file_question =new FileQuestionDao().getWenjianshangchuanti(question.getTihao());
				request.setAttribute("question", question);	
				request.setAttribute("file_question", file_question);	
				request.getRequestDispatcher("/admin/questionNaire/questionManager/file.jsp").forward(request, response);
			}
		}else{
			//����Ϊ��
			//��ʾ�������
		}
	}

}
