package com.tpm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tpm.dao.ChooseCardDao;


/**
 * Servlet implementation class DelectXuanXiangServlet
 */
@WebServlet("/DelectXuanXiangServlet")
public class DelectXuanXiangServlet extends HttpServlet {
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
		//ɾ���⣬1��ɾ����������⣬2��ɾ����������ģ�3��ɾ����Ӧ�������⡣
		//ɾ��ѡ�1��ɾ��ѡ���
		String leixing = request.getParameter("");
		String tihao = request.getParameter("");
		String dijige = request.getParameter("");
		int itihao=Integer.parseInt(tihao);
		int idijige = Integer.parseInt(dijige);		 
		ChooseCardDao xuanzetibiao=new ChooseCardDao();
		xuanzetibiao.deleXzt(itihao, idijige);		
	}

}
