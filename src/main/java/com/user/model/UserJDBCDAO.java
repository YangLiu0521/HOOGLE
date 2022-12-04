package com.user.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJDBCDAO implements UserDAO_interface {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/HOOGLE?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";

	private static final String INSERT_STMT = "INSERT INTO user (userEmail,userPassword,userName,userPhone,userIdentity,userBirthday,userRegistration) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT userId,userEmail,userPassword,userName,userPhone,userIdentity,userBirthday,userRegistration FROM user";
	private static final String GET_ONE_STMT = "SELECT userId,userEmail,userPassword,userName,userPhone,userIdentity,userBirthday,userRegistration FROM user where userId = ?";
	private static final String DELETE = "DELETE FROM user where userId = ?";
	private static final String UPDATE = "UPDATE user set userEmail=?, userPassword=?, userName=?, userPhone=?, userIdentity=?, userBirthday=?, userRegistration=? where userId = ?";

	@Override
	public void insert(UserVO userVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, userVO.getUserEmail());
			pstmt.setString(2, userVO.getUserPassword());
			pstmt.setString(3, userVO.getUserName());
			pstmt.setString(4, userVO.getUserPhone());
			pstmt.setString(5, userVO.getUserIdentity());
			pstmt.setDate(6, userVO.getUserBirthday());
			pstmt.setDate(7, userVO.getUserRegistration());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
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
	public void update(UserVO userVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, userVO.getUserEmail());
			pstmt.setString(2, userVO.getUserPassword());
			pstmt.setString(3, userVO.getUserName());
			pstmt.setString(4, userVO.getUserPhone());
			pstmt.setString(5, userVO.getUserIdentity());
			pstmt.setDate(6, userVO.getUserBirthday());
			pstmt.setDate(7, userVO.getUserRegistration());
			pstmt.setInt(8, userVO.getUserId());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
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
	public void delete(Integer userId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, userId);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
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
	public UserVO findByPrimaryKey(Integer userId) {

		UserVO userVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, userId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				userVO = new UserVO();
				userVO.setUserId(rs.getInt("userId"));
				userVO.setUserEmail(rs.getString("userEmail"));
				userVO.setUserPassword(rs.getString("userPassword"));
				userVO.setUserName(rs.getString("userName"));
				userVO.setUserPhone(rs.getString("userPhone"));
				userVO.setUserIdentity(rs.getString("userIdentity"));
				userVO.setUserBirthday(rs.getDate("userBirthday"));
				userVO.setUserRegistration(rs.getDate("userRegistration"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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

		return userVO;

	}

	@Override
	public List<UserVO> getAll() {

		List<UserVO> list = new ArrayList<UserVO>();
		UserVO userVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				userVO = new UserVO();
				userVO.setUserId(rs.getInt("userId"));
				userVO.setUserEmail(rs.getString("userEmail"));
				userVO.setUserPassword(rs.getString("userPassword"));
				userVO.setUserName(rs.getString("userName"));
				userVO.setUserPhone(rs.getString("userPhone"));
				userVO.setUserIdentity(rs.getString("userIdentity"));
				userVO.setUserBirthday(rs.getDate("userBirthday"));
				userVO.setUserRegistration(rs.getDate("userRegistration"));
				list.add(userVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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

	public static void main(String[] args) {

		UserJDBCDAO dao = new UserJDBCDAO();

		// 新增test
//		UserVO insertTest = new UserVO();
//		insertTest.setUserEmail("test123@gmail.com");
//		insertTest.setUserPassword("1234");
//		insertTest.setUserName("aga");
//		insertTest.setUserPhone("0912345678");
//		insertTest.setUserIdentity("A123456789");
//		insertTest.setUserBirthday(java.sql.Date.valueOf("2022-11-22"));
//		insertTest.setUserRegistration(java.sql.Date.valueOf("2022-11-22"));
//		dao.insert(insertTest);

		// 修改test
//		UserVO updateTest = new UserVO();
//		updateTest.setUserId(1);
//		updateTest.setUserEmail("yang123@gmail.com");
//		updateTest.setUserPassword("5678");
//		updateTest.setUserName("yang");
//		updateTest.setUserPhone("0911111111");
//		updateTest.setUserIdentity("B123456789");
//		updateTest.setUserBirthday(java.sql.Date.valueOf("2022-05-05"));
//		updateTest.setUserRegistration(java.sql.Date.valueOf("2022-06-06"));
//		dao.update(updateTest);

		// 刪除test
//		dao.delete(1);

		// 查詢單一項test
//		UserVO selectTest = dao.findByPrimaryKey(1);
//		System.out.println(selectTest.getUserId() + ",");
//		System.out.println(selectTest.getUserEmail() + ",");
//		System.out.println(selectTest.getUserPassword() + ",");
//		System.out.println(selectTest.getUserName() + ",");
//		System.out.println(selectTest.getUserPhone() + ",");
//		System.out.println(selectTest.getUserIdentity() + ",");
//		System.out.println(selectTest.getUserBirthday() + ",");
//		System.out.println(selectTest.getUserRegistration() + ",");
//		System.out.println("------------------");

		// 查詢總表

//		List<UserVO> list = dao.getAll();
//		for (UserVO selectAllTest : list) {
//			System.out.println(selectAllTest.getUserId() + ",");
//			System.out.println(selectAllTest.getUserEmail() + ",");
//			System.out.println(selectAllTest.getUserPassword() + ",");
//			System.out.println(selectAllTest.getUserName() + ",");
//			System.out.println(selectAllTest.getUserPhone() + ",");
//			System.out.println(selectAllTest.getUserIdentity() + ",");
//			System.out.println(selectAllTest.getUserBirthday() + ",");
//			System.out.println(selectAllTest.getUserRegistration() + ",\t");
//			System.out.println();
//		}

	}

}
