package test;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import beans.Employee;

public class Criteria_Aggregate {

	public static void main(String[] args) {

Configuration cfg = new Configuration();
		
		cfg.configure("resources/mysql.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session= sf.openSession();
		
		Criteria avgCriteria= session.createCriteria(Employee.class);
		Criteria maxCriteria= session.createCriteria(Employee.class);
		Criteria sumCriteria= session.createCriteria(Employee.class);
		
		Projection maxp=	Projections.max("salary");
		
		Projection avgp= Projections.avg("salary");
		
		Projection sump= Projections.sum("salary");
		
		avgCriteria.setProjection(avgp);
		maxCriteria.setProjection(maxp);
		
		sumCriteria.setProjection(sump);
		
		
		float maxsal= (Float) maxCriteria.uniqueResult();
		
		double avgsal= (Double) avgCriteria.uniqueResult();
		
		double sumsal= (Double) sumCriteria.uniqueResult();
		
		System.out.println("Max salary of Employee is "+ maxsal);
		
		System.out.println("Average salary of Employee is "+ avgsal);
		
		System.out.println("Sum of salaries of Employee is "+ sumsal);
		
		session.close();
		sf.close();

	}

}
