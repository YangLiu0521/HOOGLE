<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.food.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
  //FoodVO foodVO = (FoodVO) request.getAttribute("foodVO"); //FoodServlet.java(Concroller), 存入req的foodVO物件
%>

<html>
<head>
<title>員工資料 - listOneFood.jsp</title>

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
	width: 600px;
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
	<tr><td>
		 <h3>美食資料 - ListOneFood.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/architecture-2256489__340.jp" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>美食照片編號</th>
		<th>餐廳編號</th>
		<th>美食照片</th>
		<th>美食名稱</th>
	</tr>
	<tr>
		<td>${foodVO.foodPicid}</td>
			<td>${foodVO.restaurantId}</td>
			<td>${foodVO.foodPic}</td>
			<td>${foodVO.foodName}</td>
	</tr>
</table>

</body>
</html>