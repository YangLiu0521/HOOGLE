<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="tw.com.hoogle.hotel.model.*"%>
<%@ page import="java.util.*"%>
<%
if (session.getAttribute("userVO") == null && session.getAttribute("hotelVO") == null) {
	RequestDispatcher dispatcher = request.getRequestDispatcher("/HOOGLE/index.jsp");
	dispatcher.forward(request, response);
	return;
} else if (session.getAttribute("userVO") != null) {
	RequestDispatcher dispatcher = request.getRequestDispatcher("/hotel/hotelMemberCenter.jsp");
	dispatcher.forward(request, response);
	return;
}
HotelVO hotelVO = (HotelVO) request.getSession().getAttribute("hotelVO"); //UserServlet.java(Controller)
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>hotelMemberCenter</title>
<!-- favicon -->
<link rel="icon" href="favicon.ico" />
<!-- bootstrap core CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<!-- font awesome -->
<link href="<%=request.getContextPath()%>/css/all.min.css"
	rel="stylesheet">
<!-- owl carousel -->
<link href="<%=request.getContextPath()%>/css/owl.carousel.min.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/owl.theme.default.min.css"
	rel="stylesheet">
<!-- venobox css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/venobox.css">
<!-- datepicker css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/datepicker.min.css">
<!-- custom styles for this template -->
<link href="<%=request.getContextPath()%>/css/custom.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/responsive.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/helper.css"
	rel="stylesheet">
</head>
<body>
	<!-- ================ Header ================ -->
	<header class="header">
		<!-- header upper -->
		<div class="header-upper-bar">
			<div class="container">
				<div class="row d-flex align-items-center">
					<div class="col-lg-8 col-md-6 col-sm-4 col-2">
						<!-- header navigation -->
						<nav class="navbar header-navigation navbar-expand-lg p-0">
							<!-- mobile Toggle 手機切換 -->
							<button class="navbar-toggler" type="button"
								data-toggle="collapse" data-target="#navbarTheme"
								aria-controls="navbarTheme" aria-expanded="false"
								aria-label="Toggle navigation">
								<span></span> <span></span> <span></span>
							</button>
							<!-- mobile toggle end -->
							<!-- top Menu -->
							<div class="collapse navbar-collapse" id="navbarTheme">
								<ul class="navbar-nav align-items-start align-items-lg-center">
									<li class="active"><a class="nav-link" href="/HOOGLE/index.jsp">首頁</a></li>
									<li><a class="nav-link" href="/HOOGLE/index.jsp">比價</a></li>
									<li><a class="nav-link" href="/HOOGLE/index.jsp">美食</a></li>
									<!-- <li><a class="nav-link" href="gallery.html">畫廊</a></li> -->
									<!-- <li class="nav-item dropdown"> <a class="nav-link dropdown-toggle" href="#" id="dropdown02" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Destinations</a>
                  <div class="dropdown-menu" aria-labelledby="dropdown02"> <a class="dropdown-item" href="destinations.html">Destinations</a> <a class="dropdown-item" href="destination-detail.html">Destination Detail</a> </div>
                </li> -->
									<li class="nav-item dropdown"><a
										class="nav-link dropdown-toggle" href="#" id="dropdown04"
										data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">關於我們</a>
										<div class="dropdown-menu" aria-labelledby="dropdown04">
											<a class="dropdown-item" href="about.html">關於我們</a> <a
												class="dropdown-item" href="blog-single.html">常見問題</a> <a
												class="dropdown-item" href="blog-single.html">聯絡我們</a> <a
												class="dropdown-item" href="blog-single.html">服務條款</a>
										</div></li>
									<!-- <li class="nav-item dropdown"> <a class="nav-link dropdown-toggle" href="#" id="dropdown05" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Pages</a>
                  <div class="dropdown-menu" aria-labelledby="dropdown05"> <a class="dropdown-item" href="listing.html">Hotel Listing</a> <a class="dropdown-item" href="hotel-detail.html">Hotel Detail</a> <a class="dropdown-item" href="signin.html">Login</a> <a class="dropdown-item" href="register.html">Register</a> <a class="dropdown-item" href="team.html">Team</a> <a class="dropdown-item" href="testimonial.html">Testimonial</a> <a class="dropdown-item" href="traveler-information.html">Traveler Information</a> <a class="dropdown-item" href="payment-information.html">Payment Information</a> <a class="dropdown-item" href="faq.html">Faq</a> </div>
                </li> -->
									<!-- <li><a class="nav-link" href="contact-us.html">Contact Us</a></li> -->
								</ul>
							</div>
							<!-- top menu end -->
						</nav>
						<!-- header navigation end -->
					</div>
					<div class="col-lg-4 col-md-6 col-sm-8 col-10 text-right">
						<!-- header right link -->
						<div class="header-right-link" id="header">
							<ul>

							</ul>
						</div>
						<!-- header right link end -->
					</div>
				</div>
			</div>
		</div>
		<!-- header upper end -->
		<!-- ================ Inner banner ================ -->
		<div class="inner-banner inner-banner-bg pt-70 pb-40">
			<div class="container">
				<div class="row align-items-center">
					<div class="col-lg-8 col-md-8 mb-30">
						<!-- page-title -->
						<div class="page-title">
							<h1>飯店會員中心</h1>
						</div>
						<!-- page-title end -->
					</div>
					<div class="col-lg-4 col-md-4 mb-30">
						<!-- breadcrumb -->
						<ol class="breadcrumb mb-0">
							<li class="breadcrumb-item"><a href="/HOOGLE/index.jsp">Home</a></li>
							<li class="breadcrumb-item active">Register</li>
						</ol>
						<!-- breadcrumb end -->
					</div>
				</div>
			</div>
		</div>
		<br> <br>

		<!-- ================ memberCenter page ================ -->
		<!-- My Account Start -->
		<div class="my-account">
			<div class="container">
				<div class="row">
					<div class="col-lg-3" id="">
						<aside class="faqsidelink">
							<div>
								<ul class="nav flex-column nav-pills" role="tablist"
									aria-orientation="vertical">
									<li class="nav-item"><a class="nav-link active"
										id="account-nav" data-toggle="pill" href="#account-tab"
										role="tab"><i class="fa fa-user"></i> 資料修改</a></li>
									<li class="nav-item"><a class="nav-link"
										id="introduce-nav" data-toggle="pill" href="#introduce-tab"
										role="tab"><i class="fa fa-shopping-bag"></i> 飯店介紹</a></li>
									<li class="nav-item"><a class="nav-link" id="room-nav"
										data-toggle="pill" href="#room-tab" role="tab"><i
											class="fa fa-credit-card"></i> 房間管理</a></li>
									<li class="nav-item"><a class="nav-link" id="orders-nav"
										data-toggle="pill" href="#orders-tab" role="tab"><i
											class="fa fa-map-marker-alt"></i> 我的報表</a></li>
									<li class="nav-item" id="Signout"><a class="nav-link"><i
											class="fa fa-sign-out-alt"></i> 登出</a></li>
								</ul>
							</div>
						</aside>
					</div>
					<div class="col-md-9">
						<div class="tab-content">
							<div class="tab-pane fade show active" id="account-tab"
								role="tabpanel" aria-labelledby="account-nav">

								<!-- tabs -->
								<div class="detail-tabs mb-30">
									<ul class="nav nav-tabs nav-pills nav-justified" id="myTab"
										role="tablist">
										<li class="nav-item"><a class="nav-link active"
											id="tab1-tab" data-toggle="tab" href="#tab1" role="tab"
											aria-controls="tab1" aria-selected="true">資料修改</a></li>
									</ul>
									<!-- 飯店資料修改開始 -->
									<form action="HotelServlet" method="POST" enctype="multipart/form-data">
										<div class="tab-content" id="myTabContent">
											<div class="tab-pane fade show active p-15" id="tab1"
												role="tabpanel" aria-labelledby="tab1-tab">
												<h4 class="mb-6">飯店基本資料</h4>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span
													class="dashed-border"></span>

												<div class="form-group">
													<h6>信箱</h6>
													<br> <input type="email" class="form-control" disabled name="hotelEmail"
														value="<%=(hotelVO == null) ? "" : hotelVO.getHotelEmail()%>">
												</div>


												<div class="form-group">
													<h6>名稱</h6>
													<br> <input type="text" class="form-control" name="hotelName"
														value="<%=(hotelVO == null) ? "" : hotelVO.getHotelName()%>">
														<span class="error" style="color: red">${errors.hotelName}</span>
												</div>


												<div class="form-group">
													<h6>電話</h6>
													<br> <input type="text" class="form-control" name="hotelPhone"
														value="<%=(hotelVO == null) ? "" : hotelVO.getHotelPhone()%>">
														<span class="error" style="color: red">${errors.hotelPhone}</span>
												</div>

												<div class="form-group">
													<h6>負責人</h6>
													<br> <input type="text" class="form-control" name="hotelPrincipal"
														value="<%=(hotelVO == null) ? "" : hotelVO.getHotelPrincipal()%>">
														<span class="error" style="color: red">${errors.hotelPrincipal}</span>
												</div>

												<div class="form-group">
													<h6>統一編號</h6>
													<br> <input type="text" class="form-control" disabled name="hotelTaxid"
														value="<%=(hotelVO == null) ? "" : hotelVO.getHotelTaxid()%>">
												</div>

												<div class="form-group">
													<h6>密碼修改</h6>
													<br> <input type="password" class="form-control" placeholder="請輸入密碼" name="hotelPassword">
													<span class="error" style="color: red">${errors.hotelPassword}</span>
<%-- 														value="<%=(hotelVO == null) ? "" : hotelVO.getHotelPassword()%>" --%>
												</div>
												<div class="form-group">
													<h6>再次確認密碼</h6>
													<br> <input type="password" class="form-control" placeholder="再次確認密碼" name="comfirmPassword">
													<span class="error" style="color: red">${errors.hotelPassword}</span>
												</div>
												<div class="form-group">
													<h6>飯店狀態</h6>
													<br> <input type="text" class="form-control" disabled name="hotelState"
														 value="<%=(hotelVO == null) ? "" : hotelVO.getHotelState()%>">
												</div>
												<br>
												<button type="submit" class="btn-style-1 w-100">確認修改</button>
												<input type="hidden" name="hotelservlet" value="hotelupdate">
											</div>
									</form>
									<!-- 飯店資料修改結束 -->
								</div>
							</div>
							<!-- tabs end -->
						</div>
						<div class="col-lg-4 col-md-4"></div>



						<div class="tab-pane fade show" id="introduce-tab" role="tabpanel"
							aria-labelledby="dashboard-nav">

							<h4>飯店介紹</h4>
							<p>飯店介紹內容</p>
						</div>
						<div class="tab-pane fade" id="room-tab" role="tabpanel"
							aria-labelledby="payment-nav">
							<h4>房間管理區</h4>
							<p>內容</p>
						</div>
						<div class="tab-pane fade" id="orders-tab" role="tabpanel"
							aria-labelledby="orders-nav">
							<div class="table-responsive">
								<table class="table table-bordered">
									<thead class="thead-dark">
										<tr>
											<th>No</th>
											<th>Product</th>
											<th>Date</th>
											<th>Price</th>
											<th>Status</th>
											<th>Action</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1</td>
											<td>Product Name</td>
											<td>01 Jan 2020</td>
											<td>$99</td>
											<td>Approved</td>
											<td><button class="btn">View</button></td>
										</tr>
										<tr>
											<td>2</td>
											<td>Product Name</td>
											<td>01 Jan 2020</td>
											<td>$99</td>
											<td>Approved</td>
											<td><button class="btn">View</button></td>
										</tr>
										<tr>
											<td>3</td>
											<td>Product Name</td>
											<td>01 Jan 2020</td>
											<td>$99</td>
											<td>Approved</td>
											<td><button class="btn">View</button></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
		<!-- My Account End -->
		<!-- ================ MemberCenter page end ================ -->
		<!-- ================ Top scroll ================ -->
		<a href="#" class="scroll-top">Top</a>
		<!-- ================ Top scroll end ================ -->

		<!-- js files -->
  <script src="<%=request.getContextPath()%>/js/jquery-3.5.1.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/bootstrap.bundle.min.js"></script>
  <!-- counter js -->
  <script src="<%=request.getContextPath()%>/js/jquery-1.10.2.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/waypoints.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/jquery.counterup.min.js"></script>
  <!-- venobox js -->
  <script src="<%=request.getContextPath()%>/js/venobox.min.js"></script>
  <!-- owl carousel -->
  <script src="<%=request.getContextPath()%>/js/owl.carousel.min.js"></script>
  <!-- portfolio js -->
  <script src="<%=request.getContextPath()%>/js/jquery.mixitup.min.js"></script>
  <!-- datepicker js -->
  <script src="<%=request.getContextPath()%>/js/datepicker.min.js"></script>
  <!-- script js -->
  <script src="<%=request.getContextPath()%>/js/custom.js"></script>
  <script src="https://kit.fontawesome.com/4ce3b6b697.js" crossorigin="anonymous"></script>
  <script src="<%=request.getContextPath()%>/js/member/memberHeader.js"></script>
</body>
</html>