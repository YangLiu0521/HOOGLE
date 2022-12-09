package com.administrator.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.administrator.model.*;

@WebServlet(name = "/AdministratorServlet", urlPatterns= {"/back_end/administrator/AdministratorServlet"})

public class AdministratorServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		//==================== 單一查詢 ====================
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("administratorId");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入管理者編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back_end/administrator/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer administratorId = null;
				try {
					administratorId = Integer.valueOf(str);
				} catch (Exception e) {
					errorMsgs.add("管理者編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back_end/administrator/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				AdministratorService administratorSvc = new AdministratorService();
				AdministratorVO administratorVO = administratorSvc.getOneAdministrator(administratorId);
				if (administratorVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back_end/administrator/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("administratorVO", administratorVO); // 資料庫取出的administratorVO物件,存入req
				String url = "/back_end/administrator/listOne_page.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneAdmin.jsp
				successView.forward(req, res);
		}
		

		if ("getOne_For_Update".equals(action)) { // 來自listAllAdmin.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
Integer administratorId = Integer.valueOf(req.getParameter("administratorId"));
				
				/***************************2.開始查詢資料****************************************/
				AdministratorService administratorSvc = new AdministratorService();
				AdministratorVO administratorVO = administratorSvc.getOneAdministrator(administratorId);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("administratorVO", administratorVO);         // 資料庫取出的administratorVO物件,存入req
				String url = "/back_end/administrator/update_admin_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_admin_input.jsp
				successView.forward(req, res);
		}
		
		
		if ("update".equals(action)) { // 來自update_admin_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
Integer administratorId = Integer.valueOf(req.getParameter("administratorId").trim());
				
String administratorName = req.getParameter("administratorName").trim();
				String administratorNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z)]{2,15}$";
				if (administratorName == null || administratorName.trim().length() == 0) {
					errorMsgs.add("管理者姓名: 請勿空白");
				} else if(!administratorName.trim().matches(administratorNameReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("管理者姓名: 只能是中、英文字母 , 且長度必需在2到15之間");
	            }

String administratorAccount = req.getParameter("administratorAccount").trim();				
				
String administratorPassword = req.getParameter("administratorPassword").trim();
				if (administratorPassword == null || administratorPassword.trim().length() == 0) {
					errorMsgs.add("密碼請勿空白");
				}	
				
				//===== 字串轉成布林值 =====	
                Boolean administratorDominate;
				if (req.getParameter("administratorDominate") != null) {
					administratorDominate = true;
				} else {
					administratorDominate = false;
				}
//String nDominate = req.getParameter("newsDominate");
                Boolean newsDominate;
			    if (req.getParameter("newsDominate") != null) {
				    newsDominate = true;
			    } else {
				    newsDominate = false;
			    }
//String hDominate = req.getParameter("hotelDominate");
                Boolean hotelDominate;
		        if (req.getParameter("hotelDominate") != null) {
			        hotelDominate = true;
		        } else {
			    hotelDominate = false;
		        }
//String uDominate = req.getParameter("userDominate");
                Boolean userDominate;
	            if (req.getParameter("userDominate") != null) {
		            userDominate = true;
	            } else {
		            userDominate = false;
	            }				
				
				java.sql.Date administratorHiredate = null;
				try {
					administratorHiredate = java.sql.Date.valueOf(req.getParameter("administratorHiredate").trim());
				} catch (IllegalArgumentException e) {
					administratorHiredate = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請選擇日期！");
				}

				AdministratorVO administratorVO = new AdministratorVO();
				administratorVO.setAdministratorId(administratorId);
				administratorVO.setAdministratorName(administratorName);
				administratorVO.setAdministratorAccount(administratorAccount);
				administratorVO.setAdministratorPassword(administratorPassword);
				administratorVO.setAdministratorDominate(administratorDominate);
				administratorVO.setNewsDominate(newsDominate);
				administratorVO.setHotelDominate(hotelDominate);
				administratorVO.setUserDominate(userDominate);
				administratorVO.setAdministratorHiredate(administratorHiredate);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
req.setAttribute("administratorVO", administratorVO); // 含有輸入格式錯誤的administratorVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back_end/administrator/update_admin_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				AdministratorService administratorSvc = new AdministratorService();
				administratorVO = administratorSvc.updateAdministrator(administratorId, administratorName, administratorAccount, administratorPassword,
						          administratorDominate,newsDominate, hotelDominate, userDominate, administratorHiredate);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("administratorVO", administratorVO); // 資料庫update成功後,正確的的administratorVO物件,存入req
				String url = "/back_end/administrator/listOne_page.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneAdmin.jsp
				successView.forward(req, res);
		}

        if ("insert".equals(action)) { // 來自addAdmin.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
String administratorName = req.getParameter("administratorName").trim();
//				String administratorNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,15}$";
//				if (administratorName == null || administratorName.trim().length() == 0) {
//					errorMsgs.add("管理者姓名: 請勿空白");
//				} else if(!administratorName.trim().matches(administratorNameReg)) { //以下練習正則(規)表示式(regular-expression)
//					errorMsgs.add("管理者姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到15之間");
//	            }
				String administratorNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z)]{2,15}$";
				if (administratorName == null || administratorName.trim().length() == 0) {
					errorMsgs.add("管理者姓名: 請勿空白");
				} else if(!administratorName.trim().matches(administratorNameReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("管理者姓名: 只能是中、英文字母, 且長度必需在2到15之間");
				}
				
String administratorAccount = req.getParameter("administratorAccount").trim();
				if (administratorAccount == null || administratorAccount.trim().length() == 0) {
					errorMsgs.add("帳號請勿空白");
				}
								
				
String administratorPassword = req.getParameter("administratorPassword").trim();
				if (administratorPassword == null || administratorPassword.trim().length() == 0) {
					errorMsgs.add("密碼請勿空白");
				}
				
				java.sql.Date administratorHiredate = null;
				try {
					administratorHiredate = java.sql.Date.valueOf(req.getParameter("administratorHiredate").trim());
				} catch (IllegalArgumentException e) {
					administratorHiredate = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請選擇日期！");
				}
//===== 字串轉成布林值 =====	
                Boolean administratorDominate;
				if (req.getParameter("administratorDominate") != null) {
					administratorDominate = true;
				} else {
					administratorDominate = false;
				}
//String nDominate = req.getParameter("newsDominate");
                Boolean newsDominate;
			    if (req.getParameter("newsDominate") != null) {
				    newsDominate = true;
			    } else {
				    newsDominate = false;
			    }
//String hDominate = req.getParameter("hotelDominate");
                Boolean hotelDominate;
		        if (req.getParameter("hotelDominate") != null) {
			        hotelDominate = true;
		        } else {
			    hotelDominate = false;
		        }
//String uDominate = req.getParameter("userDominate");
                Boolean userDominate;
	            if (req.getParameter("userDominate") != null) {
		            userDominate = true;
	            } else {
		            userDominate = false;
	            }

				AdministratorVO administratorVO = new AdministratorVO();
				administratorVO.setAdministratorName(administratorName);
				administratorVO.setAdministratorAccount(administratorAccount);
				administratorVO.setAdministratorPassword(administratorPassword);
				administratorVO.setAdministratorDominate(administratorDominate);
				administratorVO.setNewsDominate(newsDominate);
				administratorVO.setHotelDominate(hotelDominate);
				administratorVO.setUserDominate(userDominate);
				administratorVO.setAdministratorHiredate(administratorHiredate);
		

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
req.setAttribute("administratorVO", administratorVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back_end/administrator/addAdmin.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				AdministratorService administratorSvc = new AdministratorService();
				administratorVO = administratorSvc.addAdministrator(administratorName, administratorAccount, administratorPassword,
						                                            administratorDominate, newsDominate, hotelDominate, userDominate, administratorHiredate);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/back_end/administrator/admin_page.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllAdmin.jsp
				successView.forward(req, res);				
		}
		
		
		if ("delete".equals(action)) { // 來自listAllAdmin.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
				/***************************1.接收請求參數***************************************/
				Integer administratorId = Integer.valueOf(req.getParameter("administratorId"));
				
				/***************************2.開始刪除資料***************************************/
				AdministratorService administratorSvc = new AdministratorService();
				administratorSvc.deleteAdministrator(administratorId);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/back_end/administrator/admin_page.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
		}
		
		if ("login".equals(action)) { // 來自login.jsp
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
//				String str = req.getParameter("administratorAccount");
//				if (str == null || (str.trim()).length() == 0) {
//					errorMsgs.add("請輸入帳號");
//				}
//				
//				String str1 = req.getParameter("administratorPassword");
//				if (str1 == null || (str1.trim()).length() == 0) {
//					errorMsgs.add("請輸入密碼");
//				}
//				
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/back_end/login/login.jsp");
//					failureView.forward(req, res);
//					return;//程式中斷
//				}
			
			String administratorAccount = req.getParameter("administratorAccount");
			String administratorPassword = req.getParameter("administratorPassword");

			AdministratorService administratorSvc = new AdministratorService();
			String account = administratorSvc.loginAccount(administratorAccount);
			
			AdministratorService administratorSvc1 = new AdministratorService();
			String password = administratorSvc1.match(administratorAccount);
			// 【檢查該帳號 , 密碼是否有效】
		    if (account == null) {  //【驗證是否有此帳號】
		    	errorMsgs.add("帳號無效");
		    }
		    if (account != null) {  
			    if (account.equals(administratorAccount) && !(password.equals(administratorPassword))) {
			    	errorMsgs.add("帳號或密碼錯誤");
			    }
		    }
		    if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back_end/login/login.jsp");
					failureView.forward(req, res);
					return;//程式中斷
			} else {   //【帳號 , 密碼有效時, 才做以下工作】
				HttpSession session = req.getSession();
			    session.setAttribute("account", account);   //*工作1: 才在session內做已經登入過的標識
			      
//			     try {                                                        
//			       String location = (String) session.getAttribute("location");
//			       if (location != null) {
//			         session.removeAttribute("location");   //*工作2: 看看有無來源網頁 (-->如有來源網頁:則重導至來源網頁)
//			         res.sendRedirect(location);            
//			         return;
//			       }
//			     }catch (Exception ignored) { }
	//
			    res.sendRedirect(req.getContextPath()+"/back_end/administrator/admin_page.jsp");  //*工作3: (-->如無來源網頁:則重導至login_success.jsp)
			}
		}
	}
}