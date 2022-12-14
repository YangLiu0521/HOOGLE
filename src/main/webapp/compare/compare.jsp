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
    <!-- favicon -->
    <link rel="icon" href="favicon.ico" />
    <!-- bootstrap core CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/compare/bootstrap.min.css" />
    <!-- font awesome -->
    <link href="<%=request.getContextPath() %>/css/compare/all.min.css" rel="stylesheet" />
    <!-- owl carousel -->
    <link href="<%=request.getContextPath() %>/css/compare/owl.carousel.min.css" rel="stylesheet" />
    <link href="<%=request.getContextPath() %>/css/compare/owl.theme.default.min.css" rel="stylesheet" />
    <!-- venobox css -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/compare/venobox.css" />
    <!-- datepicker css -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/compare/datepicker.min.css" />
    <!-- custom styles for this template -->
    <link href="<%=request.getContextPath() %>/css/compare/custom.css" rel="stylesheet" />
    <link href="<%=request.getContextPath() %>/css/compare/responsive.css" rel="stylesheet" />
    <link href="<%=request.getContextPath() %>/css/compare/helper.css" rel="stylesheet" />
    <style>
    
    p#detail{
      height:600px;
      width:80%;
      background: lightgray;
      margin-inline: auto;
      overflow-x: hidden;
      overflow-y:scroll;
      font-size: 20px;
      white-space:pre-wrap;
      font-weight:bolder;      
    }
    /* textarea.detial{
      height:600px;
      width:100%;
      margin-inline: auto;
      font-size: 16px;
    } */
    textarea.type{
      display: inline-block;
      margin: 10px 20px 20px 20px;
      width: calc((100% - 132px) /3);
      font-size: 20px;
      border: 2px solid black; 
      background-color: lightblue;
      text-rendering: auto;
    }
     </style>
  </head>
  <body>
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
                    <li class="active"><a class="nav-link" href="首頁網址"><img src="<%=request.getContextPath() %>/images/compare/logo.jpg" alt="" height="80px"></a></li>
                    <li><a class="nav-link" href="搜尋網址">訂房搜尋</a></li>
                    <li><a class="nav-link" href="比較網址">比較</a></li>
                    <li><a class="nav-link" href="最新消息網址">最新消息</a></li>
                    <li><a class="nav-link" href="https://www.google.com.tw/maps/search/%E9%A4%90%E5%BB%B3/@25.0461415,121.5255809,15z/data=!3m1!4b1?hl=zh-TW">美食</a></li>
                  </ul>
                </div>
                <!-- top menu end --> 
              </nav>
              <!-- header navigation end --> 
            </div>
            <div class="col-lg-4 col-md-6 col-sm-8 col-10 text-right"> 
              <!-- header right link -->
              <div class="header-right-link">
                <ul>
                  <li><a href="登入網址"><i class="fas fa-chevron-right"></i> Sign in</a></li>
                  <li><a href="註冊網址"><i class="fas fa-chevron-right"></i> Register</a></li>
                </ul>
              </div>
              <!-- header right link end --> 
            </div>
          </div>
        </div>
      </div>
      </header>
      <!-- header upper end --> 

      <!-- 搜尋日期房型 開始 -->
    
      <div class="center-search">
            <h1 class="text-white">Enjoy Your Holiday</h1>
            <p class="text-white">Search and Book Hotel</p>
            <form class="form-style-1">
              
              <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6 col-6 checkin">
                  <div class="form-group">
                    <input type="text" class="form-control" id="check-in" placeholder="Check In" >
                  </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6 col-6 checkout">
                  <div class="form-group">
                    <input type="text" class="form-control" id="check-out" placeholder="Check Out">
                  </div>
                </div>
              </div>
                              
              <button type="submit" class="btn-style-1 w-100">Search</button>
          </form>
        </div>
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
                      <img src="<%=request.getContextPath() %>/images/compare/blog/blog-1.jpg" alt="" />
                    </div>
                    <div class="blog-des">
                      <div class="form-group">
                        <select class="form-control">
                          <option>房型</option>
                          <option>雙人房</option>
                          <option>四人房</option>
                          <option>六人房</option>
                        </select>
                        <p>價格：</p><p class="price1" type="text" value="取得房間價格，要改標籤"></p>
                      </div>
                      <button type="submit" class="btn-style-1">立即下訂</button>
                      <button type="submit" id="detail1" class="btn-style-1" >查看詳情</button>
                      <!-- <input id="Mybutton" style="margin-left:230px;margin-bottom:0px" type=button color="red" value="下訂" οnclick="window.open('sub1.html')"> -->
                    </div>
                  </div>
                  <!-- blog box end -->
                </div>
                <div class="col-lg-4 col-md-6 mb-30">
                  <!-- blog box -->
                  <div class="blog-box shadow2">
                    <div class="blog_img mb-20">
                      <img src="<%=request.getContextPath() %>/images/compare/blog/blog-1.jpg" alt="" />
                    </div>
                    <div class="blog-des">
                      <div class="form-group">
                        <select class="form-control">
                          <option>房型</option>
                          <option>雙人房</option>
                          <option>四人房</option>
                          <option>六人房</option>
                        </select>
                        <p>價格：</p><p class="price1" type="text" value="取得房間價格，要改標籤"></p>
                      </div>
                      <button type="submit" class="btn-style-1">立即下訂</button>
                      <button type="submit" id="detail2" class="btn-style-1" >查看詳情</button>
                      <!-- <input id="Mybutton" style="margin-left:230px;margin-bottom:0px" type=button color="red" value="下訂" οnclick="window.open('sub1.html')"> -->
                    </div>
                  </div>
                  <!-- blog box end -->
                </div>
                <div class="col-lg-4 col-md-6 mb-30">
                  <!-- blog box -->
                  <div class="blog-box shadow3">
                    <div class="blog_img mb-20">
                      <img src="<%=request.getContextPath() %>/images/compare/blog/blog-1.jpg" alt="" />
                    </div>
                    <div class="blog-des">
                      <div class="form-group">
                        <select class="form-control">
                          <option>房型</option>
                          <option>雙人房</option>
                          <option>四人房</option>
                          <option>六人房</option>
                        </select>
                        <p>價格：</p><p class="price1" type="text" value="取得房間價格，要改標籤"></p>
                      </div>
                      <button type="submit" class="btn-style-1">立即下訂</button>
                      <button type="submit" id="detail3" class="btn-style-1" >查看詳情</button>
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
            <p id="detail" style=" word-wrap:break-word;">
            內文我還搞不懂垂直卷軸怎麼叫出來，還有自動換行的部分!!!!111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111
          </p>
          </div>
          <!-- <textarea class="detila" name="mytext"  placeholder="飯店介紹" readonly></textarea> -->
          <!-- 介紹內文 結束 --> 

          <!-- 自助黏貼區 開始 -->
           <!-- blog box -->
           <div class="self-typying">
            <div class="typ1">
              <textarea class="type" name="mytext" rows="20" cols="35" placeholder="此處可輸入或貼上內容"></textarea>
              <textarea class="type" name="mytext" rows="20" cols="35" placeholder="此處可輸入或貼上內容"></textarea>
              <textarea class="type" name="mytext" rows="20" cols="35" placeholder="此處可輸入或貼上內容"></textarea>
            </div>
          </div>
          <!-- blog box end -->
          <!-- 自助黏貼區 結束 -->


          <!-- js files --> 
<script src="<%=request.getContextPath() %>/js/compare/jquery-3.5.1.min.js"></script> 
<script src="<%=request.getContextPath() %>/js/compare/bootstrap.bundle.min.js"></script> 
<!-- counter js --> 
<script src="<%=request.getContextPath() %>/js/compare/jquery-1.10.2.min.js"></script> 
<script src="<%=request.getContextPath() %>/js/compare/waypoints.min.js"></script> 
<script src="<%=request.getContextPath() %>/js/compare/jquery.counterup.min.js"></script> 
<!-- venobox js --> 
<script src="<%=request.getContextPath() %>/js/compare/venobox.min.js"></script> 
<!-- owl carousel --> 
<script src="<%=request.getContextPath() %>/js/compare/owl.carousel.min.js"></script> 
<!-- portfolio js --> 
<script src="<%=request.getContextPath() %>/js/compare/jquery.mixitup.min.js"></script> 
<!-- datepicker js --> 
<script src="<%=request.getContextPath() %>/js/compare/datepicker.min.js"></script> 
<!-- script js --> 
<script src="<%=request.getContextPath() %>/js/compare/custom.js"></script>
  </body>
</html>
