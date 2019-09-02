<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<html lang="en" dir="ltr">
  <head>
    <link rel="stylesheet" type="text/css" href="/TPM/images/css/inputQust.css">
    <meta charset="utf-8">
    <title></title>
  </head>
  <body>
    <div class="centerwapper" style="margin:5 auto;">

        <div class="content" id="content" style="height:300px;">
      	<p id="queName1" class="queName1" contenteditable="true">${question.biaoti }</p>
           <!-- <+> -->
        <p id="queName2" class="queName2" contenteditable="true">${question.tishineirong }</p>
           <!-- <+> -->
        <p class="queName3">  是否必答
          <!-- <+> -->
          <select id="ansType" name="ansType">
              <option value ="yes">是</option>
              <option value ="no">否</option>
            </select>
        </p>
        <div class="single_inputText">

        </div>
        </div>
    </div>
  </body>
</html>