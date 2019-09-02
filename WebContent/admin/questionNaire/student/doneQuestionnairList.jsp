<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="question(1).css">	
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style>
	.sidebar { width: 180px; float: left; padding-left: 35px;}
	.sidebar>ul { list-style: none; padding: 0; margin: 0;}
	.sidebar>ul>li { font-size: 18px; font-weight: 400; padding: 0010px; margin-top: 5px;}
	.sidebar>ul>li>ul {display: block; list-style: none; margin: 5px010px0; padding: 10px0010px; font-size: 14px; }
	.sidebar a { line-height: 1.5;}
	.sidebar a:hover { color: #e74430; cursor:pointer;}
	.sidebar-selected { color: #e74430;}
	#finished_questionnaire{
		margin-left:15%;
		margin-top:5%;
	}
	#bottom #bottom_right #questionnaireName{
		
		max-width:150px;
		white-space:nowrap;
		overflow:hidden;
		text-overflow:ellipsis;
	}
	
	#finished_questionnaire_list{
	margin-left:10%;
	border:2px solid #ccc;
	cellspacing:0;
	cellpadding:0;
	}
	#finished_questionnaire_list td,#finished_questionnaire_list th
	{
	text-align:center;
	width:150px;
	border-right:1px solid #000;
	    max-width:150px;
		white-space:nowrap;
		overflow:hidden;
		text-overflow:ellipsis;
	} 
	.odd th{
	background-color:#b1ccea;
	}
	.odd{
	background-color:#ecf3fb;
	}
	#table_bottom1{
	margin-top:2%;
	margin-left:30%;
	}
</style>
</head>
<body>
<div class="bottom_right_done">
	    
	    <p id="naire">学生问卷管理>
			<c:if test="${QuestionnaireStatus==3 }">
				全部问卷
			</c:if>
			<c:if test="${QuestionnaireStatus==0 }">
				未做问卷
			</c:if>		
			<c:if test="${QuestionnaireStatus==1 }">
				已做问卷
			</c:if>		
		</p>
	   		<div id="finished_questionnaire">
		<table id="finished_questionnaire_list">
	   				<tr class="odd">
	   					<th id="questionnaireName">问卷名称</th>
	   					<th>问卷状态</th>
	   					<th>开始时间</th>
	   					<th>截止时间</th>
	   				</tr>
	   				<tbody>
    		 <c:forEach var="Questionnaire" items="${ questionnaireList}" >	
	   			<tr class="odd">   
	  				<td id="questionnaireName"><a href="#"onclick='window.open("/TPM/ShowQuestionnaireServlet_studo?QnaireID="+${Questionnaire.ID})'>${ Questionnaire.name}</a></td>
	    			 <td> <c:if test="${Questionnaire.status==0 }">
							未做
						    </c:if>		
						<c:if test="${Questionnaire.status==1 }">
							已做
						</c:if>		</td> 
	    			<td> ${ Questionnaire.starttime}</td>
	    			<td> ${ Questionnaire.endtime}</td>
		    	</tr> 
    		</c:forEach> 
		 	</tbody>
	   	</table></div></div>
	   	
	<div id="table_bottom1">
    	${current_page} / ${tail_page}页
		<a href="user?cp=1">首页</a>
		<a href="user?cp=${cpage-1<=0 ?1:cpage-1}">上一页</a>
		<a href="user?cp=${cpage+1>=tpage ? tpage : cpage+1 }">下一页</a>
		<a href="user?cp=${tpage }">尾页</a>
	</div>
</body>
</html>