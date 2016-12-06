package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.BookMovie;


public class SaveClientUsingAssigned {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		
		Transaction t = s.beginTransaction();
		
		BookMovie bm = new BookMovie();
		bm.setBid(100);
		bm.setMovie("pk");
		bm.setShowTime("10pm");
		bm.setSeatno(20);
		
		int pk= (Integer) s.save(bm); //Persistent state
		
		t.commit();
		
		System.out.println("Inserion Completed successfully");
		
		s.evict(bm);  //delted from session gc will collect student object

	}

}
