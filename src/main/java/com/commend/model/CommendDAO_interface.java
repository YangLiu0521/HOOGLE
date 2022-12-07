package com.commend.model;

import java.util.*;

public interface CommendDAO_interface {

	public void insert(CommendVO commendVO);
	public void update(CommendVO commendVO);
	public void delete(Integer commendAuto);
	public CommendVO findByPrimaryKey(Integer ordId);
	public List<CommendVO> getAll();

}
	

