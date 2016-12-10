package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Actor;
import beans.Movie;

public class Client {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		
		cfg.configure("resources/mysql.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction t = session.beginTransaction();
		
		Actor a= new Actor();
		a.setAid(1);
		a.setName("Aamir Khan");
		
		Movie m1= new Movie();
		m1.setMid(1);
		m1.setMovieName("pk");
		m1.setActor(a);
		
		Movie m2 = new Movie();
		m2.setMid(2);
		m2.setMovieName("Lagaan");
		m2.setActor(a);
		
		session.save(m1);
		session.save(m2);
		session.save(a);
		
		t.commit();
		session.close();
		sf.close();

	}

}
