package tw.com.hoogle.compare.model;

import java.util.List;

public class CompareService {

	private CompareDAO_interface dao;

	public CompareService() {
		dao = new CompareDAO();
	}

	public CompareVO getOneHotel(String hotelName) {
		return (CompareVO) dao.findByHotelName(hotelName);
	}
	
	public List<CompareVO> getAll() {
		return dao.getAll();
	}

}
