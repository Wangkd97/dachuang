package com.tpm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class test1 {

	public static void main(String[] args) {
		int num=10;		
		Statement stmt=null;
		ResultSet rs=null;
		try{
			Connection conn=DatabaseManger.getconnect();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//设置结果集可以滚动
			int izhibiaodian = Integer.parseInt("357");
			String str_sql="select count(*) from 索引表 where 指标点 = "+izhibiaodian;
			rs=stmt.executeQuery(str_sql);
			rs.next();
			num=rs.getInt(1);
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
	}

}
