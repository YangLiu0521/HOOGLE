package com.otherhotel.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.hotel.model.HotelVO;


public class OtherHotelDAO implements OtherHotelDAO_interface{
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/HOOGLEDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	
	private static final String UPDATE = "UPDATE hotel set hotelEmail=?, hotelPassword=?, hotelName=?, hotelPhone=?, hotelPrincipal=?, hotelTaxid=?, hotelCounty=?, hotelAddress=?, hotelType=?, hotelNotice=?, hotelQa=?, hotelIntroduction=?, hotelState=? where hotelId = ?";
	
	
	@Override
	public void updateHotel(OtherHotelVO otherhotelVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, otherhotelVO.getHotelEmail());
			pstmt.setString(2, otherhotelVO.getHotelPassword());
			pstmt.setString(3, otherhotelVO.getHotelName());
			pstmt.setString(4, otherhotelVO.getHotelPhone());
			pstmt.setString(5, otherhotelVO.getHotelPrincipal());
			pstmt.setString(6, otherhotelVO.getHotelTaxid());
			pstmt.setString(7, otherhotelVO.getHotelCounty());
			pstmt.setString(8, otherhotelVO.getHotelAddress());
			pstmt.setString(9, otherhotelVO.getHotelType());
			pstmt.setString(10, otherhotelVO.getHotelNotice());
			pstmt.setString(11, otherhotelVO.getHotelQa());
			pstmt.setString(12, otherhotelVO.getHotelIntroduction());
			pstmt.setInt(13, otherhotelVO.getHotelState());
			pstmt.setInt(14, otherhotelVO.getHotelId());

			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}
}

	
	