package com.hotel.model;

import java.util.*;

import com.user.model.UserVO;

public interface HotelDAO_interface {
	
	public void insert(HotelVO hotelVO);

	public void update(HotelVO hotelVO);

	public void delete(Integer hotelId);

	public HotelVO findByPrimaryKey(Integer hotelId);
	
	public HotelVO findByHotelEmail(String hotelEmail, String hotelTaxid);

	public List<HotelVO> getAll();
}
