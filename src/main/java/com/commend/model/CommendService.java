package com.commend.model;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;

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

	public CommendVO addCommend(CommendVO commendVO) {
		java.util.Date date = new java.util.Date();
		java.sql.Date dateSql = new java.sql.Date(date.getTime());
		commendVO.setCommendDate(dateSql);
		
		dao.insert(commendVO);
		return commendVO;
	}
	
	public CommendVO updateCommend(Integer commendAuto,Integer ordId, Integer commendGrade, String commendContent, Date commendDate) {

		CommendVO commendVO = new CommendVO();
		
		commendVO.setCommendAuto(commendAuto);
		commendVO.setOrdId(ordId);
		commendVO.setCommendGrade(commendGrade);
		commendVO.setCommendContent(commendContent);
		commendVO.setCommendDate(commendDate);
		dao.update(commendVO);
								
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
	
	public List<CommendVO> findByOrdId(Integer ordId){
		return dao.getAll().stream()
			    .filter(e -> e.getOrdId().equals(ordId))
			    .collect(Collectors.toList());
	}
}
