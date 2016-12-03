package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class PersistClient {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/mysql.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		
		Transaction t = s.beginTransaction();
		
		Student st = new Student();
		st.setId(100);
		st.setName("Masroor");
		st.setEmail("mas@gmail.com");
		st.setAddress("Varanasi");
		st.setMarks(400);
		
		s.persist(st);
		
		t.commit();
		
		s.evict(st);  //deleted from session gc will collect student object
		s.close();
		sf.close();
		System.out.println("Data Inserted");
	}

}
