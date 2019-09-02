<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="/TPM/images/css/inputQust.css">
    <script type="text/javascript" src="/TPM/images/js/inputQust.js"></script>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>
    <title>创建问卷</title>
    <style>
    .creatpaper_topbar{
      border: 1px solid blue;
      height: 64px;
      width: 100%;
      background-color: #0078c8;
    }
      .creatpaper_topbar .creatpaper_topbar_title{
        float: left;
        color: white;
        line-height: 64px;
        margin-left: 60px;
      }
      .creatpaper_topbar_add{
        display: inline-block;
        float: right;
        background-color: inherit;
        outline：none;
        margin-left: 50px;
        font-size: 1em;
        height: 32px;
        border: solid 1px white ;/* #0078c8 */
        margin-top: 16px;
        margin-right: 50px;
      }
      .creatpaper_topbar_add:hover{
        color: orange;
      }
    </style>
  </head>
  <body>
  	<div class="main">
      <div class="creatpaper_topbar">
        <h2 id="setQusInfo_html" class="creatpaper_topbar_title">创建问卷</h2>
        <input class="creatpaper_topbar_add" type="button"  href = "javascript:void(0)" onclick ="showQUS()"   name="" value="添加问题">
      </div>
		<p id="questionnairTitle" contenteditable="true" style="display:block;margin-top:20px;;margin-left:50px;border:1px,solid,blue;width:800px;height:40px;font-size:30px; text-align:center;line-height:40px;">问卷标题</p>
    

      <div class="centerwapper_creatpaper">
          <div class="content" id="qus_add_content">

          </div>
		<button id="createQuestionnair">创建问卷</button>
      </div>
    </div>

    <div id="setQusInfo" class="setQusInfo">

      <div id="setQusInfo_close" class="setQusInfo_close">
                <a style="border:1px solid black;float:right;margin-bottom:5px" class="menuExit" href = "javascript:void(0)"onclick = "hideQUS()">添加完成</a>
                <span id = "showmsg"></span>
      </div>
      <div id="setQusInfo_load" class="setQusInfo_load">

        <iframe id="setQusInfo_load_son" name="setQusInfo_load_son"  src="questionSelect.jsp" width="100%" height="100%"></iframe>
		
      </div>
    </div>
      <div id="setFillPropertyBcg" class="setFillPropertyBcg"></div>
  </body>
  <script>
  
  function addQus(questionId)
  {
	  
//       alert($(event.target).parents().prevAll().eq(2).text());//这个东西换成提示，不用点击的那种
      $("#showmsg").html("添加"+questionId+"成功！");
      var qusDiv = document.createElement("div");
      qusDiv.setAttribute("class","addQusDiv");
      var f = document.getElementById('qus_add_content');
      f.appendChild(qusDiv);
      qusDiv.innerHTML = '<input type="hidden" name="questionId" value="'+questionId+'"/>'+
//     	  '<object type="text/html" data="/TPM/QuestionPreview?questionId='+questionId+'" width="100%" height="100%"></object>';
     '<iframe id="my_son" name="my_son"  src="/TPM/QuestionPreview?questionId='+questionId+'"  width="100%" height="100%"></iframe>';
    		 }
 
  /* 创建问卷，向后台提交数据 */
  $("#createQuestionnair").click(function(){
	  
	  var questionIdArr = "";
      $("input[name='questionId']").each(function(){
    	  questionIdArr+=$(this).val()+",";//添加至数组
      });     
      var ansTypeArr="";
      $("iframe[name='my_son']").contents().find(" #ansType option:selected").each(function(){
    	
    	  ansTypeArr+=$(this).val()+",";//添加至数组
    	  })
 	  var title=$("#questionnairTitle").text();
     
	  $.ajax({
          url:'/TPM/CreateQuestionnairServlet',
          data:{'qlist':questionIdArr,
        	    'tlist':ansTypeArr,
        	     title :title},
          type:'post',
          success:function(msg){
              if(msg=='success'){
            	  alert('添加成功');
                  console.log('添加成功');
              }else if(msg=='fail'){
            	  alert('添加失败');
                  console.log('添加失败');
              }else{
            	  alert('出现不可预知的错误');
            	  console.log('出现不可预知的错误');
              }
          }
      });
  });
  
  
  </script>
</html>
