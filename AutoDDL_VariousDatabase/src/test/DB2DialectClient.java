package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class DB2DialectClient {

	public static void main(String[] args) {

		Student st = new Student();
		st.setId(100);
		st.setName("Masroor");
		st.setEmail("mas@gmail.com");
		st.setAddress("Varanasi");
		st.setMarks(400);
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/db2.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		
		s.save(st); //Persistent state
		
		s.beginTransaction().commit(); // move to database
		
		s.evict(st);  //delted from session gc will collect student object

	}

}
