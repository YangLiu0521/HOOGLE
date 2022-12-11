package model.hibernate;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

@WebFilter(
		urlPatterns = {"/*"}
)
public class OpenSessionInViewFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			Transaction transaction = session.beginTransaction();
			chain.doFilter(request, response);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			chain.doFilter(request, response);
		}
	}
	@Override
	public void destroy() {

	}
}
