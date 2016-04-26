<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>用户注册</title>
	<style>
		table input {
			width: 200px;
		}

		table td{
			text-align: right;
			height: 30px;

		}

		#register{
			padding-top: 20px;
			height: 280px;
			width: 400px;
			opacity: 0.6;
			background-color: #FFFF00;
			margin: auto;
			position: relative;
			top: 70px;
		}
	</style>
	<link rel="stylesheet" href="style/style.css">
</head>
<%@ include file="header.jsp" %>
		<div id="main">
		<form action="RegServlet" method="post" id="register" >
		<h3 style="text-align:center">用户注册</h3>
		<table style="margin:auto;">
			<tr>
				<td>
					<label for="">账&nbsp;&nbsp;号：</label>		
				</td>
				<td>
					<input type="text" id="account" name="account" placeholder="字母或数字且开头不能为数字">
				</td>
			</tr>
			<tr>
				<td>
					<label for="password">密&nbsp;&nbsp;码：</label>
				</td>
				<td>
					<input type="password" name="password1" id="password1" placeholder="字母和数字组合">
				</td>
			</tr>
			<tr>
				<td>
					<label for="password">确认密码：</label>
				</td>
				<td>
					<input type="password" name="password2" id="password2" onkeyup="checkPsw()">
				</td>
			</tr>
			<tr>
				<td>
					<label for="">姓&nbsp;&nbsp;名：</label>	
				</td>
				<td>
					<input type="text" name="username" id="name">
				</td>
			</tr>
			<tr>
				<td>
					<label for="">联系方式：</label>
				</td>
				<td>
					<input type="text" name="phone" id="phone" placeholder="如：18390903367">		
				</td>
			</tr>
			<tr>
				<td>
					<label for="">证件号码：</label>
				</td>
				<td>
					<input type="text" name="IdCard" id="IdCard" placeholder="身份证号">
				</td>
			</tr>
		</table><br>
		<input type="submit" value="注册" onclick="return checkReg()" style="margin-left:150px">
		<input type="reset" value="重填" style="margin-left:80px">
		</form>
	</div>
	<script type="text/javascript" src="Script/register.js">
	</script>
	<%@ include file="footer.jsp" %>	