package com.hotel.model;

public class HotelService {
	
	private HotelDAO_interface dao;

	public HotelService() {
		dao = new HotelDAO();
	}
	
	public HotelVO getOneHotel(String hotelEmail, String hotelTaxid) {
		return dao.findByHotelEmail(hotelEmail, hotelTaxid);
	}
	
	public HotelVO updateHotel(HotelVO hotelVO) {
		System.out.println("### updateHotel service");
		dao.update(hotelVO);
		return hotelVO;
	}
//	public HotelVO addHotel(HotelVO hotelVO) {
//		System.out.println("into addHotel service");
//		hotelVO.setHotelCounty("臺北市"); //預設地區
//		
//		
//	}
	
	
	
}
