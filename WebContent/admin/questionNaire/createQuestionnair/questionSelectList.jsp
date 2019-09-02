<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>题列表</title>
<style>
	#table_bottom1{
	margin-top:5%;
	margin-left:51%;
	}
</style>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>
</head>
<body>
	<div id="table">
		<table id="questionnaire_question">
  			<tr id="tr_first" >
	   			<th>编号</th>
    			<th>标题</th>
    			<th>题型</th>
    			<th>操作</th>
			</tr>
			<tbody>
    		<c:forEach var="question" items="${question_list}" >	
   			<tr class="odd">   
  				<td>${question.tihao}</td>
    			<td>${question.biaoti}</td>
    			<td>${question.leixing}</td>
    			<td><p><button onclick="$(window.parent.addQus( ${question.tihao }))">添加</button><p></td>
	    	</tr> 
    		</c:forEach>
		 	</tbody>
	    </table>
	</div>  	
   	<div id="table_bottom1">
    	${current_page} / ${tail_page}页
		<a href="user?cp=1">首页</a>
		<a href="user?cp=${cpage-1<=0 ?1:cpage-1}">上一页</a>
		<a href="user?cp=${cpage+1>=tpage ? tpage : cpage+1 }">下一页</a>
		<a href="user?cp=${tpage }">尾页</a>
	</div>	
</body>
</html>