package commend.controller;

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

import commend.model.CommendService;
import commend.model.CommendVO;

@WebServlet("/CommendServlet")
public class CommendServlet extends HttpServlet {

//	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		doPost(req, res);
//	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

//			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("commendAuto");
			if (str == null || (str.trim()).length() == 0) {
//				errorMsgs.put("ordID", "請輸入訂單編號");
				errorMsgs.add("請輸入評價編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/commend/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer commendAuto = null;
			try {
				commendAuto = Integer.valueOf(str);
			} catch (Exception e) {
//				errorMsgs.put("commendAuto", "評價編號格式不正確");
				errorMsgs.add("訂單編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/commend/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			CommendService commendSvc = new CommendService();
			CommendVO commendVO = commendSvc.getOneCommend(commendAuto);
			if (commendVO == null) {
//				errorMsgs.put("commendAuto", "查無資料");
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/commend/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("commendVO", commendVO); // 資料庫取出的commendVO物件,存入req
			String url = "/commend/listOneCommend.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneOrd.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllOrd.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer commendAuto = Integer.valueOf(req.getParameter("commendAuto"));

			/*************************** 2.開始查詢資料 ****************************************/
			CommendService commendSvc = new CommendService();
			CommendVO commendVO = commendSvc.getOneCommend(commendAuto);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			String param = "?commendAuto=" + commendVO.getCommendAuto() + 
							"&ordId=" + commendVO.getOrdId() + 
							"&commendGrade=" + commendVO.getCommendGrade() + 
							"&commendContent=" + commendVO.getCommendContent() + 
							"&commnedDate=" + commendVO.getCommendDate(); 

			String url = "/commend/update_input.jsp" + param;
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_ord_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_commend_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer commendAuto = Integer.valueOf(req.getParameter("commendAuto").trim());

			Integer ordId = null;
			try {
				ordId = Integer.valueOf(req.getParameter("ordId").trim());
			} catch (Exception e) {
				errorMsgs.add("訂單編號格式不正確");
			}

			Integer commendGrade = null;
			try {
				commendGrade = Integer.valueOf(req.getParameter("commendGrade").trim());
			} catch (Exception e) {
				errorMsgs.add("評價等級格式不正確");
			}

//	if(commendGrade < 0 && commendGrade>= 6) {
//		errorMsgs.add("評價等級格式不正確(請填入1-5)");
//	}else{
//			try {
//				commendGrade = Integer.valueOf(Integer.valueOf(req.getParameter("commendGrade").trim()));
//			} catch (Exception e) {
//				errorMsgs.add("評價等級格式不正確(請填入1-5)");
//			}
//	}
			String commendContent = req.getParameter("commendContent");
			if (commendContent == null || commendContent.trim().length() == 0) {
				errorMsgs.add("請填寫評論");
			}

			java.sql.Date commendDate = null;

			CommendVO commendVO = new CommendVO();
			commendVO.setCommendAuto(commendAuto);
			commendVO.setOrdId(ordId);
			commendVO.setCommendGrade(commendGrade);
			commendVO.setCommendContent(commendContent);
			commendVO.setCommendDate(commendDate);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("commendVO", commendVO); // 含有輸入格式錯誤的commendVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/commend/update_commend_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			CommendService commendSvc = new CommendService();
			commendVO = commendSvc.updateCommend(commendAuto, ordId, commendGrade, commendContent, commendDate);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("commendVO", commendVO); // 資料庫update成功後,正確的的commendVO物件,存入req
			String url = "/commend/listOneCommend.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneCommend.jsp
			successView.forward(req, res);
		}

	

        if ("insert".equals(action)) { // 來自addCommend.jsp的請求  
			
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);

				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
			
			Integer ordId = null;
			try {
				ordId = Integer.valueOf(req.getParameter("ordId").trim());
			} catch (NumberFormatException e) {
				errorMsgs.put("ordId","請填數字");
			}
			
			Integer commendGrade = null;
			try {
				commendGrade = Integer.valueOf(req.getParameter("commendGrade").trim());
			} catch (NumberFormatException e) {
				errorMsgs.put("評價等級","請填數字");
			}
			
			String commendContent = req.getParameter("commendContent");
//			String userNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{1,10}$";
			if (commendContent == null || commendContent.trim().length() == 0) {
				errorMsgs.put("評價內容","請勿空白");
			} 
//			else if(!commendContent.trim().matches(commendContentReg)) { //以下練習正則(規)表示式(regular-expression)
//				errorMsgs.put("commendContent","旅客名稱: 只能是中、英文字母、數字和_ , 且長度必需在10字以內");
//            }
						
			java.sql.Date commendDate = null;
//			try {
//				ordDate = java.sql.Date.valueOf(req.getParameter("ordDate").trim());
//			} catch (IllegalArgumentException e) {
//				errorMsgs.put("ordDate","請輸入日期");
//			}
			
				
				/***************************2.開始新增資料***************************************/
				CommendService commendSvc = new CommendService();
				commendSvc.addCommend(ordId, commendGrade, commendContent, commendDate);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/commend/listAllCommend.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllOrd.jsp
				successView.forward(req, res);				
		
		
		
		if ("delete".equals(action)) { // 來自listAllOrd.jsp

			Map<String,String> errorMsgs1 = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs1);
	
				/***************************1.接收請求參數***************************************/
				Integer commendAuto = Integer.valueOf(req.getParameter("commendAuto"));
				
				/***************************2.開始刪除資料***************************************/
				CommendService commendSvc1 = new CommendService();
				commendSvc1.deleteCommend(commendAuto);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url1 = "/commend/listAllCommend.jsp";
				RequestDispatcher successView1 = req.getRequestDispatcher(url1);// 刪除成功後,轉交回送出刪除的來源網頁
				successView1.forward(req, res);
		}
        }
   }}