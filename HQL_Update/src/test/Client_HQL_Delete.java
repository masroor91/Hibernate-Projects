package test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class Client_HQL_Delete {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("resources/mysql.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session   session=  sf.openSession();
		Transaction t = session.beginTransaction();
		
		String hql= "delete Student where id=222";
		
		Query q=session.createQuery(hql);
		
		int i = q.executeUpdate();
		t.commit();
		
		System.out.println("No of rows deleted " + i);
		
		
		session.close();
		sf.close();
	
	}


}
