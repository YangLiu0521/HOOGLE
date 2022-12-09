<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/commend/commend.css" />
<title>住宿經驗評價</title>
</head>
<body>
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
          <input type="text" value="${commendVO.commendAuto}" />
        </div>
      </div>
      <!-- 評價編號&訂單編號結束 -->
      <!-- 評價等級開始 -->
      <div class="commendGrade">
        <div>
          <h2>評價等級:</h2>
        </div>
        <div id="stars" class="left">
          <img name="1" src="<%=request.getContextPath()%>/images/commend/ostar.png" alt="" />
          <img name="2" src="<%=request.getContextPath()%>/images/commend/ostar.png" alt="" />
          <img name="3" src="<%=request.getContextPath()%>/images/commend/ostar.png" alt="" />
          <img name="4" src="<%=request.getContextPath()%>/images/commend/ostar.png" alt="" />
          <img name="5" src="<%=request.getContextPath()%>/images/commend/ostar.png" alt="" />
        </div>
        <div id="comment" class="left"></div>
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
        <div class="dateandsubmit">
          <!-- <input id="date" type="Date" value="${commendVO.commendAuto}" /> -->
          <input id="submit" type="submit" value="送出評價" />
        </div>
      </div>
      <!-- 評價日期結束 -->
    </div>

    <script src="<%=request.getContextPath()%>/js/commend/commend.js"></script>
  </body>
</html>