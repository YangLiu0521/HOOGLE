package com.search.model;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.hibernate.HibernateUtil;

public class SearchDAOHibernate implements SearchDAO{
	private SessionFactory sessionFactory;
	public SearchDAOHibernate(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
//	public static void main(String[] args) {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.getCurrentSession();
//		Transaction transaction = session.beginTransaction();
//		
//		SearchDAO dao = new SearchDAOHibernate(sessionFactory);
//		SearchBean beans = dao.select(2001);
//		System.out.println("bean="+beans);
//		
//		transaction.commit();
//		session.close();
//		HibernateUtil.closeSessionFactory();
//	}
	@Override
	public SearchBean select(Integer userId) {
		if(userId!=null) {
			return this.getSession().get(SearchBean.class, userId);
		}
		return null;
	}
//	@Override
//	public List<SearchBean> select() {
//		CriteriaBuilder criteriaBuilder =  this.getSession().getCriteriaBuilder();
//		CriteriaQuery<SearchBean> crteriaQuery = criteriaBuilder.createQuery(SearchBean.class);
//		
//		Root<SearchBean> root = crteriaQuery.from(SearchBean.class);		
//		
//		TypedQuery<SearchBean> typedQuery = this.getSession().createQuery(crteriaQuery);
//		List<SearchBean> result = typedQuery.getResultList();
//		if(result!=null && !result.isEmpty()) {
//			return result;
//		} else {
//			return null;
//		}
//	}
}
