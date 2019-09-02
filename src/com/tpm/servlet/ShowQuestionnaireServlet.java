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
import com.tpm.dao.QuestionnaireDao;
import com.tpm.entity.Choose_card;
import com.tpm.entity.File_question;
import com.tpm.entity.Fill_card;
import com.tpm.entity.Question;

/**
 * Servlet implementation class ShowQuestionnaireServlet
 */
@WebServlet("/ShowQuestionnaireServlet")
public class ShowQuestionnaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String QnaireID=request.getParameter("QnaireID");
		//String QnaireID="11";
		QnaireAndQuestionDao qnaireAndQuestionDao=new QnaireAndQuestionDao();
		ArrayList<Question> questionsList = qnaireAndQuestionDao.getQuestion(Integer.parseInt(QnaireID));
		ArrayList<ArrayList<Choose_card>> choose_cards = new ArrayList<ArrayList<Choose_card>>();
		ArrayList<ArrayList<Fill_card>> fill_cards = new ArrayList<ArrayList<Fill_card>>();
		ArrayList<File_question> file_questions = new ArrayList<File_question>();
	    for (Question question : questionsList) {
			String leixing = question.getLeixing();
			System.out.println(leixing);
			if(leixing.equals("多选题")||leixing.equals("单选题"))
			{
				int tihao = question.getTihao();
				ChooseCardDao chooseCardDao = new ChooseCardDao();
				ArrayList<Choose_card> CurrentChoose_card = chooseCardDao.getXzt(tihao);
				choose_cards.add(CurrentChoose_card);
			}
			else if(leixing.equals("多项填空题")) {
				int tihao = question.getTihao();
				FillCardDao fillCardDao = new FillCardDao();
				ArrayList<Fill_card> CurrentFill_card =fillCardDao.getTiankongka(tihao);
				fill_cards.add(CurrentFill_card);
			}
			else if(leixing.equals("文件上传题"))
			{
				int tihao = question.getTihao();
			    FileQuestionDao fileQuestionDao = new FileQuestionDao();
			    File_question file_question = fileQuestionDao.getWenjianshangchuanti(tihao);
			    file_questions.add(file_question);
			}

	    }
	    for (ArrayList<Choose_card> current_card : choose_cards) {
			for (Choose_card choose_card : current_card) {
			    System.out.println(choose_card.getBianhao());
				System.out.println(choose_card.getNeirong());
				System.out.println(choose_card.getFenzhi());
			}
		}
	    for (ArrayList<Fill_card> current_fill : fill_cards) {
			for (Fill_card fill_card : current_fill) {
				System.out.println(fill_card.getDxnum());
				System.out.println(fill_card.getBitian());
				System.out.println(fill_card.getMaxlength());
				System.out.println(fill_card.getMinlength());
				System.out.println(fill_card.getXianding());
			}
		}
	    for (File_question file_question : file_questions) {
			System.out.println(file_question.getTihao());
			System.out.println(file_question.getMaxspace());
		}
	    for (Question question : questionsList) {
			System.out.println(question.getTihao());
			System.out.println(question.getBiaoti());
			System.out.println(question.getTishineirong());
			System.out.println(question.getLeixing());
			System.out.println(question.getShifoubida());
		}
	    request.setAttribute("quetionList", questionsList);
	    request.setAttribute("choose_cards", choose_cards);
		request.setAttribute("fill_cards",fill_cards);
		request.setAttribute("file_questions", file_questions);
	    request.getRequestDispatcher("/admin/questionNaire/showQuestionnair/showQuestionnair.jsp").forward(request, response);
	}

}
