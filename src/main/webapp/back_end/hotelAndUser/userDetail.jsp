<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="tw.com.hoogle.userForBackEnd.model.*"%>
<%@ page import="tw.com.hoogle.administrator.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<jsp:useBean id="administratorSvc" scope="page" class="tw.com.hoogle.administrator.model.AdministratorService"/>
<jsp:useBean id="userForBackEndSvc" scope="page" class="tw.com.hoogle.userForBackEnd.model.UserForBackEndService"/>
<%
// AdministratorService administratorSvc = new AdministratorService();
List<UserVO> list = userForBackEndSvc.getAll();
pageContext.setAttribute("list", list);
%>
<%
UserVO userVO = (UserVO) request.getAttribute("userId");
%>
<%
String account = (String)session.getAttribute("account");
AdministratorVO permissionsVO = administratorSvc.getPermissionsByAccount(account);
pageContext.setAttribute("permissionsVO", permissionsVO);
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
					<a href="<%=request.getContextPath()%>/back_end/administrator/adminIndex.jsp" class="nav_logo"> <img
						src="<%=request.getContextPath()%>/images/logo_small_removebg.png" class="pic"> <span
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
					
					<a href="#" class="nav_link"> <ion-icon name="stats-chart-outline" class="nav_icon"></ion-icon>
						<span class="nav_name">報表查詢</span>
					</a>
					
					<div class="nav_link collapse" 
						style="display:${permissionsVO.hotelDominate==false && permissionsVO.userDominate==false?"none":""}">
						<ion-icon name="search-outline" class="nav_icon"></ion-icon>
						<span class="nav_name">飯店及旅客資訊</span>
						<ion-icon name="chevron-down-outline" class="collapse__link"></ion-icon>
						<ul class="collapse_menu">
							<div style="display:${permissionsVO.hotelDominate==true?"":"none"}">
								<a href="<%=request.getContextPath()%>/back_end/hotelAndUser/hotelList.jsp" class="collapse__sublink">
									<pre>飯店</pre>
								</a>
							</div>
							<div style="display:${permissionsVO.userDominate==true?"":"none"}">
								<a href="<%=request.getContextPath()%>/back_end/hotelAndUser/userList.jsp" class="collapse__sublink">
									<pre>旅客</pre>
								</a>
							</div>	
						</ul>
					</div>
					
<%-- 					<div class="nav_link collapse" style="display:${permissionsVO.hotelDominate==true?"":"none"}"> --%>
<!-- 						<ion-icon name="checkmark-done-outline" class="nav_icon"></ion-icon> -->
<!-- 						<span class="nav_name">審核飯店</span> -->
<!-- 						<ion-icon name="chevron-down-outline" class="collapse__link"></ion-icon> -->
<!-- 						<ul class="collapse_menu"> -->
<%-- 							<a href="<%=request.getContextPath()%>/back_end/approval/approveRegisterHotel.jsp" class="collapse__sublink"> --%>
<!-- 								<pre>飯店註冊</pre> -->
<!-- 							</a> -->
<!-- 							<a href="#" class="collapse__sublink"> -->
<!-- 								<pre>房間上架</pre> -->
<!-- 							</a> -->
<!-- 						</ul> -->
<!-- 					</div> -->
					<div style="display:${permissionsVO.hotelDominate==true?"":"none"}">
						<a href="<%=request.getContextPath()%>/back_end/approval/approveRegisterHotel.jsp" 
							class="nav_link">
							<ion-icon name="checkmark-done-outline" class="nav_icon"></ion-icon>
							<span class="nav_name">審核飯店</span>
						</a>
					</div>
					
					<div style="display:${permissionsVO.administratorDominate==true?"":"none"}">
						<a href="<%=request.getContextPath()%>/back_end/administrator/admin_page.jsp" 
							class="nav_link">
							<ion-icon name="people-outline" class="nav_icon"></ion-icon>
							<span class="nav_name">管理者資料</span>
						</a>
					</div>
					
<!-- 					<div class="nav_link collapse"  -->
<%-- 						style="display:${permissionsVO.hotelDominate==false && permissionsVO.userDominate==false?"none":""}"> --%>
<!-- 						<ion-icon name="mail-outline" class="nav_icon"></ion-icon> -->
<!-- 						<span class="nav_name">系統訊息管理</span> -->
<!-- 						<ion-icon name="chevron-down-outline" class="collapse__link"></ion-icon> -->
<!-- 						<ul class="collapse_menu"> -->
<%-- 							<div style="display:${permissionsVO.hotelDominate==true?"":"none"}"> --%>
<!-- 								<a href="#" class="collapse__sublink"><pre>飯店訊息</pre></a> -->
<!-- 							</div> -->
<%-- 							<div style="display:${permissionsVO.userDominate==true?"":"none"}"> --%>
<!-- 								<a href="#" class="collapse__sublink"><pre>旅客訊息</pre></a> -->
<!-- 							</div> -->
<!-- 						</ul> -->
<!-- 					</div> -->
					
					<div style="display:${permissionsVO.newsDominate==true?"":"none"}">
						<a href="<%=request.getContextPath()%>/back_end/news/newsList.jsp" class="nav_link">
							<ion-icon name="newspaper-outline" class="nav_icon"></ion-icon>
							<span class="nav_name">最新消息管理</span>
						</a>
					</div>
										
				</div>
			</div>
		</nav>
	</div>
	
	<div class="func_list">

		<a href="<%=request.getContextPath()%>/AdministratorServlet?action=logout" class="logout_link">
 			<ion-icon name="log-out-outline" class="logout_icon"></ion-icon>
 			<label class="logout_text">登出</label>
 		</a>
<%-- 		<form href="<%=request.getContextPath()%>/AdministratorServlet" class="logout_link"> --%>
<!-- 			<input id="logout_icon" type="hidden" name="action" value="logout"> -->
<!-- 			<ion-icon type="submit" for="logout_icon" name="log-out-outline" class="logout_icon"> -->
<!-- 			</ion-icon> -->
<!-- 		</form> -->
		
<!-- 		<a href="#" class="logout_link"> -->
<!-- 			<ion-icon name="notifications-outline" class="notification_icon"></ion-icon> -->
<!-- 		</a> -->
		

		<div class="test_radius">旅客詳細資料</div>
		<div class="login_mark">
			<%=account%> 登入中...
		</div>
	</div>


	<div class="features">
		<div class="features_search">
			<FORM METHOD="post" ACTION="UserForBackEndServlet" class="searchbyid">
				搜尋旅客
				<select size="1" name="userId">
					<c:forEach var="userVO" items="${userForBackEndSvc.all}">
						<option value="${userVO.userId}">${userVO.userId}：${userVO.userName}
					</c:forEach>
				</select>
				<input type="hidden" name="action" value="getOne_For_User">
				<input type="submit" class="csearchbyid" value="送出">
			</FORM>
		</div>
	</div>
	<div class="div_table">
	<table>
		<tr class="td_head">
			<th width="20">旅客<br>編號</th>
			<th width="50">旅客信箱</th>
			<th width="50">旅客密碼</th>
			<th width="30">旅客姓名</th>
			<th width="40">旅客電話</th>
			<th width="40">旅客身分證</th>
			<th width="22">旅客<br>生日</th>
			<th width="22">旅客<br>註冊日</th>
			<th width="20">訂單<br>查詢</th>
		</tr>
		<tr class="td_body">
			<td>${userVO.userId}</td>
			<td>${userVO.userEmail}</td>
			<td>${userVO.userPassword}</td>
			<td>${userVO.userName}</td>
			<td>${userVO.userPhone}</td>
			<td>${userVO.userIdentity}</td>
			<td>${userVO.userBirthday}</td>
			<td>${userVO.userRegistration}</td>
			<td>
				<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/OrdForBackEndServlet" class="">
					<input type="hidden" name="action" value="getOne_For_Display">
					<input type="hidden" name="userId" value="${userVO.userId}">
					<input type="submit" value="訂單">
				</FORM>
			</td>

<!-- 					<FORM METHOD="post"	ACTION="AdministratorServlet" style="margin-bottom: 0px;"> -->
<!-- 						<input type="submit" value="修改" -->
<%-- 						${(administratorVO.administratorDominate==false &&  --%>
<%-- 						administratorVO.newsDominate==false &&  --%>
<%-- 						administratorVO.hotelDominate==false &&  --%>
<%-- 						administratorVO.userDominate==false)?"disabled":""}> --%>
<%-- 						<input type="hidden" name="administratorId" value="${administratorVO.administratorId}"> --%>
<!-- 						<input type="hidden" name="action" value="getOne_For_Update"> -->
<!-- 					</FORM> -->
<!-- 				</td> -->
<!-- 				<td> -->
<!-- 					<FORM METHOD="post"	ACTION="AdministratorServlet" style="margin-bottom: 0px;"> -->
<!-- 						<input type="submit" value="停權" -->
<%-- 						${(administratorVO.administratorDominate==false &&  --%>
<%-- 						administratorVO.newsDominate==false &&  --%>
<%-- 						administratorVO.hotelDominate==false &&  --%>
<%-- 						administratorVO.userDominate==false)?"disabled":""}> --%>
<%-- 						<input type="hidden" name="administratorId" value="${administratorVO.administratorId}"> --%>
<!-- 						<input type="hidden" name="action" value="disable"> -->
<!-- 					</FORM> -->
<!-- 				</td> -->
		</tr>
	</table>
</div>
	<%-- <%@ include file="page2.file" %> --%>

	<script src="https://unpkg.com/ionicons@5.1.2/dist/ionicons.js"></script>
	<script src="<%=request.getContextPath()%>/js/admin/admin.js"></script>
</body>
</html>