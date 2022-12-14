package com.hotelpic.model;

import java.util.List;

import com.food.model.FoodDAO_interface;
import com.food.model.FoodVO;

public class HotelpicService {
	
	private HotelpicDAO_interface dao;

	public HotelpicService() {

		dao = new HotelpicJDBCDAO();
	}
	
	public HotelpicVO addHotelpic( Integer hotelId, byte[] hotelpicNo, String hotelpicName) {

		HotelpicVO hotelpicVO = new HotelpicVO();
		
		
		hotelpicVO.setHotelId(hotelId);
		hotelpicVO.setHotelpicNo(hotelpicNo);
		hotelpicVO.setHotelpicName(hotelpicName);
		dao.insert(hotelpicVO);

		return hotelpicVO;
	}

	

	public HotelpicVO updateHotelpic( byte[] hotelpicNo, String hotelpicName) {


		HotelpicVO hotelpicVO = new HotelpicVO();
		
//		hotelpicVO.setHotelpicId(hotelpicId);
//		hotelpicVO.setHotelId(hotelId);
		hotelpicVO.setHotelpicNo(hotelpicNo);
		hotelpicVO.setHotelpicName(hotelpicName);
		dao.update(hotelpicVO);
		return hotelpicVO;
		
	}
	
	public void deletehotelpic(Integer hotelpicId) {
		dao.delete(hotelpicId);
		
	}

//	public FoodVO getOneFood(Integer foodPicid) {
//		return dao.findByPrimaryKey(foodPicid);
//	}
//
//	public List<FoodVO> getAll() {
//		return dao.getAll();
//	}
	 }
//	public void deleteHotelpic(Integer hotelpicId) {
//		dao.delete(hotelpicId);
//	}

//	public HotelpicVO getOneHotelpic(Integer hotelpicId) {
//		return dao.findByPrimaryKey(hotelpicId);
//	}
//
//	public List<HotelpicVO> getAll() {
//		return dao.getAll();
//	}


	// 預留給 Struts 2 用的
//	public void updateHotelpic(HotelpicVO hotelpicVO) {
//		dao.update(hotelpicVO);
//	}
//	}
//	
//	public void deleteHotelpic(Integer foodPicid) {
//		dao.delete(foodPicid);
//	}
//	
//	public HotelpicVO getOneHotelpic(Integer hotelpicId) {
//		return dao.findByPrimaryKey(hotelpicId);
//	}
//	
//	public List<HotelpicVO> getAll(){
//		return dao.getAll();
//	}