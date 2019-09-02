<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>
     <link rel="stylesheet" type="text/css" href="../../../images/css/inputQust.css">
    <script type="text/javascript" src="../../../images/js/inputQust.js"></script>
    <script type="text/javascript" src="../../../images/js/submit.js"></script>


    <title></title>
  </head>
  <body>
  <div class="header">
	<div class="header-left"><h2>单项选择题</h2></div>
</div>
    <div class="centerwapper" >
          <div class="content" id="content">
              <!-- <+> -->
            <p id="queName1" class="queName1" contenteditable="true">${question.biaoti }</p>
              <!-- <+> -->
            <p id="queName2" class="queName2" contenteditable="true">${question.tishineirong }</p>
              <!-- <+> -->
            <p class="queName3">
              是否必答
              <!-- <+> -->
              <select id="ansType" name="ansType">
                  <option value ="yes">是</option>
                  <option value ="no">否</option>
                </select>
            </p>

            <ul class="chose_wap" id="chose_wap">
              <li  >
               <c:forEach var="choose_card" items="${clist }">
				  <li  >
                <div class="chose_left_wap">分值                  
                    <select class="chose_score" >
                        <option >${choose_card.fenzhi }</option>
                        <option value="0">0</option>
                        <option value="20">20</option>
                        <option value="30">30</option>
                        <option value="50">50</option>
                        <option value="100">100</option>
                    </select>%
                    <input class="radio" name="#" type="radio" value="" />
                </div>
                <div class="chose_right_wap">
                    <p  id="chose_text1" class="chose_text"  onclick='textnull(1)' >${choose_card.neirong }</p>
                	 <input class="del_chose_btn" type="button"  value="删除">
                </div>
              </li>				
			</c:forEach>
              </li>
            </ul>
          </div>
      </div>
      <div class="rightwapper">
          <ul>
            <li class="addChose_btn">
              <input type="button" name="" onclick="addChosesSingle()" value="增加选项">
            </li>
            <li class="submitForm_btn">

              <input type="button" name="" value="录入该题" onclick="submit_singleChose()">
            </li>
          </ul>
      </div>
  </body>
</html>