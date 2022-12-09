<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.administrator.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<jsp:useBean id="administratorSvc" scope="page" class="com.administrator.model.AdministratorService"/>
<%
// AdministratorService administratorSvc = new AdministratorService();
List<AdministratorVO> list = administratorSvc.getAll();
pageContext.setAttribute("list", list);
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
					<a href="select_page.jsp" class="nav_logo"> <img
						src="<%=request.getContextPath()%>/images/whitebg_logo_small.jpg" class="pic"> <span
						class="nav_name aaa">HOOGLE</span>
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
			<!-- <a href="#" class="nav_link">
                <ion-icon name="log-out-outline" class="nav_icon" ></ion-icon>
                <span class="nav_name">登出</span>
            </a> -->
		</nav>
	</div>
	<div class="func_list">
		<a href="#" class="logout_link"> <ion-icon name="log-out-outline"
				class="logout_icon"></ion-icon>
		</a> <a href="#" class="logout_link"> <ion-icon
				name="notifications-outline" class="notification_icon"></ion-icon>
		</a>

		<div class="test_radius">管理者列表</div>
	</div>


	<div class="features">
		<div class="features_search">
			<FORM METHOD="post" ACTION="AdministratorServlet" class="searchbyid">
				搜尋管理者
				<select size="1" name="administratorId">
					<c:forEach var="administratorVO" items="${administratorSvc.all}">
						<option value="${administratorVO.administratorId}">${administratorVO.administratorId}：${administratorVO.administratorName}
					</c:forEach>
				</select>
				<input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" class="csearchbyid" value="送出">
			</FORM>

			<a href='addAdmin.jsp' class="admin_create">新增管理者</a>

		</div>
	</div>
	<div class="div_table">
	<table>
		<tr class="td_head">
			<th>管理者編號</th>
			<th>管理者姓名</th>
			<th>管理者帳號</th>
			<!-- <th>管理者密碼</th> -->
			<th>管理者相關</th>
			<th>上下架最新消息</th>
			<th>飯店相關</th>
			<th>旅客相關</th>
			<th>雇用日期</th>
			<th>修改</th>
			<th>停權</th>
		</tr>
		<%-- 	<%@ include file="page1.file" %>  --%>
		<%-- 	<c:forEach var="administratorVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>"> --%>
		<c:forEach var="administratorVO" items="${list}">
			<tr class="td_body">
				<td>${administratorVO.administratorId}</td>
				<td>${administratorVO.administratorName}</td>
				<td>${administratorVO.administratorAccount}</td>
				<%-- 				<td>${administratorVO.administratorPassword}</td> --%>
				<td><ion-icon
						name=${(administratorVO.administratorDominate).equals(true)?"checkbox-outline":"square-outline"}></ion-icon></td>
				<td><ion-icon
						name=${(administratorVO.newsDominate).equals(true)?"checkbox-outline":"square-outline"}></ion-icon></td>
				<td><ion-icon
						name=${(administratorVO.hotelDominate).equals(true)?"checkbox-outline":"square-outline"}></ion-icon></td>
				<td><ion-icon
						name=${(administratorVO.userDominate).equals(true)?"checkbox-outline":"square-outline"}></ion-icon></td>
				<td>${administratorVO.administratorHiredate}</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/back_end/administrator/AdministratorServlet"
						style="margin-bottom: 0px;">
						<input type="submit" value="修改">
						<input type="hidden" name="administratorId" value="${administratorVO.administratorId}">
						<input type="hidden" name="action" value="getOne_For_Update">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/back_end/administrator/AdministratorServlet"
						style="margin-bottom: 0px;">
						<input type="submit" value="停權">
						<input type="hidden" name="administratorId" value="${administratorVO.administratorId}">
						<input type="hidden" name="action" value="delete">
					</FORM>
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	<%-- <%@ include file="page2.file" %> --%>

	<script src="https://unpkg.com/ionicons@5.1.2/dist/ionicons.js"></script>
	<script src="<%=request.getContextPath()%>/js/admin/admin.js"></script>
</body>
</html>