package com.tpm.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseManger {
	
	private static Connection conn=null;
	
	//�������ݿ��һ��Ҫ�ǵ�ȥ1���ر����ݿ⡣2�������쳣��һ��Ҫ�ر����ݿ�
	public static Connection getconnect() {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");				
			conn=DriverManager.getConnection(Config.sql_url+"gcf?useSSL=false&serverTimezone=UTC",Config.sql_user,Config.sql_psw);
		}catch(Exception e){
			
		}			
		return conn;
	}
	
	public static void doclose(){
		try{
			if(conn!=null){
				conn.close();
			}
		}catch(Exception e){
			
		}		
	}
}