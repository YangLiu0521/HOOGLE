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

import com.ord.model.OrdDAO;
import com.ord.model.OrdVO;

public class OrdDetailJDBCDAO implements OrdDetailDAO_interface{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/HOOGLE?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";

//		private static DataSource ds = null;
//		static {
//			try {			
//				Context ctx = new InitialContext();
//				ds = (DataSource) ctx.lookup("java:comp/env/jdbc/HOOGLEDB");
//			} catch (NamingException e) {
//				e.printStackTrace();
//			}
//		}

		private static final String INSERT_STMT = 
				"INSERT INTO orddetail (ordId, roomAuto, roomNumber) VALUES (?, ?, ?)";
			private static final String GET_ALL_STMT = 
				"SELECT orddetailId, ordId, roomAuto, roomNumber FROM orddetail order by orddetailId";
			private static final String GET_ONE_STMT = 
				"SELECT orddetailId, ordId, roomAuto, roomNumber FROM orddetail where orddetailId = ?";
			private static final String GET_ORD_STMT =
				"SELECT orddetailId, ordId, roomAuto, roomNumber FROM orddetail where ordId = ?";
			private static final String DELETE = 
				"DELETE FROM orddetail where orddetailId = ?";
			private static final String UPDATE = 
				"UPDATE orddetail set ordId=?, roomAuto=?, roomNumber=? where orddetailId=?";

			
		
		@Override
		public void insert(OrdDetailVO orddetailVO) {
			
			Connection con = null;
			PreparedStatement pstmt = null;

			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
//				con = ds.getConnection();
				pstmt = con.prepareStatement(INSERT_STMT);
				
				pstmt.setInt(1, orddetailVO.getOrdId());
				pstmt.setInt(2, orddetailVO.getRoomAuto());
				pstmt.setInt(3, orddetailVO.getRoomNumber());

				pstmt.executeUpdate();

			} 
			catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
				// Handle any SQL errors
			}
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
				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
//				con = ds.getConnection();
				pstmt = con.prepareStatement(UPDATE);

				pstmt.setInt(1, orddetailVO.getOrdId());
				pstmt.setInt(2, orddetailVO.getRoomAuto());
				pstmt.setInt(3, orddetailVO.getRoomNumber());
				pstmt.setInt(4, orddetailVO.getOrddetailId());

//				pstmt.executeUpdate();
				java.sql.Statement stmt=con.createStatement();
				stmt.executeUpdate("set auto_increment_increment=1;");
				pstmt.executeUpdate();
			} 
			catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
				// Handle any SQL errors
			}
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
				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
//				con = ds.getConnection();
				pstmt = con.prepareStatement(DELETE);

				pstmt.setInt(1, orddetailId);

				pstmt.executeUpdate();

			} 
			catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
				// Handle any SQL errors
			}
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
		public OrdDetailVO findByOrdId(Integer OrdId) {
			OrdDetailVO orddetailVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
//				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ORD_STMT);

				pstmt.setInt(1, OrdId);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					orddetailVO = new OrdDetailVO();
					orddetailVO.setOrdId(rs.getInt("ordId"));
					orddetailVO.setRoomAuto(rs.getInt("roomAuto"));
					orddetailVO.setRoomNumber(rs.getInt("roomNumber"));
					orddetailVO.setOrddetailId(rs.getInt("orddetailId"));
					
				}

			} 
			catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
				// Handle any SQL errors
			}
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
		public OrdDetailVO findByPrimaryKey(Integer orddetailId) {

			OrdDetailVO orddetailVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
//				con = ds.getConnection();
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
			catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
				// Handle any SQL errors
			}
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
				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
//				con = ds.getConnection();
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
			catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
				// Handle any SQL errors
			}
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


	public static void main(String[] args) {
		
				OrdDetailDAO dao = new OrdDetailDAO();
		
				// 新增
//				OrdDetailVO orddetailVO1 = new OrdDetailVO();
//				orddetailVO1.setOrdId(1);
//				orddetailVO1.setRoomAuto(3001);
//				orddetailVO1.setRoomNumber(1);
//				dao.insert(orddetailVO1);
//				System.out.println("新增成功");
//				System.out.println("---------------------");
				
				//訂單查詢
//				OrdDetailVO orddetailVO4 = dao.findByOrdId(5002);
//				System.out.print(orddetailVO4.getOrddetailId() + ",");
//				System.out.println(orddetailVO4.getOrdId()+",");
//				System.out.print(orddetailVO4.getRoomAuto() + ",");
//				System.out.print(orddetailVO4.getRoomNumber() + ",");
//				System.out.println("查詢成功");
//				System.out.println("---------------------");
				
				//查詢單筆
//				OrdDetailVO orddetailVO2 = dao.findByPrimaryKey(2);
//				System.out.print(orddetailVO2.getOrddetailId() + ",");
//				System.out.println(orddetailVO2.getOrdId()+",");
//				System.out.print(orddetailVO2.getRoomAuto() + ",");
//				System.out.print(orddetailVO2.getRoomNumber() + ",");
//				System.out.println("查詢成功");
//				System.out.println("---------------------");
				
				//查詢全部
//				List<OrdDetailVO> list = dao.getAll();
//				for (OrdDetailVO aOrdDetail : list) {
//				System.out.print(aOrdDetail.getOrddetailId() + ",");
//				System.out.print(aOrdDetail.getOrdId() + ",");
//				System.out.print(aOrdDetail.getRoomAuto() + ",");
//				System.out.print(aOrdDetail.getRoomNumber() + ",");
//				System.out.println("查詢成功");
//				System.out.println("---------------------");
//				}
				
				//刪除
//				dao.delete(6010);
//				System.out.println("刪除成功");
//				System.out.println("---------------------");
				
				//修改
//				OrdDetailVO orddetailVO3 = new OrdDetailVO();
//				orddetailVO3.setOrddetailId(1);
//				orddetailVO3.setOrdId(1);
//				orddetailVO3.setRoomAuto(3002);
//				orddetailVO3.setRoomNumber(123);
//				dao.update(orddetailVO3);
//				System.out.println("修改成功");
//				System.out.println("---------------------");
				
				
	}
}
