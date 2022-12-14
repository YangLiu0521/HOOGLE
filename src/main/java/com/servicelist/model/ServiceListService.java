package com.servicelist.model;

import java.util.*;
import java.sql.*;

public class ServiceListService {

	private ServiceListDAO_interface dao;

	public ServiceListService() {

		dao = new ServiceListDAO();
	}

	public ServiceVO addService(Integer serviceId, String serviceName) {

		ServiceVO serviceVO = new ServiceVO();

		serviceVO.setServiceId(serviceId);
		serviceVO.setServiceName(serviceName);
		dao.insert(serviceVO);

		return serviceVO;
	}

	// 預留給 Struts 2 或 Spring MVC 用
	public void addService(ServiceVO serviceVO) {
		dao.insert(serviceVO);
	}

	public ServiceVO updateService(Integer serviceId, String serviceName) {

		ServiceVO serviceVO = new ServiceVO();

		serviceVO.setServiceId(serviceId);
		serviceVO.setServiceName(serviceName);

		return dao.findByPrimaryKey(serviceId);
	}

	// 預留給 Struts 2 用的
	public void updateService(ServiceVO serviceVO) {
		dao.update(serviceVO);
	}
	
	public void deleteService(Integer serviceId) {
		dao.delete(serviceId);
	}
	
	public ServiceVO getOneService(Integer serviceId) {
		return dao.findByPrimaryKey(serviceId);
	}
	
	public List<ServiceVO> getAll(){
		return dao.getAll();
	}

}
