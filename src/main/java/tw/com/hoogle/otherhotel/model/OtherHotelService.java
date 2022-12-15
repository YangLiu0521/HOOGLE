package tw.com.hoogle.otherhotel.model;

public class OtherHotelService {
	
	private OtherHotelDAO_interface dao;

	public OtherHotelService() {
		dao = new OtherHotelDAO();
	}
	
	
	
	public OtherHotelVO updateHotel(OtherHotelVO otherhotelVO) {
		System.out.println("### updateHotel service");
		dao.updateHotel(otherhotelVO);
		return otherhotelVO;
	}



	}
	

	