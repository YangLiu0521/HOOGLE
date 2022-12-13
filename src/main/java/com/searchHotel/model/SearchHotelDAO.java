package com.searchHotel.model;

import java.util.List;

import com.search.model.SearchBean;

public interface SearchHotelDAO {
	
	public abstract SearchHotelBean select(String hotelCounty);

	public abstract List <SearchHotelBean> getAll();

	
}
