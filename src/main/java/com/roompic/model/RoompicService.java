package com.roompic.model;

import java.util.List;

import com.user.model.UserVO;

public class RoompicService {
	
	private RoompicDAO_interface dao;
	
	public RoompicService() {
		dao = new RoompicDAO();
	}
	
	public void insert(RoompicVO roompicVO) {
		dao.insert(roompicVO);
	}
	
	public RoompicVO findByPrimaryKey(Integer roompicId) {
		return dao.findByPrimaryKey(roompicId);
	}
	
	public RoompicVO addRoompic(Integer roomAuto, String roomType, byte[] roompicPic) {
		
		RoompicVO roompicVO = new RoompicVO();
		roompicVO.setRoomAuto(roomAuto);
		roompicVO.setRoomType(roomType);
		roompicVO.setRoompicPic(roompicPic);
		dao.insert(roompicVO);
		return roompicVO;
	}
	
	public List<RoompicVO> getAll(){
		return dao.getAll();
	}

}
