package tw.com.hoogle.compare.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CompareDAO implements CompareDAO_interface {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/HOOGLE?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";

	private static DataSource ds = null;
	static {
		try {			
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/HOOGLEDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String GET_ONE_STMT = "SELECT\r\n"
			+ "		h.hotelName,\r\n"
			+ "        h.hotelAddress,\r\n"
			+ "        r.roomType,\r\n"
			+ "        r.roomPrice,\r\n"
			+ "        s.serviceId\r\n"
			+ "	FROM\r\n"
			+ "		hotel h\r\n"
			+ "			JOIN\r\n"
			+ "		room r JOIN\r\n"
			+ "        serviceList s\r\n"
			+ "        ON h.hotelId = r.hotelID = s.hotelId;";

	@Override
	public List<CompareVO> findByHotelName(String hotelName) {
		List<CompareVO> list = new ArrayList<CompareVO>();
		CompareVO compareVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				compareVO = new CompareVO();
				compareVO.setHotelName(rs.getString("hotelName"));
				compareVO.setHotelAddress(rs.getString("hotelAddress"));
				compareVO.setRoomType(rs.getString("roomType"));
				compareVO.setRoomPrice(rs.getInt("roomPrice"));
				list.add(compareVO);

			}

		} 
//		catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
//			// Handle any SQL errors
//		} 
		catch (SQLException se) {
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
		return list;
	}}
