package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Admin;
import beans.HardwareEmployee;
import beans.SoftwareEmployee;

public class Client {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		
		cfg.configure("resources/mysql.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session= sf.openSession();

		Transaction t = session.beginTransaction();
		
		SoftwareEmployee se = new SoftwareEmployee(111, "abc", "abc@gmail.com", 5000, "hibernate");
		HardwareEmployee he = new HardwareEmployee(222, "xyz", "xyz@gmail.com", 6000, 9);
		Admin admin= new Admin(333, "adm123", "adm123@gmail.com", 7000, "SR Nagar");
		
		session.save(se);
		session.save(he);
		session.save(admin);
		
		t.commit();
		
		session.close();
		sf.close();
		
	}

}
