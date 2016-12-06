package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.OldStudent;

public class ClientInsert {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("resources/mysql.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session   session=  sf.openSession();
		Transaction t = session.beginTransaction();
		
		OldStudent os1= new OldStudent(111, "abc", "abc@gmail.com", "Hyd");
		OldStudent os2= new OldStudent(112, "xyz", "xyz@gmail.com", "Vns");
		OldStudent os3= new OldStudent(113, "pqr", "pqr@gmail.com", "Del");

		session.save(os1);
		session.save(os2);
		session.save(os3);
		
		t.commit();
		session.close();
		sf.close();
	
	}


}
