package com.ordHibernate.model;

import java.util.List;

public interface OrdDAOHibernate_interface {
	public void insert(OrdBean ordBean);
	public void update(OrdBean ordBean);
	public void delete(Integer ordId);
	public OrdBean findByPrimaryKey(Integer ordId);
	public List<OrdBean> getAll();
}
