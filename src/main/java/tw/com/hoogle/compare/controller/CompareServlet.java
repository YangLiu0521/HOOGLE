package tw.com.hoogle.compare.controller;

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

import tw.com.hoogle.compare.model.CompareService;
import tw.com.hoogle.compare.model.CompareVO;
import tw.com.hoogle.hotel.model.HotelService;
import tw.com.hoogle.hotel.model.HotelVO;
import tw.com.hoogle.ord.model.OrdService;
import tw.com.hoogle.ord.model.OrdVO;

@WebServlet("/compare/CompareServlet")
public class CompareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

//			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("hotelName");
			if (str == null || (str.trim()).length() == 0) {
//				errorMsgs.put("ordID", "請輸入訂單編號");
				errorMsgs.add("請選擇飯店");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/compare/compare.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer hotelName = null;
			try {
				hotelName = Integer.valueOf(str);
			} catch (Exception e) {
//				errorMsgs.put("ordId", "訂單編號格式不正確");
				errorMsgs.add("請選擇飯店");
			}
			// Send the use back to the form, if there were errors
//			if (!errorMsgs.isEmpty()) {
//				RequestDispatcher failureView = req.getRequestDispatcher("/ord/select_ord_page.jsp");
//				failureView.forward(req, res);
//				return;// 程式中斷
//			}

			/*************************** 2.開始查詢資料 *****************************************/
			CompareService compareSvc = new CompareService();
			CompareVO compareVO = compareSvc.getOneHotel(str);
			if (hotelName == null) {
//				errorMsgs.put("ordId", "查無資料");
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/compare/compare.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			
			
//要轉交到哪!!!!??	
			req.setAttribute("compareVO", compareVO); // 資料庫取出的ordVO物件,存入req
			String url = "/compare/compare.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneOrd.jsp
			successView.forward(req, res);
		}

		
	}

}
