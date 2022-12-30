<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="tw.com.hoogle.administrator.model.*"%>
<%@ page import="tw.com.hoogle.news.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<jsp:useBean id="administratorSvc" scope="page" class="tw.com.hoogle.administrator.model.AdministratorService"/>
<jsp:useBean id="newsSvc" scope="page" class="tw.com.hoogle.news.model.NewsService"/>
<%
AdministratorVO administratorVO = (AdministratorVO) request.getAttribute("administratorVO");
%>
<%
AdministratorVO loginAdministratorVO = (AdministratorVO)session.getAttribute("loginAdministratorVO");
Integer adminId = loginAdministratorVO.getAdministratorId();
// String adminName = loginAdministratorVO.getAdministratorName();
%>
<%
NewsVO newsVO = (NewsVO) request.getAttribute("newsVO");
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
					
					<a href="<%=request.getContextPath()%>/back_end/finStm/stmList.jsp" class="nav_link">
						<ion-icon name="stats-chart-outline" class="nav_icon"></ion-icon>
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
		

		<div class="test_radius">新增最新消息</div>
		<div class="login_mark">
			<%=account%> 登入中...
		</div>
	</div>
	
	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<b style="color: #fa9797; font-size: 8px">請修正以下錯誤：</b>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: #fa9797; font-size: 8px">${message}</li>
			</c:forEach>
		</ul>
	</c:if>
	
	
	<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/NewsServlet" name="form1" enctype="multipart/form-data">
	<div class="div_table">
	
		<table>
			<tr class="td_head">
				<td width="70">管理者編號</td>
				<td width="80">上架日期</td>
			</tr>
			
			<tr class="td_body">
				
<!-- Integer adminId = administratorVO.getAdministratorId(); -->
<!-- String adminName = administratorVO.getAdministratorName(); -->
<!-- pageContext.setAttribute("adminId", adminId); -->
<!-- pageContext.setAttribute("adminName", adminName); -->
					

			  	<td><input type="text" name="administratorId" size="2" 
			  		value="<%=adminId %>"/></td>
			  
				<td><input type="date" name="newsDate" size="10"
					value="<%=(newsVO == null) ? "" : newsVO.getNewsDate()%>" /></td>
	
			</tr>
		</table>
	
	</div>
	
	<br>

	<div class="div_table">
		<table>
			
			<%-- 	<%@ include file="page1.file" %>  --%>
			<%-- 	<c:forEach var="administratorVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>"> --%>
			<tr class="td_body" style=${newsVO.newsState==0?"color:gray;":""}>	
				<td>
<!-- 					<ion-icon name="pin" width="30px" height="30px"></ion-icon> -->
					<input type="TEXT" name="newsSubject" size="50" width="70" placeholder="請輸入主旨..."
					value="<%=(newsVO == null) ? "" : newsVO.getNewsSubject()%>" />
				</td>
				<td rowspan="2">
					<form action="/somewhere/to/upload" enctype="multipart/form-data">
	   					<input type="file" name="newsPic" onchange="readURL(this)" targetID="preview_progressbarTW_img" accept="image/*"/>
	   					<br>
	   					<img id="preview_progressbarTW_img" src="#" width="300px" height="200px"/>
					</form>
										
				</td>
			</tr>
			<tr class="td_body">
				<td>
					<textarea style="resize: none; width: 370px; height: 200px;" name="newsContent" placeholder="請輸入內容..." 
						value="<%=(newsVO == null) ? "" : newsVO.getNewsContent()%>"></textarea>
<!-- 				<input type="text" name="newsContent" size="200" -->
<%-- 					value="<%=(newsVO == null) ? "" : newsVO.getNewsContent()%>" /> --%>
				</td>

			</tr>
		</table>
	</div>
	

	<br>
	<input type="hidden" name="action" value="insert">
	<input type="submit" value="確定新增" class="input_add">
		
	</FORM>
	<%-- <%@ include file="page2.file" %> --%>
	
	<script>
	function readURL(input){
		  if(input.files && input.files[0]){
		    var imageTagID = input.getAttribute("targetID");
		    var reader = new FileReader();
		    reader.onload = function (e) {
		       var img = document.getElementById(imageTagID);
		       img.setAttribute("src", e.target.result)
		    }
		    reader.readAsDataURL(input.files[0]);
		  }
		}
	</script>

	<script src="https://unpkg.com/ionicons@5.1.2/dist/ionicons.js"></script>
	<script src="<%=request.getContextPath()%>/js/admin/admin.js"></script>
</body>
</html>