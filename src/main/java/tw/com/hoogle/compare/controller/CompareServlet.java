package tw.com.hoogle.compare.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.hoogle.compare.model.CompareService;
import tw.com.hoogle.compare.model.CompareVO;

@WebServlet("/compare/CompareServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class CompareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println(123);
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			System.out.println("getOne_For_Display##1");

//			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String hotelName1 = req.getParameter("hotelName1");	//"hotelName1" = jsp的name屬性
			String hotelName2 = req.getParameter("hotelName2");
			String hotelName3 = req.getParameter("hotelName3");
			System.out.println("hotelName1 = " + hotelName1);
			System.out.println("hotelName2 = " + hotelName2);
			System.out.println("hotelName3 = " + hotelName3);
//			

			/*************************** 2.開始查詢資料 *****************************************/
			CompareService compareSvc = new CompareService();
			List<CompareVO> list1 = compareSvc.getOneHotel(hotelName1);
			List<CompareVO> list2 = compareSvc.getOneHotel(hotelName2);
			List<CompareVO> list3 = compareSvc.getOneHotel(hotelName3);
			System.out.println(list1);
			System.out.println("getOne_For_Display##2");
//			if (hotelName == null) {
//				errorMsgs.add("查無資料");
//			}
//			// Send the use back to the form, if there were errors
//			if (!errorMsgs.isEmpty()) {
//				RequestDispatcher failureView = req.getRequestDispatcher("/compare/compare.jsp");
//				failureView.forward(req, res);
//				return;// 程式中斷
//			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("list1", list1); // 資料庫取出的ordVO物件,存入req
			req.setAttribute("list2", list2); // 資料庫取出的ordVO物件,存入req
			req.setAttribute("list3", list3); // 資料庫取出的ordVO物件,存入req
			String url = "/compare/compare.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneOrd.jsp
			successView.forward(req, res);
			System.out.println("getOne_For_Display##3");
		}

		
	}

}
