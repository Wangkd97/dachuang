package com.tpm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONObject;


public class QnaireAndStuDao {
	public void addQnaireAndStu(int QnaireID,String StuID,String Starttime,String Endtime) {
		PreparedStatement preparedStatement=null;
		Connection conn = DatabaseManger.getconnect();
		String str_sql="insert into �ʾ�ѧ����ϵ�� (�ʾ�ID,ѧ��ID,�ʾ�״̬,��ʼʱ��,��ֹʱ��)";
		str_sql+="values(?,?,?,?,?)";
		try {
			preparedStatement=conn.prepareStatement(str_sql);
			preparedStatement.setInt(1, QnaireID);
			preparedStatement.setString(2, StuID);
			preparedStatement.setInt(3, 0);
			preparedStatement.setString(4, Starttime);
			preparedStatement.setString(5, Endtime);
			preparedStatement.execute();
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
	}
	
	public void updateQnaireAndStu(int QnaireID,String StuID,String Usetime) {
		PreparedStatement preparedStatement=null;
		Connection conn = DatabaseManger.getconnect();
		String str_sql="update �ʾ�ѧ����ϵ�� set �ʾ�״̬=1 ,����ʱ��= "+Usetime+" where �ʾ�ID= "+QnaireID+" and ѧ��ID= "+StuID;
		try {
			preparedStatement=conn.prepareStatement(str_sql);
			preparedStatement.execute();
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
	}
	public ArrayList<String> getAllGrade() {
		ArrayList<String> allGradeList= new ArrayList<String>();
		Statement stmt=null;
		ResultSet rs=null;
		try {
			Connection conn=DatabaseManger.getconnect();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//���ý�������Թ���
			String sql="select  �꼶 from ѧ����Ϣ�� GROUP BY �꼶 ";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				allGradeList.add(rs.getString(1));
			}
		}catch(Exception e) {
			}finally {
				try {
					if(rs!=null)rs.close();
					if(stmt!=null)stmt.close();
					DatabaseManger.doclose();
				}catch(Exception e) {
					
				}
			}
		return allGradeList;
	}
	public int getnumofQnaire(String stuID) {
		int num=-1;
		Statement ps=null;
		ResultSet rs=null;
		Connection conn = DatabaseManger.getconnect();
		try {
			ps=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//���ý�������Թ���
			String str_sql="select count(*) from �ʾ�ѧ����ϵ�� where  ѧ��ID='"+stuID+"'";
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
