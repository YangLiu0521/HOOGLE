package com.commend.model;

import java.sql.Date;
import java.util.List;

public class CommendService {

	private CommendDAO_interface dao;

	public CommendService() {
		dao = new CommendDAO();
	}

	public CommendVO addCommend(Integer ordId, Integer commendGrade, String commendContent, Date commendDate) {

		CommendVO commendVO = new CommendVO();

		commendVO.setOrdId(ordId);
		commendVO.setCommendGrade(commendGrade);
		commendVO.setCommendContent(commendContent);
		commendVO.setCommendDate(commendDate);
		dao.insert(commendVO);

		return commendVO;
	}

	public void addCommend(CommendVO commendVO) {
		dao.insert(commendVO);
	}
	
	public CommendVO updateCommend(Integer commendAuto,Integer ordId, Integer commendGrade, String commendContent, Date commendDate) {

		CommendVO commendVO = new CommendVO();
		
//		commendVO.setCommendAuto(commendAuto);
		commendVO.setOrdId(ordId);
		commendVO.setCommendGrade(commendGrade);
		commendVO.setCommendContent(commendContent);
		commendVO.setCommendDate(commendDate);
		dao.update(commendVO);
								//commendAuto?
		return dao.findByPrimaryKey(commendAuto);
	}
	
	public void updateCommend(CommendVO commendVO) {
		dao.update(commendVO);
	}

	public void deleteCommend(Integer commendAuto) {
		dao.delete(commendAuto);
	}

	public CommendVO getOneCommend(Integer commendAuto) {
		return dao.findByPrimaryKey(commendAuto);
	}

	public List<CommendVO> getAll() {
		return dao.getAll();
	}
}
