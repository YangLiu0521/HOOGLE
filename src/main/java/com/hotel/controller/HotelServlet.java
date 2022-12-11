package com.hotel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.model.HotelService;
import com.hotel.model.HotelVO;
import com.mail.model.MailService;

@WebServlet("/hotel/HotelServlet")
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
		
		String hotelservlet = null;
		if (req.getParameter("hotelservlet") != null) {
			hotelservlet = req.getParameter("hotelservlet");
		}
		System.out.println("######  into HotelServlet  ######. hotelservlet is " + hotelservlet);
		
// ===================================================飯店忘記密碼=========================================================//
		
		if("forgotPasswordForHotel".equals(hotelservlet)) {
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
				if(hotelEmail == null || (hotelEmail.trim().length() == 0)) {
					errorMsgs.add("請輸入註冊時信箱");
				} else if(hotelTaxid == null || (hotelTaxid.trim().length() == 0)) {
					errorMsgs.add("請輸入註冊時統一編號");
				}
				
				HotelService hotelSvc = new HotelService();
				HotelVO hotelVO = hotelSvc.getOneHotel(hotelEmail, hotelTaxid);
				if(!hotelEmail.equals(hotelVO.getHotelEmail())) {
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
				
			}catch(Exception e) {
				e.getStackTrace();
				errorMsgs.add("飯店忘記密碼錯誤" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/hotel/loginForHotel.jsp");
				failureView.forward(req, res);
			}
			
		}
		
		
	}

}
