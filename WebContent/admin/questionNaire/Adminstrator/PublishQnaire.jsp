<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <link rel="stylesheet" type="text/css" href="../student/question(1).css">	 -->
<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
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
	#ending_time,
	#start_time{
	margin-right:30px;
	}
	#publish{
	margin-left:10%;}
	#table_bottom1{
	margin-top:2%;
	margin-left:30%;
	}
	#publish_btn{
	margin-left:60%;
	}
	.bottom_right_done{
	min-width:900px;
	width:1000px;
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
		    
            			<form id="publish">
		    		    <p id="publishnext" style="display:inline-block">问卷开始时间</p>
			    		<input id="start_time" type="datetime-local" style="display:inline-block">
			    	 	
			    	
			    		 <p id="publishnext" style="display:inline-block">问卷结束时间</p>
			    		<input id="ending_time" type="datetime-local" style="display:inline-block">
			    	
				    	<div id="grade"  style="display:inline-block;">
				    		 <p id="publishnext" style="display:inline-block">年级</p>
				    		<select id="student_grade">
				    		 <c:forEach var="grade" items="${ allGrade}"  >	
	   			
	   			             <option id="${ grade}">${ grade}</option>
    		                 </c:forEach> 
				    		</select>
				    	</div>	
	  		    		  </form>
	   		<div id="finished_questionnaire">
	   		
		<table id="finished_questionnaire_list">
	   				<tr class="odd">
	   					<th id="questionnaireName">问卷名称</th>
	   					<th id="all_choose"> 全选<input type="checkbox" name='check' id='check0'></th>
	   				</tr>
	   				<tbody>
	   				
    		 <c:forEach var="Questionnaire" items="${ questionnaireList}"  >	
	   			<c:set var="i" value="${i+1}" />
	   			<tr class="odd">   
	  				<td id="questionnaireName"><a href="#" onclick='window.open("/TPM/ShowQuestionnaireServlet?QnaireID="+${Questionnaire.ID})'>${ Questionnaire.name}</a></td>
		    		<td><input id="check${i}" value="${ Questionnaire.ID}" type="checkbox" name='check'></td>
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
	   		<input type="button" value="发布" id="publish_btn" onclick="getQniareID(); M()">
<script>
 document.getElementById("check0").onclick=function checked_funct(){
	 
	var c0=document.getElementById("check0");
	if(c0.checked==true){
		for(var i=1;i<=${i};i++){
			var all_choose=document.getElementById("all_choose");
			document.getElementById("check"+i).checked=true;
			
			
		}
	}else{
		for(var i=1;i<=${i};i++){
			document.getElementById("check"+i).checked=false;
			/* all_choose.innerHTML="取消全选<input type='checkbox' name='check' id='check0'>"; */
		}
	}
};


function fix(num, length) {
    return ('' + num).length < length ? ((new Array(length + 1)).join('0') + num).slice(-length) : '' + num;
}
var checked=new Array();

function publish_Questionnaire()
{
	
	 var now = new Date();
    now.setHours(now.getHours() + 1);
    var startTime = now.getFullYear() + "-" + fix((now.getMonth() + 1), 2) + "-" + fix(now.getDate(), 2) +"-" + fix(now.getHours(), 2) + ":" + fix(now.getMinutes(), 2);
    $("#start_time").val(startTime); 
     
    startTime=startTime+"";
    var end = new Date();    
    end.setHours(end.getHours() + 1);
    var endTime = end.getFullYear() + "-" + fix((end.getMonth() + 1), 2) + "-" + fix(end.getDate(), 2) +"-" + fix(end.getHours(), 2) + ":" + fix(end.getMinutes(), 2);
    $("#end_time").val(endTime);
    endTime=endTime+"";
	alert(startTime);
	alert(endTime); 
	
	var gradehao=$("select").val();
	 alert(gradehao);

        
	$(function(){
		 $.ajax({
			  traditional: true,
		      type: 'get',
		       url: '/TPM/PublishQnaireServlet',
		      data:{
		    	  "starttime":startTime,
		    	  "endtime":endTime,
		    	  /* formJSON, */
		    	  "gradehao":gradehao,
		    	  checked,
		    	  
		         },
		     success: function (data) { 
		    	 alert("成功");
		     },
		       error: function(){
		        	alert("error");
		        }
		     }) 
	})
	checked=[];
	}

    
	function getQniareID(){
		
		for(var i=1;i<${i};i++){
			var check=document.getElementById("check"+i);
			if(check.checked==true){
				var s=check.getAttribute("value")
				checked.push(s);
				alert(s);
			}
		}	
	}
	function CompareDate(d1,d2)
	{
	 /*  return ((new Date(d1.replace(/-/g,"\/"))) > (new Date(d2.replace(/-/g,"\/")))); */
	 s1=new Date(d1);
	 s2=new Date(d2);
	 if(s1.getTime()>s2.getTime()){
		 alert("截止时间比开始时间早，请重新设置"); 
	 }else{
		 publish_Questionnaire()
	 }
	}
	function M(){
		var startTime=document.getElementById("start_time").value;
	    var endTime = document.getElementById("ending_time").value;
		CompareDate(startTime,endTime);
	}
	function f(){
		var now = new Date();
	    now.setHours(now.getHours() + 1);
	    var startime = now.getFullYear() + "-" + fix((now.getMonth() + 1), 2) + "-" + fix(now.getDate(), 2) +"T" + fix(now.getHours(), 2) + ":" + fix(now.getMinutes(), 2);     
	    document.getElementById("start_time").setAttribute("value",startime); 
	    document.getElementById("ending_time").setAttribute("value",startime); 
	}
	f();

</script>
</body>
</html>