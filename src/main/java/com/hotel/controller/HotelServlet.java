package com.hotel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.model.HotelService;
import com.hotel.model.HotelVO;
import com.mail.model.MailService;

@WebServlet("/hotel/HotelServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class HotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		// 產生HttpSession物件，讓Servlet可以取得該使用者資訊
		HttpSession session = req.getSession(); // 總共有64512條Session
		PrintWriter out = res.getWriter();
		String url = "/hotel/hotelMemberCenter.jsp";

		String hotelservlet = null;
		if (req.getParameter("hotelservlet") != null) {
			hotelservlet = req.getParameter("hotelservlet");
		}
		System.out.println("######  into HotelServlet  ######. hotelservlet is " + hotelservlet);

// ===================================================飯店註冊=========================================================//
		if ("registerHotel".equals(hotelservlet)) {

			System.out.println("### into registerHotel  ###");

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				HotelService hotelSvc = new HotelService();
				HotelVO hotelVO = new HotelVO();

				// 1.接收請求參數，輸入格式的錯誤處理
				String hotelEmail = req.getParameter("hotelEmail");
				String hotelEmailReg = "^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$";
				if (hotelEmail == null || hotelEmail.trim().length() == 0) {
					errorMsgs.add("請填寫信箱");
				} else if (!hotelEmail.trim().matches(hotelEmailReg)) {
					errorMsgs.add("請輸入正確信箱格式");
				}
//						else if (hotelSvc.getUserEmails(hotelEmail).size() > 0) {
//							errorMsgs.add("已有此帳號，請直接登入");				
//						}

				String hotelPassword = req.getParameter("hotelPassword");
				String hotelcomfirmPassword = req.getParameter("hotelcomfirmPassword");
				if (hotelPassword == null || hotelPassword.trim().length() == 0) {
					errorMsgs.add("請輸入密碼");
				} else if (!hotelPassword.equals(hotelcomfirmPassword)) {
					errorMsgs.add("兩次密碼需一致");
				}

				String hotelName = req.getParameter("hotelName");
				String hotelNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (hotelName == null || hotelName.trim().length() == 0) {
					errorMsgs.add("請填寫飯店名稱");
				} else if (!hotelName.trim().matches(hotelNameReg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
				}

				String hotelPhone = req.getParameter("hotelPhone");
				String hotelPhoneReg = "^[0-9]{10}$";
				if (hotelPhone == null || hotelPhone.trim().length() == 0) {
					errorMsgs.add("請輸入電話號碼");
				} else if (!hotelPhone.trim().matches(hotelPhoneReg)) {
					errorMsgs.add("電話號碼: 只能是數字 , 且長度必需是10");
				}

				String hotelPrincipal = req.getParameter("hotelPrincipal");
				if (hotelPrincipal == null || hotelPrincipal.trim().length() == 0) {
					errorMsgs.add("請輸入負責人");
				}

				String hotelTaxid = req.getParameter("hotelTaxid");
				String hotelTaxidPhoneReg = "^[0-9]{8}$";
				if (hotelTaxid == null || hotelTaxid.trim().length() == 0) {
					errorMsgs.add("請輸入統一編號");
				} else if (!hotelTaxid.trim().matches(hotelTaxidPhoneReg)) {
					errorMsgs.add("統一編號: 只能是數字 , 且長度必需8");
				}

				hotelVO.setHotelEmail(hotelEmail);
				hotelVO.setHotelPassword(hotelPassword);
				hotelVO.setHotelName(hotelName);
				hotelVO.setHotelPhone(hotelPhone);
				hotelVO.setHotelPrincipal(hotelPrincipal);
				hotelVO.setHotelTaxid(hotelTaxid);

				if (!errorMsgs.isEmpty()) {
					req.setAttribute("hotelVO", hotelVO);
					RequestDispatcher failureView = req.getRequestDispatcher("/hotel/registerForHotel.jsp");
					failureView.forward(req, res);
					return;
				}

				// 開始新增資料

				hotelVO = hotelSvc.addHotel(hotelVO);
				session.setAttribute("hotelVO", hotelVO);

				// 新增完成，準備轉交
//						String url = "/user/loginForUser.jsp";
//						RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交到loginForUser.jsp					
//						successView.forward(req, res);

				out.println("<meta http-equiv='refresh' content='1;URL=" + req.getContextPath()
						+ "/hotel/loginForHotel.jsp'>");
				out.println("<script> alert('註冊成功!');</script>");

			} catch (Exception e) {
				e.printStackTrace();
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/hotel/registerForHotel.jsp");
				failureView.forward(req, res);
			}

		}

// ===================================================飯店修改=========================================================//
		if ("hotelupdate".equals(hotelservlet)) { // 來自userMemberCenter的請求

			System.out.println("hotelupdate");

			
			Map<String, String> errors = new HashMap<String, String>();
			req.setAttribute("errors", errors);

			try {

				HotelService hotelSvc = new HotelService();
				HotelVO hotelVO = (HotelVO) session.getAttribute("hotelVO"); // 表示已登入，取得userVO物件
				System.out.println("### into hotel update ### 1");

				// 1.接收請求參數，輸入格式的錯誤處理

//				String userPassword = req.getParameter("userPassword");
//				String comfirmPassword = req.getParameter("comfirmpassword");
//				if (userPassword == null || userPassword.trim().length() == 0) {
//					errorMsgs.add("請輸入密碼");
//				} else if (!userPassword.equals(comfirmPassword)) {
//					errorMsgs.add("兩次密碼需一致");
//				}

				String hotelPassword = req.getParameter("hotelPassword");
				String comfirmPassword = req.getParameter("comfirmPassword");
				if (hotelPassword == null || hotelPassword.trim().length() == 0) {

				} else if (comfirmPassword == null || comfirmPassword.trim().length() == 0) {

				} else if (!hotelPassword.equals(comfirmPassword)) {
//					errorMsgs.add("兩次密碼需一致");
				}

				String hotelName = req.getParameter("hotelName");
				String hotelNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (hotelName == null || hotelName.trim().length() == 0) {
					errors.put("hotelName", "請輸入飯店名稱");
				} else if (!hotelName.trim().matches(hotelNameReg)) { // 以下練習正則(規)表示式(regular-expression)
					errors.put("hotelName", "飯店名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
				}

				String hotelPhone = req.getParameter("hotelPhone");
				String hotelPhoneReg = "^[0-9]{10}$";
				if (hotelPhone == null || hotelPhone.trim().length() == 0) {
					errors.put("hotelPhone", "請輸入電話號碼");
				} else if (!hotelPhone.trim().matches(hotelPhoneReg)) {
					errors.put("hotelPhone", "電話號碼: 只能是數字 , 且長度必需是10");
				}

				String hotelPrincipal = req.getParameter("hotelPrincipal");
				if (hotelPrincipal == null || hotelPrincipal.trim().length() == 0) {
					errors.put("hotelPrincipal", "請輸入負責人");
				} 


				hotelVO.setHotelPassword(hotelSvc.pwdhash(hotelPassword));
				hotelVO.setHotelName(hotelName);
				hotelVO.setHotelPhone(hotelPhone);
				hotelVO.setHotelPrincipal(hotelPrincipal);
				
				if(errors != null && !errors.isEmpty()) {
					req.getRequestDispatcher("/hotel/hotelMemberCenter.jsp").forward(req, res);
					return;
				}
				
//				if (!errorMsgs.isEmpty()) {
//					session.setAttribute("hotelVO", hotelVO);
//					RequestDispatcher failureView = req.getRequestDispatcher("/hotel/hotelMemberCenter.jsp");
//					failureView.forward(req, res);
//					return;
//				}

				// 開始修改資料

				hotelVO = hotelSvc.updateHotel(hotelVO);
				System.out.println("修改成功");

				// 修改完成，準備轉交
				out.println("<meta http-equiv='refresh' content='0;URL=" + req.getContextPath()
						+ "/hotel/hotelMemberCenter.jsp'>");
				out.println("<script> alert('修改資料完成!');</script>");

			} catch (Exception e) {
				System.out.println("update exception :" + e);
				RequestDispatcher failureView = req.getRequestDispatcher("index.jsp");
				failureView.forward(req, res);
			}
		}
// ===================================================飯店登入=========================================================//

		if ("loginForHotel".equals(hotelservlet)) {
			System.out.println("### into loginForHotel ###");

			List<String> errorMsgs = new LinkedList<>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				HotelVO hotelVO = new HotelVO();
				HotelService hotelSvc = new HotelService();

				// 確認旅客輸入的值
				String hotelEmail = req.getParameter("hotelEmail");
				if (hotelEmail == null || hotelEmail.trim().length() == 0) {
					errorMsgs.add("請輸入信箱");
				}
				System.out.println("使用者輸入的信箱: " + hotelEmail); // 使用者輸入的信箱

				String hotelPassword = req.getParameter("hotelPassword");
				if (hotelPassword == null || hotelPassword.trim().length() == 0) {
					errorMsgs.add("請輸入密碼");
				}
				System.out.println("使用者輸入的密碼: " + hotelPassword);

				// 設定UserService傳入資訊

				hotelVO = hotelSvc.findByHotelEmail(hotelEmail);
				System.out.println(hotelVO);
				String hotelPwd = hotelSvc.pwdhash(hotelPassword);

				String hotelEmailCheck = hotelVO.getHotelEmail();
				System.out.println(hotelEmailCheck);
				if (!hotelEmailCheck.equals(hotelEmail)) {
					errorMsgs.add("信箱或密碼錯誤");
				}

				String hotelPasswordCheck = hotelVO.getHotelPassword();
				System.out.println(hotelEmailCheck);
				if (!hotelPasswordCheck.equals(hotelPwd)) {
					errorMsgs.add("信箱或密碼錯誤");
				}

				// 確認資料有誤，印出錯誤資料並跳回原頁
				if (!errorMsgs.isEmpty()) {
//					session.setAttribute("hotelVO", hotelVO);
					RequestDispatcher failureView = req.getRequestDispatcher("/hotel/loginForHotel.jsp");
					failureView.forward(req, res);
					return;
				}

				// 確認資料無誤，則設定
				session.setAttribute("hotelVO", hotelVO);
				System.out.println("be login...");
				String location = (String) session.getAttribute("location"); // 看看有無來源網頁

				if (location != null) { // 代表有來源網頁
					session.removeAttribute("location"); // 有來源網頁:重導至來源網頁
					res.sendRedirect(location);
					return;
				}
				RequestDispatcher successView = req.getRequestDispatcher("/hotel/hotelMemberCenter.jsp");
				successView.forward(req, res);
				return;

			} catch (Exception e) {
				errorMsgs.add(":" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/hotel/loginForHotel.jsp");
				failureView.forward(req, res);
			}

		}
// ===================================================飯店忘記密碼=========================================================//

		if ("forgotPasswordForHotel".equals(hotelservlet)) {
			System.out.println("into hotelForgotPassword");
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				// 確認傳入的值
				String hotelEmail = req.getParameter("hotelEmail").trim();
				System.out.println("hotelEmail:" + hotelEmail);
				String hotelTaxid = req.getParameter("hotelTaxid").trim();
				System.out.println("hotelTaxid:" + hotelTaxid);
				// 錯誤處理
				if (hotelEmail == null || (hotelEmail.trim().length() == 0)) {
					errorMsgs.add("請輸入註冊時信箱");
				} else if (hotelTaxid == null || (hotelTaxid.trim().length() == 0)) {
					errorMsgs.add("請輸入註冊時統一編號");
				}

				HotelService hotelSvc = new HotelService();
				HotelVO hotelVO = hotelSvc.getOneHotel(hotelEmail, hotelTaxid);
				if (!hotelEmail.equals(hotelVO.getHotelEmail())) {
					errorMsgs.add("非註冊信箱");
				}

				// 確認資料有誤，印出錯誤資料並跳回原頁
				if (!errorMsgs.isEmpty()) {
					session.setAttribute("hotelVO", hotelVO);
					RequestDispatcher failureView = req.getRequestDispatcher("/hotel/loginForHotel.jsp");
					failureView.forward(req, res);
					return;
				}
				// 確認資料無誤，則設定
				MailService mailService = new MailService();
				String newPassword = mailService.genAuthCode();
				String subject = "忘記密碼重新設定";
				String messageText = "Hello!" + hotelVO.getHotelName() + "您的新密碼 ：「 " + newPassword + "  」";
				mailService.sendMail(hotelEmail, subject, messageText);

				hotelVO.setHotelPassword(newPassword);
				System.out.println(newPassword);
				hotelVO = hotelSvc.updateHotel(hotelVO);
				System.out.println("forgotPasswordSuccess");

				// 設定成功，轉交回登入畫面

				RequestDispatcher successView = req.getRequestDispatcher("/hotel/loginForHotel.jsp");
				successView.forward(req, res);

			} catch (Exception e) {
				e.getStackTrace();
				errorMsgs.add("飯店忘記密碼錯誤" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/hotel/loginForHotel.jsp");
				failureView.forward(req, res);
			}

		}

	}

}
