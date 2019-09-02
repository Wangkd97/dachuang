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
import com.tpm.dao.QnaireAndQuestionDao;
import com.tpm.dao.StuAnsDao;
import com.tpm.entity.Answer;
import com.tpm.entity.Choose_card;
import com.tpm.entity.File_question;
import com.tpm.entity.Fill_card;
import com.tpm.entity.Question;

@WebServlet("/ShowQnaireAnsServlet")
public class ShowQnaireAnsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//�����URLӦ��ת��ͬһ���ط�
		//int QnaireID= Integer.parseInt(request.getParameter("QnaireID"));
		int QnaireID=11;
		QnaireAndQuestionDao qnaireAndQuestionDao=new QnaireAndQuestionDao();
		ArrayList<Question> questionsList=qnaireAndQuestionDao.getQuestion(QnaireID);
		ArrayList<ArrayList<Choose_card>> choose_cardArrayList = new ArrayList<ArrayList<Choose_card>>();
		ArrayList<ArrayList<Fill_card>> fill_cardArrayList = new ArrayList<ArrayList<Fill_card>>();
		ArrayList<File_question> file_questionArrayList = new ArrayList<File_question>();
		ArrayList<ArrayList<Answer>> answerList=new ArrayList<ArrayList<Answer>>();
		for (Question question : questionsList) {
			if(question!=null){
				if(question.getLeixing().equals("��ѡ��")){
					ChooseCardDao chooseCardDao=new ChooseCardDao();
					ArrayList<Choose_card> clist=chooseCardDao.getXzt(question.getTihao());
					choose_cardArrayList.add(clist);
					StuAnsDao stuAnsDao=new StuAnsDao();
					ArrayList<Answer> ansList= stuAnsDao.getAns("123", QnaireID, question.getTihao());
					answerList.add(ansList);
					
				}else if(question.getLeixing().equals("��ѡ��")){
					ChooseCardDao chooseCardDao=new ChooseCardDao();
					ArrayList<Choose_card> clist=chooseCardDao.getXzt(question.getTihao());
					choose_cardArrayList.add(clist);
					StuAnsDao stuAnsDao=new StuAnsDao();
					ArrayList<Answer> ansList= stuAnsDao.getAns("123", QnaireID, question.getTihao());
					answerList.add(ansList);
				}else if(question.getLeixing().equals("���������")){	
					ArrayList<Fill_card>flist=new FillCardDao().getTiankongka(question.getTihao());
					fill_cardArrayList.add(flist);
					StuAnsDao stuAnsDao=new StuAnsDao();
					ArrayList<Answer> ansList= stuAnsDao.getAns("123", QnaireID, question.getTihao());
					answerList.add(ansList);
				}else if(question.getLeixing().equals("�ļ��ϴ���")){
						
					File_question file_question =new FileQuestionDao().getWenjianshangchuanti(question.getTihao());
					file_questionArrayList.add(file_question);
					StuAnsDao stuAnsDao=new StuAnsDao();
					ArrayList<Answer> ansList= stuAnsDao.getAns("123", QnaireID, question.getTihao());
					answerList.add(ansList);
				}
			}
		}
		request.setAttribute("questionsList", questionsList);	
		request.setAttribute("answerList", answerList);
		request.setAttribute("choose_cardArrayList", choose_cardArrayList);
		request.setAttribute("fill_cardArrayList", fill_cardArrayList);
		request.setAttribute("file_questionArrayList", file_questionArrayList);	
		for (ArrayList<Answer> arrayList : answerList) {
			for (Answer answer : arrayList) {
				System.out.println("��ţ� "+answer.getTiID());
				System.out.println("�𰸣� "+answer.getAnswer());
			}
		}
		for (Question question : questionsList) {
			System.out.println("���⣺ "+question.getTihao());		
		}
		for (ArrayList<Choose_card> arrayList : choose_cardArrayList) {
			for (Choose_card choose_card : arrayList) {
				System.out.println("��ֵ ��"+choose_card.getFenzhi());
				System.out.println("��ţ�"+choose_card.getBianhao());
				System.out.println("���ݣ� "+choose_card.getNeirong());
				System.err.println();
			}
		}		
		for (ArrayList<Fill_card> arrayList : fill_cardArrayList) {
			for (Fill_card fill_card : arrayList) {
				System.out.println("�Ƿ���"+fill_card.getBitian());
				System.out.println("���"+fill_card.getDxnum());
				System.out.println("max���ȣ�"+fill_card.getMaxlength());
				System.out.println("min���ȣ�"+fill_card.getMinlength());
			}
		}
		request.getRequestDispatcher("/admin/questionNaire/createQuestionnair/file_question_preview.jsp").forward(request, response);
	}
}
