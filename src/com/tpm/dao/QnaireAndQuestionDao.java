package com.tpm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;
import com.tpm.entity.Question;
import com.tpm.entity.Questionnaire;

public class QnaireAndQuestionDao {

	public void addQuestion(int QnaireID, int TiID, int shifoubida) { //�������������Ƿ�ش�
		PreparedStatement preparedStatement=null;
		Connection conn = DatabaseManger.getconnect();
		String str_sql="insert into �ʾ���Ŀ��ϵ�� (���,�ʾ�ID,�Ƿ�ش�)";
		str_sql+="values(?,?,?)";
		try {
			preparedStatement=conn.prepareStatement(str_sql);
			preparedStatement.setInt(1, TiID);
			preparedStatement.setInt(2,QnaireID );
			preparedStatement.setInt(3, shifoubida);
			preparedStatement.execute();
			 
		}
		 catch (SQLException e) {
			// TODO �Զ����ɵ� catch �� 
			 e.printStackTrace();
		}finally {
			try{
				if(preparedStatement!=null)
					preparedStatement.close();
				DatabaseManger.doclose();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	public ArrayList<Question> getQuestion(int QnaireID) {
		ArrayList<Question>questionsList=new ArrayList<Question>();
		
		Statement ps=null;
		ResultSet rs=null;
		Connection conn = DatabaseManger.getconnect();
		
		try {
			ps=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//���ý�������Թ���
			String str_sql="select * from �ʾ���Ŀ��ϵ�� inner join ����  on �ʾ���Ŀ��ϵ��.��� = ����.��� where �ʾ�ID = "+QnaireID;
			rs=ps.executeQuery(str_sql);
			
			while(rs.next()) {
				Question question=new Question();
				question.setTihao(rs.getInt("���"));
				question.setBiaoti(rs.getString("����"));
				question.setTishineirong(rs.getString("��ʾ����"));
				question.setLeixing(rs.getString("����"));
				question.setShifoubida(rs.getInt("�Ƿ�ش�"));
				questionsList.add(question);
			}
			
		} catch (SQLException e) {
			
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			try{
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				DatabaseManger.doclose();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		 return questionsList;
	}
	
	
	
	
}
