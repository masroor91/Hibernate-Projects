package test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQL_1ColumnSelectClient {

	public static void main(String[] args) {

Configuration cfg = new Configuration();
		
		cfg.configure("resources/mysql.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session= sf.openSession();
		
		String hql= "Select name from Employee";	 
		
		Query q=session.createQuery(hql);
		
		List<String> names = q.list();
		
		System.out.println("\n forloop using iterator");
		for (Iterator<String> iterator = names.iterator(); iterator.hasNext();) {
			String name = iterator.next();
			System.out.println(name);
		}
		
		System.out.println("\nUsing froeach");
		for (String name : names) {
			System.out.println(name);
		}
		
		session.close();
		sf.close();

	}

}
