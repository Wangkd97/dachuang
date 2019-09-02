package com.tpm.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sun.org.apache.bcel.internal.util.SecuritySupport;
import com.tpm.dao.ChooseCardDao;
import com.tpm.dao.FileQuestionDao;
import com.tpm.dao.FillCardDao;
import com.tpm.dao.QuestionDao;
import com.tpm.dao.SuoyinDao;
import com.tpm.entity.Choose_card;
import com.tpm.entity.File_question;
import com.tpm.entity.Fill_card;
import com.tpm.entity.Question;



/**
 * Servlet implementation class GetSuoyinServlet
 */
@WebServlet("/GetSuoyinServlet")
public class GetSuoyinServlet extends HttpServlet {
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
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "*");
		//����������ͣ�1����������⣬2����������⣬3����ѡ�⣬4����ѡ�⣬5���ļ��ϴ���
		 
		response.setContentType("text/json; charset=utf-8");
		//int tihao=Integer.parseInt(request.getParameter("")); //��ȡ�����������		
		int tihao=114;
		QuestionDao questionDao=new QuestionDao();	//
		Question question=new Question();		//����һ������
		question=questionDao.getTi(tihao);		//�����ݿ��л�ȡ�����Ϣ
		String leixing=question.getLeixing();		//�õ�����������
			if (leixing.equals("���������")||leixing.equals("���������")) {
				FillCardDao fillCardDao = new FillCardDao();
				ArrayList<Fill_card> fill_cardsList=new ArrayList<Fill_card>();
				fill_cardsList=fillCardDao.getTiankongka(tihao);
				request.setAttribute("Question", question);
				request.setAttribute("fill_cardsList", fill_cardsList);
				request.getRequestDispatcher("/admin/questionNaire/questionManager/questionList.jsp").forward(request, response);
			}
			
			else if (leixing.equals("��ѡ��")||leixing.equals("��ѡ��")) {
				 ChooseCardDao chooseCardDao=new ChooseCardDao();
				 ArrayList<Choose_card> choose_cardList=new ArrayList<Choose_card>();
				 choose_cardList=chooseCardDao.getXzt(tihao);
				 request.setAttribute("Question", question);
				 request.setAttribute("choose_cardList", choose_cardList);
				 
				JSONArray jsonArray=new JSONArray();
				JSONObject jsonObject=new JSONObject();
				try {
					jsonObject.put("��ʾ����", question.getTishineirong());
					jsonObject.put("���", question.getTihao());
					jsonObject.put("����", question.getBiaoti());
					jsonArray.put(jsonObject);
				
				} catch (JSONException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				for (Choose_card choose_card : choose_cardList) {
					JSONObject jsonObject2 =new JSONObject();
					
					try {
						jsonObject2.put("���", choose_card.getBianhao());
						jsonObject2.put("ѡ������", choose_card.getNeirong());
						jsonObject2.put("��ֵ", choose_card.getFenzhi());
						jsonArray.put(jsonObject2);
					} catch (JSONException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
					
				}
					
				
				 System.out.println(question.getBiaoti());
				 for (Choose_card choose_card : choose_cardList) {
					System.out.println("neirong"+choose_card.getNeirong());
				}
				 
				 response.getWriter().print(jsonArray.toString());
				 //request.getRequestDispatcher("/admin/questionNaire/questionManager/questionList.jsp").forward(request, response);
			}
			
			else if(leixing.equals("�ļ��ϴ���")){
				 File_question file_question=new File_question();
				 FileQuestionDao fileQuestionDao=new FileQuestionDao();
				 file_question=fileQuestionDao.getWenjianshangchuanti(tihao);	
				 request.setAttribute("Question", question);
				 request.setAttribute("file_question", file_question);
				 request.getRequestDispatcher("/admin/questionNaire/questionManager/questionList.jsp").forward(request, response);
			}			
		}		
	}
	