package com.tpm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.json.JSONArray;
import org.json.JSONObject;


public class TabelGetMajorList {
	public static JSONArray getMajorlist() {
		JSONArray jsonArray =new JSONArray();
		Statement stmt=null;
		ResultSet rs=null;
		try {
			Connection conn=DatabaseManger.getconnect();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//���ý�������Թ���
			String sql="select*from רҵ�� ";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				JSONObject jsonObject=new JSONObject();
				jsonObject.put("רҵ����", rs.getString(1));
				jsonObject.put("רҵ����", rs.getString(2));
				jsonArray.put(jsonObject);				
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
		 return jsonArray;		
	}
}
