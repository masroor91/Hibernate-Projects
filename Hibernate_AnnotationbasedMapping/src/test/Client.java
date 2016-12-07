package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class Client {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		
		cfg.configure("resources/mysql.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session= sf.openSession();
		
		Transaction t = session.beginTransaction();
		
		Student s= new Student();
		s.setId(111);
		s.setName("Masroor");
		s.setEmail("mas@gmail.com");
		s.setAddress("Varanasi");
		
		session.save(s);
		
		t.commit();

	}

}
