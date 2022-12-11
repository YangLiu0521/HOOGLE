package com.hotel.model;

import com.user.model.UserVO;

public class HotelService {
	
	private HotelDAO_interface dao;

	public HotelService() {
		dao = new HotelDAO();
	}
	
	public HotelVO addHotel(HotelVO hotelVO) {
		System.out.println("### addHotel service");
		hotelVO.setHotelState(1);
		dao.insert(hotelVO);
		
		return hotelVO;
	}
	
	public HotelVO getOneHotel(String hotelEmail, String hotelTaxid) {
		return dao.findByHotelEmailandTaxid(hotelEmail, hotelTaxid);
	}
	
	public HotelVO findByHotelEmail(String hotelEmail) {
		return dao.findByHotelEmail(hotelEmail);
	}
	
	public HotelVO updateHotel(HotelVO hotelVO) {
		System.out.println("### updateHotel service");
		dao.update(hotelVO);
		return hotelVO;
	}

	public String pwdhash(String password) {
		dao.pwdhash(password);
		return password;
	}
	
	
}
