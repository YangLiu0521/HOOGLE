<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>飯店註冊頁面</title>

<!-- favicon -->
<link rel="icon" href="favicon.ico" />
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
</head>
<body>

<!-- ================ Inner banner ================ -->
<div class="inner-banner inner-banner-bg pt-70 pb-40">
  <div class="container">
    <div class="row align-items-center">
      <div class="col-lg-8 col-md-8 mb-30"> 
        <!-- page-title -->
        <div class="page-title">
          <h1>飯店註冊</h1>
        </div>
        <!-- page-title end --> 
      </div>
      <div class="col-lg-4 col-md-4 mb-30"> 
        <!-- breadcrumb -->
        <ol class="breadcrumb mb-0">
          <li class="breadcrumb-item"><a href="#">Home</a></li>
          <li class="breadcrumb-item active">Register</li>
        </ol>
        <!-- breadcrumb end --> 
      </div>
    </div>
  </div>
</div>
<!-- ================ Register page ================ -->
<div class="login-register-page pt-70 pb-70">
  <div class="container">
    <div class="row">
      <div class="col-lg-6 offset-lg-3"> 
        <!-- register box -->
        <div class="login-box">
          <form class="form-style-1 shadow p-30">
            <p>還沒有帳號嗎？立即註冊吧！
            </p>
            <div class="form-group">
              <input type="email" class="form-control" placeholder="信箱(此為登入帳號)">
            </div>
            <div class="form-group">
              <input type="password" class="form-control" placeholder="密碼">
            </div>
            <div class="form-group">
              <input type="password" class="form-control" placeholder="確認密碼">
            </div>
            <div class="form-group">
              <input type="text" class="form-control" placeholder="飯店名稱">
            </div>
            <div class="form-group">
              <input type="text" class="form-control" placeholder="電話">
            </div>
            <div class="form-group">
              <input type="text" class="form-control" placeholder="負責人">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="統一編號">
              </div>
            <button type="submit" class="btn-style-1 w-100">Create an Account</button>
          </form>
        </div>
        <!-- register box end --> 
      </div>
    </div>
  </div>
</div>
<!-- ================ Register page end ================ --> 
    
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
</body>
</html>