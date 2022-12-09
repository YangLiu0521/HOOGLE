package com.roompic.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.mysql.cj.protocol.Resultset;
import com.roompic.model.*;

@WebServlet("/roompic/RoompicServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class RoompicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("insert".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			try {
				
				RoompicVO roompicVO = new RoompicVO();
				
				Integer roomAuto = null;
				
				try {
					roomAuto = Integer.valueOf(req.getParameter("roomAuto"));
				} catch (NumberFormatException e) {
					errorMsgs.add("房型流水號必須是數字");
				}
				

				String roomType = req.getParameter("roomType");
				if (roomType == null || roomType.trim().length() == 0) {
					errorMsgs.add("房型種類不可為空");
				}

				byte[] roompicPic = null;

				Part part = req.getPart("roompicPic");
				if (part == null || part.getSize() == 0) {
					errorMsgs.add("請上傳一張圖片");
				}
				
				InputStream is = part.getInputStream();
				roompicPic = new byte[is.available()];
				is.read(roompicPic);
				is.close();
				
				
				roompicVO.setRoomAuto(roomAuto);
				roompicVO.setRoomType(roomType);
				roompicVO.setRoompicPic(roompicPic);

				if (!errorMsgs.isEmpty()) {
					req.setAttribute("roompicVO", roompicVO);
					RequestDispatcher failureView = req.getRequestDispatcher("/roompic/addRoompic.jsp");
					failureView.forward(req, res);
					return;
				}

				// 新增
				RoompicService roompicSvc = new RoompicService();
				roompicVO = roompicSvc.addRoompic(roomAuto, roomType, roompicPic);

				// 轉交
				String url = "/roompic/listAllRoompic.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交到旅客總表listAllUser.jsp
				successView.forward(req, res);

			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/roompic/addRoompic.jsp");
				failureView.forward(req, res);
			}

		}

	}

}
