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
import com.tpm.entity.Choose_card;
import com.tpm.entity.File_question;
import com.tpm.entity.Fill_card;
import com.tpm.entity.Question;
import com.tpm.entity.Suoyin;





/**
 * Servlet implementation class SetTiServlet
 */
@WebServlet("/SetTiServlet")
public class SetTiServlet extends HttpServlet {
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
		//����������ͣ�1����������⣬2����������⣬3����ѡ�⣬4����ѡ�⣬5���ļ��ϴ���
		response.setCharacterEncoding("utf-8");
		//int num = Integer.parseInt(request.getParameter("num"));
		
	//	for(int count=0;count<num;count++) {
			//��Ӧ�øĳ������˰�
//			String leixing =request.getParameter("queType");
//			String biaoti = request.getParameter("caption");
//			String tishineirong = request.getParameter("tipText");
//			String shifoubida = request.getParameter("ansType"); //���������Ƿ�ش�
//			String zhibiaodian = request.getParameter("option_catchValue_indexPoint");
//			String nengli = request.getParameter("option_catchValue_ability");
//			String zhuanyedaima=request.getParameter("option_catchValue");
		String leixing="���������";
		String biaoti="sadasdas";
		String tishineirong="qwewqewq";
		String shifoubida="yes";
		String zhibiaodian="357";
		String nengli ="1";
		String zhuanyedaima="2001";
		
		int izhuanyedaima=Integer.parseInt(zhuanyedaima); //ת����int��רҵ����
			int izhibiaodian = Integer.parseInt(zhibiaodian);	//ת����int��ָ���
			int inengli = Integer.parseInt(nengli);  //ת����int������
			int ishifoubida;		//ת����int���Ƿ�ش�
				
				if (shifoubida.equals("yes")) {
					ishifoubida=1;
				}
				else {
					ishifoubida=0;
				}
				Question tilei=new Question();
				tilei.setBiaoti(biaoti);
				tilei.setLeixing(leixing);
				tilei.setTishineirong(tishineirong);
				tilei.setShifoubida(ishifoubida);
				QuestionDao tikubiao=new QuestionDao();
				int id =tikubiao.addTi(tilei);   //��������������
				System.out.println(id);
				SuoyinDao suoyinbiao = new SuoyinDao();
				Suoyin suoyin=new Suoyin();
				suoyin.setTihao(id);
				suoyin.setZhibiaodian(izhibiaodian);
				suoyinbiao.addSy(suoyin);  //�����������	
		if (leixing.equals("��ѡ��")||leixing.equals("��ѡ��")) {
	
			try {
				String []fenzhi= request.getParameterValues("chose_score_array");	
				String []xuanxiang_neirong= request.getParameterValues("chose_text_array");
				if (fenzhi!=null&&xuanxiang_neirong!=null) {
				float[] a=new float[fenzhi.length];	//a��ѡ��ķ�ֵ
				
				ChooseCardDao tableDuoxuanti=new ChooseCardDao();
				if (leixing.equals("��ѡ��")) {
					for(int i=0;i<fenzhi.length;i++){
						a[i]=Integer.parseInt(fenzhi[i]);      //a:[4,5,6] 
						tableDuoxuanti.addXzt(id,xuanxiang_neirong[i],a[i]);
						}
				}else {
					for(int i=1;i<fenzhi.length;i++){
						a[i]=Integer.parseInt(fenzhi[i]);      //a:[4,5,6] 
						tableDuoxuanti.addXzt(id,xuanxiang_neirong[i],a[i]);
						}
				}
				
				}else{  
	                System.out.println("��ȡ�������ʧ��!");  
	            }
					
			} catch (NumberFormatException e) {
				// TODO �Զ����ɵ� catch ��
				//e.printStackTrace();
			}
		}
		
		if (leixing.equals("���������")) {
			String neirong =biaoti;
			System.out.println(neirong);
			 
			//�����������տ���
			String []min= request.getParameterValues("minSize");
			String []max= request.getParameterValues("maxSize");
			FillCardDao tableTiankongka=new FillCardDao();
			if (min!=null&&max!=null) {
				for(int i=1;i<min.length;i++) {
					int iminlength=Integer.parseInt(min[i]);
					int imaxlength=Integer.parseInt(max[i]);
					Fill_card tkk = new Fill_card();
					tkk.setDxnum(id);//�����������
					tkk.setMaxlength(imaxlength);
					tkk.setMinlength(iminlength);
					tkk.setBitian(1);
					tkk.setXianding(1);
					tableTiankongka.addTiankongka(tkk);
				}
				
			}else {
				System.out.println("��ȡ�������ʧ��!");  
			}
		}
	
		if (leixing.equals("�ļ��ϴ���")) {
			//String maxspace=request.getParameter(""); //û������д���ǲ�����4M
			//int imaxspace= Integer.parseInt(maxspace);
			FileQuestionDao tableWenjianshangchuanti=new FileQuestionDao();
			File_question wj = new File_question();
			wj.setMaxspace(4);
			wj.setTihao(id);
			tableWenjianshangchuanti.addWenjianshangchuanti(wj);
		}	
		
		//}
		///�ļ�β
	}

}
