package tw.com.hoogle.service.model;

import java.util.*;
import java.sql.*;

public class ServiceService {

	private ServiceDAO_interface dao;

	public ServiceService() {

		dao = new ServiceDAO();
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
