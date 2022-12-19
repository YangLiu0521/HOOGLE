package tw.com.hoogle.searchHotel.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.com.hoogle.searchHotel.model.SearchHotelBean;
import tw.com.hoogle.searchHotel.model.SearchHotelDAO;
import tw.com.hoogle.searchHotel.model.SearchHotelDAOHibernate;
import tw.com.hoogle.searchHotel.model.SearchHotelService;

@Controller
public class SearchHotelServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
	private SimpleDateFormat sFormat = new SimpleDateFormat("MM/dd/yyyy");
	@Autowired
	private SearchHotelService searchHotelService;
	@RequestMapping(
			path ={"/searchHotel/searchHotel.controller"}		
	)
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.getCurrentSession();
//		Transaction transaction = session.beginTransaction();
//		SearchHotelDAO dao = new SearchHotelDAOHibernate(sessionFactory);
		
//接收資料
		String hotelCounty = request.getParameter("hotelCounty");
		String searchHotel = request.getParameter("searchHotel");
		String checkinInput =request.getParameter("checkinInput");
		String checkoutInput =request.getParameter("checkoutInput");
		
		java.util.Date date1 = null ,date2 = null;
		long ordNights = 0;
		try {
			date1 = sFormat.parse(checkinInput);
			date2 = sFormat.parse(checkoutInput);
			System.out.println("checkinInput="+date1);
			System.out.println("checkinoutput="+date2);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		Calendar cal = Calendar.getInstance();
		
		if(date1!=null && date2!=null) {
		cal.setTime(date1);
		long time1 = cal.getTimeInMillis();
		
		cal.setTime(date2);
		long time2 = cal.getTimeInMillis();
		
		ordNights = (time2-time1)/(1000*60*60*24);
		System.out.println("訂房天數共"+ordNights+"天");
		}
		
		
		
		
		
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("errors", errors);
//轉換資料
		String hotelCountyInput = "";
		if(hotelCounty!=null && hotelCounty.length()!=0 && hotelCounty!="") {
			try {
				hotelCountyInput = hotelCounty;
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("hotelCountyInput", "hotelCountyInput must be a String");
			}
		}
		if(errors!=null && !errors.isEmpty()) {
			System.out.println("error");
			request.getRequestDispatcher(
					"/index.jsp").forward(request, response);
			return;
		}
//呼叫Model
		SearchHotelBean bean = new SearchHotelBean();
//		Query <SearchHotelBean> query = session.createQuery("From SearchHotelBean where hotelCounty=?0",SearchHotelBean.class);
//		query.setParameter(0, hotelCountyInput);
//		List results = query.list();
		System.out.println("hotelCountyInput = "+hotelCountyInput);
		System.out.println("checkinInput ="+checkinInput);
		System.out.println("checkoutInput ="+checkoutInput);
		
		if(searchHotel!=null && searchHotel.equals("Select")) {
			request.setAttribute("hotelCountyInput", hotelCountyInput);
			request.setAttribute("checkinInput", checkinInput);
			request.setAttribute("checkoutInput", checkoutInput);
			request.setAttribute("ordNights", ordNights);
			request.getRequestDispatcher(
					"/searchHotel/displaySearchHotel.jsp").forward(request, response);
		}
		else  {
			errors.put("action", "Unknown Action:"+searchHotel);
			request.getRequestDispatcher(
					"/index.jsp").forward(request, response);
		}
//		transaction.commit();
//		session.close();
	}
}
