<%@page import="com.baiyi.hotelsystem.bean.Home"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>房间预订</title>
	<link rel="stylesheet" href="style/style.css">
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
			width: 90px;
			height: 90px;
			margin: 0px;
			transform:rotate(0deg);
			-o-transform:rotate(0deg);
			-webkit-tranform:rotate(0deg);	
			background-color: green;
		}
		#roomlist{
			width: 980px;
			display:inline-block;
		}
		#order{
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
</head>
<%@ include file="header.jsp" %>
	<div id="main">
		<div id="roomlist" >
			<!--酒店房间列表，may be in 表格形式-->
			<% List<Home> homes = (List<Home>)request.getAttribute("homes");
				for(Home home:homes){
			%><div class="room" id="<%= home.getHomeNumber() %>" <% if (home.getHomeState()==Home.HOMESTATE_BOOK||home.getHomeState()==Home.HOMESTATE_CHECKIN){ %> style="background-color:pink;"
			<%} else {%> style="background-color:#CCCCCC;" <%} %> ><%=home.getHomeNumber() %>
			</div>
			<%} %>
		</div>
		<div id="order">
			<form action="OrderServlet" id="order" method="post">
				<h3 style="padding-top:100px; text-align:center;">房间预订</h3><br>
				<label for="room" style="padding-left:10px;">房间号码：</label><input type="text" name="roomId" id="roomId"><br><br>
				<input type="submit" value="预订" onclick="return checkOrder()" style="margin-left:200px">  
			</form>
		</div>
		
	</div>
		
	<script type="text/javascript" src="Script/order.js"></script>
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
