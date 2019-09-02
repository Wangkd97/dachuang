package com.tpm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tpm.entity.Choose_card;


public class ChooseCardDao {

	public void addXzt(int tihao,String neirong,float fenzhi) {
		PreparedStatement preparedStatement=null;
		Connection conn = DatabaseManger.getconnect();
		String str_sql="insert into ѡ�񿨱� (���,ѡ������,��ֵ)";
		str_sql+="values(?,?,?)";
		try {
			preparedStatement=conn.prepareStatement(str_sql);
			preparedStatement.setInt(1, tihao);
			preparedStatement.setString(2, neirong);
			preparedStatement.setFloat(3, fenzhi);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			try{
				if(preparedStatement!=null)preparedStatement.close();
				DatabaseManger.doclose();
			}catch(Exception e){
				e.printStackTrace();
			}
			}
	}
	
	
	public void deleteDanxuanxiang(int d) {
		String sql="delete from ѡ�񿨱� where ��� = ?";
	    Connection conn=DatabaseManger.getconnect();
	    PreparedStatement ps=null;
	    try {
	    	ps = conn.prepareStatement(sql);
	    	ps.setInt(1, d);
	    	ps.executeUpdate();
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	}
	
	public void deleXzt(int tihao,int dijige ) {
		Statement stmt=null;
		Statement ss=null;
		ResultSet rs=null;
		int i=0;
		try{
			Connection conn=DatabaseManger.getconnect();
			stmt=conn.createStatement();
			String ssql = "select * from ѡ�񿨱� where ��� ='"+tihao+"'";
			rs=stmt.executeQuery(ssql);
			if(rs.next()){
				i=dijige+rs.getInt(1)-1;
			}
			System.out.println(i);
			ss=conn.createStatement();
			String str_sql="delete from ѡ�񿨱� where ѡ����= '"+i+"'";
			ss.execute(str_sql);
		}catch(Exception e){
			
		}finally {
			try{
				if(stmt!=null)stmt.close();
				if(ss!=null)ss.close();
				DatabaseManger.doclose();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	public ArrayList<Choose_card> getXzt(int tihao) {
		ArrayList<Choose_card> list =new ArrayList<Choose_card>();
		Statement stmt=null;
		ResultSet rs=null;
		try{
			Connection conn=DatabaseManger.getconnect();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//���ý�������Թ���
			String str_sql="select * from ѡ�񿨱�  where ��� = "+String.valueOf(tihao);
			rs=stmt.executeQuery(str_sql);
			while(rs.next()) {
				Choose_card xuanzetilei=new Choose_card();
				xuanzetilei.setBianhao(rs.getInt(2));
				xuanzetilei.setNeirong(rs.getString(3));
				xuanzetilei.setFenzhi(rs.getInt(4));
				list.add(xuanzetilei);
			}
			
		}catch(Exception e){
			e.printStackTrace();
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
	
	
	
}
