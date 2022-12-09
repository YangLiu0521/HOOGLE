package com.food.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

import com.food.model.FoodService;
import com.food.model.FoodVO;


@MultipartConfig
public class FoodServlet extends HttpServlet {

//	public void doGet(HttpServletRequest req, HttpServletResponse res)
//			throws ServletException, IOException {
//		doPost(req, res);
//	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			String str = req.getParameter("foodPicid");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.put("foodPicid","請輸入編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/food/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			
			Integer foodPicid = null;
			try {
				foodPicid = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.put("foodPicid","編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/food/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
				/***************************2.開始查詢資料*****************************************/
//				
				
				FoodService foodSvc = new FoodService();
				FoodVO foodVO = foodSvc.getOneFood(foodPicid);
				if (foodVO == null) {
					errorMsgs.put("foodPicid","查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/food/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("foodVO", foodVO); // 資料庫取出的foodVO物件,存入req
				String url = "/food/listOneFood.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneFood.jsp
				successView.forward(req, res);
		}
		
		
	if ("getOne_For_Update".equals(action)) { // 來自listAllFood.jsp的請求

			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
				Integer foodPicid = Integer.valueOf(req.getParameter("foodPicid"));
				
				/***************************2.開始查詢資料****************************************/
				FoodService foodSvc = new FoodService();
				FoodVO foodVO = foodSvc.getOneFood(foodPicid);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				String param = "?foodPicid="      +foodVO.getFoodPicid()+
						       "&restaurantId="   +foodVO.getRestaurantId()+
						       "&foodPic="        +foodVO.getFoodPic()+
						       "&foodName="       +foodVO.getFoodName();
				String url = "/food/update_food_input.jsp"+param;
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_food_input.jsp
				successView.forward(req, res);
		}
//		
//		
		if ("update".equals(action)) { // 來自update_food_input.jsp的請求
			
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer foodPicid = Integer.valueOf(req.getParameter("foodPicid").trim());
				
				Integer restaurantId = Integer.valueOf(req.getParameter("restaurantId").trim());

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/food/update_food_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				Part part = req.getPart("foodPic");
				InputStream is = part.getInputStream();
				byte[] pic = is.readAllBytes();
				is.close();
			//	byte[]foodPic = null;
				
				String foodName = req.getParameter("foodName");
				String foodNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (foodName == null || foodName.trim().length() == 0) {
					errorMsgs.put("restaurantId","欄位: 請勿空白");
				} else if(!foodName.trim().matches(foodNameReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.put("restaurantId","欄位: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
	            }
				
				
//				
////				
//				
				
//				
//				/***************************2.開始修改資料*****************************************/
				FoodService foodSvc = new FoodService();
				FoodVO foodVO = foodSvc.updateFood(foodPicid,  restaurantId, pic,  foodName);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("foodVO", foodVO); // 資料庫update成功後,正確的的foodVO物件,存入req
				String url = "/food/listOneFood.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneFood.jsp
				successView.forward(req, res);
		}
//
   if ("insert".equals(action)) { // 來自addFood.jsp的請求  
System.out.println("IN INSERT");
		Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
		req.setAttribute("errorMsgs", errorMsgs);

			/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
		Integer restaurantId = Integer.valueOf(req.getParameter("restaurantId").trim());
		
			String foodName = req.getParameter("foodName");
			String foodNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (foodName == null || foodName.trim().length() == 0) {
System.out.println("IN FOODNAME NULL");
				errorMsgs.put("foodName","餐廳名稱: 請勿空白");
			} else if(!foodName.trim().matches(foodNameReg)) { //以下練習正則(規)表示式(regular-expression)
				System.out.println("IN FOODNAME NULL");
				errorMsgs.put("foodName","餐廳名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
            }
			byte[] picture =null;
			Collection<Part> parts = req.getParts();
			for(Part part:parts) {
				String filename = part.getSubmittedFileName();
				if(filename!=null && filename.length()!=0 && part.getContentType()!=null) {
					InputStream inputStream = part.getInputStream();
					picture = inputStream.readAllBytes();
				}
				
			}
			
			
			
		 
			
		
	
			if (!errorMsgs.isEmpty()) {
			RequestDispatcher failureView = req
					.getRequestDispatcher("/food/addFood.jsp");
			failureView.forward(req, res);
			return;
		}
//			
//			/***************************2.開始新增資料***************************************/
			FoodService foodSvc = new FoodService();
			foodSvc.addFood (restaurantId,picture,foodName);
			
//			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/food/listAllFood.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllFood.jsp
			successView.forward(req, res);				
	}
	
	
	if ("delete".equals(action)) { // 來自listAllFood.jsp

		Map<String,String> errorMsgs1 = new LinkedHashMap<String,String>();
		req.setAttribute("errorMsg", errorMsgs1);

			/***************************1.接收請求參數***************************************/
			Integer foodPicid = Integer.valueOf(req.getParameter("foodPicid"));
			
			/***************************2.開始刪除資料***************************************/
			FoodService foodSvc = new FoodService();
			foodSvc.deleteFood(foodPicid);
			
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
			String url = "/food/listAllFood.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
	}
}
	}
