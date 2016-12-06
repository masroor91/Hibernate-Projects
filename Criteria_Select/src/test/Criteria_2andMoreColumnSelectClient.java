package test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import beans.Employee;

public class Criteria_2andMoreColumnSelectClient {

	public static void main(String[] args) {

Configuration cfg = new Configuration();
		
		cfg.configure("resources/mysql.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session= sf.openSession();
		
		Criteria c = session.createCriteria(Employee.class);
		
		ProjectionList pl= Projections.projectionList(); //pl is a List
		Projection p1= Projections.property("name");
		Projection p2= Projections.property("email");
		pl.add(p1);
		pl.add(p2);
		
		c.setProjection(pl);
		
		List<Object> list= c.list();
		
		System.out.println("\nIterating using forloop iterator\n");
		
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Object[] objects = (Object[]) iterator.next();
			
			for (Object object : objects) {
				System.out.println(object);
			}
			
		}
		
		
		System.out.println("\nIterating using foreach\n");
		for (Object object : list) {
			
			Object[] objects= (Object[]) object;
			
			for (Object val : objects) {
				System.out.println(val);
			}
			
		}
		
		
		System.out.println("\nIterating using foreach \n");
		for (Object object : list) {
			Object[] objects= (Object[]) object;
			
			System.out.println("Name: " + objects[0]);
			System.out.println("Email: " + objects[1]);
		}
		
		session.close();
		sf.close();

	}

}
