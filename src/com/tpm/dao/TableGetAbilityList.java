package com.tpm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

public class TableGetAbilityList {
	public static JSONArray getAbilitylist(String num) {
		JSONArray jsonArray =new JSONArray();
		Statement stmt=null;
		ResultSet rs=null;
		try {
			Connection conn=DatabaseManger.getconnect();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//���ý�������Թ���
			String sql="select*from ��ҵ��Ӧ��õ�֪ʶ�������� where ��Ӧϵ='"+num+"'";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				JSONObject jsonObject=new JSONObject();
				jsonObject.put("��ҵ��Ӧ��õ�֪ʶ������ID", rs.getInt(1));
				jsonObject.put("��ҵ��Ӧ��õ�֪ʶ��������", rs.getString(2));
				jsonObject.put("רҵ��Ӧ��õ�֪ʶ����������", rs.getString(3));
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
