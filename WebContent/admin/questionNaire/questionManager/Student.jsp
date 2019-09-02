<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="question(1).css">	
<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>

<style>
	/* /* #do{display:block; font-style:none;} */
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
	.bottom_right_all, .bottom_right_done,.bottom_right_notdone{
	display:none;}
	#finished_questionnaire_list{
	margin-left:10%;
	}
	#finished_questionnaire_list td{
	    max-width:150px;
		white-space:nowrap;
		overflow:hidden;
		text-overflow:ellipsis;
	} */
</style>
</head>
<body>
<div id="header">	
</div>
<div id="bottom">
    <div id="bottom_left">
   		<!-- <p>学生问卷管理</p>
   		<ul>
    		<li><a id="do" href="#">做问卷</a></li>
    		<li><a id="do" href="#">查看历史问卷</a></li>
   		</ul> -->
   		<div class="sidebar"> 
   			<ul> 
   			<li id="student_ul_header">学生问卷管理
   			<ul> 
   			<li id="sidebar-selected">
   			<a onclick="all_questionnaire()" class="sidebar-selected">全部
   			</a></li> <li><a onclick="finished_questionnaire()">已做问卷
   			</a></li> <li><a onclick="not_finished_questionnaire()">待做问卷</a></li> <li>
   			<a onclick="">P3
   			</a>
   			</li>
   		  <li><a onclick="">P4</a></li> </ul> </li>
   		  </ul></div>
    </div>
    <div id="bottom_right" >
  <!--  全部问卷 -->
	    <div class="bottom_right_all">
	    	<p id="naire">学生问卷管理>全部问卷</p>
	   		<div id="finished_questionnaire">	
	   			<table id="finished_questionnaire_list">
	   				<tr class="odd">
	   					<th id="questionnaireName">问卷名</th>
	   					<th>问卷状态</th>
	   					<th>开始时间</th>
	   					<th>截止时间</th>
	   				</tr>
	   				<%-- <tbody>
    		 <c:forEach var="Questionnaire" items="${questionnairesList}" >	
	   			<tr class="odd">   
	  				<td id=questionnaireName><a href="#">${Questionnaire.name}</a></td>
	    			<td>${Questionnaire.stutas}</td>
	    			<td>${Questionnaire.starttime}</td>
	    			<td>${Questionnaire.endtime}</td>
		    	</tr> 
    		</c:forEach> 
		 	</tbody> --%>
	   				<!-- <tr>
	   					<td ><a href="#">5555555555511111111111111111111</a></td>
	   					<td>全部问卷</td>
	   					<td></td>
	   					<td></td>
	   				</tr>
	   				<tr class="odd">
	   					<td id=questionnaireName><a href="#">777777777777777777777777</a></td>
	   					<td></td>
	   					<td></td>
	   					<td>16666666666666666666666666666666666666666666666666</td>
					</tr>
	   				<tr><td id=questionnaireName><a href="#"></a></td>
	   					<td></td>
	   					<td></td>
	   					<td>3333333333333333333333333333333333</td>
	   				</tr>
	   				<tr class="odd">
	   					<td id=questionnaireName><a href="#"></a></td>
	   					<td></td>
	   					<td></td>
	   					<td></td>
					</tr>
	   				<tr><td id=questionnaireName><a href="#"></a></td>
	   					<td></td>
	   					<td></td>
	   					<td></td>
	   				</tr>
	   				<tr class="odd">
	   					<td id=questionnaireName><a href="#"></a></td>
	   					<td></td>
	   					<td></td>
	   					<td></td>
					</tr>
	   				<tr>
	   					<td id=questionnaireName><a href="#"></a></td>
	   					<td></td>
	   					<td></td>
	   					<td></td>
	   				</tr>
	   				<tr class="odd">
	   					<td id=questionnaireName><a href="#"></a></td>
	   					<td></td>
	   					<td></td>
	   					<td></td>
					</tr>
					<tr>
	   					<td id=questionnaireName><a href="#"></a></td>
	   					<td></td>
	   					<td></td>
	   					<td></td>
	   				</tr>
	   				<tr class="odd">
	   					<td id=questionnaireName><a href="#"></a></td>
	   					<td></td>
	   					<td></td>
	   					<td></td>
					</tr> -->
	   			</table>
	   		</div>
	   	</div>
  <!-- 已做问卷 -->
    	<div class="bottom_right_done">
	    	<p id="naire">学生问卷管理>已做问卷</p>
	   		<div id="finished_questionnaire">	
	   			<table id="finished_questionnaire_list">
	   				<tr class="odd">
	   					<th id="questionnaireName">问卷名</th>
	   					<th>完成时间</th>
	   					<th>完成次数</th>
	   					<th>最高成绩</th>
	   				</tr>
	   				<tbody>
    		 <c:forEach var="Questionnaire" items="${questionnairesList}" >	
	   			<tr class="odd">   
	  				<td id=questionnaireName><a href="#">${Questionnaire.name}</a></td>
	    			<td>${Questionnaire.stutas}</td>
	    			<td>${Questionnaire.starttime}</td>
	    			<td>${Questionnaire.endtime}</td>
		    	</tr> 
    		</c:forEach> 
		 	</tbody>
	   				<!-- <tr>
	   					<td id=questionnaireName><a href="#">111111111111111111111111111111111</a></td>
	   					<td>已经完成</td>
	   					<td></td>
	   					<td></td>
	   				</tr>
	   				<tr class="odd">
	   					<td id=questionnaireName><a href="#"></a></td>
	   					<td></td>
	   					<td></td>
	   					<td>16666666666666666666666666666666666666666666666666</td>
					</tr>
	   				<tr><td id=questionnaireName><a href="#"></a></td>
	   					<td></td>
	   					<td></td>
	   					<td>3333333333333333333333333333333333</td>
	   				</tr>
	   				<tr class="odd">
	   					<td id=questionnaireName><a href="#"></a></td>
	   					<td></td>
	   					<td></td>
	   					<td></td>
					</tr>
	   				<tr><td id=questionnaireName><a href="#"></a></td>
	   					<td></td>
	   					<td></td>
	   					<td></td>
	   				</tr>
	   				<tr class="odd">
	   					<td id=questionnaireName><a href="#"></a></td>
	   					<td></td>
	   					<td></td>
	   					<td></td>
					</tr>
	   				<tr>
	   					<td id=questionnaireName><a href="#"></a></td>
	   					<td></td>
	   					<td></td>
	   					<td></td>
	   				</tr>
	   				<tr class="odd">
	   					<td id=questionnaireName><a href="#"></a></td>
	   					<td></td>
	   					<td></td>
	   					<td></td>
					</tr>
					<tr>
	   					<td id=questionnaireName><a href="#"></a></td>
	   					<td></td>
	   					<td></td>
	   					<td></td>
	   				</tr>
	   				<tr class="odd">
	   					<td id=questionnaireName><a href="#"></a></td>
	   					<td></td>
	   					<td></td>
	   					<td></td>
					</tr> -->
	   			</table>
	   		</div>
   		</div>
  <!-- 未做问卷	 -->
   		<div  class="bottom_right_notdone">
	    	<p id="naire">学生问卷管理>未做问卷</p>
	   		<div id="finished_questionnaire">
	   			<table id="finished_questionnaire_list">
	   				<tr class="odd">
	   					<th>问卷名</th>
	   					<th>开始时间</th>
	   					<th>终止时间</th>
	   					<th>最高成绩</th>
	   				</tr>
	   				<tr>
	   					<td><a href="#">未完成。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。</a></td>
	   					<td></td>
	   					<td></td>
	   					<td></td>
	   				</tr>
	   				<tr class="odd">
	   					<td><a href="#"></a></td>
	   					<td></td>
	   					<td>11111233333333333333333333333333333333333333333333333333333</td>
	   					<td></td>
					</tr>
	   				<tr><td><a href="#"></a></td>
	   					<td></td>
	   					<td></td>
	   					<td></td>
	   				</tr>
	   				<tr class="odd">
	   					<td><a href="#"></a></td>
	   					<td></td>
	   					<td></td>
	   					<td></td>
					</tr>
	   				<tr><td><a href="#"></a></td>
	   					<td></td>
	   					<td></td>
	   					<td></td>
	   				</tr>
	   				<tr class="odd">
	   					<td><a href="#"></a></td>
	   					<td></td>
	   					<td></td>
	   					<td></td>
					</tr>
	   				<tr>
	   					<td><a href="#"></a></td>
	   					<td></td>
	   					<td></td>
	   					<td></td>
	   				</tr>
	   				<tr class="odd">
	   					<td><a href="#"></a></td>
	   					<td></td>
	   					<td></td>
	   					<td></td>
					</tr>
					<tr>
	   					<td><a href="#"></a></td>
	   					<td></td>
	   					<td></td>
	   					<td></td>
	   				</tr>
	   				<tr class="odd">
	   					<td><a href="#"></a></td>
	   					<td></td>
	   					<td></td>
	   					<td></td>
					</tr>
	   			</table>
	   		</div>
	   		</div>
      	</div> 	
    
</div>
	<script>
	
	/* function search_for_button_click(){
		/* location.replace('QuestionListGetList?abilityId='+$("#able").val()+"&zhibiao="
				+$("#indexPpint").val()+"&type="+$("#questionClass").val()); */
		/* if($("#questionClass").val().toString()=="无要求"){
			$("#table_load").load("/TPM/QuestionListServlet?page=1&zhibiao="+$("#zhibiao").val());
		}else{
			$("#table_load").load("/TPM/QuestionListServlet?page=1&zhibiao="+$("#zhibiao").val()+"&type="+$("#questionClass").val());
		}	
	}  */
	
		function finished_questionnaire(){
			document.getElementsByClassName("bottom_right_all")[0].style.display="none";
			document.getElementsByClassName("bottom_right_notdone")[0].style.display="none";
			document.getElementsByClassName("bottom_right_done")[0].style.display="block";
			
			$.ajax({
		        async:true,
		        type: "get",//数据发送的方式（post 或者 get）
		        url: "../../../GetQuestionnaireServlet",//要发送的后台地址
		        contentType: 'application/json;charset=utf-8',
		        data: {'QuestionnaireStatus':1,'StuID':123},//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
		        //dataType: "questionnaire",//后台处理后返回的数据格式
		        success: function (data) {//ajax请求成功后触发的方法
		        	alert("ok");
		        
		          /*  var arr = eval("("+data+")");
		           for(var i = 0;i<arr.result.length;i++){
		                $(".xianshi").append(arr.result[i].sname+":"+arr.result[i].sprice+":"+arr.result[i].cou+"<br>")
		            } */
		        },
		        error: function () {//ajax请求失败后触发的方法
		                alert("msg");//弹出错误信息
		        }
		});
			
		}
		function not_finished_questionnaire(){
			document.getElementsByClassName("bottom_right_all")[0].style.display="none";
			document.getElementsByClassName("bottom_right_done")[0].style.display="none";
			document.getElementsByClassName("bottom_right_notdone")[0].style.display="block";
		}
		function all_questionnaire(){
			document.getElementsByClassName("bottom_right_notdone")[0].style.display="none";
			document.getElementsByClassName("bottom_right_done")[0].style.display="none";
			document.getElementsByClassName("bottom_right_all")[0].style.display="block";
		}
		
	</script>
</body>
</html>