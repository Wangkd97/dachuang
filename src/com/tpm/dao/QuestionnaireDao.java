package com.tpm.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tpm.entity.Questionnaire;

public class QuestionnaireDao {
	
	public int  addQuestionnaire(Questionnaire Qnaire) {	
		int id;
		PreparedStatement preparedStatement=null;
		PreparedStatement ps=null;
		Connection conn = DatabaseManger.getconnect();
		String str_sql="insert into �ʾ�� (�ʾ�����,����ԱID)";
		str_sql+="values(?,?)";
		String str="select  LAST_INSERT_ID()";
		try {
			preparedStatement=conn.prepareStatement(str_sql);
			 
			//preparedStatement.setInt(1, Qnaire.getID());
			preparedStatement.setString(1, Qnaire.getName());
			preparedStatement.setString(2, Qnaire.getAdminID());		 
			preparedStatement.execute();
			ps=conn.prepareStatement(str);
			ResultSet rs=null;
			rs=ps.executeQuery(str);
			if(rs.next()){
					id=rs.getInt(1);
					return id;
					}
		}
		 catch (SQLException e) {
			// TODO �Զ����ɵ� catch �� 
		}finally {
			try{
				if(preparedStatement!=null)
					preparedStatement.close();
				DatabaseManger.doclose();
			}catch(Exception e){
				
			}
		}
		return 0; 
	}
	
	public ArrayList<Questionnaire> getQnaireInfo(int status,String stuID) {
		
		ArrayList<Questionnaire> questionnairesList=new ArrayList<Questionnaire>();
		Statement ps=null;
		ResultSet rs=null;
		Connection conn = DatabaseManger.getconnect();
		
		try {
			ps=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//���ý�������Թ���
			String str_sql="select * from �ʾ�ѧ����ϵ��  natural join �ʾ�� where �ʾ�״̬ = "+status+" and ѧ��ID='"+stuID+"'";
			rs=ps.executeQuery(str_sql);
			
			while(rs.next()) {
				Questionnaire questionnaire=new Questionnaire();
				questionnaire.setID(rs.getInt("�ʾ�ID"));
				questionnaire.setName(rs.getString("�ʾ�����"));
				questionnaire.setStatus(rs.getInt("�ʾ�״̬"));
				questionnaire.setStarttime(rs.getString("��ʼʱ��"));
				questionnaire.setEndtime(rs.getString("��ֹʱ��"));
				questionnaire.setAdminID(rs.getString("����ԱID"));
				questionnairesList.add(questionnaire);
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
		return questionnairesList;	
	}
	public ArrayList<Questionnaire> getAllQnaireInfo(String stuID,int page) {
		
		ArrayList<Questionnaire> questionnairesList=new ArrayList<Questionnaire>();
		Statement ps=null;
		ResultSet rs=null;
		Connection conn = DatabaseManger.getconnect();
		
		try {
			ps=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//���ý�������Թ���
			String str_sql="select * from �ʾ�ѧ����ϵ��  natural join �ʾ�� where  ѧ��ID='"+stuID+"'limit "+page+" ,10";
			rs=ps.executeQuery(str_sql);
			
			while(rs.next()) {
				Questionnaire questionnaire=new Questionnaire();
				questionnaire.setID(rs.getInt("�ʾ�ID"));
				questionnaire.setName(rs.getString("�ʾ�����"));
				questionnaire.setStatus(rs.getInt("�ʾ�״̬"));
				questionnaire.setStarttime(rs.getString("��ʼʱ��"));
				questionnaire.setEndtime(rs.getString("��ֹʱ��"));
				questionnaire.setAdminID(rs.getString("����ԱID"));
				questionnairesList.add(questionnaire);
				
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
		return questionnairesList;		
	}
public ArrayList<Questionnaire> getAdminAllQnaireInfo(String AdminID,int page) {
		
		ArrayList<Questionnaire> questionnairesList=new ArrayList<Questionnaire>();
		Statement ps=null;
		ResultSet rs=null;
		Connection conn = DatabaseManger.getconnect();
		
		try {
			ps=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//���ý�������Թ���
			String str_sql="select * from �ʾ�� where  ����ԱID='"+AdminID+"' limit "+page+" ,10";
			rs=ps.executeQuery(str_sql);
			
			while(rs.next()) {
				Questionnaire questionnaire=new Questionnaire();
				questionnaire.setID(rs.getInt("�ʾ�ID"));
				questionnaire.setName(rs.getString("�ʾ�����"));
				questionnaire.setAdminID(rs.getString("����ԱID"));
				questionnairesList.add(questionnaire);
				
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
		return questionnairesList;		
	}
	public int getnumofQnaire(String adminID) {
		int num=-1;
		Statement ps=null;
		ResultSet rs=null;
		Connection conn = DatabaseManger.getconnect();
		try {
			ps=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//���ý�������Թ���
			String str_sql="select count(*) from �ʾ�� where  ����ԱID='"+adminID+"'";
			rs=ps.executeQuery(str_sql);
			
			rs.next();
			num=rs.getInt(1);
			int yushu=num%10;
			if (yushu>0) {
				num=(num/10)+1;
			}else {
				num=num/10;
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
		return num;
	}
}
