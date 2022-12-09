package com.hotelpic.model;
import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.*;



public class HotelpicDAO implements HotelpicDAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/HOOGLEDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO hotelpic (hotelId,hotelpicNo,hotelpicName) VALUES (?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT hotelpicId,hotelId,hotelpicNo,hotelpicName FROM hotelpic";
	private static final String GET_ONE_STMT = "SELECT hotelpicId,hotelId,hotelpicNo,hotelpicName FROM hotelpic where hotelpicId = ?";
	private static final String DELETE = "DELETE FROM hotelpic where hotelpicId = ?";
	private static final String UPDATE = "UPDATE hotelpic set hotelId=?, hotelpicNo=?, hotelpicName=? where hotelpicId = ?";

	@Override
	public void insert(HotelpicVO hotelpicVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setInt(1, hotelpicVO.getHotelId());
			pstmt.setBytes(2, hotelpicVO.getHotelpicNo());
			pstmt.setString(3, hotelpicVO.getHotelpicName());
			
;

			pstmt.executeUpdate();
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

	@Override
	public void update(HotelpicVO hotelpicVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, hotelpicVO.getHotelId());
			pstmt.setBytes(2, hotelpicVO.getHotelpicNo());
			pstmt.setString(3, hotelpicVO.getHotelpicName());
			pstmt.setInt(4, hotelpicVO.getHotelpicId());

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

	@Override
	public void delete(Integer hotelpicId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, hotelpicId);

			pstmt.executeUpdate();

			// Handle any driver errors
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

	@Override
	public HotelpicVO findByPrimaryKey(Integer hotelpicId) {
		
		HotelpicVO hotelpicVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, hotelpicId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				hotelpicVO = new HotelpicVO();
				hotelpicVO.setHotelpicId(rs.getInt("hotelpicId"));
				hotelpicVO.setHotelId(rs.getInt("hotelId"));
				hotelpicVO.setHotelpicNo(rs.getBytes("hotelpicNo"));
				hotelpicVO.setHotelpicName(rs.getString("hotelpicName"));
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
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
		
		return hotelpicVO;
	}

	@Override
	public List<HotelpicVO> getAll() {
		
		List<HotelpicVO> list = new ArrayList<HotelpicVO>();
		HotelpicVO hotelpicVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				hotelpicVO = new HotelpicVO();
				hotelpicVO.setHotelpicId(rs.getInt("hotelpicId"));
				hotelpicVO.setHotelId(rs.getInt("hotelId"));
				hotelpicVO.setHotelpicNo(rs.getBytes("hotelpicNo"));
				hotelpicVO.setHotelpicName(rs.getString("hotelpicName"));
				list.add(hotelpicVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
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
		return list;
	}
}

