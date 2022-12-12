package com.hotel.model;

import java.util.*;

import com.user.model.UserVO;

public interface HotelDAO_interface {
	
	public void insert(HotelVO hotelVO);

	public void update(HotelVO hotelVO);

	public void delete(Integer hotelId);

	public HotelVO findByPrimaryKey(Integer hotelId);
	
	public HotelVO findByHotelEmailandTaxid(String hotelEmail, String hotelTaxid);
	
	public HotelVO findByHotelEmail(String userEmail);

	public List<HotelVO> getAll();
	
	public String pwdhash(String password);
}
