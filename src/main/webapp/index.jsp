<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- page title -->
<title>Hoogle</title>

<!-- bootstrap core CSS -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<!-- font awesome -->
<link href="<%=request.getContextPath()%>/css/all.min.css" rel="stylesheet">
<!-- owl carousel -->
<link href="<%=request.getContextPath()%>/css/owl.carousel.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/owl.theme.default.min.css" rel="stylesheet">
<!-- venobox css -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/venobox.css">
<!-- datepicker css -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/datepicker.min.css">
<!-- custom styles for this template -->
<link href="<%=request.getContextPath()%>/css/custom.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/responsive.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/helper.css" rel="stylesheet">
<!-- Fontawesome -->
<script src="https://kit.fontawesome.com/0cf2b86d93.js" crossorigin="anonymous"></script>
<!-- ajax -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

</head>

<body>
	<!-- ================ Preloader ================ -->
	<div id="preloader">
		<div class="spinner-grow" role="status">
			<span class="sr-only">Loading...</span>
		</div>
	</div>
	<!-- ================ Preloader end ================ -->

	<!-- ================ Header ================ -->
	<header class="header">
		<!-- header upper -->
		<div class="header-upper-bar">
			<div class="container">
				<div class="row d-flex align-items-center">
					<div class="col-lg-8 col-md-6 col-sm-4 col-2">
						<!-- header navigation -->
						<nav class="navbar header-navigation navbar-expand-lg p-0">
							<!-- mobile Toggle -->
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
									<li class="active"><a href="index.jsp"><img
											src="images/logo_small_removebg.png" style="width: 50px;"
											alt="" class="img-fluid"></a></li>
									<li><a class="nav-link" href="compare.jsp">比較</a></li>
									<li><a class="nav-link" href="gallery.html">美食</a></li>
									<!--原pages-->
									<li class="nav-item dropdown"><a
										class="nav-link dropdown-toggle" href="#" id="dropdown05"
										data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">關於我們</a>
										<div class="dropdown-menu" aria-labelledby="dropdown05">
											<a class="dropdown-item" href="faq.html">關於我們</a> <a
												class="dropdown-item" href="QA.html">常見問題QA</a> <a
												class="dropdown-item" href="Terms.html">服務條款</a> <a
												class="dropdown-item" href="customer-service.html">客服支援</a>
										</div></li>
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
	</header>
	<!-- ================ Header end ================ -->

<<<<<<< HEAD
              <!-- 下拉式選單 -->
<!--               <li class="nav-item dropdown"> <a class="nav-link dropdown-toggle" href="#" id="dropdown05" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">  <img src="images/abu-index/login.png" alt="" class="img-fluid"></a> -->
<!--                 <div class="dropdown-menu" aria-labelledby="dropdown05"> <a class="dropdown-item" href="faq.html">登入</a> <a class="dropdown-item" href="QA.html">註冊</a> <a class="dropdown-item" href="Terms.html">會員中心</a> <a class="dropdown-item" href="customer-service.html">登出</a>  -->
                <!-- <a class="dropdown-item" href="team.html">Team</a> <a class="dropdown-item" href="testimonial.html">Testimonial</a> <a class="dropdown-item" href="traveler-information.html">Traveler Information</a> <a class="dropdown-item" href="payment-information.html">Payment Information</a> <a class="dropdown-item" href="faq.html">Faq</a> </div> -->
<!--               </li> -->
            </ul>
          </div>
          <!-- header right link end --> 
        </div>
      </div>
    </div>
  </div>
  <!-- header upper end --> 
  <!-- header lover -->
  <!-- <div class="header-lover">
    <div class="container">
      <div class="row align-items-center">
        <div class="col-lg-3 col-md-12">  -->
          <!-- brand -->
          <!-- <div class="logo"><a class="navbar-brand p-0" href="index.html"><img src="img/logo.png" alt=""></a></div> -->
          <!-- brand end --> 
        <!-- </div>
        <div class="col-lg-9 col-md-12">  -->
          <!-- header call us -->
          <!-- <div class="header-call-us">
            <ul>
              <li>
                <div class="iocn-holder"><i class="far fa-clock"></i></div>
                <div class="text-holder">
                  <h6>Working Hours</h6>
                  <p class="mb-0">Monday - Sunday: 9.00am to 6.00pm</p>
                </div>
              </li>
              <li>
                <div class="iocn-holder"><i class="fas fa-phone-volume"></i></div>
                <div class="text-holder">
                  <h6>Call Us</h6>
                  <p class="mb-0"><a href="tel:123456789">+011 123 4567</a></p>
                </div>
              </li>
              <li>
                <div class="iocn-holder"><i class="far fa-envelope"></i></div> -->
                <!-- <div class="text-holder">
                  <h6>Mail Us</h6>
                  <p class="mb-0"><a href="mailto:info@exampal.com">info@exampal.com</a></p>
                </div>
              </li>
            </ul>
          </div> -->
          <!-- header call us end --> 
        </div>
      </div>
    </div>
  </div>
  <!-- header lover end --> 
</header>
<!-- ================ Header end ================ --> 

<!-- ================ Slider area ================ -->
<div class="slider"> 
  <!-- search area -->
  <div class="search-area">
    <div class="container">
      <div class="row">
        <div class="col-lg-6 col-md-8 col-sm-12 col-12 offset-xl-0 offset-lg-3 offset-sm-0">
          <div class="center-search">
            <h1 class="text-white">Go once, living anywhere</h1>
            <!-- <p class="text-white">living anywhere</p> -->
            <form class="form-style-1" method="get" action="${pageContext.request.contextPath}/searchHotel/searchHotel.controller">
              <div class="form-group">
                <input type="text" class="form-control" name="hotelCounty" value="${param.hotelCounty}" placeholder="目的地">
              </div>
              <div class="row pt-20">
                <div class="col-lg-6 col-md-6 col-sm-6 col-6">
                  <div class="form-group">
                    <input type="text" class="form-control" id="check-in" placeholder="入住日期">
                  </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6 col-6">
                  <div class="form-group">
                    <input type="text" class="form-control" id="check-out" placeholder="退房日期">
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6 col-6">
                  <!-- <div class="form-group">
=======
	<!-- ================ Slider area ================ -->
	<div class="slider">
		<!-- search area -->
		<div class="search-area">
			<div class="container">
				<div class="row">
					<div
						class="col-lg-6 col-md-8 col-sm-12 col-12 offset-xl-0 offset-lg-3 offset-sm-0">
						<div class="center-search">
							<h1 class="text-white">Go once, living anywhere</h1>
							<!-- <p class="text-white">living anywhere</p> -->
							<form class="form-style-1">
								<div class="form-group">
									<input type="text" class="form-control" placeholder="目的地">
								</div>
								<div class="row pt-20">
									<div class="col-lg-6 col-md-6 col-sm-6 col-6">
										<div class="form-group">
											<input type="text" class="form-control" id="check-in"
												placeholder="入住日期">
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-6 col-6">
										<div class="form-group">
											<input type="text" class="form-control" id="check-out"
												placeholder="退房日期">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-6 col-md-6 col-sm-6 col-6">
										<!-- <div class="form-group">
>>>>>>> aga
                    <select class="form-control">
                      <option>Adult(s)(18+)</option>
                      <option>1</option>
                      <option>2</option>
                      <option>3</option>
                      <option>4</option>
                    </select>
                  </div> -->
									</div>
									<div class="col-lg-6 col-md-6 col-sm-6 col-6">
										<div class="form-group">
											<!-- <select class="form-control">
                      <option>Children(0-17)</option>
                      <option>1</option>
                      <option>2</option>
                      <option>3</option>
                      <option>4</option>
                    </select> -->
										</div>
									</div>
								</div>
								<div class="form-group">
									<!-- <select class="form-control"> -->
									<!-- <option>Rooms</option>
                  <option>1</option>
                  <option>2</option>
                  <option>3</option>
                  <option>4</option> -->
<<<<<<< HEAD
                </select>
              </div>
              <button type="submit" class="btn-style-1 w-100" name="searchHotel" value="Select">搜尋飯店</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- search area end -->
  <div id="myCarousel" class="carousel slide carousel-fade" data-ride="carousel">
    <div class="carousel-inner"> 
      <!-- slider item -->
      <div class="carousel-item active"> <img src="images/abu-index/scenery.jpg" alt="" class="img-fluid"> </div>
      <!-- slider item end --> 
      <!-- slider item -->
      <div class="carousel-item"> <img src="images/abu-index/scenery02.jpg" alt="" class="img-fluid"> </div>
      <!-- slider item end --> 
      <!-- slider item -->
      <div class="carousel-item"> <img src="images/abu-index/scenery03.jpg" alt="" class="img-fluid"> </div>
      <!-- slider item end --> 
    </div>
    <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev"> 
      <i class="fas fa-caret-left"></i>
    </a> 
    <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next"> 
      <i class="fas fa-caret-right"></i>
    </a>
  </div>
</div>
<!-- ================ Slider area end ================ --> 
=======
									</select>
								</div>
								<button type="submit" class="btn-style-1 w-100">搜尋飯店</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- search area end -->
		<div id="myCarousel" class="carousel slide carousel-fade"
			data-ride="carousel">
			<div class="carousel-inner">
				<!-- slider item -->
				<div class="carousel-item active">
					<img src="images/abu-index/scenery.jpg" alt="" class="img-fluid">
				</div>
				<!-- slider item end -->
				<!-- slider item -->
				<div class="carousel-item">
					<img src="images/abu-index/scenery02.jpg" alt="" class="img-fluid">
				</div>
				<!-- slider item end -->
				<!-- slider item -->
				<div class="carousel-item">
					<img src="images/abu-index/scenery03.jpg" alt="" class="img-fluid">
				</div>
				<!-- slider item end -->
			</div>
			<a class="carousel-control-prev" href="#myCarousel" role="button"
				data-slide="prev"> <i class="fas fa-caret-left"></i>
			</a> <a class="carousel-control-next" href="#myCarousel" role="button"
				data-slide="next"> <i class="fas fa-caret-right"></i>
			</a>
		</div>
	</div>
	<!-- ================ Slider area end ================ -->
>>>>>>> aga

	<!-- ================ About area ================ -->
	<div class="about-area pt-70 pb-60">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 mb-30">
					<!-- about text -->
					<!-- <div class="about-col">
          <h6>About us</h6>
          <h2>We <span>provide solutions</span> to grow your business</h2>
          <p>Lorem ipsum dolor sit amet consectetur adipiscing elit amet consectetur piscing elit amet consectetur adipiscing elit sed et eletum nulla eu placerat felis etiam tincidunt orci lacus id varius dolor fermum sit amet.</p>
          <p>Lorem ipsum dolor sit amet consectetur adipiscing elit amet consectetur piscing elit amet consectetur adipiscing elit sed et eletum nulla eu placerat felis etiam tincidunt orci lacus id varius dolor fermum sit amet.</p>
          <a class=" btn-style-1" href="#" role="button">Explore More <i class="fas fa-long-arrow-alt-right pl-6"></i></a> </div> -->
					<!-- about text end -->
					<!-- </div> -->
					<div class="col-lg-6 mb-30">
						<!-- about video -->
						<!-- <div class="about-video-img-box position-relative rounded"> <img src="img/about-us/about-video-img-1.jpg" alt="" class="img-fluid rounded">
          <div class="hoverlay d-flex flex-row align-items-center justify-content-center"> <a class="venobox d-inline" data-gall="gall-video" data-autoplay="true" data-vbtype="video" href="https://www.youtube.com/watch?v=668nUCeBHyY&t=28s"><i class="fab fa-google-play"></i></a> </div>
        </div> -->
						<!-- about video end -->
					</div>
				</div>
			</div>
		</div>
		<!-- ================ About area end ================ -->
		<!-- ================ Blog area ================ -->
		<div class="blog-area pt-70 pb-40 position-relative">
			<div class="bg-style-1"></div>
			<div class="container">
				<!-- section title -->
				<div class="section-title text-center">
					<h2>最新消息</h2>
					<span class="dashed-border"></span>
				</div>
				<!-- section title -->
				<div class="row">
					<div class="col-lg-4 col-md-6 mb-30">
						<!-- blog box -->
						<div class="blog-box shadow">
							<div class="blog_img mb-20">
								<img src="images/blog/blog-1.jpg" alt="">
							</div>
							<div class="blog-des">
								<h6 class="blog_date font-weight-normal text-muted">
									<span>公告類型</span> January 01, 2020
								</h6>
								<h5 class="mt-10 mb-6">
									<a href="#" class="text-dark">The Most Advance Business
										Plan</a>
								</h5>
								<p class="text-muted">Lorem ipsum dolor sit amet consectetur
									ipiscing elit amet consectetur piscing elit consectetur
									adipiscing elit sed et eletum.</p>
								<div class="read_more">
									<div class="blog_border"></div>
									<a href="#" class="text-dark text-uppercase"> Read More</a>
								</div>
							</div>
						</div>
						<!-- blog box end -->
					</div>
					<div class="col-lg-4 col-md-6 mb-30">
						<!-- blog box -->
						<div class="blog-box shadow">
							<div class="blog_img mb-20">
								<img src="images/blog/blog-2.jpg" alt="">
							</div>
							<div class="blog-des">
								<h6 class="blog_date font-weight-normal text-muted">
									<span>公告類型</span> January 01, 2020
								</h6>
								<h5 class="mt-10 mb-6">
									<a href="#" class="text-dark">Beautiful Home Page</a>
								</h5>
								<p class="text-muted">Lorem ipsum dolor sit amet consectetur
									ipiscing elit amet consectetur piscing elit consectetur
									adipiscing elit sed et eletum.</p>
								<div class="read_more">
									<div class="blog_border"></div>
									<a href="#" class="text-dark text-uppercase"> Read More</a>
								</div>
							</div>
						</div>
						<!-- blog box end -->
					</div>
					<div class="col-lg-4 col-md-6 mb-30">
						<!-- blog box -->
						<div class="blog-box shadow">
							<div class="blog_img mb-20">
								<img src="images/blog/blog-3.jpg" alt="">
							</div>
							<div class="blog-des">
								<h6 class="blog_date font-weight-normal text-muted">
									<span>公告類型</span> January 01, 2020
								</h6>
								<h5 class="mt-10 mb-6">
									<a href="#" class="text-dark">Modern Design Concept</a>
								</h5>
								<p class="text-muted">Lorem ipsum dolor sit amet consectetur
									ipiscing elit amet consectetur piscing elit consectetur
									adipiscing elit sed et eletum.</p>
								<div class="read_more">
									<div class="blog_border"></div>
									<a href="#" class="text-dark text-uppercase"> Read More</a>
								</div>
							</div>
						</div>
						<!-- blog box end -->
					</div>
				</div>
			</div>
		</div>
		<!-- ================ Blog area end ================ -->
		<!-- ================ Most popular hotel ================ -->
		<div class="most-popular-hotel pt-70 pb-70 position-relative">
			<div class="bg-style-1"></div>
			<div class="container">
				<!-- section title -->
				<div class="section-title text-center">
					<h2>人氣飯店</h2>
					<span class="dashed-border"></span>
				</div>
				<!-- section title -->
			</div>
			<div class="container-fluid">
				<!-- popular hotel carousel -->
				<div class="popular-hotel-carousel owl-carousel owl-theme">
					<div class="item">
						<!-- popular hotel box -->
						<div class="popular-hotel-box">
							<div class="imege mb-10">
								<img src="images/popular-hotel/1.jpg" alt="">
								<div class="black-bg">
									<a href=""><i class="fas fa-map-marker-alt"></i> Thailand</a>
								</div>
							</div>
							<div class="reting">
								<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
									class="fas fa-star"></i> <i class="far fa-star"></i> <i
									class="far fa-star"></i>
							</div>
							<h4>
								<a href="">Ansan Hotel</a>
							</h4>
							<div class="price">
								$100.00 / <span>Per night</span>
							</div>
						</div>
						<!-- popular hotel box end -->
					</div>
					<div class="item">
						<!-- popular hotel box -->
						<div class="popular-hotel-box">
							<div class="imege mb-10">
								<img src="images/popular-hotel/2.jpg" alt="">
								<div class="black-bg">
									<a href=""><i class="fas fa-map-marker-alt"></i> Vietnam</a>
								</div>
							</div>
							<div class="reting">
								<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
									class="fas fa-star"></i> <i class="far fa-star"></i> <i
									class="far fa-star"></i>
							</div>
							<h4>
								<a href="">Fawlty Towers</a>
							</h4>
							<div class="price">
								$200.00 / <span>Per night</span>
							</div>
						</div>
						<!-- popular hotel box end -->
					</div>
					<div class="item">
						<!-- popular hotel box -->
						<div class="popular-hotel-box">
							<div class="imege mb-10">
								<img src="images/popular-hotel/3.jpg" alt="">
								<div class="black-bg">
									<a href=""><i class="fas fa-map-marker-alt"></i> Italy</a>
								</div>
							</div>
							<div class="reting">
								<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
									class="fas fa-star"></i> <i class="far fa-star"></i> <i
									class="far fa-star"></i>
							</div>
							<h4>
								<a href="">Hotel Valle</a>
							</h4>
							<div class="price">
								$300.00 / <span>Per night</span>
							</div>
						</div>
						<!-- popular hotel box end -->
					</div>
					<div class="item">
						<!-- popular hotel box -->
						<div class="popular-hotel-box">
							<div class="imege mb-10">
								<img src="images/popular-hotel/4.jpg" alt="">
								<div class="black-bg">
									<a href=""><i class="fas fa-map-marker-alt"></i> Mexico</a>
								</div>
							</div>
							<div class="reting">
								<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
									class="fas fa-star"></i> <i class="far fa-star"></i> <i
									class="far fa-star"></i>
							</div>
							<h4>
								<a href="">Hotel Las Trojes</a>
							</h4>
							<div class="price">
								$400.00 / <span>Per night</span>
							</div>
						</div>
						<!-- popular hotel box end -->
					</div>
					<div class="item">
						<!-- popular hotel box -->
						<div class="popular-hotel-box">
							<div class="imege mb-10">
								<img src="images/popular-hotel/5.jpg" alt="">
								<div class="black-bg">
									<a href=""><i class="fas fa-map-marker-alt"></i> United
										States</a>
								</div>
							</div>
							<div class="reting">
								<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
									class="fas fa-star"></i> <i class="far fa-star"></i> <i
									class="far fa-star"></i>
							</div>
							<h4>
								<a href="">Rosen Shingle Creek</a>
							</h4>
							<div class="price">
								$500.00 / <span>Per night</span>
							</div>
						</div>
						<!-- popular hotel box end -->
					</div>
				</div>
				<!-- popular hotel carousel end -->
			</div>
		</div>
		<!-- ================ Most popular hotel end ================ -->


		<!-- ================ Popular destinations ================ -->
		<div class="popular-destinations pt-70 pb-40 position-relative">
			<div class="bg-style-1"></div>
			<div class="container">
				<!-- section title -->
				<div class="section-title text-center">
					<h2>各式飯店，任君挑選</h2>
					<span class="dashed-border"></span>
				</div>
				<!-- section title -->
				<div class="row">
					<div class="col-lg-4 col-md-6 col-sm-6 mb-30">
						<!-- popular destination box -->
						<div class="popular-destination-box">
							<div class="img-holder-overlay">
								<div class="img-holder">
									<img class="myImg" src="images/popular-destination/1.jpg"
										alt="">
								</div>
								<div class="overlay">
									<a href="#"><i class="fas fa-share"></i></a>
								</div>
							</div>
							<div class="title">
								<h3>
									<a href="">Orlando</a>
								</h3>
							</div>
						</div>
						<!-- popular destination box end -->
					</div>
					<div class="col-lg-4 col-md-6 col-sm-6 mb-30">
						<!-- popular destination box -->
						<div class="popular-destination-box">
							<div class="img-holder-overlay">
								<div class="img-holder">
									<img class="myImg" src="images/popular-destination/1.jpg"
										alt="">
								</div>
								<div class="overlay">
									<a href="#"><i class="fas fa-share"></i></a>
								</div>
							</div>
							<div class="title">
								<h3>
									<a href="">Miami</a>
								</h3>
							</div>
						</div>
						<!-- popular destination box end -->
					</div>
					<div class="col-lg-4 col-md-6 col-sm-6 mb-30">
						<!-- popular destination box -->
						<div class="popular-destination-box">
							<div class="img-holder-overlay">
								<div class="img-holder">
									<img class="myImg" src="images/popular-destination/1.jpg"
										alt="">
								</div>
								<div class="overlay">
									<a href="#"><i class="fas fa-share"></i></a>
								</div>
							</div>
							<div class="title">
								<h3>
									<a href="">Los Angeles</a>
								</h3>
							</div>
						</div>
						<!-- popular destination box end -->
					</div>
					<div class="col-lg-4 col-md-6 col-sm-6 mb-30">
						<!-- popular destination box -->
						<div class="popular-destination-box">
							<div class="img-holder-overlay">
								<div class="img-holder">
									<img class="myImg" src="images/popular-destination/1.jpg"
										alt="">
								</div>
								<div class="overlay">
									<a href="#"><i class="fas fa-share"></i></a>
								</div>
							</div>
							<div class="title">
								<h3>
									<a href="">San Diego</a>
								</h3>
							</div>
						</div>
						<!-- popular destination box end -->
					</div>
					<div class="col-lg-4 col-md-6 col-sm-6 mb-30">
						<!-- popular destination box -->
						<div class="popular-destination-box">
							<div class="img-holder-overlay">
								<div class="img-holder">
									<img class="myImg" src="images/popular-destination/1.jpg"
										alt="">
								</div>
								<div class="overlay">
									<a href="#"><i class="fas fa-share"></i></a>
								</div>
							</div>
							<div class="title">
								<h3>
									<a href="">Houston</a>
								</h3>
							</div>
						</div>
						<!-- popular destination box end -->
					</div>
					<div class="col-lg-4 col-md-6 col-sm-6 mb-30">
						<!-- popular destination box -->
						<div class="popular-destination-box">
							<div class="img-holder-overlay">
								<div class="img-holder">
									<img class="myImg" src="images/popular-destination/1.jpg"
										alt="">
								</div>
								<div class="overlay">
									<a href="#"><i class="fas fa-share"></i></a>
								</div>
							</div>
							<div class="title">
								<h3>
									<a href="">New York</a>
								</h3>
							</div>
						</div>
						<!-- popular destination box end -->
					</div>
				</div>
			</div>
		</div>
		<!-- ================ Popular destinations end ================ -->

		<!-- ================ Testimonials ================ -->

		<!-- ================ Testimonials end ================ -->


		<!-- ================ Download app are ================ -->

		<!-- ================ Partner area ================ -->

		<!-- ================ Footer area ================ -->
		<footer class="pt-50">
			<div class="footer-top">
				<div class="container">
					<div class="row">
						<div class="col-lg-3 col-md-3 col-sm-6 mb-30">
							<div class="title mb-10">
								<h3>關於我們</h3>
							</div>
							<div class="text" style="color: white">
								<p>疫情逐漸趨緩，國人報復性消費帶動旅遊產業。</p>
								<p>訂房網往往只能看到飯店的價格設施，讓使用者在使用時可能要開好幾個頁面做比較。</p>
								<p>因此我們想讓消費者在比較的同時，比的不只是價格。而是可以針對自己在意的項目做比較。再透過平台系統直接訂房。</p>
							</div>
						</div>
						<div class="col-lg-2 col-md-3 col-sm-6 mb-30">
							<div class="title mb-10">
								<h3>指南</h3>
							</div>
							<ul class="footer-link">
								<li><i class="fas fa-caret-right"></i> <a href="#">首頁</a></li>
								<li><i class="fas fa-caret-right"></i> <a href="#">比價</a></li>
								<li><i class="fas fa-caret-right"></i> <a href="#">美食</a></li>
								<li><i class="fas fa-caret-right"></i> <a href="#">關於我們</a>
								</li>
								<li><i class="fas fa-caret-right"></i> <a href="#">服務條款</a>
								</li>
								<li><i class="fas fa-caret-right"></i> <a href="#">常見問題</a>
								</li>
							</ul>
						</div>
						<div class="col-lg-6 col-md-3 col-sm-6 mb-30">
							<br>
							<div class="title mb-10">
								<h1 align="center" style="color: white">版權聲明</h1>
							</div>
							<h2 align="center" style="color: white">Copyright © 2022
								HOOGLE. All rights reserved.</h2>
						</div>
					</div>
				</div>
			</div>
		</footer>
		<!-- ================ Footer area end================ -->
		
		<!-- ================ js area================ -->
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
		<script src="<%=request.getContextPath()%>/js/abu-js/abu.js"></script>
		<!-- header right link js by aga -->
		<script src="<%=request.getContextPath()%>/js/member/memberHeader.js"></script>
		<!-- ================ js area end================ -->
</body>

<script>
	
</script>

</html>