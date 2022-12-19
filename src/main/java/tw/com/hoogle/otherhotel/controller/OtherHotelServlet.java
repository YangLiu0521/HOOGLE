package tw.com.hoogle.otherhotel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.com.hoogle.hotel.model.HotelService;
import tw.com.hoogle.hotel.model.HotelVO;
import tw.com.hoogle.otherhotel.model.OtherHotelService;
import tw.com.hoogle.otherhotel.model.OtherHotelVO;

@WebServlet("/otherhotel/OtherHotelServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class OtherHotelServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		// 產生HttpSession物件，讓Servlet可以取得該使用者資訊
		HttpSession session = req.getSession(); // 總共有64512條Session
		PrintWriter out = res.getWriter();
//===============================================不知道要改嗎?====		
		String url = "/hotel/hotelMemberCenter.jsp";

		String otherhotelservlet = null;
		if (req.getParameter("otherhotelservlet") != null) {
			otherhotelservlet = req.getParameter("otherhotelservlet");
		}
		System.out.println("###### update into OtherHotelServlet  ######. otherhotelservlet is " + otherhotelservlet);



// ===================================================飯店修改=========================================================//
		if ("otherhotelupdate".equals(otherhotelservlet)) { // 來自userMemberCenter的請求

			System.out.println("otherhotelupdate");

			
			Map<String, String> errors = new HashMap<String, String>();
			req.setAttribute("errors", errors);

			try {

//				OtherHotelService otherhotelSvc = new OtherHotelService();
//				OtherHotelVO otherhotelVO = (OtherHotelVO) session.getAttribute("hotelVO"); // 表示已登入，取得userVO物件
				HotelService hotelSvc = new HotelService();
				HotelVO hotelVO = (HotelVO) session.getAttribute("hotelVO"); // 表示已登入，取得hotelVO物件
				System.out.println("### update into otherhotel update ### 1");

				// 1.接收請求參數，輸入格式的錯誤處理
			
			
				String hotelCounty = req.getParameter("hotelCounty");
				if (hotelCounty == null || hotelCounty.trim().length() == 0) {
					errors.put("hotelCounty", "請選擇區域");
				} 
				String hotelAddress = req.getParameter("hotelAddress");
				if (hotelAddress == null || hotelAddress.trim().length() == 0) {
					errors.put("hotelAddress", "請輸入地址");
				} 
				
				String hotelType = req.getParameter("hotelType");
				if (hotelType == null || hotelType.trim().length() == 0) {
					errors.put("hotelCounty", "請選擇類型");
				} 
				
				String hotelNotice = req.getParameter("hotelNotice");
				if (hotelNotice == null || hotelNotice.trim().length() == 0) {
					errors.put("hotelNotice", "請輸入訂房須知");
				} 
				
				String hotelQa = req.getParameter("hotelQa");
				if (hotelQa == null || hotelQa.trim().length() == 0) {
					errors.put("hotelQa", "請輸入QA");
				} 
				
				String hotelIntroduction = req.getParameter("hotelIntroduction");
				if (hotelIntroduction == null || hotelIntroduction.trim().length() == 0) {
					errors.put("hotelIntroduction", "請輸入飯店介紹");
				} 


				hotelVO.setHotelCounty(hotelCounty);
				hotelVO.setHotelAddress(hotelAddress);
				hotelVO.setHotelType(hotelType);
				hotelVO.setHotelNotice(hotelNotice);
				hotelVO.setHotelQa(hotelQa);
				hotelVO.setHotelIntroduction(hotelIntroduction);
				
				
				if(errors != null && !errors.isEmpty()) {
					req.getRequestDispatcher("/hotel/hotelMemberCenter.jsp").forward(req, res);
					return;
				}
				
				

				// 開始修改資料

				hotelVO = hotelSvc.updateHotel(hotelVO);
				System.out.println("修改成功");

				// 修改完成，準備轉交
				out.println("<meta http-equiv='refresh' content='0;URL=" + req.getContextPath()
						+ "/hotel/hotelMemberCenter.jsp'>");
				out.println("<script> alert('修改資料完成!');</script>");

			} catch (Exception e) {
				System.out.println("update exception :" + e);
		
				
				RequestDispatcher failureView = req.getRequestDispatcher(url);
				failureView.forward(req, res);
			}
		}
	}
}