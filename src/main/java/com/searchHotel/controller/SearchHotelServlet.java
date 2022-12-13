package com.searchHotel.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.searchHotel.model.SearchHotelBean;
import com.searchHotel.model.SearchHotelDAO;
import com.searchHotel.model.SearchHotelDAOHibernate;
import com.searchHotel.model.SearchHotelService;

import model.hibernate.HibernateUtil;

@WebServlet(
		urlPatterns={"/searchHotel/searchHotel.controller"}		
)
public class SearchHotelServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	private SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
	private SearchHotelService searchHotelService;
	@Override
	public void init() throws ServletException {
		
		searchHotelService = new SearchHotelService(
		new SearchHotelDAOHibernate(HibernateUtil.getSessionFactory()));
	}
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		SearchHotelDAO dao = new SearchHotelDAOHibernate(sessionFactory);
		
		
//接收資料
		
		String hotelCounty = request.getParameter("hotelCounty");
		String searchHotel = request.getParameter("searchHotel");
		
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("errors", errors);
//轉換資料
		String hotelCountyInput = "";
		if(hotelCounty!=null && hotelCounty.length()!=0 && hotelCounty!="") {
			try {
				hotelCountyInput = hotelCounty;
				System.out.println("輸入縣市 : "+hotelCountyInput);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("hotelCountyInput", "hotelCountyInput must be a String");
			}
		}
		if(errors!=null && !errors.isEmpty()) {
			System.out.println("error");
			request.getRequestDispatcher(
					"/searchHotel/searchHotel.jsp").forward(request, response);
			return;
		}
		
//呼叫Model
		SearchHotelBean bean = new SearchHotelBean();
//		bean.setHotelCounty(hotelCountyInput);
		Query <SearchHotelBean> query = session.createQuery("From SearchHotelBean where hotelCounty=?0",SearchHotelBean.class);
		query.setParameter(0, hotelCountyInput);
		
		List results = query.list();
		if(searchHotel!=null && searchHotel.equals("Select")) {
			request.setAttribute("select", results);
			request.getRequestDispatcher(
					"/searchHotel/displayHotel.jsp").forward(request, response);
		} 
//		else  {
//			errors.put("action", "Unknown Action:"+searchHotel);
//			request.getRequestDispatcher(
//					"/searchHotel/displaySearchHotel.jsp").forward(request, response);
//		}
		
//		if(searchHotel!=null && searchHotel.equals("ListAll")) {
//			request.setAttribute("listAll", results);
//			request.getRequestDispatcher(
//					"/searchHotel/displayHotel.jsp").forward(request, response);
//		} 
		else  {
			errors.put("action", "Unknown Action:"+searchHotel);
			request.getRequestDispatcher(
					"/searchHotel/displaySearchHotel.jsp").forward(request, response);
		}
		
		
		
		transaction.commit();
//		session.close();
	}
}
