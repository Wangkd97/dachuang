package com.tpm.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tpm.entity.Questionnaire;

public class QuestionnaireDao {
	
	public int  addQuestionnaire(Questionnaire Qnaire) {	
		int id;
		PreparedStatement preparedStatement=null;
		PreparedStatement ps=null;
		Connection conn = DatabaseManger.getconnect();
		String str_sql="insert into 问卷表 (问卷名称,管理员ID)";
		str_sql+="values(?,?)";
		String str="select  LAST_INSERT_ID()";
		try {
			preparedStatement=conn.prepareStatement(str_sql);
			 
			//preparedStatement.setInt(1, Qnaire.getID());
			preparedStatement.setString(1, Qnaire.getName());
			preparedStatement.setString(2, Qnaire.getAdminID());		 
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
			// TODO 自动生成的 catch 块 
		}finally {
			try{
				if(preparedStatement!=null)
					preparedStatement.close();
				DatabaseManger.doclose();
			}catch(Exception e){
				
			}
		}
		return 0; 
	}
	
	public ArrayList<Questionnaire> getQnaireInfo(int status,String stuID) {
		
		ArrayList<Questionnaire> questionnairesList=new ArrayList<Questionnaire>();
		Statement ps=null;
		ResultSet rs=null;
		Connection conn = DatabaseManger.getconnect();
		
		try {
			ps=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//设置结果集可以滚动
			String str_sql="select * from 问卷学生联系表  natural join 问卷表 where 问卷状态 = "+status+" and 学生ID='"+stuID+"'";
			rs=ps.executeQuery(str_sql);
			
			while(rs.next()) {
				Questionnaire questionnaire=new Questionnaire();
				questionnaire.setID(rs.getInt("问卷ID"));
				questionnaire.setName(rs.getString("问卷名称"));
				questionnaire.setStatus(rs.getInt("问卷状态"));
				questionnaire.setStarttime(rs.getString("开始时间"));
				questionnaire.setEndtime(rs.getString("终止时间"));
				questionnaire.setAdminID(rs.getString("管理员ID"));
				questionnairesList.add(questionnaire);
			}
			
			
		} catch (SQLException e) {
			
			// TODO 自动生成的 catch 块
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
		return questionnairesList;	
	}
	public ArrayList<Questionnaire> getAllQnaireInfo(String stuID,int page) {
		
		ArrayList<Questionnaire> questionnairesList=new ArrayList<Questionnaire>();
		Statement ps=null;
		ResultSet rs=null;
		Connection conn = DatabaseManger.getconnect();
		
		try {
			ps=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//设置结果集可以滚动
			String str_sql="select * from 问卷学生联系表  natural join 问卷表 where  学生ID='"+stuID+"'limit "+page+" ,10";
			rs=ps.executeQuery(str_sql);
			
			while(rs.next()) {
				Questionnaire questionnaire=new Questionnaire();
				questionnaire.setID(rs.getInt("问卷ID"));
				questionnaire.setName(rs.getString("问卷名称"));
				questionnaire.setStatus(rs.getInt("问卷状态"));
				questionnaire.setStarttime(rs.getString("开始时间"));
				questionnaire.setEndtime(rs.getString("终止时间"));
				questionnaire.setAdminID(rs.getString("管理员ID"));
				questionnairesList.add(questionnaire);
				
			}
			
			
		} catch (SQLException e) {
			
			// TODO 自动生成的 catch 块
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
		return questionnairesList;		
	}
public ArrayList<Questionnaire> getAdminAllQnaireInfo(String AdminID,int page) {
		
		ArrayList<Questionnaire> questionnairesList=new ArrayList<Questionnaire>();
		Statement ps=null;
		ResultSet rs=null;
		Connection conn = DatabaseManger.getconnect();
		
		try {
			ps=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//设置结果集可以滚动
			String str_sql="select * from 问卷表 where  管理员ID='"+AdminID+"' limit "+page+" ,10";
			rs=ps.executeQuery(str_sql);
			
			while(rs.next()) {
				Questionnaire questionnaire=new Questionnaire();
				questionnaire.setID(rs.getInt("问卷ID"));
				questionnaire.setName(rs.getString("问卷名称"));
				questionnaire.setAdminID(rs.getString("管理员ID"));
				questionnairesList.add(questionnaire);
				
			}
			
			
		} catch (SQLException e) {
			
			// TODO 自动生成的 catch 块
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
		return questionnairesList;		
	}
	public int getnumofQnaire(String adminID) {
		int num=-1;
		Statement ps=null;
		ResultSet rs=null;
		Connection conn = DatabaseManger.getconnect();
		try {
			ps=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//设置结果集可以滚动
			String str_sql="select count(*) from 问卷表 where  管理员ID='"+adminID+"'";
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
			
			// TODO 自动生成的 catch 块
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
