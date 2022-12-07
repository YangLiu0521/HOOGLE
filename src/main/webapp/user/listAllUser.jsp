<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.user.model.*"%>

<%
UserService userSvc = new UserService();
List<UserVO> list = userSvc.getAll();
pageContext.setAttribute("list", list);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>旅客資料列表 - listAllUser</title>
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
	width: 1000px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
}

table, th, td {
	border: 1px solid #CCCCFF;
}

th, td {
	padding: 5px;
	text-align: center;
}
</style>
</head>
<body bgcolor='white'>

	<table id="table-1">
		<tr>
			<td>
				<h2>所有旅客資料 - listAllUser.jsp</h2>
				<h3>
					<a href="select_page.jsp">回首頁</a>
				</h3>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>旅客編號</th>
			<th>旅客信箱</th>
			<th>旅客密碼</th>
			<th>旅客姓名</th>
			<th>旅客電話</th>
			<th>旅客身分證</th>
			<th>旅客生日</th>
			<th>旅客註冊日</th>
		</tr>


		<c:forEach var="userVO" items="${list}">
			<tr>
				<td>${userVO.userId}</td>
				<td>${userVO.userEmail}</td>
				<td>${userVO.userPassword}</td>
				<td>${userVO.userName}</td>
				<td>${userVO.userPhone}</td>
				<td>${userVO.userIdentity}</td>
				<td>${userVO.userBirthday}</td>
				<td>${userVO.userRegistration}</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/user/UserServlet"
						style="margin-bottom: 0px;">
						<input type="submit" value="修改"> <input type="hidden"
							name="userId" value="${userVO.userId}"> <input
							type="hidden" name="action" value="getOne_For_Update">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/user/UserServlet"
						style="margin-bottom: 0px;">
						<input type="submit" value="刪除"> <input type="hidden"
							name="userId" value="${userVO.userId}"> <input
							type="hidden" name="action" value="delete">
					</FORM>
				</td>
			</tr>
		</c:forEach>
	</table>



</body>
</html>