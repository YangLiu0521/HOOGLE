package com.search.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.hibernate.HibernateUtil;

public class SearchService {
	private SearchDAO searchDao;
	public SearchService(SearchDAO searchDao) {
		super();
		this.searchDao = searchDao;
	}
	
//	public static void main(String[] args) {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.getCurrentSession();
//		Transaction transaction = session.beginTransaction();
//
//		SearchService searchService = new SearchService(new SearchDAOHibernate(sessionFactory));
////		List<SearchBean> selects = productService.select(null);
////		System.out.println("selects="+selects);
////		
//		transaction.commit();
//		session.close();
//		HibernateUtil.closeSessionFactory();
//	}
	
	public SearchBean select(SearchBean bean) {
		SearchBean result = null;
		if(bean!=null && bean.getUserId()!=null && !bean.getUserId().equals(0)) {
			SearchBean temp = searchDao.select(bean.getUserId());
			if(temp!=null) {
				result = new SearchBean();	
				result=bean;
				System.out.println(result);
			}
		} 
		
		return result;
	}
	public SearchBean select(Integer userId) {
		SearchBean result = null;
		if(userId!=null && userId!=null && !userId.equals(0)) {
			SearchBean temp = searchDao.select(userId);
			System.out.println("temp="+temp);
			if(temp!=null) {
				result = new SearchBean();	
				result=temp;
				System.out.println(result);
			}
		} 
		
		return result;
	}
//	public List<SearchBean> select(SearchBean bean) {
//		List<SearchBean> result = null;
//		if(bean!=null && bean.getUserId()!=null && !bean.getUserId().equals(0)) {
//			SearchBean temp = searchDao.select(bean.getUserId());
//			if(temp!=null) {
//				result = new ArrayList<SearchBean>();
//				result.add(temp);
//			}
//		} else {
//			result = searchDao.select(); 
//		}
//		return result;
//	}
}
