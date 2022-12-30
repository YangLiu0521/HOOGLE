package tw.com.hoogle.otherhotel.model;

import java.util.List;

import tw.com.hoogle.hotelpic.model.HotelpicVO;
import tw.com.hoogle.servicelist.model.ServiceListVO;

public interface OtherHotelDAO_interface {
	


	public void updateHotel(OtherHotelVO otherhotelVO,List<ServiceListVO> servicelist,List<HotelpicVO> Hotelpiclist);

	
	
	
}
