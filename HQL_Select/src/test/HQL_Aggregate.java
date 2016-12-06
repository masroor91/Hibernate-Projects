package test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQL_Aggregate {

	public static void main(String[] args) {

Configuration cfg = new Configuration();
		
		cfg.configure("resources/mysql.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session= sf.openSession();
		
		String hql= "Select max(salary) from Employee";
		String avghql="Select avg(salary) from Employee";
		
		Query q=session.createQuery(hql);
		
		Query avgq = session.createQuery(avghql);
		
		Float maxsal= (Float) q.uniqueResult();
		
		double avgsal= (Double) avgq.uniqueResult();
		
		System.out.println("Max salary of Employee is "+ maxsal);
		
		System.out.println("Average salary of Employee is "+ avgsal);
		
		session.close();
		sf.close();

	}

}
