<%@page import="com.baiyi.hotelsystem.bean.Home"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>酒店房间管理</title>
	<style>
		.room{
			display: inline-block;
			opacity: 0.8;
			width: 80px;
			height: 80px;
			margin: 5px;
			background-color: #CCCCCC;
			transform:rotate(3deg);
			-o-transform:rotate(3deg);
			-webkit-tranform:rotate(3
				deg);

		}
		.room:hover{
			width: 80px;
			height: 80px;
			background-color: lime;
			transform:rotate(0deg);
			-o-transform:rotate(0deg);
			-webkit-tranform:rotate(0
				deg);
			
		}
		#roomlist{
			width: 980px;
			display:inline-block;
		}
		#control{
			float: right;
			position: relative;
			background-color: #EEEEEE;
			opacity: 0.8;
			top: 0px;
			right: 20px;
			width: 250px;
			height: 490px;
		}
	</style>
	<link rel="stylesheet" href="style/style.css">
</head>
<%@ include file="header.jsp" %>
	<div id="main">
		<div id="roomlist" >
			<!--酒店房间列表，may be in 表格形式-->
			<%List<Home> homes = (List<Home>)request.getAttribute("homes");
				for(Home home:homes){			
				%><div class="room" id="<%= home.getHomeNumber() %>" <% if (home.getHomeState()==Home.HOMESTATE_BOOK||home.getHomeState()==Home.HOMESTATE_CHECKIN){ %> style="background-color:pink;"
			<%} else {%> style="background-color:#CCCCCC;" <%} %> ><%=home.getHomeNumber() %>
			</div>
			<%} %>
		</div>
		<div id="control">
			<form action="CheInSevlet" id="checkin" method="post">
				<h3 style="padding-top:20px;">入住登记</h3><br>
				<label for="name">姓&nbsp;&nbsp;名：</label><input type="text" name="username" id="name"><br><br>
				<label for="IdCard">身份证号：</label><input type="text" name="IdCard" id="IdCard" ><br><br>
				<label for="phone">电话号码：</label><input type="text" name="phone" id="phone"><br><br>
				<label for="room">房间号码：</label><input type="text" name="roomId" id="checkInId"><br><br>
				<input type="submit" value="登记" onclick="return checkIn();"  style="margin-left:80px">   <input type="reset" value="重置" style="margin-left:40px;">
			</form><br><br>
			<hr><br><br>
			<form action="CheOutServlet" id="checkout" method="post">
				<h3>退房</h3><br>
				<label for="room">房间号码：</label><input type="text" name="roomId" id="checkOutId"> <br><br>
				<input type="submit" value="退房" onclick="return checkOut();" style="margin-left:160px">  
			</form>
		</div>
	</div>
	<script type="text/javascript" src="Script/manage.js"></script>
	<script type="text/javascript">
		<%if("1"==request.getAttribute("show")){%>
			alert("<%= request.getAttribute("message")%>");
			<%request.setAttribute("show", "0");%>
		<%}%>
		var homes = new Array();
		<% 
		for(int i =0;i<homes.size();i++){
			Home home = homes.get(i);
		  %>homes[<%=i%>]= "<%=home.getHomeDescribe()%>";
		  <% }%>

		var room = document.getElementsByClassName("room");
		for (var x = 0;x<homes.length; x++) {
			(function (x) {
				room[x].onclick = function tst(){ 
				  alert(homes[x]);
			    };
			})(x);
		
		};
	</script>
	
	<%@ include file="footer.jsp" %>	