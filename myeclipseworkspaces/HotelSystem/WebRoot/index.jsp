<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>周家酒店欢迎您——主页</title>
	<link rel="stylesheet" href="style/style.css">
	<style>
		#login_form{
		background-color: white;
		height: 250px;
		width: 400px;
		position: fixed;
		right: 50px;
		top:175px;
		opacity: 0.5;
	}
	#login{
		padding-top: 50px;
		padding-left: 90px;
		height: 180px;
	}
	</style>
</head>
<%@ include file="header.jsp" %>
	<div id="main">
		<div id="login_form">

			<form action="UserLogServlet" id="login" method="post">
				<h3>旅客登录</h3><br>
				<%
				if("false".equals(request.getAttribute("loginState"))){
				%>
				<h5 style="color:red">
				账号和密码不匹配！请查证后重新登录...
				</h5><br>
				<%} %>
				<label for="username">用户名：</label><input type="text" name="username" id="username"><br><br>
				<label for="password">密&nbsp;码：</label><input type="password" name="password" id="password"><br><br>
				<input type="submit" value="登录" onclick="return checkLog()" style="margin-left:70px;"><input type="reset" value="清空" style="margin-left:50px;">
			</form>
			<label for="tip" style="margin-left:200px;font-size:0.5em;">没有账号？</label><a href="register.jsp" style="font-size:0.5em;">现在注册</a>
		</div>
	</div>
	<script type="text/javascript" src="Script/index.js"></script>
	<%@ include file="footer.jsp" %>	