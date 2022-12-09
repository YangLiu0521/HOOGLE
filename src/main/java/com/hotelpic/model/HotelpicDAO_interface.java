package com.hotelpic.model;

import java.util.List;

public interface HotelpicDAO_interface {
	
	public void insert(HotelpicVO hotelpicVO);
	public void update(HotelpicVO hotelpicVO);
	public void delete(Integer hotelpicId);
	public HotelpicVO findByPrimaryKey(Integer hotelpicId);
	public List<HotelpicVO> getAll();

}
