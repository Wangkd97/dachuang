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
		$("#table_load").load("/TPM/QuestionSelectListServlet?page=1&zhibiao="+$("#zhibiao").val());
	}else{
		$("#table_load").load("/TPM/QuestionSelectListServlet?page=1&zhibiao="+$("#zhibiao").val()+"&type="+$("#questionClass").val());
	}
}
</script>
</head>
<body>
    	<div id="bottom_righ">
    	<p id="naire">问题管理</p>
    		<div id="choice">    			
    		    <ul id="bottom_search">
    		    <li>    		    	
	    		    <p>能力</p>
		    		<select id="ability" onchange="getzhibiao( $('#ability option:selected').val() )"></select>
		    		<!--  -->
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
	    	<div id="table_load">
	    			
	    	</div>  		
    	</div>
		
</body>
<script type="text/javascript">

		//2、请求分解点方法
		function getzhibiao(ability_id){
			$("#zhibiao").find("option").remove();
		    if(window.XMLHttpRequest){
		      ajax=new XMLHttpRequest();
		    }else if(window.ActiveXObject){
		      ajax=new ActiveXObject();
		    }
		    var url="/TPM/GetZhibiaoServlet?"+"毕业生应获得的知识和能力ID="+ability_id;
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
		//1、直接请求相应的能力
		var request_num=0;
		var ajax;
		function getMajorList(){
			$("#ability").find("option").remove();
		    if(window.XMLHttpRequest){
		      ajax=new XMLHttpRequest();
		    }else if(window.ActiveXObject){
		      ajax=new ActiveXObject();
		    }
		    var url="/TPM/GetAbilityListServlet?"+"对应系=2001";
		    ajax.onreadystatechange=doGetMajorList;
		    ajax.open("post",url,true);
		    ajax.send();
		  }
		function doGetMajorList(){
		    if(ajax.readyState==4 && ajax.status==200){
			     var str=ajax.responseText;
			     //alert(str);
			     var obj = eval('(' + str + ')'); //由JSON字符串转换为JSON对象
			     var select_ability = document.getElementById("ability");
			     for (var i = 0; i < obj.length; i++) {
			          var t = document.createElement("option");
			          
			          var item_str=obj[i].毕业生应获得的知识和能力名;
			          t.appendChild(document.createTextNode(item_str));
			          t.setAttribute("value",obj[i].毕业生应获得的知识和能力ID);
			       
			          select_ability.appendChild(t);
			     }	
			     if(request_num==0){
			    	 request_num=1;
			    	 getzhibiao(1);
			     }
			}
		}
		getMajorList();		
		
</script>
</html>