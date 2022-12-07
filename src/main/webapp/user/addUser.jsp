<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.user.model.*"%>
<%
UserVO userVO = (UserVO) request.getAttribute("userVO");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>旅客新增 - addUser.jsp</title>

<style>
table#table-1 {
	background-color: #CCCCFF;
	border: 2px solid black;
	text-align: center;
}

table#table-1 h4 {
	color: red;
	display: block;
	margin-bottom: 1px;
}

h4 {
	color: blue;
	display: inline;
}
</style>

<style>
table {
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
}

table, th, td {
	border: 0px solid #CCCCFF;
}

th, td {
	padding: 1px;
}
</style>
</head>
<body bgcolor='white'>
	<table id="table-1">
		<tr>
			<td>
				<h2>旅客新增 - addUser.jsp</h2>
				<h3>
					<a href="select_page.jsp">回首頁</a>
				</h3>
			</td>
		</tr>
	</table>

	<h3>資料新增:</h3>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

<FORM METHOD="post" ACTION="UserServlet" name="form1">
<table>
	<tr>
		<td>旅客信箱：</td>
		<td><input type="text" name="userEmail" size="45"
			value="<%= (userVO == null)? "" : userVO.getUserEmail() %>"></td>
	</tr>
	<tr>
		<td>旅客密碼：</td>
		<td><input type="password" name="userPassword" size="20"
			value="<%= (userVO == null)? "" : userVO.getUserPassword() %>"></td>
	</tr>
	<tr>
		<td>旅客姓名：</td>
		<td><input type="text" name="userName" size="10"
			value="<%= (userVO == null)? "" : userVO.getUserName() %>"></td>
	</tr>
	<tr>
		<td>旅客電話：</td>
		<td><input type="text" name="userPhone" size="10"
			value="<%= (userVO == null)? "" : userVO.getUserPhone() %>"></td>
	</tr>
	<tr>
		<td>旅客身分證：</td>
		<td><input type="text" name="userIdentity" size="10"
			value="<%= (userVO == null)? "" : userVO.getUserIdentity() %>"></td>
	</tr>
	<tr>
		<td>旅客生日：</td>
		<td><input type="date" name="userBirthday" size="10"
			value="<%= (userVO == null)? "" : userVO.getUserBirthday() %>"></td>
	</tr>
	<tr>
		<td>旅客註冊日：</td>
		<td><input type="date" name="userRegistration" size="10"
			value="<%= (userVO == null)? "" : userVO.getUserRegistration() %>"></td>
	</tr>
</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增">
</FORM>
</body>
</html>