package com.tpm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tpm.entity.Answer;
public class StuAnsDao {
	public ArrayList<Answer> getAns(String StuID,int QnaireID,int tihao) {
		ArrayList<Answer> AnsList= new ArrayList<Answer>();
		Statement ps=null;
		ResultSet rs=null;
		Connection conn = DatabaseManger.getconnect();
		try {
			ps=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//���ý�������Թ���
			String str_sql="select * from ѧ���ʾ���Ŀ��ϵ��  where �ʾ�ID = "+QnaireID+" and ѧ��ID='"+StuID+"'and ���= "+tihao;
			rs=ps.executeQuery(str_sql);
			while(rs.next()) {
				Answer ans = new Answer();
				ans.setAnswer(rs.getString("��"));
				ans.setTiID(tihao);
				AnsList.add(ans);
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
		return AnsList;
	}
	public void SetStuQnaireAns(String stuID,int QnaireID,int tihao,String answer) {
		PreparedStatement preparedStatement=null;
		Connection conn = DatabaseManger.getconnect();
		String str_sql="insert into ѧ���ʾ���Ŀ��ϵ�� (ѧ��ID,�ʾ�ID,���,��)";
		str_sql+="values(?,?,?,?)";
		try {
			preparedStatement=conn.prepareStatement(str_sql);
			preparedStatement.setString(1,stuID);
			preparedStatement.setInt(2, QnaireID);
			preparedStatement.setInt(3, tihao);;
			preparedStatement.setString(4, answer);;
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		finally {
			try{
				if(preparedStatement!=null)preparedStatement.close();
				DatabaseManger.doclose();
			}
			catch(Exception e){
				
			}
		}
    }

//	public int  getscore(String StuID,int QnaireID,int tihao ) {
//		int score=0;
//		Statement ps=null;
//		ResultSet rs=null;
//		Connection conn = DatabaseManger.getconnect();
//		try {
//			ps=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//���ý�������Թ���
//			String str_sql="select * from �ʾ��  where �ʾ�ID = "+QnaireID+"and ѧ��ID= "+StuID+" and ���= "+tihao;
//			rs=ps.executeQuery(str_sql);
//			while(rs.next()) {
//				AnsList.add(rs.getString("��"));
//			}
//			
//		} catch (SQLException e) {
//			// TODO �Զ����ɵ� catch ��
//			e.printStackTrace();
//		}finally {
//			try{
//				if(rs!=null)rs.close();
//				if(ps!=null)ps.close();
//				DatabaseManger.doclose();
//			}catch(Exception e){
//				e.printStackTrace();
//			}
//		}
//		
//		
//		return score;
//		
//	}
}
