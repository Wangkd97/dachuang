package com.tpm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tpm.dao.ChooseCardDao;
import com.tpm.dao.FileQuestionDao;
import com.tpm.dao.FillCardDao;
import com.tpm.dao.QuestionDao;
import com.tpm.dao.SuoyinDao;
import com.tpm.entity.Question;



/**
 * Servlet implementation class DelectTiServlet
 */
@WebServlet("/DelectTiServlet")
public class DelectTiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//����������ͣ�1����������⣬2����������⣬3����ѡ�⣬4����ѡ�⣬5���ļ��ϴ���
		String tihao=request.getParameter("queNum");
		String leixing = null;
		int itihao= Integer.parseInt(tihao);
		QuestionDao tikubiao=new QuestionDao();
		Question question= tikubiao.getTi(itihao);
		leixing=question.getLeixing();

		tikubiao.deleTi(itihao);  //ɾ�������е���
		SuoyinDao suoyinbiao=new SuoyinDao();
		suoyinbiao.deleSy(itihao);	//ɾ���������������
		
		// ɾ����Ӧ������
		if (leixing.equals("���������")) {
			FillCardDao duoxinagtiankongti=new FillCardDao();
			duoxinagtiankongti.deleteTiankongka(itihao);
		}
		
		if (leixing.equals("��ѡ��")||leixing.equals("��ѡ��")) {
			ChooseCardDao xuanzetibiao=new ChooseCardDao();
			xuanzetibiao.deleteDanxuanxiang(itihao);
			
		}
		if (leixing.equals("�ļ���")) {
			FileQuestionDao tableWenjianshangchuanti=new FileQuestionDao();
			tableWenjianshangchuanti.deleteWenjianshangchuanti(itihao);
		}
	}

}
