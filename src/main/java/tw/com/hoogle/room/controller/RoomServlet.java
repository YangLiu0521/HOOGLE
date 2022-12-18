package tw.com.hoogle.room.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.hoogle.room.model.RoomService;
import tw.com.hoogle.room.model.RoomVO;


@WebServlet("/room/RoomServlet")
public class RoomServlet extends HttpServlet {
	

		public void doGet(HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException {
			doPost(req, res);
		}

		public void doPost(HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException {

			req.setCharacterEncoding("UTF-8");
			String action = req.getParameter("action");
			
			
			if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

				Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
				req.setAttribute("errorMsgs", errorMsgs);
				
				
				

					/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("roomAuto");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.put("roomAuto", "請輸入編號");
//					errorMsgs.add("請輸入編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/room/select_room_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}
				
				Integer roomAuto = null;
				try {
					roomAuto = Integer.valueOf(str);
				} catch (Exception e) {
					errorMsgs.put("roomAuto","編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/room/select_room_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
					/***************************2.開始查詢資料*****************************************/
					
					
					RoomService roomSvc = new RoomService();
					RoomVO roomVO = roomSvc.getOneRoom(roomAuto);
					if (roomVO == null) {
						errorMsgs.put("roomAuto","查無資料");
					}
					// Send the use back to the form, if there were errors
					if (!errorMsgs.isEmpty()) {
						RequestDispatcher failureView = req
								.getRequestDispatcher("/room/select_room_page.jsp");
						failureView.forward(req, res);
						return;//程式中斷
					}
					
					/***************************3.查詢完成,準備轉交(Send the Success view)*************/
					req.setAttribute("roomVO", roomVO); // 資料庫取出的roomVO物件,存入req
					String url = "/room/listOneRoom.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneFood.jsp
					successView.forward(req, res);
			}
			
			
		if ("getOne_For_Update".equals(action)) { // 來自listAllFood.jsp的請求

				Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
				req.setAttribute("errorMsgs", errorMsgs);
				
					/***************************1.接收請求參數****************************************/
					Integer roomAuto = Integer.valueOf(req.getParameter("roomAuto"));
					
					/***************************2.開始查詢資料****************************************/
					RoomService roomSvc = new RoomService();
					RoomVO roomVO = roomSvc.getOneRoom(roomAuto);
									
					/***************************3.查詢完成,準備轉交(Send the Success view)************/
					String param = "?roomAuto="      +roomVO.getRoomAuto()+
							        "&hotelId="       +roomVO.getHotelId()+
							        "&roomTotal="     +roomVO.getRoomTotal()+
							        "&nonreserved="   +roomVO.getNonreserved()+
									"&roomName="     +roomVO.getRoomName()+
									"&roomType="     +roomVO.getRoomType()+
									"&roomPrice="    +roomVO.getRoomPrice();
					
					String url = "/Room/update_room_input.jsp"+param;
					RequestDispatcher successView = req.getRequestDispatcher(url);
					successView.forward(req, res);
			}
//			
//			
			if ("update".equals(action)) { // 來自update_room_input.jsp的請求
				
				Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
				req.setAttribute("errorMsgs", errorMsgs);
			
					/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/			
					
					 
					
					Integer roomAuto = null;
					try {
						roomAuto = Integer.valueOf(req.getParameter("roomAuto").trim());
					} catch (NumberFormatException e) {
						errorMsgs.put("roomAuto","請填數字");
					}
					
					Integer hotelId = null;
					try {
						hotelId = Integer.valueOf(req.getParameter("hotelId").trim());
					} catch (NumberFormatException e) {
						errorMsgs.put("hotelId","請填數字");
					}
					
					Integer roomTotal = null;
					try {
						roomTotal = Integer.valueOf(req.getParameter("roomTotal").trim());
					} catch (NumberFormatException e) {
						errorMsgs.put("roomTotal","請填數字");
					}
					Integer nonreserved = null;
					try {
						nonreserved = Integer.valueOf(req.getParameter("nonreserved").trim());
					} catch (NumberFormatException e) {
						errorMsgs.put("nonreserved","請填數字");
					}
					
					
					String roomName = req.getParameter("roomName");
					String roomNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{1,10}$";
					if (roomName == null || roomName.trim().length() == 0) {
						errorMsgs.put("roomName","旅客名稱: 請勿空白");
					} else if(!roomName.trim().matches(roomNameReg)) { //以下練習正則(規)表示式(regular-expression)
						errorMsgs.put("roomName","旅客名稱: 只能是中、英文字母、數字和_ , 且長度必需在10字以內");
		            }
					
					String roomType = req.getParameter("roomType");
					String roomTypeReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{1,10}$";
					if (roomType == null || roomType.trim().length() == 0) {
						errorMsgs.put("roomType","飯店名稱: 請勿空白");
					} else if(!roomType.trim().matches(roomTypeReg)) { //以下練習正則(規)表示式(regular-expression)
						errorMsgs.put("roomType","飯店名稱: 只能是中、英文字母、數字和_ , 且長度必需在10字以內");
		            }
					
					Integer roomPrice = null;
					try {
						roomPrice = Integer.valueOf(req.getParameter("roomPrice").trim());
					} catch (NumberFormatException e) {
						errorMsgs.put("roomPrice","請填數字");
					}
					
					if (!errorMsgs.isEmpty()) {
						RequestDispatcher failureView = req
								.getRequestDispatcher("/food/update_room_input.jsp");
						failureView.forward(req, res);
						return; //程式中斷
					}
					
					
//					
////					
//					
					
//					
//					/***************************2.開始修改資料*****************************************/
					RoomService roomSvc = new RoomService();
					RoomVO roomVO = roomSvc.updateRoom(roomAuto,  hotelId, roomTotal,  nonreserved,roomName,roomType,roomPrice);
					
					/***************************3.修改完成,準備轉交(Send the Success view)*************/
					req.setAttribute("roomVO", roomVO); // 資料庫update成功後,正確的的foodVO物件,存入req
					String url = "/room/listOneRoom.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneFood.jsp
					successView.forward(req, res);
			}
	//
	   if ("insert".equals(action)) { // 來自addFood.jsp的請求  
	System.out.println("IN INSERT");
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);

				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
			
			
			Integer hotelId = null;
			try {
				hotelId = Integer.valueOf(req.getParameter("hotelId").trim());
			} catch (NumberFormatException e) {
				errorMsgs.put("hotelId","請填數字");
			}
			
			Integer roomTotal = null;
			try {
				roomTotal = Integer.valueOf(req.getParameter("roomTotal").trim());
			} catch (NumberFormatException e) {
				errorMsgs.put("roomTotal","請填數字");
			}
			Integer nonreserved = null;
			try {
				nonreserved = Integer.valueOf(req.getParameter("nonreserved").trim());
			} catch (NumberFormatException e) {
				errorMsgs.put("nonreserved","請填數字");
			}
			
			
			String roomName = req.getParameter("roomName");
			String roomNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{1,10}$";
			if (roomName == null || roomName.trim().length() == 0) {
				errorMsgs.put("roomName","旅客名稱: 請勿空白");
			} else if(!roomName.trim().matches(roomNameReg)) { //以下練習正則(規)表示式(regular-expression)
				errorMsgs.put("roomName","旅客名稱: 只能是中、英文字母、數字和_ , 且長度必需在10字以內");
            }
			
			String roomType = req.getParameter("roomType");
			String roomTypeReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{1,10}$";
			if (roomType == null || roomType.trim().length() == 0) {
				errorMsgs.put("roomType","飯店名稱: 請勿空白");
			} else if(!roomType.trim().matches(roomTypeReg)) { //以下練習正則(規)表示式(regular-expression)
				errorMsgs.put("roomType","飯店名稱: 只能是中、英文字母、數字和_ , 且長度必需在10字以內");
            }
			
			Integer roomPrice = null;
			try {
				roomPrice = Integer.valueOf(req.getParameter("roomPrice").trim());
			} catch (NumberFormatException e) {
				errorMsgs.put("roomPrice","請填數字");
			}
			
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/food/update_room_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
//				
//				/***************************2.開始新增資料***************************************/
				RoomService roomSvc = new RoomService();
			roomSvc.addRoom(hotelId, roomTotal, nonreserved, roomName, roomType, roomPrice);
				
				
				
//				/***************************3.新增完成,準備轉交(Send the Success view)***********/
//              String url = "/room/listAllRoom.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllFood.jsp
//				successView.forward(req, res);				
//		}
		
		
		if ("delete".equals(action)) { // 來自listAllFood.jsp

			Map<String,String> errorMsgs1 = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsg", errorMsgs1);

				/***************************1.接收請求參數***************************************/
				Integer roomAuto = Integer.valueOf(req.getParameter("roomAuto"));
				
				/***************************2.開始刪除資料***************************************/
				RoomService roomSvc1 = new RoomService();
				roomSvc1.deleteRoom(roomAuto);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/room/listAllRoom.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
		}
	   }
	   }
	}
		

   
	

