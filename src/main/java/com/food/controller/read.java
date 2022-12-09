package com.food.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class read
 */
@WebServlet("/read")
public class read extends HttpServlet {
	Connection con;

public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {

	res.setContentType("image/gif");
	ServletOutputStream out = res.getOutputStream();

	try {
		Statement stmt = con.createStatement();
		String foodPicid = req.getParameter("foodPicid");
		ResultSet rs = stmt.executeQuery(
			"SELECT foodPic FROM food WHERE foodPicid = "+foodPicid);

		if (rs.next()) {
			BufferedInputStream in = new BufferedInputStream(rs.getBinaryStream("foodPic"));
			byte[] buf = new byte[4 * 1024]; // 4K buffer
			int len;
			while ((len = in.read(buf)) != -1) {
				out.write(buf, 0, len);
			}
			in.close();
		} else {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
		rs.close();
		stmt.close();
	} catch (Exception e) {
		System.out.println(e);
	}
}

public void init() throws ServletException {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOOGLE?serverTimezone=Asia/Taipei", "root", "password");
	} catch (ClassNotFoundException e) {
		throw new UnavailableException("Couldn't load JdbcOdbcDriver");
	} catch (SQLException e) {
		throw new UnavailableException("Couldn't get db connection");
	}
}

public void destroy() {
	try {
		if (con != null) con.close();
	} catch (SQLException e) {
		System.out.println(e);
	}
}

}