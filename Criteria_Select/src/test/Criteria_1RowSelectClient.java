package test;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import beans.Employee;

public class Criteria_1RowSelectClient {

	public static void main(String[] args) {

Configuration cfg = new Configuration();
		
		cfg.configure("resources/mysql.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session= sf.openSession();
		
		Criteria c = session.createCriteria(Employee.class);
		Criterion cr=Restrictions.eq("id", 111);
		c.add(cr);
		
		Employee e = (Employee) c.uniqueResult();
		
		System.out.println(e.getId());
		System.out.println(e.getName());
		System.out.println(e.getEmail());
		System.out.println(e.getSalary());
		
		session.close();
		sf.close();

	}

}
