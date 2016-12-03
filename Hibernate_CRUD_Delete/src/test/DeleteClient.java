package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class DeleteClient {

	public static void main(String[] args) {

		
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/mysql.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		
		Transaction t = s.beginTransaction();
		
		Student st = new Student();
		st.setId(100); //Need to pass only primary key value only
		
		//s.get(Student.class, 100); If this code is there then update code will not work
		
		s.delete(st);
		
		t.commit();
		
		s.evict(st);  //delted from session gc will collect student object
		s.close();
		sf.close();
		System.out.println("Data Deleted");
	}

}
