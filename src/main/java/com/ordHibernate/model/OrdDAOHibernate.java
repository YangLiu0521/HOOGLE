package com.ordHibernate.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.hibernate.HibernateUtil;

public class OrdDAOHibernate implements OrdDAOHibernate_interface{
	private SessionFactory sessionFactory;
	public OrdDAOHibernate(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		OrdDAOHibernate_interface dao = new OrdDAOHibernate(sessionFactory);
		OrdBean FBP = dao.findByPrimaryKey(5009);
		System.out.println("查詢5009");
		
		transaction.commit();
		session.close();
		HibernateUtil.closeSessionFactory();
	}
	
	private static final String INSERT_STMT = "INSERT INTO ord (userId,hotelId,userName,hotelName,ordDate,ordCheckin,ordCheckout,ordNights,ordRemark) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT ordId,userId,hotelId,userName,hotelName,ordDate,ordCheckin,ordCheckout,ordNights,ordRemark FROM ord order by ordId";
	private static final String GET_ONE_STMT = "SELECT ordId,userId,hotelId,userName,hotelName,ordDate,ordCheckin,ordCheckout,ordNights,ordRemark FROM ord where ordId = ?";
	private static final String DELETE = "DELETE FROM ord where ordId = ?";
	private static final String UPDATE = "UPDATE ord set userId=?, hotelId=?, userName=?, hotelName=?, ordDate=?, ordCheckin=?, ordCheckout=?, ordNights=?, ordRemark=? where ordId=?";

	
	@Override
	public void insert(OrdBean ordBean) {
		
	}
	@Override
	public void update(OrdBean ordVO) {
		
	}
	@Override
	public void delete(Integer ordId) {
		
	}
	@Override
	public OrdBean findByPrimaryKey(Integer ordId) {
		return null;
	}
	@Override
	public List<OrdBean> getAll() {
		return null;
	}
}
