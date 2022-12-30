package tw.com.hoogle.otherhotel.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import tw.com.hoogle.hotelpic.model.HotelpicDAO;
import tw.com.hoogle.hotelpic.model.HotelpicVO;
import tw.com.hoogle.service.model.ServiceVO;
import tw.com.hoogle.servicelist.model.ServiceListDAO;
import tw.com.hoogle.servicelist.model.ServiceListVO;

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

	private static final String UPDATE = "UPDATE hotel set hotelCounty=?, hotelAddress=?, hotelType=?, hotelNotice=?, hotelQa=?, hotelIntroduction=? where hotelId = ?";
	
	@Override
	public void updateHotel(OtherHotelVO otherhotelVO,List<ServiceListVO> servicelist,List<HotelpicVO> Hotelpiclist) {
		try {
			Connection con = ds.getConnection();
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement(UPDATE);			
		
			//OtherHotel table
			pstmt.setString(1, otherhotelVO.getHotelCounty());
			pstmt.setString(2, otherhotelVO.getHotelAddress());
			pstmt.setString(3, otherhotelVO.getHotelType());
			pstmt.setString(4, otherhotelVO.getHotelNotice());
			pstmt.setString(5, otherhotelVO.getHotelQa());
			pstmt.setString(6, otherhotelVO.getHotelIntroduction());
			pstmt.setInt(7, otherhotelVO.getHotelId());
			pstmt.executeUpdate();
			
			//ServiceList table
			ServiceListDAO servicelistdao = new ServiceListDAO(); 
			int serviceId = 0;
			servicelistdao.delete(otherhotelVO.getHotelId());
			for(ServiceListVO service:servicelist) {
				servicelistdao.insert2(service,con);
//				servicelistdao.update2(service,con);
			}
			
			//HOTELPIC table
			HotelpicDAO hotelpicdao = new HotelpicDAO();
			if(Hotelpiclist.size() > 0) {
				hotelpicdao.delete2(otherhotelVO.getHotelId(),con);
				for(HotelpicVO aData:Hotelpiclist) {
					hotelpicdao.insert2(aData,con);
				}
			}
			
			
			con.commit();
			con.setAutoCommit(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

	
	