package com.searchHotel.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.hibernate.HibernateUtil;

public class SearchHotelDAOHibernate implements SearchHotelDAO{
	private SessionFactory sessionFactory;
	public SearchHotelDAOHibernate(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
//	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//	Session session = sessionFactory.getCurrentSession();
//	Transaction transaction = session.beginTransaction();
//	SearchHotelDAO dao = new SearchHotelDAOHibernate(sessionFactory);
	
//	query.setParameter(0, "台北市");
//	System.out.println("query"+query);
//	List<SearchHotelBean> objs =query.list();
//	System.out.println(objs);	
	
//	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//	Session session = sessionFactory.getCurrentSession();
//	Transaction transaction = session.beginTransaction();
//	SearchHotelDAO dao = new SearchHotelDAOHibernate(sessionFactory);

//	Query query = session.createQuery("From SearchHotelBean where hotelCounty=?0",SearchHotelBean.class);
//	query.setParameter(0, "台北市");
//	List<SearchHotelBean> objs =query.list();

	
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
	public SearchHotelBean select(String hotelCounty) {
		
		if(hotelCounty!=null) {
			return this.getSession().get(SearchHotelBean.class, hotelCounty);
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
	
//	transaction.commit();
//	session.close();
}
