<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.searchHotel.model.*"%>
<%@ page import="java.util.*" %>

<!-- //............... -->
<%
// 	SearchHotelService searchHotelSvc = new SearchHotelService();
//     List <SearchHotelBean> list = searchHotelSvc.getAll();
//     pageContext.setAttribute("list",list);
%>
<!-- //............... -->

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Fontawesome -->
<script src="https://kit.fontawesome.com/0cf2b86d93.js" crossorigin="anonymous"></script>

<!-- page title -->
<title>Hoogle</title>
<!-- favicon -->
<!-- <link rel="icon" href="favicon.ico" /> -->
<!-- bootstrap core CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" >
<!-- font awesome -->
<link href="${pageContext.request.contextPath}/css/all.min.css" rel="stylesheet">
<!-- owl carousel -->
<link href="${pageContext.request.contextPath}/css/owl.carousel.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/owl.theme.default.min.css" rel="stylesheet">
<!-- venobox css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/venobox.css">
<!-- datepicker css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/datepicker.min.css">
<!-- custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/abu-css/abu.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/responsive.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/helper.css" rel="stylesheet">
</head>

<body>
<!-- ================ Preloader ================ -->
<div id="preloader">
  <div class="spinner-grow" role="status"> <span class="sr-only">Loading...</span> </div>
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
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTheme" aria-controls="navbarTheme" aria-expanded="false" aria-label="Toggle navigation"> <span></span> <span></span> <span></span> </button>
            <!-- mobile toggle end --> 
            <!-- top Menu -->
            <div class="collapse navbar-collapse" id="navbarTheme">
              <ul class="navbar-nav align-items-start align-items-lg-center">
                <li class="active"><a href="/index.jsp"><img src="${pageContext.request.contextPath}/images/abu-index/logo.png" alt="" class="img-fluid"></a></li> 
                <li><a class="nav-link" href="about.html">比價</a></li>
                <li><a class="nav-link" href="gallery.html">美食</a></li>
                <!-- <li class="nav-item dropdown"> <a class="nav-link dropdown-toggle" href="#" id="dropdown02" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">關於我們</a>
                  <div class="dropdown-menu" aria-labelledby="dropdown02"> <a class="dropdown-item" href="destinations.html">Destinations</a> <a class="dropdown-item" href="destination-detail.html">Destination Detail</a> </div>
                </li> -->
                <!-- <li class="nav-item dropdown"> <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Blog</a>
                  <div class="dropdown-menu" aria-labelledby="dropdown04"> <a class="dropdown-item" href="blog.html">Blog</a> <a class="dropdown-item" href="blog-single.html">Blog Singal</a> </div>
                </li> -->

                <!--原pages-->
                <li class="nav-item dropdown"> <a class="nav-link dropdown-toggle" href="#" id="dropdown05" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">關於我們</a>
                  <div class="dropdown-menu" aria-labelledby="dropdown05"> <a class="dropdown-item" href="faq.html">關於我們</a> <a class="dropdown-item" href="QA.html">常見問題QA</a> <a class="dropdown-item" href="Terms.html">服務條款</a> <a class="dropdown-item" href="customer-service.html">客服支援</a> 
                  <!-- <a class="dropdown-item" href="team.html">Team</a> <a class="dropdown-item" href="testimonial.html">Testimonial</a> <a class="dropdown-item" href="traveler-information.html">Traveler Information</a> <a class="dropdown-item" href="payment-information.html">Payment Information</a> <a class="dropdown-item" href="faq.html">Faq</a> </div> -->
                </li>
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
              <!-- <li><a href="signin.html"><img src="./img/imgs/註冊.png" alt="" class="img-fluid"></li> -->
<!--                 <li><a class="nav-link" href="about.html">會員名稱</a></li> -->
              <!-- <li><a href="contact-us.html" class="header-request">Request a Quote</a></li>

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
      <div class="carousel-item active"> <img src="${pageContext.request.contextPath}/images/abu-index/scenery.jpg" alt="" class="img-fluid"> </div>
      <!-- slider item end --> 
      <!-- slider item -->
      <div class="carousel-item"> <img src="${pageContext.request.contextPath}/images/abu-index/scenery02.jpg" alt="" class="img-fluid"> </div>
      <!-- slider item end --> 
      <!-- slider item -->
      <div class="carousel-item"> <img src="${pageContext.request.contextPath}/images/abu-index/scenery03.jpg" alt="" class="img-fluid"> </div>
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
<!-- <div class="blog-area pt-70 pb-40 position-relative"> -->
<!--   <div class="bg-style-1"></div> -->
<!--   <div class="container">  -->
<!--     section title -->
<!--     <div class="section-title text-center"> -->
<!--       <h2>最新消息</h2> -->
<!--       <span class="dashed-border"></span> </div> -->
<!--     section title -->
<!--     <div class="row"> -->
<!--       <div class="col-lg-4 col-md-6 mb-30">  -->
<!--         blog box -->
<!--         <div class="blog-box shadow"> -->
<%--           <div class="blog_img mb-20"><img src="${pageContext.request.contextPath}/images/blog/blog-1.jpg" alt=""></div> --%>
<!--           <div class="blog-des"> -->
<!--             <h6 class="blog_date font-weight-normal text-muted"><span>公告類型</span> January 01, 2020</h6> -->
<!--             <h5 class="mt-10 mb-6"><a href="#" class="text-dark">The Most Advance Business Plan</a></h5> -->
<!--             <p class="text-muted">Lorem ipsum dolor sit amet consectetur ipiscing elit amet consectetur piscing elit consectetur adipiscing elit sed et eletum.</p> -->
<!--             <div class="read_more"> -->
<!--               <div class="blog_border"></div> -->
<!--               <a href="#" class="text-dark text-uppercase"> Read More</a> </div> -->
<!--           </div> -->
<!--         </div> -->
<!--         blog box end  -->
<!--       </div> -->
<!--       <div class="col-lg-4 col-md-6 mb-30">  -->
<!--         blog box -->
<!--         <div class="blog-box shadow"> -->
<%--           <div class="blog_img mb-20"><img src="${pageContext.request.contextPath}/images/blog/blog-2.jpg" alt=""></div> --%>
<!--           <div class="blog-des"> -->
<!--             <h6 class="blog_date font-weight-normal text-muted"><span>公告類型</span> January 01, 2020</h6> -->
<!--             <h5 class="mt-10 mb-6"><a href="#" class="text-dark">Beautiful Home Page</a></h5> -->
<!--             <p class="text-muted">Lorem ipsum dolor sit amet consectetur ipiscing elit amet consectetur piscing elit consectetur adipiscing elit sed et eletum.</p> -->
<!--             <div class="read_more"> -->
<!--               <div class="blog_border"></div> -->
<!--               <a href="#" class="text-dark text-uppercase"> Read More</a> </div> -->
<!--           </div> -->
<!--         </div> -->
<!--         blog box end  -->
<!--       </div> -->
<!--       <div class="col-lg-4 col-md-6 mb-30">  -->
<!--         blog box -->
<!--         <div class="blog-box shadow"> -->
<%--           <div class="blog_img mb-20"><img src="${pageContext.request.contextPath}/images/blog/blog-3.jpg" alt=""></div> --%>
<!--           <div class="blog-des"> -->
<!--             <h6 class="blog_date font-weight-normal text-muted"><span>公告類型</span> January 01, 2020</h6> -->
<!--             <h5 class="mt-10 mb-6"><a href="#" class="text-dark">Modern Design Concept</a></h5> -->
<!--             <p class="text-muted">Lorem ipsum dolor sit amet consectetur ipiscing elit amet consectetur piscing elit consectetur adipiscing elit sed et eletum.</p> -->
<!--             <div class="read_more"> -->
<!--               <div class="blog_border"></div> -->
<!--               <a href="#" class="text-dark text-uppercase"> Read More</a> </div> -->
<!--           </div> -->
<!--         </div> -->
<!--         blog box end  -->
<!--       </div> -->
<!--     </div> -->
<!--   </div> -->
<!-- </div> -->
<!-- ================ Blog area end ================ --> 
<!-- ================ Most popular hotel ================ -->
<!-- <div class="most-popular-hotel pt-70 pb-70 position-relative"> -->
<!--   <div class="bg-style-1"></div> -->
<!--   <div class="container">  -->
<!--     section title -->
<!--     <div class="section-title text-center"> -->
<!--       <h2>人氣飯店</h2> -->
<!--       <span class="dashed-border"></span> </div> -->
<!--     section title  -->
<!--   </div> -->
<!--   <div class="container-fluid">  -->
<!--     popular hotel carousel -->
<!--     <div class="popular-hotel-carousel owl-carousel owl-theme"> -->
<!--       <div class="item">  -->
<!--         popular hotel box -->
<!--         <div class="popular-hotel-box"> -->
<%--           <div class="imege mb-10"><img src="${pageContext.request.contextPath}/images/popular-hotel/1.jpg" alt=""> --%>
<!--             <div class="black-bg"> <a href=""><i class="fas fa-map-marker-alt"></i> Thailand</a> </div> -->
<!--           </div> -->
<!--           <div class="reting"> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="far fa-star"></i> <i class="far fa-star"></i> </div> -->
<!--           <h4><a href="">Ansan Hotel</a></h4> -->
<!--           <div class="price">$100.00 / <span>Per night</span></div> -->
<!--         </div> -->
<!--         popular hotel box end  -->
<!--       </div> -->
<!--       <div class="item">  -->
<!--         popular hotel box -->
<!--         <div class="popular-hotel-box"> -->
<%--           <div class="imege mb-10"><img src="${pageContext.request.contextPath}/images/popular-hotel/2.jpg" alt=""> --%>
<!--             <div class="black-bg"> <a href=""><i class="fas fa-map-marker-alt"></i> Vietnam</a> </div> -->
<!--           </div> -->
<!--           <div class="reting"> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="far fa-star"></i> <i class="far fa-star"></i> </div> -->
<!--           <h4><a href="">Fawlty Towers</a></h4> -->
<!--           <div class="price">$200.00 / <span>Per night</span></div> -->
<!--         </div> -->
<!--         popular hotel box end  -->
<!--       </div> -->
<!--       <div class="item">  -->
<!--         popular hotel box -->
<!--         <div class="popular-hotel-box"> -->
<%--           <div class="imege mb-10"><img src="${pageContext.request.contextPath}/images/popular-hotel/3.jpg" alt=""> --%>
<!--             <div class="black-bg"> <a href=""><i class="fas fa-map-marker-alt"></i> Italy</a> </div> -->
<!--           </div> -->
<!--           <div class="reting"> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="far fa-star"></i> <i class="far fa-star"></i> </div> -->
<!--           <h4><a href="">Hotel Valle</a></h4> -->
<!--           <div class="price">$300.00 / <span>Per night</span></div> -->
<!--         </div> -->
<!--         popular hotel box end  -->
<!--       </div> -->
<!--       <div class="item">  -->
<!--         popular hotel box -->
<!--         <div class="popular-hotel-box"> -->
<%--           <div class="imege mb-10"><img src="${pageContext.request.contextPath}/images/popular-hotel/4.jpg" alt=""> --%>
<!--             <div class="black-bg"> <a href=""><i class="fas fa-map-marker-alt"></i> Mexico</a> </div> -->
<!--           </div> -->
<!--           <div class="reting"> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="far fa-star"></i> <i class="far fa-star"></i> </div> -->
<!--           <h4><a href="">Hotel Las Trojes</a></h4> -->
<!--           <div class="price">$400.00 / <span>Per night</span></div> -->
<!--         </div> -->
<!--         popular hotel box end  -->
<!--       </div> -->
<!--       <div class="item">  -->
<!--         popular hotel box -->
<!--         <div class="popular-hotel-box"> -->
<%--           <div class="imege mb-10"><img src="${pageContext.request.contextPath}/images/popular-hotel/5.jpg" alt=""> --%>
<!--             <div class="black-bg"> <a href=""><i class="fas fa-map-marker-alt"></i> United States</a> </div> -->
<!--           </div> -->
<!--           <div class="reting"> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="far fa-star"></i> <i class="far fa-star"></i> </div> -->
<!--           <h4><a href="">Rosen Shingle Creek</a></h4> -->
<!--           <div class="price">$500.00 / <span>Per night</span></div> -->
<!--         </div> -->
<!--         popular hotel box end  -->
<!--       </div> -->
<!--     </div> -->
<!--     popular hotel carousel end  -->
<!--   </div> -->
<!-- </div> -->
<!-- ================ Most popular hotel end ================ --> 


<!-- ================ Popular destinations ================ -->
<div class="popular-destinations pt-70 pb-40 position-relative">
  <div class="bg-style-1"></div>
  <div class="container"> 
    <!-- section title -->
    <div class="section-title text-center">
      <h2>各式飯店，任君挑選</h2>
      <span class="dashed-border"></span> </div>
    <!-- section title -->
    <div class="row">
      <div class="col-lg-4 col-md-6 col-sm-6 mb-30"> 
        <!-- popular destination box -->
        <div class="popular-destination-box">
          <div class="img-holder-overlay">
            <div class="img-holder"><img src="${pageContext.request.contextPath}/images/popular-destination/1.jpg" alt=""></div>
            <div class="overlay"><a href="#"><i class="fas fa-share"></i></a></div>
          </div>
          
          <table>
          <tr>
          	<td>${searchHotelBean.hotelId}</td>
          </tr>
          </table>
          
          <div class="title">
            <h3><a href="">Orlando</a></h3>
          </div>
        </div>
        <!-- popular destination box end --> 
      </div>
      <div class="col-lg-4 col-md-6 col-sm-6 mb-30"> 
        <!-- popular destination box -->
        <div class="popular-destination-box">
          <div class="img-holder-overlay">
            <div class="img-holder"><img src="${pageContext.request.contextPath}/images/popular-destination/2.jpg" alt=""></div>
            <div class="overlay"><a href="#"><i class="fas fa-share"></i></a></div>
          </div>
          <div class="title">
            <h3><a href="">Miami</a></h3>
          </div>
        </div>
        <!-- popular destination box end --> 
      </div>
      <div class="col-lg-4 col-md-6 col-sm-6 mb-30"> 
        <!-- popular destination box -->
        <div class="popular-destination-box">
          <div class="img-holder-overlay">
            <div class="img-holder"><img src="${pageContext.request.contextPath}/images/popular-destination/3.jpg" alt=""></div>
            <div class="overlay"><a href="#"><i class="fas fa-share"></i></a></div>
          </div>
          <div class="title">
            <h3><a href="">Los Angeles</a></h3>
          </div>
        </div>
        <!-- popular destination box end --> 
      </div>
      <div class="col-lg-4 col-md-6 col-sm-6 mb-30"> 
        <!-- popular destination box -->
        <div class="popular-destination-box">
          <div class="img-holder-overlay">
            <div class="img-holder"><img src="${pageContext.request.contextPath}/images/popular-destination/4.jpg" alt=""></div>
            <div class="overlay"><a href="#"><i class="fas fa-share"></i></a></div>
          </div>
          <div class="title">
            <h3><a href="">San Diego</a></h3>
          </div>
        </div>
        <!-- popular destination box end --> 
      </div>
      <div class="col-lg-4 col-md-6 col-sm-6 mb-30"> 
        <!-- popular destination box -->
        <div class="popular-destination-box">
          <div class="img-holder-overlay">
            <div class="img-holder"><img src="${pageContext.request.contextPath}/images/popular-destination/5.jpg" alt=""></div>
            <div class="overlay"><a href="#"><i class="fas fa-share"></i></a></div>
          </div>
          <div class="title">
            <h3><a href="">Houston</a></h3>
          </div>
        </div>
        <!-- popular destination box end --> 
      </div>
      <div class="col-lg-4 col-md-6 col-sm-6 mb-30"> 
        <!-- popular destination box -->
        <div class="popular-destination-box">
          <div class="img-holder-overlay">
            <div class="img-holder"><img src="${pageContext.request.contextPath}/images/popular-destination/6.jpg" alt=""></div>
            <div class="overlay"><a href="#"><i class="fas fa-share"></i></a></div>
          </div>
          <div class="title">
            <h3><a href="">New York</a></h3>
          </div>
        </div>
        <!-- popular destination box end --> 
      </div>
    </div>
  </div>
</div>

<!-- <table> -->
<!-- 	<thead> -->
<!-- 	<tr> -->
<!-- 		<th>hotelId</th> -->
<!-- 		<th>hotelEmail</th> -->
<!-- 		<th>hotelPassword</th> -->
<!-- 		<th>hotelName</th> -->
<!-- 		<th>hotelPhone</th> -->
<!-- 		<th>hotelPrincipal</th> -->
<!-- 		<th>hotelTaxid</th> -->
<!-- 		<th>hotelCounty</th> -->
<!-- 		<th>hotelAddress</th> -->
<!-- 		<th>hotelType</th> -->
<!-- 		<th>hotelNotice</th> -->
<!-- 		<th>hotelQa</th> -->
<!-- 		<th>hotelIntroduction</th> -->
<!-- 		<th>hotelState</th> -->
<!-- 	</tr> -->
<!-- 	</thead> -->
<!-- 	<tbody> -->
		
<%-- 		<c:forEach var="row" items="${list}"> --%>
<%-- 		<c:url value="/searchHotel/displayHotel.jsp" var="path"> --%>
<%-- 			<c:param name="hotelId" value="${row.hotelId}" /> --%>
<%-- 			<c:param name="hotelEmail" value="${row.hotelEmail}" /> --%>
<%-- 			<c:param name="hotelPassword" value="${row.hotelPassword}" /> --%>
<%-- 			<c:param name="hotelName" value="${row.hotelName}" /> --%>
<%-- 			<c:param name="hotelPhone" value="${row.hotelPhone}" /> --%>
<%-- 			<c:param name="hotelPrincipal" value="${row.hotelPrincipal}" /> --%>
<%-- 			<c:param name="hotelTaxid" value="${row.hotelTaxid}" /> --%>
<%-- 			<c:param name="hotelCounty" value="${row.hotelCounty}" /> --%>
<%-- 			<c:param name="hotelAddress" value="${row.hotelAddress}" /> --%>
<%-- 			<c:param name="hotelType" value="${row.hotelType}" /> --%>
<%-- 			<c:param name="hotelNotice" value="${row.hotelNotice}" /> --%>
<%-- 			<c:param name="hotelQa" value="${row.hotelQa}" /> --%>
<%-- 			<c:param name="hotelIntroduction" value="${row.hotelIntroduction}" /> --%>
<%-- 			<c:param name="hotelState" value="${row.hotelState}" /> --%>
<%-- 		</c:url> --%>
		
<!-- 	<tr> -->
<%-- 		<td><a href="${path}">${row.hotelId}</a></td> --%>
<%-- 		<td>${row.hotelEmail}</td> --%>
<%-- 		<td>${row.hotelPassword}</td> --%>
<%-- 		<td>${row.hotelName}</td> --%>
<%-- 		<td>${row.hotelPhone}</td> --%>
<%-- 		<td>${row.hotelPrincipal}</td> --%>
<%-- 		<td>${row.hotelTaxid}</td> --%>
<%-- 		<td>${row.hotelCounty}</td> --%>
<%-- 		<td>${row.hotelAddress}</td> --%>
<%-- 		<td>${row.hotelType}</td> --%>
<%-- 		<td>${row.hotelNotice}</td> --%>
<%-- 		<td>${row.hotelQa}</td> --%>
<%-- 		<td>${row.hotelIntroduction}</td> --%>
<%-- 		<td>${row.hotelState}</td> --%>
<!-- 	</tr> -->
<%-- 		</c:forEach> --%>
	
<!-- 	</tbody> -->
<!-- </table> -->
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
          <!-- title -->
          <div class="title mb-10">
            <h3>關於我們</h3>
          </div>
          <!-- title end --> 
          <!-- text -->
          <div class="text">
            <p>Lorem ipsum dolor sit amet sectetur adipiscing elit amet consectetur scing elit amet consectetur adipiscing elit sed et eletum.</p>
            <p>Lorem ipsum dolor sit amet sectetur adipiscing elit amet consectetur scing elit amet.</p>
          </div>
          <!-- end text --> 
          <!-- footer social -->
          <!-- <div class="footer-social"> <a href=""><i class="fab fa-facebook-square"></i></a> <a href=""><i class="fab fa-twitter-square"></i></a> <a href=""><i class="fab fa-linkedin"></i></a> <a href=""><i class="fab fa-pinterest-square"></i></a> <a href=""><i class="fab fa-google-plus-square"></i></a> </div> -->
          <!-- footer social end --> 
        </div>
        <div class="col-lg-3 col-md-3 col-sm-6 mb-30"> 
          <!-- title -->
          <div class="title mb-10">
            <h3>指南</h3>
          </div>
          <!-- title end --> 
          <!-- footer link -->
          <ul class="footer-link">
            <li><i class="fas fa-caret-right"></i> <a href="#">首頁</a> </li>
            <li><i class="fas fa-caret-right"></i> <a href="#">比價</a> </li>
            <li><i class="fas fa-caret-right"></i> <a href="#">美食</a> </li>
            <li><i class="fas fa-caret-right"></i> <a href="#">關於我們</a> </li>
            <li><i class="fas fa-caret-right"></i> <a href="#">服務條款</a> </li>
            <li><i class="fas fa-caret-right"></i> <a href="#">客服支援</a> </li>
          </ul>
          <!-- footer link end --> 
        </div>
        <div class="col-lg-3 col-md-3 col-sm-6 mb-30"> 
          <!-- title -->
          <div class="title mb-10">
            <h3>服務項目</h3>
          </div>
          <!-- title end --> 
          <!-- recent-posts -->
          <div class="footer-recent-post"> 
            <!-- footer recent post item -->
            <div class="footer-recent-post-item"> <a href="">
              <p>租車服務</p>
              <small><!-- <i> i class="far fa-calendar-alt pr-6"></i> --> </small></a> </div>
            <!-- footer recent post item end --> 
            <!-- footer recent post item -->
            <div class="footer-recent-post-item"> <a href="">
              <p>訂機票</p>
              <small><!-- class="far fa-calendar-alt pr-6"></i> --> </small></a> </div>
            <!-- footer recent post item end --> 
            <!-- footer recent post item -->
            <div class="footer-recent-post-item"> <a href="">
              <p>餐廳訂位</p>
              <small><!-- <i class="far fa-calendar-alt pr-6"></i> --> </small></a> </div>
            <!-- footer recent post item end --> 
          </div>
          <!-- recent-posts end --> 
        </div>
        <div class="col-lg-3 col-md-3 col-sm-6 mb-30"> 
          <!-- title -->
          <div class="title mb-10">
            <h3>郵件聯絡</h3>
          </div>
          <!-- title end --> 
          <!-- footer newsletter text -->
          <div class="footer-newsletter-text">
            <p>Lorem ipsum dolor sit amet sectetur adipiscing elit amet consectetur scing elit sed et eletum.</p>
          </div>
          <!-- footer newsletter text end --> 
          <!-- footer newsletter form -->
          <div class="footer-newsletter-form">
            <form>
              <input placeholder="Email Adress..." type="text" required>
              <button type="submit">Subscribe</button>
            </form>
          </div>
          <!-- footer newsletter form end -->

<!-- js files --> 
<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script> 
<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script> 
<!-- counter js --> 
<script src="${pageContext.request.contextPath}/js/jquery-1.10.2.min.js"></script> 
<script src="${pageContext.request.contextPath}/js/waypoints.min.js"></script> 
<script src="${pageContext.request.contextPath}/js/jquery.counterup.min.js"></script> 
<!-- venobox js --> 
<script src="${pageContext.request.contextPath}/js/venobox.min.js"></script> 
<!-- owl carousel --> 
<script src="${pageContext.request.contextPath}/js/owl.carousel.min.js"></script> 
<!-- portfolio js --> 
<script src="${pageContext.request.contextPath}/js/jquery.mixitup.min.js"></script> 
<!-- datepicker js --> 
<script src="${pageContext.request.contextPath}/js/datepicker.min.js"></script> 
<!-- script js --> 
<script src="${pageContext.request.contextPath}/js/abu-js/abu.js"></script>
<!-- header right link js by aga -->
<script src="${pageContext.request.contextPath}/js/member/memberHeader.js"></script>
</body>
</html>