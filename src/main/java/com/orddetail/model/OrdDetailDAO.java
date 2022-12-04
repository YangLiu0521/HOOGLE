package com.orddetail.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class OrdDetailDAO implements OrdDetailDAO_interface{

	
//	String driver = "com.mysql.cj.jdbc.Driver";
//	String url = "jdbc:mysql://localhost:3306/HOOGLE?serverTimezone=Asia/Taipei";
//	String userid = "root";
//	String passwd = "password";
	
	private static DataSource ds = null;
	static {
		try {
			
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/HOOGLEDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
		private static final String INSERT_STMT = 
			"INSERT INTO orddetail (ordId, roomAuto, roomNumber) VALUES (?, ?, ?)";
		private static final String GET_ALL_STMT = 
			"SELECT orddetailId, ordId, roomAuto, roomNumber FROM orddetail order by orddetailId";
		private static final String GET_ONE_STMT = 
			"SELECT orddetailId, ordId, roomAuto, roomNumber FROM orddetail where orddetailId = ?";
		private static final String DELETE = 
			"DELETE FROM orddetail where orddetailId = ?";
		private static final String UPDATE = 
			"UPDATE orddetail set ordId=?, roomAuto=?, roomNumber=? where orddetailId=?";

		
	
	@Override
	public void insert(OrdDetailVO orddetailVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, orddetailVO.getOrdId());
			pstmt.setInt(2, orddetailVO.getRoomAuto());
			pstmt.setInt(3, orddetailVO.getRoomNumber());

			pstmt.executeUpdate();

		} 
//		catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
//			// Handle any SQL errors
//		}
		catch (SQLException se) {
			throw new RuntimeException("A database error occured. "+ se.getMessage());
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
	public void update(OrdDetailVO orddetailVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, orddetailVO.getOrdId());
			pstmt.setInt(2, orddetailVO.getRoomAuto());
			pstmt.setInt(3, orddetailVO.getRoomNumber());
			pstmt.setInt(4, orddetailVO.getOrddetailId());

			pstmt.executeUpdate();

		} 
//		catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
//			// Handle any SQL errors
//		}
		catch (SQLException se) {
			throw new RuntimeException("A database error occured. "+ se.getMessage());
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
	public void delete(Integer orddetailId) {
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, orddetailId);

			pstmt.executeUpdate();

		} 
//		catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
//			// Handle any SQL errors
//		}
		catch (SQLException se) {
			throw new RuntimeException("A database error occured. "+ se.getMessage());
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
	public OrdDetailVO findByPrimaryKey(Integer orddetailId) {

		OrdDetailVO orddetailVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, orddetailId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				orddetailVO = new OrdDetailVO();
				orddetailVO.setOrdId(rs.getInt("ordId"));
				orddetailVO.setRoomAuto(rs.getInt("roomAuto"));
				orddetailVO.setRoomNumber(rs.getInt("roomNumber"));
				orddetailVO.setOrddetailId(rs.getInt("orddetailId"));
				
			}

		} 
//		catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
//			// Handle any SQL errors
//		}
		catch (SQLException se) {
			throw new RuntimeException("A database error occured. "+ se.getMessage());
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
		return orddetailVO;
	}

	@Override
	public List<OrdDetailVO> getAll() {

		List<OrdDetailVO> list = new ArrayList<OrdDetailVO>();
		OrdDetailVO orddetailVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				orddetailVO = new OrdDetailVO();
				orddetailVO.setOrddetailId(rs.getInt("orddetailId"));
				orddetailVO.setOrdId(rs.getInt("ordId"));
				orddetailVO.setRoomAuto(rs.getInt("roomAuto"));
				orddetailVO.setRoomNumber(rs.getInt("roomNumber"));
	
				list.add(orddetailVO); 
				
			}

		} 
//		catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
//			// Handle any SQL errors
//		}
		catch (SQLException se) {
			throw new RuntimeException("A database error occured. "+ se.getMessage());
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
