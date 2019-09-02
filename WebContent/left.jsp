<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<HTML>

	<HEAD>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" href="<%=basePath%>images/css/bootstrap.css" />
		<link rel="stylesheet" href="<%=basePath%>images/css/css.css" />
		<script type="text/javascript" src="<%=basePath%>images/js/sdmenu.js"></script>
		<script type="text/javascript" src="<%=basePath%>images/js/jquery.js"></script>
		<link rel="stylesheet" href="<%=basePath%>images/css/screen.css" media="screen" />
		<link rel="stylesheet" href="<%=basePath%>images/css/jquery.treetable.css" />
		<link rel="stylesheet" href="<%=basePath%>images/css/jquery.treetable.theme.default.css" />
		<style type="text/css">
			* {
				moz-user-select: -moz-none;
				-moz-user-select: none;
				-o-user-select: none;
				-khtml-user-select: none;
				-webkit-user-select: none;
				-ms-user-select: none;
				user-select: none;
			}
			
			a {
				color: #0087E8;
			}
			
			a:hover {
				text-decoration: none;
				color: #f37028;
			}
			
			a:active {
				color: #f37028;
				text-decoration: none;
			}
			
			a:focus {
				color: #f37028;
				text-decoration: none;
			}
			
			#mid {
				background-color: #E0E0E0;
			}
			/*	
			#long {
				cursor: w-resize;
				position: absolute;
				height: 100%;
				width: 100%;
			}
			*/
			
			#pointer {
				cursor: pointer;
				position: absolute;
				height: 30px;
				width: 100%;
				top: 50%;
			}
			
			#long:hover,
			#pointer:hover {
				background-color: #FFCC00;
			}
		</style>
	</HEAD>

	<body style="overflow:hidden;">
		<div id="left" class="left" style="overflow:auto;width:252px;">
			<div id="main" style="width:255px;">
				<table id="example-advanced">
					<tbody>
						<tr data-tt-id='3'>
							<td><span class='folder'><a href="${pageContext.request.contextPath}/user_tomainPage.action" target="MainFrame">培养计划管理系统</a></span></td>
						</tr>
						
						<!-- DYH -->
						<tr data-tt-id='4-5' data-tt-parent-id='3'>
							<td><span class='folder'>问卷系统</span></td>
						</tr>
							<tr data-tt-id='4-5-1' data-tt-parent-id='4-5'>
								<td><span class='folder'><a href="/TPM/admin/questionNaire/createQuestion/createQuestion.jsp" target="MainFrame">录入题目</a></span></td>
							</tr>
								<tr data-tt-id='4-5-1-1' data-tt-parent-id='4-5-1'>
									<td><span class='file'><a href="/TPM/admin/questionNaire/createQuestion/single_choose.jsp" target="MainFrame">单选题</a></span></td>
								</tr>
								<tr data-tt-id='4-5-1-2' data-tt-parent-id='4-5-1'>
									<td><span class='file'><a href="/TPM/admin/questionNaire/createQuestion/mult_choose.jsp" target="MainFrame">多选题</a></span></td>
								</tr>
								<tr data-tt-id='4-5-1-3' data-tt-parent-id='4-5-1'>
									<td><span class='file'><a href="/TPM/admin/questionNaire/createQuestion/single_fill.jsp" target="MainFrame">单项填空题</a></span></td>
								</tr>
								<tr data-tt-id='4-5-1-4' data-tt-parent-id='4-5-1'>
									<td><span class='file'><a href="/TPM/admin/questionNaire/createQuestion/mult_fill.jsp" target="MainFrame">多项填空题</a></span></td>
								</tr>
								<tr data-tt-id='4-5-1-5' data-tt-parent-id='4-5-1'>
									<td><span class='file'><a href="/TPM/admin/questionNaire/createQuestion/file.jsp" target="MainFrame">文件上传题</a></span></td>
								</tr>
							<tr data-tt-id='4-5-2' data-tt-parent-id='4-5'>
								<td><span class='file'><a href="/TPM/admin/questionNaire/createQuestionnair/createQuestionnair.jsp" target="MainFrame">创建问卷</a></span></td>
							</tr>
							<tr data-tt-id='4-5-2' data-tt-parent-id='4-5'>
								<td><span class='file'><a href="/TPM/admin/questionNaire/questionManager/questionManager.jsp" target="MainFrame">问题管理</a></span></td>
							</tr>
							

							<tr data-tt-id='4-5-3' data-tt-parent-id='4-5'>
							<td><span class='folder'><a href="admin/questionNaire/student/myStudent.jsp" target="MainFrame">学生问卷管理</a></span></td>
							</tr>
								<tr data-tt-id='4-5-3-1' data-tt-parent-id='4-5-1'>
									<td><span class='file' ><a href="/TPM/GetQuestionnaireServlet?QuestionnaireStatus=3" target="MainFrame" >全部问卷</a></span></td>
								</tr>
								<tr data-tt-id='4-5-3-2' data-tt-parent-id='4-5-1'>
									<td><span class='file'><a href="/TPM/GetQuestionnaireServlet?QuestionnaireStatus=1" target="MainFrame" >已做问卷</a></span></td>
								</tr>
								<tr data-tt-id='4-5-3-3' data-tt-parent-id='4-5-1'>
									<td><span class='file'><a href="/TPM/GetQuestionnaireServlet?QuestionnaireStatus=0" target="MainFrame" >未做问卷</a></span></td>
								</tr>
							<tr data-tt-id='4-5-3' data-tt-parent-id='4-5'>
							<td><span class='folder'><a href="/TPM/AdminGetQnaireServlet?QuestionnaireStatus=3" target="MainFrame">管理员管理问卷</a></span></td>
							</tr>
					</tbody>
				</table>
			</div>
			<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
			<script src="<%=basePath%>images/js/jquery.treetable.js"></script>
			<script>
			
				$("#example-advanced").treetable({
					expandable: true
				});

				
			
			</script>
		</div>
		<div id="mid" style="position:absolute;right:0;top:0;height: 100%;width:6px;">
			<div id="long"></div>
			<div id="pointer" onclick="HideScreen()">
				<img id="img1" style="margin-top: 12px;position:absolute;height:8px;width:100%;" src="<%=basePath%>images/img/440-arrow-simle-left.png" align="center" />
			</div>
		</div>
	</body>
	<script type="text/javascript">
		var screen = true;

		function HideScreen() {
			if(screen) {
				parent.topwin.cols = "6,*"
				document.getElementById("img1").src = '<%=basePath%>images/img/439-arrow-simle-right.png';
			} else {
				parent.topwin.cols = "258,*"
				document.getElementById("img1").src = '<%=basePath%>images/img/440-arrow-simle-left.png';
			}
			screen = !screen;
		}
	</script>

</html>