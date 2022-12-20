package tw.com.hoogle.compare.model;

import java.util.List;

public interface CompareDAO_interface {

	public List<CompareVO> findByHotelName(String hotelName);
}
	

