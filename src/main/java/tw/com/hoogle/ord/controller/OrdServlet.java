package tw.com.hoogle.ord.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.hoogle.ord.model.OrdService;
import tw.com.hoogle.ord.model.OrdVO;

//@WebServlet("/OrdServlet")
public class OrdServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
//			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("ordId");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.put("ordID", "請輸入訂單編號");
//				errorMsgs.add("請輸入訂單編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/ord/select_ord_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer ordId = null;
			try {
				ordId = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.put("ordId", "訂單編號格式不正確");
//				errorMsgs.add("訂單編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/ord/select_ord_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			OrdService ordSvc = new OrdService();
			OrdVO ordVO = ordSvc.getOneOrd(ordId);
			if (ordVO == null) {
				errorMsgs.put("ordId", "查無資料");
//				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/ord/select_ord_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("ordVO", ordVO); // 資料庫取出的ordVO物件,存入req
			String url = "/ord/listOneOrd.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneOrd.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllOrd.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer ordId = Integer.valueOf(req.getParameter("ordId"));

			/*************************** 2.開始查詢資料 ****************************************/
			OrdService ordSvc = new OrdService();
			OrdVO ordVO = ordSvc.getOneOrd(ordId);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			String param = "?ordId=" + ordVO.getOrdId() + 
							"&userId=" + ordVO.getUserId() + 
							"&hotelId=" + ordVO.getHotelId() + 
							"&userName=" + ordVO.getUserName() + 
							"&hotelName=" + ordVO.getHotelName() + 
							"&ordDate=" + ordVO.getOrdDate() + 
							"&ordCheckin=" + ordVO.getOrdCheckin() + 
							"&ordCheckout=" + ordVO.getOrdCheckout() + 
							"&ordNights=" + ordVO.getOrdNights() + 
							"&ordRemark=" + ordVO.getOrdRemark();

			String url = "/ord/update_ord_input.jsp" + param;
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_ord_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_ord_input.jsp的請求
			
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer ordId = null;
				try {
					ordId = Integer.valueOf(req.getParameter("ordId").trim());
				} catch (NumberFormatException e) {
					errorMsgs.put("ordId","請填數字");
				}
				
				Integer userId = null;
				try {
					userId = Integer.valueOf(req.getParameter("userId").trim());
				} catch (NumberFormatException e) {
					errorMsgs.put("userId","請填數字");
				}
				
				Integer hotelId = null;
				try {
					hotelId = Integer.valueOf(req.getParameter("hotelId").trim());
				} catch (NumberFormatException e) {
					errorMsgs.put("hotelId","請填數字");
				}
				
				String userName = req.getParameter("userName");
				String userNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{1,10}$";
				if (userName == null || userName.trim().length() == 0) {
					errorMsgs.put("userName","旅客名稱: 請勿空白");
				} else if(!userName.trim().matches(userNameReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.put("userName","旅客名稱: 只能是中、英文字母、數字和_ , 且長度必需在10字以內");
	            }
				
				String hotelName = req.getParameter("hotelName");
				String hotelNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{1,10}$";
				if (hotelName == null || hotelName.trim().length() == 0) {
					errorMsgs.put("hotelName","飯店名稱: 請勿空白");
				} else if(!hotelName.trim().matches(hotelNameReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.put("hotelName","飯店名稱: 只能是中、英文字母、數字和_ , 且長度必需在10字以內");
	            }
				
				java.sql.Date ordDate = null;
				try {
					ordDate = java.sql.Date.valueOf(req.getParameter("ordDate").trim());
				} catch (IllegalArgumentException e) {
					errorMsgs.put("ordDate","請輸入日期");
				}
				
				java.sql.Date ordCheckin = null;
				try {
					ordCheckin = java.sql.Date.valueOf(req.getParameter("ordCheckin").trim());
				} catch (IllegalArgumentException e) {
					errorMsgs.put("ordCheckin","請輸入日期");
				}
				
				java.sql.Date ordCheckout = null;
				try {
					ordCheckout = java.sql.Date.valueOf(req.getParameter("ordCheckout").trim());
				} catch (IllegalArgumentException e) {
					errorMsgs.put("ordCheckout","請輸入日期");
				}
				
				Integer ordNights = null;
				try {
					ordNights = Integer.valueOf(req.getParameter("ordNights").trim());
				} catch (NumberFormatException e) {
					errorMsgs.put("ordNights","入住天數請填數字");
				}
				
				String ordRemark = req.getParameter("ordRemark").trim();
			
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/ord/update_ord_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				OrdService ordSvc = new OrdService();
				OrdVO ordVO = ordSvc.updateOrd(ordId, userId ,hotelId ,userName ,hotelName ,ordDate ,ordCheckin ,ordCheckout ,ordNights ,ordRemark);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("ordVO", ordVO); // 資料庫update成功後,正確的的ordVO物件,存入req
				String url = "/ord/listOneOrd.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneOrd.jsp
				successView.forward(req, res);
		}

        if ("insert".equals(action)) { // 來自addOrd.jsp的請求  
			
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);

				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
			
			Integer userId = null;
			try {
				userId = Integer.valueOf(req.getParameter("userId").trim());
			} catch (NumberFormatException e) {
				errorMsgs.put("userId","請填數字");
			}
			
			Integer hotelId = null;
			try {
				hotelId = Integer.valueOf(req.getParameter("hotelId").trim());
			} catch (NumberFormatException e) {
				errorMsgs.put("hotelId","請填數字");
			}
			
			String userName = req.getParameter("userName");
			String userNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{1,10}$";
			if (userName == null || userName.trim().length() == 0) {
				errorMsgs.put("userName","旅客名稱: 請勿空白");
			} else if(!userName.trim().matches(userNameReg)) { //以下練習正則(規)表示式(regular-expression)
				errorMsgs.put("userName","旅客名稱: 只能是中、英文字母、數字和_ , 且長度必需在10字以內");
            }
			
			String hotelName = req.getParameter("hotelName");
			String hotelNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{1,10}$";
			if (hotelName == null || hotelName.trim().length() == 0) {
				errorMsgs.put("hotelName","飯店名稱: 請勿空白");
			} else if(!hotelName.trim().matches(hotelNameReg)) { //以下練習正則(規)表示式(regular-expression)
				errorMsgs.put("hotelName","飯店名稱: 只能是中、英文字母、數字和_ , 且長度必需在10字以內");
            }
			
			java.sql.Date ordDate = null;
			try {
				ordDate = java.sql.Date.valueOf(req.getParameter("ordDate").trim());
			} catch (IllegalArgumentException e) {
				errorMsgs.put("ordDate","請輸入日期");
			}
			
			java.sql.Date ordCheckin = null;
			try {
				ordCheckin = java.sql.Date.valueOf(req.getParameter("ordCheckin").trim());
			} catch (IllegalArgumentException e) {
				errorMsgs.put("ordCheckin","請輸入日期");
			}
			
			java.sql.Date ordCheckout = null;
			try {
				ordCheckout = java.sql.Date.valueOf(req.getParameter("ordCheckout").trim());
			} catch (IllegalArgumentException e) {
				errorMsgs.put("ordCheckout","請輸入日期");
			}
			
			Integer ordNights = null;
			try {
				ordNights = Integer.valueOf(req.getParameter("ordNights").trim());
			} catch (NumberFormatException e) {
				errorMsgs.put("ordNights","入住天數請填數字");
			}
			
			String ordRemark = req.getParameter("ordRemark").trim();
			
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/ord/addOrd.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				OrdService ordSvc = new OrdService();
				ordSvc.addOrd(userId ,hotelId ,userName ,hotelName ,ordDate ,ordCheckin ,ordCheckout ,ordNights ,ordRemark);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/ord/listAllOrd.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllOrd.jsp
				successView.forward(req, res);				
		}
		
		
		if ("delete".equals(action)) { // 來自listAllOrd.jsp

			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);
	
				/***************************1.接收請求參數***************************************/
				Integer ordId = Integer.valueOf(req.getParameter("ordId"));
				
				/***************************2.開始刪除資料***************************************/
				OrdService ordSvc = new OrdService();
				ordSvc.deleteOrd(ordId);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/ord/listAllOrd.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
		}
	}

}
