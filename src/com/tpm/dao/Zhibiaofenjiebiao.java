package com.tpm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.tpm.entity.Analysis;
import com.tpm.entity.Zhibiaofenjie;


public class Zhibiaofenjiebiao {

	public ArrayList<Zhibiaofenjie> getzhibiao(int nengli) {
		
		ArrayList<Zhibiaofenjie> list=new ArrayList<Zhibiaofenjie>();
		Statement stmt=null;
		ResultSet rs=null;
		try{
			Connection conn=DatabaseManger.getconnect();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//���ý�������Թ���
			String str_sql="select * from ָ��ֽ��  where ��Ӧ���� = "+String.valueOf(nengli);
			rs=stmt.executeQuery(str_sql);
			while(rs.next()) {
				Zhibiaofenjie zhibiaofenjie=new Zhibiaofenjie();
				zhibiaofenjie.setFenjieid(rs.getInt(1));
				zhibiaofenjie.setNeirong(rs.getString(2));
				list.add(zhibiaofenjie);
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
		 
		return list;
		
	}
}
