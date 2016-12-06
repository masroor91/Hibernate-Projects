package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Employee;

public class Client {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		
		cfg.configure("resources/mysql.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session= sf.openSession();
		
		Transaction t=	session.beginTransaction();
		
		Employee e1 = new Employee(111, "abc", "abc@gmail.com", 5000.0F);
		Employee e2 = new Employee(222, "xyz", "xyz@gmail.com", 6000.0F);
		Employee e3 = new Employee(333, "pqr", "pqr@gmail.com", 7000.0F);
		Employee e4 = new Employee(444, "efg", "efg@gmail.com", 8000.0F);
		
		session.save(e1);
		session.save(e2);
		session.save(e3);
		session.save(e4);
		
		t.commit();
		session.close();
		sf.close();
	
	}

}
