package com.ordHibernate.model;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.hibernate.HibernateUtil;

public class OrdService {
	private OrdDAOHibernate_interface OrdDao;
	public OrdService(OrdDAOHibernate_interface OrdDao) {
		super();
		this.OrdDao = OrdDao;
	}	
		public static void main(String[] args) {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();

			OrdService ordService = new OrdService(new OrdDAOHibernate(sessionFactory));
			
			
			transaction.commit();
			session.close();
			HibernateUtil.closeSessionFactory();
		}
		public OrdBean addOrd(Integer userId, Integer hotelId, String userName, String hotelName, Date ordDate
				, Date ordCheckin,Date ordCheckout, Integer ordNights,String ordRemark) {

			OrdBean ordBean = new OrdBean();

			ordBean.setUserId(userId);
			ordBean.setHotelId(hotelId);
			ordBean.setUserName(userName);
			ordBean.setHotelName(hotelName);
			ordBean.setOrdDate(ordDate);
			ordBean.setOrdCheckin(ordCheckin);
			ordBean.setOrdCheckout(ordCheckout);
			ordBean.setOrdNights(ordNights);
			ordBean.setOrdRemark(ordRemark);
			OrdDao.insert(ordBean);

			return ordBean;
		}

		public void addOrd(OrdBean ordBean) {
			OrdDao.insert(ordBean);
		}
		
		public OrdBean updateOrd(Integer ordId, Integer userId, Integer hotelId, String userName, String hotelName, Date ordDate
				, Date ordCheckin,Date ordCheckout, Integer ordNights,String ordRemark) {

			OrdBean ordBean = new OrdBean();

			ordBean.setOrdId(ordId);
			ordBean.setUserId(userId);
			ordBean.setHotelId(hotelId);
			ordBean.setUserName(userName);
			ordBean.setHotelName(hotelName);
			ordBean.setOrdDate(ordDate);
			ordBean.setOrdCheckin(ordCheckin);
			ordBean.setOrdCheckout(ordCheckout);
			ordBean.setOrdNights(ordNights);
			ordBean.setOrdRemark(ordRemark);
			OrdDao.update(ordBean);

			return OrdDao.findByPrimaryKey(ordId);
		}
		
		public void updateOrd(OrdBean ordBean) {
			OrdDao.update(ordBean);
		}

		public void deleteOrd(Integer ordId) {
			OrdDao.delete(ordId);
		}

		public OrdBean getOneOrd(Integer ordId) {
			return OrdDao.findByPrimaryKey(ordId);
		}

		public List<OrdBean> getAll() {
			return OrdDao.getAll();
		}
}
