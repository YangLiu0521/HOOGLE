package com.room.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ord.model.OrdVO;

public class RoomDAO implements RoomDAO_interface {
	
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/HOOGLE?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";
	
//	private static DataSource ds = null;
//	static {
//		try {			
//			Context ctx = new InitialContext();
//			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/HOOGLEDB");
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//	}
	
	private static final String INSERT_STMT = "INSERT INTO room (hotelId,roomTotal,nonreserved,roomName,roomType,roomPrice) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT roomAuto,hotelId,roomTotal,nonreserved,roomName,roomType,roomPrice FROM room order by roomAuto";
	private static final String GET_ONE_STMT = "SELECT roomAuto,hotelId,roomTotal,nonreserved,roomName,roomType,roomPrice FROM room where roomAuto = ?";
	private static final String DELETE = "DELETE FROM room where roomAuto = ?";
	private static final String UPDATE = "UPDATE room set hotelId=?, roomTotal=?, nonreserved=?, roomName=?, roomType=?, roomPrice=? where roomAuto=?";
	@Override
	public void insert(RoomVO roomVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
//			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, roomVO.getHotelId());
			pstmt.setInt(2, roomVO.getRoomTotal());
			pstmt.setInt(3, roomVO.getNonreserved());
			pstmt.setString(4, roomVO.getRoomName());
			pstmt.setString(5, roomVO.getRoomType());
			pstmt.setInt(6, roomVO.getRoomPrice());


			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void update(RoomVO roomVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
//			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, roomVO.getHotelId());
			pstmt.setInt(2, roomVO.getRoomTotal());
			pstmt.setInt(3, roomVO.getNonreserved());
			pstmt.setString(4, roomVO.getRoomName());
			pstmt.setString(5, roomVO.getRoomType());
			pstmt.setInt(6, roomVO.getRoomPrice());
			pstmt.setInt(7, roomVO.getRoomAuto());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void delete(Integer roomAuto) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
//			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, roomAuto);

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public RoomVO findByPrimaryKey(Integer roomAuto) {
		RoomVO roomVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
//			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, roomAuto);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				roomVO = new RoomVO();
				roomVO.setHotelId(rs.getInt("hotelId"));
				roomVO.setRoomTotal(rs.getInt("roomTotal"));
				roomVO.setNonreserved(rs.getInt("nonreserved"));
				roomVO.setRoomName(rs.getString("roomName"));
				roomVO.setRoomType(rs.getString("roomType"));
				roomVO.setRoomPrice(rs.getInt("roomPrice"));
				roomVO.setRoomAuto(rs.getInt("roomAuto"));

			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return roomVO;	}
	@Override
	public List<RoomVO> getAll() {
		List<RoomVO> list = new ArrayList<RoomVO>();
		RoomVO roomVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
//			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				roomVO = new RoomVO();
				roomVO.setRoomAuto(rs.getInt("roomAuto"));
				roomVO.setHotelId(rs.getInt("hotelId"));
				roomVO.setRoomTotal(rs.getInt("roomTotal"));
				roomVO.setNonreserved(rs.getInt("nonreserved"));
				roomVO.setRoomName(rs.getString("roomName"));
				roomVO.setRoomType(rs.getString("roomType"));
				roomVO.setRoomPrice(rs.getInt("roomPrice"));
				list.add(roomVO);

			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return list;	}



}
