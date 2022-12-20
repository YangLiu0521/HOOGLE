<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ page --%>
<%-- import="com.commend.model.*"%> <% CommendVO commendVO = (CommendVO) --%>
<%-- request.getAttribute("commendVO"); %> --%>
<!DOCTYPE html>
<html lang="zh-TW">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>比較您的選擇</title>

<%@ include file="/header.jsp"%>


<style>
p#detail {
	height: 600px;
	width: 80%;
	background: lightgray;
	margin-inline: auto;
	overflow-x: hidden;
	overflow-y: scroll;
	font-size: 20px;
	white-space: pre-wrap;
	font-weight: bolder;
}
textarea.type {
	display: inline-block;
	margin: 10px 20px 20px 20px;
	width: calc(( 100% - 132px)/3);
	font-size: 20px;
	border: 2px solid black;
	background-color: lightblue;
	text-rendering: auto;
}
</style>
</head>
<body>


	<!-- 搜尋日期房型 開始 -->

	<!-- 	<div class="center-search"> -->
	<!-- 		<h1 class="text-white">Enjoy Your Holiday</h1> -->
	<!-- 		<p class="text-white">Search and Book Hotel</p> -->
	<!-- 		<form class="form-style-1"> -->

	<!-- 			<div class="row"> -->
	<!-- 				<div class="col-lg-6 col-md-6 col-sm-6 col-6 checkin"> -->
	<!-- 					<div class="form-group"> -->
	<!-- 						<input type="text" class="form-control" id="check-in" -->
	<!-- 							placeholder="Check In"> -->
	<!-- 					</div> -->
	<!-- 				</div> -->
	<!-- 				<div class="col-lg-6 col-md-6 col-sm-6 col-6 checkout"> -->
	<!-- 					<div class="form-group"> -->
	<!-- 						<input type="text" class="form-control" id="check-out" -->
	<!-- 							placeholder="Check Out"> -->
	<!-- 					</div> -->
	<!-- 				</div> -->
	<!-- 			</div> -->

	<!-- 			<button type="submit" class="btn-style-1 w-100">Search</button> -->
	<!-- 		</form> -->
	<!-- 	</div> -->
	<!-- 搜尋日期房型 結束 -->

	<!-- 比較數量 開始 -->
	<div class="blog-area pt-70 pb-40 position-relative">
		<div class="bg-style-1"></div>
		<div class="container">
			<!-- section title -->
			<div class="section-title text-center"></div>
			<!-- section title -->
			<div class="row">
				<div class="col-lg-4 col-md-6 mb-30">
					<!-- blog box -->
					<div class="blog-box shadow1">
						<div class="blog_img mb-20">
							<img
								src="<%=request.getContextPath()%>/images/compare/blog/blog-1.jpg"
								alt="" />
						</div>
						<div class="blog-des">
							<div class="form-group">
								<select class="form-control">
									<option>飯店名稱</option>
									<option>hotle1</option>
									<option>hotle2</option>
									<option>hotle3</option>
								</select> <select class="form-control">
									<option>房型</option>
									<option>雙人房</option>
									<option>四人房</option>
									<option>六人房</option>
								</select>
								<p>價格：</p>
								<p class="price1" type="text" value="取得房間價格，要改標籤"></p>
							</div>
							<!-- 							<button type="submit" class="btn-style-1">立即下訂</button> -->
							<button type="submit" id="detail1" class="btn-style-1">查看詳情</button>
							<!-- <input id="Mybutton" style="margin-left:230px;margin-bottom:0px" type=button color="red" value="下訂" οnclick="window.open('sub1.html')"> -->
						</div>
					</div>
					<!-- blog box end -->
				</div>
				<div class="col-lg-4 col-md-6 mb-30">
					<!-- blog box -->
					<div class="blog-box shadow2">
						<div class="blog_img mb-20">
							<img
								src="<%=request.getContextPath()%>/images/compare/blog/blog-1.jpg"
								alt="" />
						</div>
						<div class="blog-des">
							<div class="form-group">
								<select class="form-control">
									<option>房型</option>
									<option>雙人房</option>
									<option>四人房</option>
									<option>六人房</option>
								</select>
								<p>價格：</p>
								<p class="price1" type="text" value="取得房間價格，要改標籤"></p>
							</div>
							<button type="submit" class="btn-style-1">立即下訂</button>
							<button type="submit" id="detail2" class="btn-style-1">查看詳情</button>
							<!-- <input id="Mybutton" style="margin-left:230px;margin-bottom:0px" type=button color="red" value="下訂" οnclick="window.open('sub1.html')"> -->
						</div>
					</div>
					<!-- blog box end -->
				</div>
				<div class="col-lg-4 col-md-6 mb-30">
					<!-- blog box -->
					<div class="blog-box shadow3">
						<div class="blog_img mb-20">
							<img
								src="<%=request.getContextPath()%>/images/compare/blog/blog-1.jpg"
								alt="" />
						</div>
						<div class="blog-des">
							<div class="form-group">
								<select class="form-control">
									<option>房型</option>
									<option>雙人房</option>
									<option>四人房</option>
									<option>六人房</option>
								</select>
								<p>價格：</p>
								<p class="price1" type="text" value="取得房間價格，要改標籤"></p>
							</div>
							<button type="submit" class="btn-style-1">立即下訂</button>
							<button type="submit" id="detail3" class="btn-style-1">查看詳情</button>
							<!-- <input id="Mybutton" style="margin-left:230px;margin-bottom:0px" type=button color="red" value="下訂" οnclick="window.open('sub1.html')"> -->
						</div>
					</div>
					<!-- blog box end -->


				</div>
			</div>
		</div>
	</div>
	<!-- 比較數量 結束 -->

	<!-- 介紹內文 開始 -->
	<div class="detail">
		<p id="detail" style="word-wrap: break-word;">這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸
		這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸
		這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸
		這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸
		這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸
		這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸
		這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸
		這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸
		這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸
		這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸
		這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸
		這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸
		這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸
		這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸
		這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸
		這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸
		這裡的內容來自於上面三個"查看詳情"，且內容過多會有卷軸</p>
	</div>
	<!-- <textarea class="detila" name="mytext"  placeholder="飯店介紹" readonly></textarea> -->
	<!-- 介紹內文 結束 -->

	<!-- 自助黏貼區 開始 -->
	<!-- blog box -->
	<div class="self-typying">
		<div class="typ1">
			<textarea class="type" name="mytext" rows="20" cols="35"
				placeholder="此處可輸入或貼上內容"></textarea>
			<textarea class="type" name="mytext" rows="20" cols="35"
				placeholder="此處可輸入或貼上內容"></textarea>
			<textarea class="type" name="mytext" rows="20" cols="35"
				placeholder="此處可輸入或貼上內容"></textarea>
		</div>
	</div>
	<!-- blog box end -->
	<!-- 自助黏貼區 結束 -->


	<!-- js files -->
	
	<%@ include file="/footer.jsp"%>
</body>
</html>
