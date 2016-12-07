package test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Vote;
import model.Voter;

public class Client {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		
		cfg.configure("resources/mysql.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session= sf.openSession();
		
		Transaction t= session.beginTransaction();
		
		Voter voter1 = new Voter();
		voter1.setVid(1);
		voter1.setVname("xyz");
		voter1.setAge(20);
		
		Vote vote1= new Vote();
		
		vote1.setPartyName("BJP");
		vote1.setCastDate(new Date());
		vote1.setVoter(voter1);
		
		//Vote vote2= new Vote();
		//vote2.setPartyName("BJP");
		//vote2.setCastDate(new Date());
		//vote2.setVoter(voter1);
		
		
		session.save(voter1);
		session.save(vote1);
		//session.save(vote2);
		
		t.commit();
		session.close();
		sf.close();

	}

}
