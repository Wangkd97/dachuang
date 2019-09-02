package com.tpm.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.tpm.entity.Answer;
import com.tpm.dao.StuAnsDao;

/**
 * Servlet implementation class SetStudentQnaireAnsSevlet
 */
@WebServlet("/SetStudentQnaireAnsSevlet")
public class SetStudentQnaireAnsSevlet extends HttpServlet {
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
		String questionaireid = request.getParameter("QnaireID");
		String StuId= "123";
		//String questionaireid = "17";
		int QuestionNaireId=Integer.parseInt(questionaireid);
		ArrayList<ArrayList<Answer>> AnswerList = new ArrayList<ArrayList<Answer>>();
		String jsonString = new String(request.getParameter("jsonstr").getBytes("ISO-8859-1"),"utf-8");
		System.out.println(jsonString);
	    JSONArray jsa = JSONArray.fromObject(jsonString);
	    for (Object object : jsa) {
			JSONObject jso = JSONObject.fromObject(object);
			System.out.println("���: "+jso.get("���").toString());
			System.out.println("����: "+jso.get("����").toString());
			Answer answer = new Answer();
			answer.setAnswer(jso.get("����").toString());
			answer.setTiID(Integer.parseInt(jso.get("���").toString()));
			ArrayList<Answer> answerlist = new ArrayList<Answer>();
			answerlist.add(answer);
			AnswerList.add(answerlist);		
		}
	    for (ArrayList<Answer> answerList : AnswerList) {
			for (Answer answer : answerList) {
				StuAnsDao stuQnaireAnsDao = new StuAnsDao();
				stuQnaireAnsDao.SetStuQnaireAns(StuId,QuestionNaireId, answer.getTiID(), answer.getAnswer());
			}
		}
	 //   response.sendRedirect("/TPM/GetQuestionnaireServlet?QuestionnaireStatus=3");
	}

}
