<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="tw.com.hoogle.searchHotel.model.*"%>
<%@ page import="java.util.*" %>
<%@ page import="tw.com.hoogle.ord.model.*" %>
<%@ page import="tw.com.hoogle.user.model.*" %>
<%@ page import="tw.com.hoogle.searchHotel.model.*" %>


<% 
// if (session.getAttribute("userVO") == null && session.getAttribute("hotelVO") == null ) {
// 	RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
// 	dispatcher.forward(request, response);
// 	return;
// }else if(session.getAttribute("copVO") != null){
// 	RequestDispatcher dispatcher = request.getRequestDispatcher("/hotel/hotelMemberCenter.jsp");
// 	dispatcher.forward(request, response);
// 	return;
// }
UserVO userVO = (UserVO) request.getSession().getAttribute("userVO"); //UserServlet.java(Controller)

OrdVO ordVO = (OrdVO) request.getSession().getAttribute("ordVO");

OrdService ordSvc = new OrdService();
List<OrdVO> list = ordSvc.getAll();
pageContext.setAttribute("list",list);

%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Fontawesome -->
<!-- <script src="https://kit.fontawesome.com/0cf2b86d93.js" crossorigin="anonymous"></script> -->

<!-- page title -->
<title>Hoogle_SearchHotel</title>

<%@ include file="/header.jsp" %>
</head>

<body>
<!-- ================ Preloader ================ -->
<!-- <div id="preloader"> -->
<!--   <div class="spinner-grow" role="status"> <span class="sr-only">Loading...</span> </div> -->
<!-- </div> -->
<!-- ================ Preloader end ================ --> 

<!-- ================ Header ================ -->
<header class="header"> 

  
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
                    <input type="text" class="form-control" name="checkinInput" value="${param.checkinInput}"  id="check-in" placeholder="訂房日期">
                  </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6 col-6">
                  <div class="form-group">
                    <input type="text" class="form-control" name="checkoutInput" value="${param.checkoutInput}" id="check-out" placeholder="退房日期">
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6 col-6"></div>
                <div class="col-lg-6 col-md-6 col-sm-6 col-6">
                  <div class="form-group"></div>
                </div>
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
<!-- <div class="about-area pt-70 pb-60"> -->
<!--   <div class="container"> -->
<!--     <div class="row"> -->
<!--       <div class="col-lg-6 mb-30">  -->
<!--       <div class="col-lg-6 mb-30">  -->
<!--       </div> -->
<!--     </div> -->
<!--   </div> -->
<!-- </div> -->
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
    <c:if test="${not empty checkinInput}">
    <c:if test="${not empty checkoutInput}">
    <c:if test="${ordNights > 0}">
    <div class="section-title text-center">
		<h4>訂房日期 : ${checkinInput}</h4>
      	<h4>退房日期 : ${checkoutInput}</h4>
      	<h4>入住天數 : ${ordNights}天</h4>   
     </div>
     </c:if>
     </c:if>
     </c:if>
     <c:if test="${ordNights < 0}">
      <div class="section-title text-center">
      	<h4>入住日期(${checkinInput})不得晚於退房日期(${checkoutInput})</h4>   
     </div>
     </c:if>
<div class="row">
<c:if test="${hotelCountyInput=='台北市'}">
      <div class="col-lg-4 col-md-6 col-sm-6 mb-30">     
        <!-- popular destination box -->
        <div class="popular-destination-box">
          <div class="img-holder-overlay">
            <div class="img-holder"><img src="${pageContext.request.contextPath}/images/popular-destination/1.jpg" alt=""></div>
            <div class="overlay"><a href="#"><i class="fas fa-share"></i></a></div>
          </div>        
          
        <div class="title text-center">
<%--             <h3><a href="${pageContext.request.contextPath}/hotelDetail/hotelDetail.jsp">${hotelCountyInput}</a></h3> --%>
					<FORM METHOD="post" ACTION="${pageContext.request.contextPath}/OrdServlet" >
						<input type="hidden" name="userId" value="${userVO.userId}"><font color=red>${errorMsgs.userId}</font>
						<input type="hidden" name="hotelId" value="${3001}"><font color=red>${errorMsgs.hotelId}</font>
						<input type="hidden" name="userName" value="${userVO.userName}"><font color=red>${errorMsgs.userName}</font>
						<input type="hidden" name="hotelName" value="hotel1"><font color=red>${errorMsgs.hotelName}</font>
						<input type="hidden" name="ordDate" value="${ordDate}"><font color=red>${errorMsgs.ordDate}</font>
						<input type="hidden" name="ordCheckin" value="${checkinInput}"><font color=red>${errorMsgs.checkinInput}</font>
						<input type="hidden" name="ordCheckout" value="${checkoutInput}"><font color=red>${errorMsgs.checkoutInput}</font>
						<input type="hidden" name="ordNights" value="${ordNights}"><font color=red>${errorMsgs.ordNights}</font>
						<input type="hidden" name="ordRemark" value="無特別註記"><font color=red>${errorMsgs.ordNights}</font>
						<input type="hidden" name="action" value="insert">
						<input type="submit" value="hotel1">
					</FORM>
          </div>
        </div>
        <!-- popular destination box end --> 
      </div>
</c:if>
 
    <c:if test="${hotelCountyInput=='新北市'}">  
      <div class="col-lg-4 col-md-6 col-sm-6 mb-30"> 
        <!-- popular destination box -->
        <div class="popular-destination-box">
          <div class="img-holder-overlay">
            <div class="img-holder"><img src="${pageContext.request.contextPath}/images/popular-destination/2.jpg" alt=""></div>
            <div class="overlay"><a href="#"><i class="fas fa-share"></i></a></div>
          </div>
          <div class="title">
            <h3><a href="">${hotelCountyInput}</a></h3>
          </div>
        </div>
        <!-- popular destination box end --> 
      </div>
   </c:if>
      
    <c:if test="${hotelCountyInput=='台中市'}">  
      <div class="col-lg-4 col-md-6 col-sm-6 mb-30"> 
        <!-- popular destination box -->
        <div class="popular-destination-box">
          <div class="img-holder-overlay">
            <div class="img-holder"><img src="${pageContext.request.contextPath}/images/popular-destination/3.jpg" alt=""></div>
            <div class="overlay"><a href="#"><i class="fas fa-share"></i></a></div>
          </div>
          <div class="title">
            <h3><a href="">${hotelCountyInput}</a></h3>
          </div>
        </div>
        <!-- popular destination box end --> 
      </div>
     </c:if>
      
     <c:if test="${hotelCountyInput=='台南市'}">  
      <div class="col-lg-4 col-md-6 col-sm-6 mb-30"> 
        <!-- popular destination box -->
        <div class="popular-destination-box">
          <div class="img-holder-overlay">
            <div class="img-holder"><img src="${pageContext.request.contextPath}/images/popular-destination/4.jpg" alt=""></div>
            <div class="overlay"><a href="#"><i class="fas fa-share"></i></a></div>
          </div>
          <div class="title">
            <h3><a href="">${hotelCountyInput}</a></h3>
          </div>
        </div>
        <!-- popular destination box end --> 
      </div>
     </c:if>
     
     <c:if test="${hotelCountyInput=='高雄市'}">  
      <div class="col-lg-4 col-md-6 col-sm-6 mb-30"> 
        <!-- popular destination box -->
        <div class="popular-destination-box">
          <div class="img-holder-overlay">
            <div class="img-holder"><img src="${pageContext.request.contextPath}/images/popular-destination/5.jpg" alt=""></div>
            <div class="overlay"><a href="#"><i class="fas fa-share"></i></a></div>
          </div>
          <div class="title">
            <h3><a href="">${hotelCountyInput}</a></h3>
          </div>
        </div>
        <!-- popular destination box end --> 
      </div>
      </c:if>
      
       <c:if test="${hotelCountyInput=='台北市'}">  
      <div class="col-lg-4 col-md-6 col-sm-6 mb-30"> 
<!--         popular destination box -->
        <div class="popular-destination-box">
          <div class="img-holder-overlay">
            <div class="img-holder"><img src="${pageContext.request.contextPath}/images/popular-destination/6.jpg" alt=""></div>
            <div class="overlay"><a href="#"><i class="fas fa-share"></i></a></div>
          </div>
          <div class="title">
            <h3><a href="${pageContext.request.contextPath}/hotelDetail/hotelDetail.jsp">${hotelCountyInput}</a></h3>
          </div>
        </div>
<!--         popular destination box end  -->
      </div>
     </c:if>
    </div>
  </div>
</div>

<!-- >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> -->
<%-- <%-- <c:if test="${not empty select}">	 --%> 
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

<%-- 		<c:forEach var="row" items="${select}"> --%>
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
<%-- <%-- </c:if>	 --%>
<%@ include file="/footer.jsp" %>
</body>
<!-- >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> -->

<!-- ================ Popular destinations end ================ --> 

<!-- ================ Testimonials ================ -->

<!-- ================ Testimonials end ================ --> 


<!-- ================ Download app are ================ -->

<!-- ================ Partner area ================ --> 

<!-- ================ Footer area ================ -->

</html>