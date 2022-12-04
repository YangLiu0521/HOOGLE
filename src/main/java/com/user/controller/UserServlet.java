package com.user.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.user.model.*;

@WebServlet(name = "/UserServlet", urlPatterns= {"/user/UserServlet"})

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		//=============================單一查詢=============================//
		if ("getOne_For_Display".equals(action)) { // select_page.jsp請求

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			// 1.接收請求參數，輸入格式的錯誤處理
			String str = req.getParameter("userId");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入旅客編號");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/user/select_page.jsp");
				failureView.forward(req, res);
				return; // 程式中斷於此
			}

			Integer userId = null;
			try {
				userId = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("旅客編號格式不正確");
			}

			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/user/select_page.jsp");
				failureView.forward(req, res);
				return;
			}

			// 2.查詢資料

			UserService userSvc = new UserService();
			UserVO userVO = userSvc.getOneUser(userId);
			if (userId == null) {
				errorMsgs.add("無此筆資料");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/user/select_page.jsp");
				failureView.forward(req, res);
				return;
			}
			
			// 3.查詢完成，準備轉交
			
			req.setAttribute("userVO", userVO); //資料庫取出userVO物件，存入req
			String url = "/user/listOneUser.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交給listOneUser.jsp
			successView.forward(req, res);
		}
		
		//=============================新增資料=============================//
		if("insert".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			// 1.接收請求參數，輸入格式的錯誤處理
			String userEmail = req.getParameter("userEmail");
			String userEmailReg = "^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$";
			if(userEmail == null || userEmail.trim().length() == 0) {
				errorMsgs.add("請填寫信箱");
			} else if(! userEmail.trim().matches(userEmailReg)) {
				errorMsgs.add("請輸入正確信箱格式");
			}
			
			String userPassword = req.getParameter("userPassword").trim();
			if(userPassword == null || userPassword.trim().length() == 0) {
				errorMsgs.add("請輸入密碼");
			}
			
			String userName = req.getParameter("userName");
			String userNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (userName == null || userName.trim().length() == 0) {
				errorMsgs.add("請填寫姓名");
			} else if(!userName.trim().matches(userNameReg)) { //以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
            }
			
			String userPhone = req.getParameter("userPhone");
			String userPhoneReg = "^[0-9]{10}$";
			if (userPhone == null || userPhone.trim().length() == 0) {
				errorMsgs.add("請輸入電話號碼");
			} else if(!userPhone.trim().matches(userPhoneReg)) { 
				errorMsgs.add("電話號碼: 只能是數字 , 且長度必需是10");
            }
			
			String userIdentity = req.getParameter("userIdentity");
			String userIdentityReg = "^[A-Z][12]\\d{8}$";
			if (userIdentity == null || userIdentity.trim().length() == 0) {
				errorMsgs.add("請輸入身分證");
			} else if(!userIdentity.trim().matches(userIdentityReg)) { 
				errorMsgs.add("請符合身分證格式");
            }
			
			java.sql.Date userBirthday = null;
			try {
				userBirthday = java.sql.Date.valueOf(req.getParameter("userBirthday").trim());
			}catch(IllegalArgumentException e) {
				userBirthday = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入西元日期");
			}
			
			java.sql.Date userRegistration = null;
			try {
				userRegistration = java.sql.Date.valueOf(req.getParameter("userRegistration").trim());
			}catch(IllegalArgumentException e) {
				userRegistration = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入西元日期");
			}
					
				UserVO userVO = new UserVO();
				userVO.setUserEmail(userEmail);
				userVO.setUserPassword(userPassword);
				userVO.setUserName(userName);
				userVO.setUserPhone(userPhone);
				userVO.setUserIdentity(userIdentity);
				userVO.setUserBirthday(userBirthday);
				userVO.setUserRegistration(userRegistration);
				
				
				if(! errorMsgs.isEmpty()) {
					req.setAttribute("userVO", userVO);
					RequestDispatcher failureView = req.getRequestDispatcher("/user/addUser.jsp");
					failureView.forward(req, res);
					return;
				}
				
				// 開始新增資料
				UserService userSvc = new UserService();
				userVO = userSvc.addUser(userEmail, userPassword, userName, userPhone, userIdentity, userBirthday, userRegistration);
			
				// 新增完成，準備轉交
				String url = "/user/listAllUser.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); //新增成功後轉交到旅客總表listAllUser.jsp
				successView.forward(req, res);
				
		}
		
	}

}
