package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Customer;

/**
 * Servlet implementation class StudentRegController
 */
public class CustomerRegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SessionFactory sf;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/db2.cfg.xml");
		
		 sf = cfg.buildSessionFactory();
		System.out.println("Seesion Factory Init");
		
		
	}
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name= request.getParameter("name");
		String email= request.getParameter("email");
		Long phone= Long.parseLong(request.getParameter("phone"));
		int balance= Integer.parseInt(request.getParameter("balance"));
		
		Customer st = new Customer();
		st.setName(name);
		st.setEmail(email);
		st.setPhone(phone);
		st.setBalance(balance);
		
		Session session = sf.openSession();
		
		Transaction t= session.beginTransaction();
		
		String pk= (String) session.save(st);
		
		t.commit();
		session.close();
		
		response.getWriter().println("reg Success id==" + pk);
		
	}
	
	@Override
	public void destroy() {
		
		sf.close();
		
	}


}
