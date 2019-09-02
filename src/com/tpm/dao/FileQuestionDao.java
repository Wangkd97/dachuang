package com.tpm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.tpm.entity.File_question;


public class FileQuestionDao {
	public void addWenjianshangchuanti(File_question w) {
		String sql="insert into �ļ��ϴ����(���,�ϴ����ռ�) values(?,?)";
		Connection conn = DatabaseManger.getconnect();
		PreparedStatement ps=null;
		try {
		    ps = conn.prepareStatement(sql);
			//���ʺ��趨ֵ
			ps.setInt(1,w.getTihao());
			ps.setInt(2,w.getMaxspace() );;
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{
				if(ps!=null)ps.close();
				DatabaseManger.doclose();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	public void deleteWenjianshangchuanti(int w) {
		String sql="delete from �ļ��ϴ���� where ��� = ?";
	    Connection conn=DatabaseManger.getconnect();
	    PreparedStatement ps=null;
	    try {
	    	ps = conn.prepareStatement(sql);
	    	ps.setInt(1, w);
	    	ps.executeUpdate();
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	}
	public File_question getWenjianshangchuanti(int w) {
		File_question wi=new File_question();
		Statement stmt=null;
		ResultSet rs=null;
		try {
			Connection conn=DatabaseManger.getconnect();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//���ý�������Թ���
			String sql="select*from �ļ��ϴ���� where ���='"+w+"'";
			rs=stmt.executeQuery(sql);
			if(rs.next()) {
				
				wi.setTihao(rs.getInt(2));
				wi.setMaxspace(rs.getInt(3));;
			}
		}catch(Exception e) {
			}finally {
				try {
					if(rs!=null)rs.close();
					if(stmt!=null)stmt.close();
					DatabaseManger.doclose();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		 return wi;		
	}
}
