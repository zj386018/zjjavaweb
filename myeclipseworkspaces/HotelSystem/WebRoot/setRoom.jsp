<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>房间参数设置</title>
	<link rel="stylesheet" href="style/style.css">
</head>
<%@ include file="header.jsp" %>
	<div id="main">
		<!-- there is something show to the people who view this page-->
		<!--and there must be have the login form-->
		<!--and there must have a link tag to link the page of the order rooms-->
		<!--and is like this-->
		<form action="#" style="text-align:center;">
			输入房间号：<input type="text">
			<input type="submit" value="查询">	<br><br><br>
			<hr>
			<br>
		</form>
		<form action="#" id="update" method="post" style="margin-left:500px;">
			房间编号：<input type="text"><br><br>
			价&nbsp;&nbsp;格: <input type="text"><br><br>
			状&nbsp;&nbsp;态：<input type="text"><br><br>
			房间描述：<br> <textarea name="description" id="descriotion" cols="12" rows="3" style="width:300px;"></textarea>	<br><br>
			<input type="submit" value="更新" style="margin-left:250px;">		
		</form>
		
	</div>
	<%@ include file="footer.jsp" %>	