<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.administrator.model.*"%>
<%
AdministratorVO administratorVO = (AdministratorVO) request.getAttribute("administratorVO");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>HOOGLE</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin/admin.css">

</head>
<body id="body-pd">

	<div class="l-navbar style-3" id="navbar">
		<nav class="nav">
			<div>
				<div class="nav_link">
					<a href="select_page.jsp" class="nav_logo">
					<img src="<%=request.getContextPath()%>/images/whitebg_logo_small.jpg" class="pic">
					<span class="nav_name aaa">HOOGLE</span>
					</a>

				</div>
				<div class="nav_brand">
					<!-- <ion-icon name="menu-outline" class="nav_toggle" id="nav_toggle"></ion-icon> -->
					<span> <ion-icon name="menu-outline" class="nav_toggle"
							id="nav-toggle"></ion-icon> <span class="nav_ch">管理者專區</span>
					</span>
				</div>
				<div class="nav_list">
					<!-- <div class="nav_h2">管理者專區</div>  要調整字的顏色、字在縮起來時消失-->
					<div class="nav_link collapse">
						<ion-icon name="search-outline" class="nav_icon"></ion-icon>
						<span class="nav_name">查詢</span>
						<ion-icon name="chevron-down-outline" class="collapse__link"></ion-icon>
						<ul class="collapse_menu">
							<a href="#" class="collapse__sublink"><pre>飯店資料</pre></a>
							<a href="#" class="collapse__sublink"><pre>旅客資料</pre></a>
							<a href="#" class="collapse__sublink"><pre>報表</pre></a>
						</ul>
					</div>
					<div class="nav_link collapse">
						<ion-icon name="repeat-outline" class="nav_icon"></ion-icon>
						<span class="nav_name">資料異動</span>
						<ion-icon name="chevron-down-outline" class="collapse__link"></ion-icon>
						<ul class="collapse_menu">
							<a href="#" class="collapse__sublink"><pre>飯店</pre></a>
							<a href="#" class="collapse__sublink"><pre>旅客</pre></a>
						</ul>
					</div>
					<div class="nav_link collapse">
						<ion-icon name="checkmark-done-outline" class="nav_icon"></ion-icon>
						<span class="nav_name">審核</span>
						<ion-icon name="chevron-down-outline" class="collapse__link"></ion-icon>
						<ul class="collapse_menu">
							<a href="#" class="collapse__sublink"><pre>飯店註冊</pre></a>
							<a href="#" class="collapse__sublink"><pre>房間上架</pre></a>
						</ul>
					</div>
					<a href="./admin_page.jsp" class="nav_link"> <ion-icon name="people-outline"
							class="nav_icon"></ion-icon> <span class="nav_name">管理者資料</span>
					</a>
					<div class="nav_link collapse">
						<ion-icon name="mail-outline" class="nav_icon"></ion-icon>
						<span class="nav_name">系統訊息管理</span>
						<ion-icon name="chevron-down-outline" class="collapse__link"></ion-icon>
						<ul class="collapse_menu">
							<a href="#" class="collapse__sublink"><pre>飯店訊息</pre></a>
							<a href="#" class="collapse__sublink"><pre>旅客訊息</pre></a>
						</ul>
					</div>
					<a href="#" class="nav_link"> <ion-icon
							name="newspaper-outline" class="nav_icon"></ion-icon> <span
						class="nav_name">最新消息上架</span>
					</a> <a href="#" class="nav_link"> <ion-icon
							name="newspaper-outline" class="nav_icon"></ion-icon> <span
						class="nav_name">飯店設施管理</span>
					</a>
				</div>
			</div>
		</nav>
	</div>
	<div class="func_list">
		<a href="#" class="logout_link"> <ion-icon name="log-out-outline"
				class="logout_icon"></ion-icon>
		</a> <a href="#" class="logout_link"> <ion-icon
				name="notifications-outline" class="notification_icon"></ion-icon>
		</a>

		<div class="test_radius">新增管理者</div>
	</div>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post" ACTION="AdministratorServlet" name="form1">
	<div class="div_table">
		<table>
			<tr class="td_head">
				<td>管理者姓名</td>
				<td>管理者帳號</td>
				<td>管理者密碼</td>
				<td>管理者相關</td>
				<td>上下架最新消息</td>
				<td>飯店相關</td>
				<td>旅客相關</td>
				<td>雇用日期</td>
			</tr>
			<tr class="td_body">
				<td><input type="TEXT" name="administratorName" size="10"
					value="<%=(administratorVO == null) ? "" : administratorVO.getAdministratorName()%>" /></td>
				<td><input type="TEXT" name="administratorAccount" size="20"
					value="<%=(administratorVO == null) ? "" : administratorVO.getAdministratorAccount()%>" /></td>
				<td><input type="TEXT" name="administratorPassword" size="20"
					value="<%=(administratorVO == null) ? "" : administratorVO.getAdministratorPassword()%>" /></td>

				<!-- 		設定value="true"的話，有勾選會回傳boolean，否則會回傳null -->
				<td><input type="checkbox" name="administratorDominate"
					value="true" /></td>
				<td><input type="checkbox" name="newsDominate" value="true" /></td>
				<td><input type="checkbox" name="hotelDominate" value="true" /></td>
				<td><input type="checkbox" name="userDominate" value="true" /></td>
				<td><input type="date" name="administratorHiredate" size="10"
					value="<%=(administratorVO == null) ? "" : administratorVO.getAdministratorHiredate()%>"></td>
			</tr>

		</table>
	</div>
		<br> <input type="hidden" name="action" value="insert">
		
			<input type="submit" value="送出新增" class="input_add">
		
	</FORM>

	<script src="https://unpkg.com/ionicons@5.1.2/dist/ionicons.js"></script>
	<script src="<%=request.getContextPath()%>/js/admin/admin.js"></script>
</body>
</html>