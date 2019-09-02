package com.tpm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.tpm.entity.Question;


public class QuestionDao {
public int  addTi(Question t) {
		
		String biaoti=t.getBiaoti();
		String tishineirong=t.getTishineirong();
		String leixing=t.getLeixing();
		int id;
		PreparedStatement preparedStatement=null;
		PreparedStatement ps=null;
		Connection conn = DatabaseManger.getconnect();
		String str_sql="insert into ���� ( ����,��ʾ����,����)";
		String str="select  LAST_INSERT_ID()";
		str_sql+="values(?,?,?)";
		try {
			preparedStatement=conn.prepareStatement(str_sql);
			preparedStatement.setString(1, biaoti);
			preparedStatement.setString(2, tishineirong);
			preparedStatement.setString(3, leixing);
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
				if(preparedStatement!=null)preparedStatement.close();
				DatabaseManger.doclose();
			}catch(Exception e){
				
			}
		}
		return 0; //û���ҵ�����0
	}
	public void deleTi(int tihao) {
		Statement stmt=null;
		try{
			Connection conn=DatabaseManger.getconnect();
			stmt=conn.createStatement();
			String str_sql="delete from ���� where ���= '"+tihao+"' ";
			stmt.execute(str_sql);
		}catch(Exception e){
			
		}finally {
			try{
				if(stmt!=null)stmt.close();
				DatabaseManger.doclose();
			}catch(Exception e){
				
			}
		}
		
	}
	public Question getTi(int tihao) {
		Question ti=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
			Connection conn=DatabaseManger.getconnect();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//���ý�������Թ���
			String str_sql="select * from ���� where ��� ='"+tihao+"'";
			rs=stmt.executeQuery(str_sql);
			if(rs.next()){
				ti=new Question();
				ti.setTihao(tihao);
				ti.setBiaoti(rs.getString(2));
				ti.setLeixing(rs.getString(4));
				ti.setTishineirong(rs.getString(3));
			}		
		}catch(Exception e){
			
		}finally {
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				DatabaseManger.doclose();
			}catch(Exception e){
				
			}
		}
		return ti;
		
	}
	
	public ArrayList<Question> fenyegetTi(int startPage,String type,String zhibiaodian) {
		Question ti;
		ArrayList <Question> list=new ArrayList<Question>();
		int izhibiaodian=Integer.parseInt(zhibiaodian);
		int page=(startPage-1)*10;
		Statement stmt=null;
		ResultSet rs=null;
		try{
			Connection conn=DatabaseManger.getconnect();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//���ý�������Թ���
			String str_sql="select * from ���� natural join ������  where ָ��� = "+izhibiaodian+" and ����='"+type+ "' limit "+ page +",10";
			rs=stmt.executeQuery(str_sql);
			while(rs.next()){
				ti=new Question();
				ti.setTihao(Integer.parseInt(rs.getString(1)));
				ti.setBiaoti(rs.getString(2));
				ti.setLeixing(rs.getString(4));
				ti.setTishineirong(rs.getString(3));
				list.add(ti);
			}		
		}catch(Exception e){
			
		}finally {
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				DatabaseManger.doclose();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public int  numOfTi(String zhibiaodian) {
		
		int num=-1;		
		Statement stmt=null;
		ResultSet rs=null;
		try{
			Connection conn=DatabaseManger.getconnect();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//���ý�������Թ���
			int izhibiaodian = Integer.parseInt(zhibiaodian);
			String str_sql="select count(*) from ������ where ָ��� = "+izhibiaodian;			
			rs=stmt.executeQuery(str_sql);
			rs.next();
			num=rs.getInt(1);
			int yushu=num%10;
			if (yushu>0) {
				num=(num/10)+1;
			}else {
				num=num/10;
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				DatabaseManger.doclose();
			}catch(Exception e){
				
			}
		}
		
		
		return num;
		
	}
	public void update(Question question)
	{
		System.out.println("aaaa");
	        String sql = "UPDATE ���� SET  ����= ?,��ʾ����= ?,���� = ? WHERE ��� = "+question.getTihao();
	        Connection conn=DatabaseManger.getconnect();
	        try{
	        	PreparedStatement ps = conn.prepareStatement(sql);
				//���ʺ��趨ֵ
				ps.setString(1,question.getBiaoti());
				ps.setString(2,question.getTishineirong());
				ps.setString(3,question.getLeixing());
				ps.executeUpdate();
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	}	
}


