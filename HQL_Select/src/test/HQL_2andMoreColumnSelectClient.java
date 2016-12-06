package test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQL_2andMoreColumnSelectClient {

	public static void main(String[] args) {

Configuration cfg = new Configuration();
		
		cfg.configure("resources/mysql.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session= sf.openSession();
		
		String hql= "Select name, email from Employee";	 
		
		Query q=session.createQuery(hql);
		
		List<Object> list= q.list();
		
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
			
			System.out.println(objects[0]);
			System.out.println(objects[1]);
		}
		
		session.close();
		sf.close();

	}

}
