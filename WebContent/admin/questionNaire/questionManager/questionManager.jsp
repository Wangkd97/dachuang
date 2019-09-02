<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta charset="UTF-8">
<title>问题管理</title>

<link rel="stylesheet" type="text/css" href="/TPM/images/css/questionManager.css"/>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>
<script type="text/javascript">
function search_for_button_click(){
	/* location.replace('QuestionListGetList?abilityId='+$("#able").val()+"&zhibiao="
			+$("#indexPpint").val()+"&type="+$("#questionClass").val()); */
	if($("#questionClass").val().toString()=="无要求"){
		$("#table_load").load("/TPM/QuestionListServlet?page=1&zhibiao="+$("#zhibiao").val());
	}else{
		$("#table_load").load("/TPM/QuestionListServlet?page=1&zhibiao="+$("#zhibiao").val()+"&type="+$("#questionClass").val());
	}	
}
</script>
<style>
#bottom_righ{
position:relitive;
}
#background{
display:none;
position:absolute;
z-index:999;
width:100%;
height:100%;
top:0;
left:0;
}
#H_btn{
width:50px;
height:50px;
}
#QuestionMinWin{
	
	z-index:99999;
	border:2px solid #ccc;
	background-color:#fff;
	position:absolute;
	top:200px;
	left:236px;
	}
	#hide_btn{
	display: inline-block;
	width:100px;
	height:25px;
	border:2px solid #ccc;
	background-color:#ecf3fb;
	text-align:center;
	padding:12px;
	color:blue;
	}
	#hide_btn:hover{
	border:2px solid blue;
	background-color:blue;
	color:#fff;
	}
</style>
</head>
<body id="body">
    	<div id="bottom_righ">
    	<p id="naire">问题管理</p>
    		<div id="choice" position="absolute">    			
    		    <ul id="bottom_search">
    		    <li>    		    	
	    		    <p>能力</p>
		    		<select id="ability" onchange="getzhibiao()">   		</select>
				 </li>
				 <li>
				 	<p>指标点</p>
		    		<select id="zhibiao">	</select>
				 </li>
				 <li>
				    <p>题型</p>
		    		<select id="questionClass">
		    			<option value="无要求">无要求</option>
		    			<option value="单选题">单项选择题</option>
		    			<option value="多选题">多项选择题</option>
		    			<option value="单项填空题">单项填空题</option>
		    			<option value="多项填空题">多项填空题</option>
		    			<option value="文件上传题">文件上传题</option>
		    		</select>
		    	</li>
		    	<li>
		    		<input type="button" onclick="search_for_button_click()" id="search1" value="查找">
		    	</li>
	    		</ul>
	    	</div>
	    	<div id="table_load" position="absolute">
	    			
	    	</div>  		
    	</div>
    	<div id="background" style="background-color:rgba(1,1,1,0.8);">
    		<div id="QuestionMinWin">
    		    <div id="QuestionMinWin_span" style="margin-left:10px; margin-top:10px;">
    		    </div>
    			<!-- <span id="hide_btn" onclick="hide_MInWin()">关闭</span> -->
    		</div>
    	</div>
		
</body>
<script type="text/javascript">

		//1、直接请求相应的能力
		var ajax;
		function getMajorList(){
		    if(window.XMLHttpRequest){
		      ajax=new XMLHttpRequest();
		    }else if(window.ActiveXObject){
		      ajax=new ActiveXObject();
		    }
		    var url="/TPM/GetAbilityListServlet";
		    ajax.onreadystatechange=doGetMajorList;
		    ajax.open("post",url,true);
		    ajax.send();
		  }
		function doGetMajorList(){
		    if(ajax.readyState==4 && ajax.status==200){
			     var str=ajax.responseText;
			     var obj = eval('(' + str + ')'); //由JSON字符串转换为JSON对象
			     var select_ability = document.getElementById("ability");
			     for (var i = 0; i < obj.length; i++) {
			          var t = document.createElement("option");
			          t.appendChild(document.createTextNode(obj[i].毕业生应获得的知识和能力名));
			          t.setAttribute("value",obj[i].毕业生应获得的知识和能力ID);
			          select_ability.appendChild(t);
			     }		     
			}
		}
		getMajorList();
		
		
		///2、请求分解点方法
		function getzhibiao(){
		    if(window.XMLHttpRequest){
		      ajax=new XMLHttpRequest();
		    }else if(window.ActiveXObject){
		      ajax=new ActiveXObject();
		    }
		    var url="/TPM/GetZhibiaoServlet";
		    ajax.onreadystatechange=doGetzhibiao;
		    ajax.open("post",url,true);
		    ajax.send();
		  }
		function doGetzhibiao(){
		    if(ajax.readyState==4 && ajax.status==200){
			     var str=ajax.responseText;
			     var obj = eval('(' + str + ')'); //由JSON字符串转换为JSON对象
			     var select_zhibiao = document.getElementById("zhibiao");
			     for (var i = 0; i < obj.length; i++) {
			          var t = document.createElement("option");
			          var zhibiao_item_str=obj[i].指标分解内容;
			          t.appendChild(document.createTextNode(zhibiao_item_str));
			          t.setAttribute("value",obj[i].指标分解ID);
			          select_zhibiao.appendChild(t);
			     }		     
			}
		}
		function showQue(i){
			
			var view=document.getElementById("background");
			view.style.display="block";
			var QuestionMinWin=document.getElementById("QuestionMinWin_span");
			$("#QuestionMinWin").load('/TPM/QuestionShow?questionId='+i);
			/*  var content=document.getElementById("content");
			var hid_btn=document.createElement("input"); 
			 hid_btn.setAttribute("id","hid_btn");
			hid_btn.setAttribute("type","button");
			hid_btn.setAttribute("value","关闭");
			content.appendChild(hid_btn);  */
		}
		 function lookQuestion(i,biaoti,tihao){
			 /* url="/TPM/QuestionPreviewServlet?questionId="+tihao"; */
			var view=document.getElementById("background");
			view.style.display="block";
			var QuestionMinWin=document.getElementById("QuestionMinWin_span");
			
			//QuestionMinWin.innerHTML="<p>"+biaoti+"<p>";
			 
			 var ajax;
			function getMajorList1(){
			    if(window.XMLHttpRequest){
			      ajax=new XMLHttpRequest();
			    }else if(window.ActiveXObject){
			      ajax=new ActiveXObject();
			    }
			    var url="/TPM/GetSuoyinServlet?queNum="+tihao;
			    ajax.onreadystatechange=doGetMajorList1;
			    ajax.open("post",url,true);
			    ajax.send();
			  }
			function doGetMajorList1(){
			    if(ajax.readyState==4 && ajax.status==200){
				     var str=ajax.responseText;
				     alert(str);
				     var obj = eval('(' + str + ')'); //由JSON字符串转换为JSON对象
				     
				     var select_ability = document.getElementById("QuestionMinWin_span"); 
				          for (var i = 0; i < obj.length; i++) {
				    	  var t = document.createElement("p"); 
				          t.appendChild(document.createTextNode(obj[i].标题));
				          t.appendChild(document.createTextNode(obj[i].题号));
				          t.appendChild(document.createTextNode(obj[i].提示内容));
				          t.setAttribute("id","tishi");
				          t.setAttribute("value",obj[i].提示内容);
				          select_ability.appendChild(t);   
				    	 }  
				           
				     }		     
				}
			
			getMajorList1(); 
			/* $("#QuestionMinWin").load("/TPM/GetSuoyinServlet?queNum="+tihao); */
				/* $(function(){
					 $.ajax({
					      type: 'get',
					       url: '/TPM/GetSuoyinServlet',
					      dataType: 'json', 
					      data:{		    	  
					    	  "queNum":tihao,
					         },
					     success: function (data) { 
					    	var json=eval(data);
					    	$.each(json,function(index,item){
					    		//var name=json[index].标题;
					    		
					    		})
					    	}
					     },
					       error: function(){
					        	alert("error");
					        }
					     ) 
				}) */
							
			 }
		function hide_MInWin(){
			var del=document.getElementById("QuestionMinWin_span");
			var tishi=document.getElementById("tishi");
			
			del.removeChild(tishi);
			 var view=document.getElementById("background");
			view.style.display="none";
			} 

</script>
</html>