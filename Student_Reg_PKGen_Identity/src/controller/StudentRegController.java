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

import beans.Student;

/**
 * Servlet implementation class StudentRegController
 */
public class StudentRegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SessionFactory sf;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/mysql.cfg.xml");
		
		 sf = cfg.buildSessionFactory();
		System.out.println("Seesion Factory Init");
		
		
	}
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name= request.getParameter("name");
		String email= request.getParameter("email");
		String address= request.getParameter("address");
		int marks= Integer.parseInt(request.getParameter("marks"));
		
		Student st = new Student();
		st.setName(name);
		st.setEmail(email);
		st.setAddress(address);
		st.setMarks(marks);
		
		Session session = sf.openSession();
		
		Transaction t= session.beginTransaction();
		
		int pk= (Integer) session.save(st);
		
		t.commit();
		session.close();
		
		response.getWriter().println("reg Success id==" + pk);
		
	}
	
	@Override
	public void destroy() {
		
		sf.close();
		
	}


}
