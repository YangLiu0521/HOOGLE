package tw.com.hoogle.orddetail.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.com.hoogle.orddetail.model.OrdDetailService;
import tw.com.hoogle.orddetail.model.OrdDetailVO;

@WebServlet("/OrddetailServlet")
//@WebServlet(name="OrddetailServlet",urlPatterns="/orddetail/orddetail.do")
public class OrdDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrdDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		HttpSession session = req.getSession();

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
//			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("orddetailId");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.put("orddetailID", "請輸入訂單明細編號");
//				errorMsgs.add("請輸入訂單編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/orddetail/select_orddetail_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer orddetailId = null;
			try {
				orddetailId = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.put("orddetailId", "訂單明細編號格式不正確");
//				errorMsgs.add("訂單編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/orddetail/select_orddetail_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			OrdDetailService orddetailSvc = new OrdDetailService();
			OrdDetailVO orddetailVO = orddetailSvc.getOneOrddetail(orddetailId);
			if (orddetailVO == null) {
				errorMsgs.put("orddetailId", "查無資料");
//				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/orddetail/select_orddetail_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("orddetailVO", orddetailVO); // 資料庫取出的ordVO物件,存入req
			String url = "/orddetail/listOneOrdDetail.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneOrdDetail.jsp
			successView.forward(req, res);
		}

		if ("OrdId_getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
//			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("ordId");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.put("ordId", "請輸入訂單編號");
//				errorMsgs.add("請輸入訂單編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/user/ordSearch.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer ordId = null;
			try {
				ordId = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.put("ordId", "訂單編號格式不正確");
				//errorMsgs.add("訂單編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/user/ordSearch.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			OrdDetailService orddetailSvc = new OrdDetailService();
			List<OrdDetailVO> orddetailVO = orddetailSvc.getOneOrd(ordId);
			if (ordId == null) {
				errorMsgs.put("ordId", "查無資料");
//				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/user/ordSearch.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			
			session.setAttribute("orddetailVO", orddetailVO); // 資料庫取出的orddetailVO物件,存入req
			
			String url = "/user/ordPakage/listAllOrdDetailByOrdId.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneOrdDetail.jsp
			successView.forward(req, res);
		}
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllOrddetail.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer orddetailId = Integer.valueOf(req.getParameter("orddetailId"));

			/*************************** 2.開始查詢資料 ****************************************/
			OrdDetailService orddetailSvc = new OrdDetailService();
			OrdDetailVO orddetailVO = orddetailSvc.getOneOrddetail(orddetailId);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			String param = "?orddetailId=" + orddetailVO.getOrddetailId() + 
							"&ordId=" + orddetailVO.getOrdId() + 
							"&roomAuto=" + orddetailVO.getRoomAuto() + 
							"&roomNumber=" + orddetailVO.getRoomNumber();

			String url = "/orddetail/update_orddetail_input.jsp" + param;
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_orddetail_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_orddetail_input.jsp的請求
			
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer orddetailId = null;
				try {
					orddetailId = Integer.valueOf(req.getParameter("orddetailId").trim());
				} catch (NumberFormatException e) {
					errorMsgs.put("orddetailId","請填數字");
				}
				
				Integer ordId = null;
				try {
					ordId = Integer.valueOf(req.getParameter("ordId").trim());
				} catch (NumberFormatException e) {
					errorMsgs.put("ordId","請填數字");
				}
				
				Integer roomAuto = null;
				try {
					roomAuto = Integer.valueOf(req.getParameter("roomAuto").trim());
				} catch (NumberFormatException e) {
					errorMsgs.put("roomAuto","請填數字");
				}
				
				Integer roomNumber = null;
				try {
					roomNumber = Integer.valueOf(req.getParameter("roomNumber").trim());
				} catch (NumberFormatException e) {
					errorMsgs.put("roomNumber","請填數字");
				}
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/orddetail/update_orddetail_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				OrdDetailService orddetailSvc = new OrdDetailService();
				OrdDetailVO orddetailVO = orddetailSvc.updateOrddetail(orddetailId, ordId, roomAuto, roomNumber);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("orddetailVO", orddetailVO); // 資料庫update成功後,正確的的ordVO物件,存入req
				String url = "/orddetail/listOneOrdDetail.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneOrdDetail.jsp
				successView.forward(req, res);
		}

        if ("insert".equals(action)) { // 來自addOrd.jsp的請求  
			
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);

				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
			
			Integer ordId = null;
			try {
				ordId = Integer.valueOf(req.getParameter("ordId").trim());
				System.out.println("ordId="+ordId);
			} catch (NumberFormatException e) {
				errorMsgs.put("ordId","請填數字");
			}
			
			Integer roomAuto = null;
			try {
				roomAuto = Integer.valueOf(req.getParameter("roomAuto").trim());
				System.out.println("roomAuto="+roomAuto);
			} catch (NumberFormatException e) {
				errorMsgs.put("roomAuto","請填數字");
			}
			
			Integer roomNumber = null;
			try {
				roomNumber = Integer.valueOf(req.getParameter("roomNumber").trim());
				System.out.println("roomNumber="+roomNumber);
			} catch (NumberFormatException e) {
				errorMsgs.put("roomNumber","請填數字");
			}
			
			
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/index.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				OrdDetailService orddetailSvc = new OrdDetailService();
				orddetailSvc.addOrddetail(ordId, roomAuto, roomNumber);
				int money;
				int ordNights = Integer.valueOf(req.getParameter("ordNights").trim());
				if(roomAuto == 4001) {
					money = 1200*roomNumber*ordNights;
				}
				else {
					money = 9999;
				}
				session.setAttribute("roomNumber", roomNumber);
				session.setAttribute("money", money);
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/ord/ord_page.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllOrd.jsp
				successView.forward(req, res);				
		}
		
		
		if ("delete".equals(action)) { // 來自listAllOrd.jsp

			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);
	
				/***************************1.接收請求參數***************************************/
				Integer orddetailId = Integer.valueOf(req.getParameter("orddetailId"));
				
				/***************************2.開始刪除資料***************************************/
				OrdDetailService orddetailSvc = new OrdDetailService();
				orddetailSvc.deleteOrddetail(orddetailId);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/orddetail/listAllOrdDetail.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
		}
	}

}
