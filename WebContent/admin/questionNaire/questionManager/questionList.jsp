<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>
<title>题列表</title>
<style>
	#table_bottom1{
	margin-top:5%;
	margin-left:51%;
	}
	.delete:hover{
	background-color:#b1ccea;
	cursor:pointer;
	}
	#questionDiv{
	width:200px;
	height:200px;
	background-color:pink;
	/* float:left; */
	}
	
	#QuestonMinWin{
	width:625px;
	height:390px;
	z-index:99999;
	border:2px solid #ccc;
	background-color:#fff;
	position:absolute;
	top:200px;
	left:236px;
	}
	#bottom_righ{
position:relitive;
}
</style>
<script src="jquery-1.12.4.js"></script>
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
			<tbody id="tbody">
			<c:set var="i" value="0" /> 
    		<c:forEach var="question" items="${question_list}" >	
    			<c:set var="i" value="${i+1}" /> 
	   			<tr id="del${i}" class="odd">   
	  				<td>${question.tihao}</td>
	    			<td>${question.biaoti}</td>
	    			<td>${question.leixing}</td>
	    			<td><p id="view${i}" class="delete" onclick="showQue(${question.tihao})">查看 </a> </p>
	    			<p id="change" class="delete">修改 </p>
	    			<p class="delete" id="delete${i}" onclick="deleteQuestion(${i},${question.tihao})">删除 </p></td>
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
	<script>
	    function deleteQuestion(i,tihao){
		var td=document.getElementById("tbody");
		var de=document.getElementById("del"+i);
		td.removeChild(de);
		
		$(function(){
			 $.ajax({
			      type: 'get',
			       url: '/TPM/DelectTiServlet',
			     // dataType: 'json',
			      data:{		    	  
			    	  "queNum":tihao,
			         },
			     success: function (data) { 
			    	 alert("删除成功");
			     },
			       error: function(){
			        	alert("error");
			        }
			     }) 
		})
			
		}
	 
	 
	
	//* $(function(){
		//$(".delete").click(function(){
			//console.log($(:parent).index());
			/* var deleteEle=this.parent().parent();
			var p=this.parent().parent().index();
			deleteEle.parent().remove(deleteEle); 
		});
		
	}); */
//		this.parentElement.parentElement.setAttribute("id","del");
//		var deleteEle=document.getElementById("del");
//	    del.parentElement.removeChild(deleteEle); }
  // 		this.parentElement.parentElement.setAttribute("id","del");
// 		var deleteEle=document.getElementById("del");
// 	    del.parentElement.removeChild(deleteEle); }
	</script>	
</body>
</html>