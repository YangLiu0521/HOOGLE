package com.servicelist.model;

import java.util.List;

public interface ServiceListDAO_interface {
	
	public void insert(ServiceListVO serviceListVO);
	public void update(ServiceListVO serviceListVO);
	public void delete(Integer serviceListId);
	public ServiceListVO findByPrimaryKey(Integer serviceListId);
	public List<ServiceListVO> getAll();

}
