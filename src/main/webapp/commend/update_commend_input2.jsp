<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.commend.model.*"%>

<%
  CommendVO commendVO = (CommendVO) request.getAttribute("commendVO"); //CommendServlet.java (Concroller) 存入req的commendVO物件 (包括幫忙取出的commendVO, 也包括輸入資料錯誤時的commendVO物件)
%>
<%-- --<%= commendVO==null %>--${commendVo.commendAuto}-- --%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>評價資料修改 - update_commend_input.jsp</title>

<style>
  table#table-1 {<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.commend.model.*"%>	
<%
  CommendVO commendVO = (CommendVO) request.getAttribute("commendVO");
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0" /> -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/commend/commend.css" />
<title>住宿經驗評價</title>
</head>
<body>
	<FORM METHOD="post" ACTION="commend.do" name="form1">
		<!--header upper start-->
		<header class="header">
			<div class="header-up-bar">住宿經驗評價</div>
		</header>
		<!--header upper end-->
		<!-- 評價編號&訂單編號開始 -->
		<div class="commend">
			<div class="commendAutoAndOrdId">
				<!--         <div class="commendAuto"> -->
				<!--           <h2>評價編號:</h2> -->
				<%--           <p>${commendVO.commendAuto}</p> --%>
				<!--         </div> -->

				<div class="ordId">
					<h2>訂單編號:</h2>
					<input  type="TEXT" class="ordId" name="ordId" value="${commendVO.ordId}" />
				</div>
			</div>
			<!-- 評價編號&訂單編號結束 -->
			<!-- 評價等級開始 -->
			<div class="commendGrade">
				<div>
					<h2>評價等級:</h2>
				</div>
<!-- 				<input type="TEXT" name="commendGrade" size="45"  -->
<%-- 					value="<%=commendVO == null? "" : commendVO.getCommendGrade()%>" /> --%>
				<div id="stars" class="left">
					<img name="1" src="<%=request.getContextPath()%>/images/commend/ostar.png" alt="" /> 
					<img name="2" src="<%=request.getContextPath()%>/images/commend/ostar.png" alt="" /> 
					<img name="3" src="<%=request.getContextPath()%>/images/commend/ostar.png" alt="" /> 
					<img name="4" src="<%=request.getContextPath()%>/images/commend/ostar.png" alt="" /> 
					<img name="5" src="<%=request.getContextPath()%>/images/commend/ostar.png" alt="" />
				</div>
			</div>
			<!-- 評價等級結束 -->
			<!-- 評價內容開始 -->
			<div>
				<div class="commendContent">
					<h2>評價內容:</h2>
					<textarea name="commendContent" id="commendContent"></textarea>
				</div>
			</div>
			<!-- 評價內容結束 -->
			<!-- 評價日期開始 -->
			<div class="commendDate">
				<!-- <h2>評價日期：</h2> -->
				<!--         <div class="dateandsubmit"> -->
				<!-- <input id="date" type="Date" value="${commendVO.commendAuto}" /> -->
				<input type="hidden" name="action" value="insert"> <input
					id="submit" type="submit" value="送出評價" />
				<!--         </div> -->
			</div>
			<!-- 評價日期結束 -->
		</div>
	</FORM>
	<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>
	<%--     <script src="<%=request.getContextPath()%>/js/commend/commend.js"></script> --%>
	<script>
	//製作一個星星評分
	var divStars = document.getElementById("stars");
	var divComment = document.getElementById("comment");
	//   var attitude = ["差", "較差", "一般", "好", "很好"];
	var starNum = -1; //記錄當前第幾顆星星被點擊
	var starArray = Array.from(divStars.children); //星星數組

	//滑鼠移入
	divStars.onmouseover = function (e) {
	  if (e.target.tagName === "IMG") {
	    //事件源是圖片
	    //把滑鼠移動到的星星替換圖片
	    e.target.src="<%=request.getContextPath()%>/images/commend/star.png";
	    //把滑鼠移動到的星星之前的星星替換圖片
	    var prev = e.target.previousElementSibling;
	    while (prev) {
	      prev.src="<%=request.getContextPath()%>/images/commend/star.png";
	      prev = prev.previousElementSibling;
	    }
	    //把滑鼠移動到的星星之後的星星替換圖片
	    var next = e.target.nextElementSibling;
	    while (next) {
	      //把滑鼠移動到的星星之後的星星替換圖片
	      next.src="<%=request.getContextPath()%>/images/commend/ostar.png";
	      next = next.nextElementSibling;
	    }

	    var index = starArray.indexOf(e.target); //找到滑鼠移動到的星星的序號
	    divComment.innerHTML = attitude[index]; //顯示對應的評論
	  }
	};

	//滑鼠點擊
	divStars.onclick = function (e) {
	  if (e.target.tagName === "IMG") {
	    //記錄當前點擊的星星序號
	    starNum = starArray.indexOf(e.target);
	  }
	};

	//滑鼠移出
	divStars.onmouseout = function (e) {
	  if (starNum !== -1) {
	    //滑鼠點擊事件發生，將評分固定在點擊的星星上
	    for (var i = 0; i < divStars.children.length; i++) {
	      if (i <= starNum) {
	        divStars.children[i].src="<%=request.getContextPath()%>/images/commend/star.png";
	      } else {
	        divStars.children[i].src="<%=request.getContextPath()%>/images/commend/ostar.png";
	      }
	    }
	    divComment.innerHTML = attitude[starNum]; //顯示對應的評論
	  } else {
	    for (var i = 0; i < divStars.children.length; i++) {
	      divStars.children[i].src="<%=request.getContextPath()%>/images/commend/ostar.png";
	    }
	    divComment.innerHTML = ""; //不顯示評論
	  }
	};

	</script>
</body>
</html>
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
	width: 800px;
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
	<tr><td>
		 <h3>評價資料修改  - update_commend_input.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="img/logo.jpg" width="100" height="100" border="0">回首頁</a></h4>
	</td></tr>
</table>

<h3>資料修改:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="commend.do" name="form1">
<table>
	<tr>
		<td>評價編號:</td>
		<td>${commendVO.commendAuto}</td>
	</tr>
	<tr>
		<td>訂單編號:</td>
		<td><input type="TEXT" name="ordId" size="45" value="${commendVO.ordId}"/></td>
	</tr>
	<tr>
		<td>評價等級:</td>
		<td><input type="TEXT" name="commendGrade" size="45" value="${commendVO.commendGrade}" /></td>
	</tr>
	<tr>
		<td>評價內容:</td>
		<td><input type="TEXT" name="commendContent" size="100"	value="${commendVO.commendContent}" /></td>
	</tr>
	<tr>
		<td>評價日期：</td>
		<td><input type="Date" name="commendDate" size="20" value="${commendVO.commendDate}"></td>
	</tr>
	
</table>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="commendAuto" value="${commendVO.commendAuto}">
<input type="submit" value="送出修改"></FORM>


</body>

</html>