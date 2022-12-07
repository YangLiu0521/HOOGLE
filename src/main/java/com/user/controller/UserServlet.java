package com.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.user.model.UserService;
import com.user.model.UserVO;

@WebServlet("/user/user.do")

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		HttpSession session = req.getSession();
		PrintWriter out = res.getWriter();
		String action = null;
		String body = null;
		
		
		if(req.getParameter("action") != null) {
			action = req.getParameter("action");
		}
		System.out.println("######  into UserServlet  ######. action is " + action);
		
//		if((body = req.getReader().readLine()) != null) {
//			JSONObject paraJsonObj = new JSONObject(body);
//			action = paraJsonObj.getString("action");
//		}
		
		
		
// ===================================================單一查詢=========================================================//
		if ("getOne_For_Display".equals(action)) { // select_page.jsp請求
			System.out.println("getOne_For_Display");
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			// 1.接收請求參數，輸入格式的錯誤處理
			String str = req.getParameter("userId");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入旅客編號");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/user/select_page.jsp");
				failureView.forward(req, res);
				return; // 程式中斷於此
			}

			Integer userId = null;
			try {
				userId = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("旅客編號格式不正確");
			}

			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/user/select_page.jsp");
				failureView.forward(req, res);
				return;
			}

			// 2.查詢資料

			UserService userSvc = new UserService();
			UserVO userVO = userSvc.getOneUser(userId);
			if (userId == null) {
				errorMsgs.add("無此筆資料");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/user/select_page.jsp");
				failureView.forward(req, res);
				return;
			}

			// 3.查詢完成，準備轉交

			req.setAttribute("userVO", userVO); // 資料庫取出userVO物件，存入req
			String url = "/user/listOneUser.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交給listOneUser.jsp
			successView.forward(req, res);
		}

// ===================================================旅客註冊=========================================================//
		if ("insert".equals(action)) {
			
			System.out.println("### into insert user ###");

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
//			List<String> reportMsgs = new LinkedList<String>();
//			HttpSession session = req.getSession();
			
			try {
				
				UserService userSvc = new UserService();
				UserVO userVO = new UserVO();
				
				// 1.接收請求參數，輸入格式的錯誤處理
				String userEmail = req.getParameter("userEmail");
				String userEmailReg = "^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$";
				if (userEmail == null || userEmail.trim().length() == 0) {
					errorMsgs.add("請填寫信箱");
				} else if (!userEmail.trim().matches(userEmailReg)) {
					errorMsgs.add("請輸入正確信箱格式");
				} else if (userSvc.getUserEmails(userEmail).size() > 0) {
					errorMsgs.add("已有此帳號，請直接登入");
//					JSONObject jsonObject = new JSONObject();
//					jsonObject.put("err", reportMsgs);
//					jsonObject.put("status", 200);
//					out.print(jsonObject);
//					out.print(reportMsgs);
//					return;
				}
					
				String userPassword = req.getParameter("userPassword");
				String comfirmPassword = req.getParameter("comfirmpassword");
				if (userPassword == null || userPassword.trim().length() == 0) {
					errorMsgs.add("請輸入密碼");
				} else if (!userPassword.equals(comfirmPassword)) {
					errorMsgs.add("兩次密碼需一致");
				} 

				String userName = req.getParameter("userName");
				String userNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (userName == null || userName.trim().length() == 0) {
					errorMsgs.add("請填寫姓名");
				} else if (!userName.trim().matches(userNameReg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
				}

				String userPhone = req.getParameter("userPhone");
				String userPhoneReg = "^[0-9]{10}$";
				if (userPhone == null || userPhone.trim().length() == 0) {
					errorMsgs.add("請輸入電話號碼");
				} else if (!userPhone.trim().matches(userPhoneReg)) {
					errorMsgs.add("電話號碼: 只能是數字 , 且長度必需是10");
				}

				String userIdentity = req.getParameter("userIdentity");
				String userIdentityReg = "^[A-Z][12]\\d{8}$";
				if (userIdentity == null || userIdentity.trim().length() == 0) {
					errorMsgs.add("請輸入身分證");
				} else if (!userIdentity.trim().matches(userIdentityReg)) {
					errorMsgs.add("請符合身分證格式");
				}

				java.sql.Date userBirthday = null;
				try {
					userBirthday = java.sql.Date.valueOf(req.getParameter("userBirthday").trim());
				} catch (IllegalArgumentException e) {
					userBirthday = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入西元日期");
				}

//				java.sql.Date userRegistration = null;
//				try {
//					userRegistration = java.sql.Date.valueOf(req.getParameter("userRegistration").trim());
//				} catch (IllegalArgumentException e) {
//					userRegistration = new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("請輸入西元日期");
//				}

				// 獲得時間戳記
				Timestamp userRegistration = new Timestamp(System.currentTimeMillis());// 獲取系統當前時間
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String timeStr = df.format(userRegistration);
				userRegistration = Timestamp.valueOf(timeStr);

				
				userVO.setUserEmail(userEmail);
				userVO.setUserPassword(userSvc.pwdhash(userPassword));
				userVO.setUserName(userName);
				userVO.setUserPhone(userPhone);
				userVO.setUserIdentity(userIdentity);
				userVO.setUserBirthday(userBirthday);
				userVO.setUserRegistration(userRegistration);

				if (!errorMsgs.isEmpty()) {
					req.setAttribute("userVO", userVO);
					RequestDispatcher failureView = req.getRequestDispatcher("/user/registerForUser.jsp");
					failureView.forward(req, res);
					return;
//					JSONObject jsonObject = new JSONObject();
//					jsonObject.put("err", errorMsgs);
//					jsonObject.put("status", 200);
//					out.print(jsonObject);
//					return;
				}

				// 開始新增資料
				
				userVO = userSvc.addUser(userEmail, userPassword, userName, userPhone, userIdentity, userBirthday,
						userRegistration);
				
				
				
				// 發送註冊成功信件
				
//				MailService mailService = new MailService();
//				String subject = "恭喜您註冊成功！";
//				String messageText = "Hello !" + userVO.getUserName() + " 請謹記此密碼: " + userSvc.getUserEmails(userEmail).get(0).getUserPassword() + "\n" +" (已經啟用)";
//				mailService.sendMail(userVO.getUserEmail(), subject, messageText);
				
				// java驗證後jsp alert
//				String al = "<script type=\"text/javascript\">\n"+
//						   "   alert('註冊成功');\n " +
//						   "</script>";
				
				// 新增完成，準備轉交
				String url = "/user/loginForUser.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交到旅客總表listAllUser.jsp
				successView.forward(req, res);
				// 回傳 json
//				reportMsgs.add("註冊成功");
//				JSONObject jsonObject = new JSONObject();
//				jsonObject.put("data", reportMsgs);
//				jsonObject.put("status", 200);
//				out.print(jsonObject);
				
			}catch(Exception e) {
				session.setAttribute("userVO", "");
				errorMsgs.add("新增資料失敗 "+e.getMessage());
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("err", errorMsgs);
				jsonObject.put("status", 200);
				out.print(jsonObject);
			}

		
		}
		
// ===================================================旅客登入=========================================================//
		
		if("loginForUser".equals(action)) {
			System.out.println("### into loginForUser ###");
			
			List<String> errorMsgs = new LinkedList<>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				
				UserVO userVO = new UserVO();
				UserService userSvc = new UserService();
				
				// 確認旅客輸入的值
				String userEmail = req.getParameter("userEmail");
				if (userEmail == null || userEmail.trim().length() == 0) {
					errorMsgs.add("請輸入信箱");
				}
				System.out.println("使用者輸入的信箱: " + userEmail); // 使用者輸入的信箱
				
				String userPassword = req.getParameter("userPassword");
				if(userPassword == null || userPassword.trim().length() == 0){
					errorMsgs.add("請輸入密碼");
				}
				System.out.println("使用者輸入的密碼: " + userPassword);
				
				
				  
				// 設定UserService傳入資訊
				
				
				userVO = userSvc.findByUserEmail(userEmail);
				String userPwd = userSvc.pwdhash(userPassword);
				
				
				
				
				String userEmailCheck = userVO.getUserEmail();
				System.out.println(userEmailCheck);
				if(!userEmailCheck.equals(userEmail)) {
					errorMsgs.add("信箱或密碼錯誤");
				}
//				System.out.println(userEmailCheck);
				String userPasswordCheck = userVO.getUserPassword();
//				System.out.println(userPasswordCheck);
				if(!userPasswordCheck.equals(userPwd)) {
					errorMsgs.add("信箱或密碼錯誤");
				}
				
				// 確認資料有誤，印出錯誤資料並跳回原頁
				if (!errorMsgs.isEmpty()) {
//					session.setAttribute("userVO", userVO);
					RequestDispatcher failureView = req.getRequestDispatcher("/user/loginForUser.jsp");
					failureView.forward(req, res);
					return;
				}
				
				// 確認資料無誤，則設定
				session.setAttribute("userVO", userVO);
				System.out.println("be login...");
				String location = (String) session.getAttribute("location");
				
				if (location != null) {
					session.removeAttribute("location"); // *工作2: 看看有無來源網頁 (-->如有來源網頁:則重導至來源網頁)
					res.sendRedirect(location);
					return;
				}
				RequestDispatcher successView = req.getRequestDispatcher("/user/userMemberCenter.jsp");
				successView.forward(req, res);
				return;
				
				
				
			}catch(Exception e) {
//				errorMsgs.add(":" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/user/loginForUser.jsp");
				failureView.forward(req, res);
			}
			
		}
		
		

		if ("getOne_For_Update".equals(action)) { // 來自listAllUser.jsp的請求
			
			System.out.println("getOne_For_Update");
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			// 1.接收請求參數
			Integer userId = Integer.valueOf(req.getParameter("userId"));

			// 2.開始查詢資料
			UserService userSvc = new UserService();
			UserVO userVO = userSvc.getOneUser(userId);

			// 3. 查詢完成，準備轉交
			req.setAttribute("userVO", userVO);
			String url = "/user/update_user_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_user_input.jsp
			successView.forward(req, res);
		}

// ===================================================旅客修改資料=========================================================//
		if ("update".equals(action)) { // 來自userMemberCenter的請求
			
			System.out.println("update");

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				
				UserService userSvc = new UserService();
				UserVO userVO = (UserVO) session.getAttribute("userVO");
				System.out.println("### into update ### 1");
				
				
			// 1.接收請求參數，輸入格式的錯誤處理
//			Integer userId = Integer.valueOf(req.getParameter("userId").trim());

//			String userEmail = req.getParameter("userEmail");
//			String userEmailReg = "^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$";
//			if (userEmail == null || userEmail.trim().length() == 0) {
//				errorMsgs.add("請填寫信箱");
//			} else if (!userEmail.trim().matches(userEmailReg)) {
//				errorMsgs.add("請輸入正確信箱格式");
//			}

			String userPassword = req.getParameter("userPassword");
			String comfirmPassword = req.getParameter("comfirmpassword");
			if (userPassword == null || userPassword.trim().length() == 0) {
				errorMsgs.add("請輸入密碼");
			} else if (!userPassword.equals(comfirmPassword)) {
				errorMsgs.add("兩次密碼需一致");
			} 

			String userName = req.getParameter("userName");
			String userNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (userName == null || userName.trim().length() == 0) {
				errorMsgs.add("請填寫姓名");
			} else if (!userName.trim().matches(userNameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}

			String userPhone = req.getParameter("userPhone");
			String userPhoneReg = "^[0-9]{10}$";
			if (userPhone == null || userPhone.trim().length() == 0) {
				errorMsgs.add("請輸入電話號碼");
			} else if (!userPhone.trim().matches(userPhoneReg)) {
				errorMsgs.add("電話號碼: 只能是數字 , 且長度必需是10");
			}

			String userIdentity = req.getParameter("userIdentity");
			String userIdentityReg = "^[A-Z][12]\\d{8}$";
			if (userIdentity == null || userIdentity.trim().length() == 0) {
				errorMsgs.add("請輸入身分證");
			} else if (!userIdentity.trim().matches(userIdentityReg)) {
				errorMsgs.add("請符合身分證格式");
			}

			java.sql.Date userBirthday = null;
			try {
				userBirthday = java.sql.Date.valueOf(req.getParameter("userBirthday").trim());
			} catch (IllegalArgumentException e) {
				userBirthday = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入西元日期");
			}

//			java.sql.Timestamp userRegistration = null;
//			try {
//				userRegistration = java.sql.Timestamp.valueOf(req.getParameter("userRegistration").trim());
//			} catch (IllegalArgumentException e) {
//				userRegistration = new java.sql.Timestamp(System.currentTimeMillis());
//				errorMsgs.add("請輸入西元日期");
//			}
			
//			Timestamp userRegistration = new Timestamp(System.currentTimeMillis());// 獲取系統當前時間
//			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			String timeStr = df.format(userRegistration);
//			userRegistration = Timestamp.valueOf(timeStr);
			

//			UserVO userVO = new UserVO();
//			userVO.setUserId(userId);
//			userVO.setUserEmail(userEmail);
			userVO.setUserPassword(userPassword);
			userVO.setUserName(userName);
			userVO.setUserPhone(userPhone);
			userVO.setUserIdentity(userIdentity);
			userVO.setUserBirthday(userBirthday);
//			userVO.setUserRegistration(userRegistration);

			if (!errorMsgs.isEmpty()) {
				req.setAttribute("userVO", userVO);
				RequestDispatcher failureView = req.getRequestDispatcher("/user/userMemberCenter.jsp");
				failureView.forward(req, res);
				return;
			}

			// 開始修改資料
			
//			userVO = userSvc.updateUser(userId, userEmail, userPassword, userName, userPhone, userIdentity,
//					userBirthday, userRegistration);
			
			userVO = userSvc.updateUser(userVO);
		
			

			// 修改完成，準備轉交
			req.setAttribute("userVO", userVO);
			RequestDispatcher successView = req.getRequestDispatcher("/user/userMemberCenter.jsp"); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
			
			}catch(Exception e) {
				System.out.println("update exception :" + e);
				RequestDispatcher failureView = req.getRequestDispatcher("index.html");
				failureView.forward(req, res);
			}
		}
// ===================================================忘記密碼=========================================================//
		if("forgotPassword".equals(action)) {
			System.out.println("### into forgotPassword ###");
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				
				String userEmail = req.getParameter("userEmail");
				String userEmailReg = "^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$";
				if (userEmail == null || userEmail.trim().length() == 0) {
					errorMsgs.add("請填寫信箱");
				} else if (!userEmail.trim().matches(userEmailReg)) {
					errorMsgs.add("請輸入正確信箱格式");
				}
				
				System.out.println(userEmail);
				
				UserService userSvc = new UserService();
				UserVO userVO = userSvc.findByUserEmail(userEmail);
				if(userVO == null) {
					errorMsgs.add("Your userEmail userVO != null");
				}
				
				if(userEmail.equals(userVO.getUserEmail())) {
					errorMsgs.add("非註冊信箱");
				}
				
				// 確認資料有誤，印出錯誤資料並跳回原頁
				if (!errorMsgs.isEmpty()) {
					session.setAttribute("userVO", userVO);
					RequestDispatcher failureView = req.getRequestDispatcher("/user/loginForUser.jsp"); //錯誤返回登入頁面		
					failureView.forward(req, res);
					return;
				}
				
				
				
			}catch(Exception e) {
				e.getStackTrace();
				errorMsgs.add("忘記密碼錯誤" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/user/loginForUser.jsp");
				failureView.forward(req, res);
			}
			
			
			
		}
		
		
		
		
		
		

// ===================================================刪除資料=========================================================//
		if ("delete".equals(action)) {
			
			System.out.println("delete");

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			// 1.接收請求參數
			Integer userId = Integer.valueOf(req.getParameter("userId"));

			// 2.開始刪除資料
			UserService userSvc = new UserService();
			userSvc.deleteUser(userId);

			// 3.刪除完成，準備轉交
			String url = "/user/listAllUser.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 刪除成功後，轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
		
		out.flush();
		out.close();
	}

}
