package tw.com.hoogle.compare.model;

import java.util.List;

import tw.com.hoogle.commend.model.CommendVO;

public interface CompareDAO_interface {

	public List<CompareVO> findByHotelName(String hotelName);
	public List<CompareVO> getAll();
}
	

