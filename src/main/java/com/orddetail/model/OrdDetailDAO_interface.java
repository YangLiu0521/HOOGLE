package com.orddetail.model;

import java.util.List;

public interface OrdDetailDAO_interface {

	public void insert(OrdDetailVO orddetailVO);
	public void update(OrdDetailVO orddetailVO);
	public void delete(Integer orddetailId);
	public OrdDetailVO findByPrimaryKey(Integer orddetailId);
	public List<OrdDetailVO> getAll();

}