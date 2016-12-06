package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class ClientInsert {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("resources/mysql.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session   session=  sf.openSession();
		Transaction t = session.beginTransaction();
		
		Student s= new Student(333, "abc", "abc@gmail.com", "Hyd");
		
		session.save(s);
		
		t.commit();
		session.close();
		sf.close();
	
	}


}
