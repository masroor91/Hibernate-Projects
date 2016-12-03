package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class GetClient {

	public static void main(String[] args) {

		
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/mysql.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		
		Object o=s.get(Student.class, 101);
		
		Student stu=(Student)o; //Will print NullPointerException here id not found in the database
		
		System.out.println(stu.getId());
		System.out.println(stu.getName());
		System.out.println(stu.getEmail());
		System.out.println(stu.getAddress());
		System.out.println(stu.getMarks());
		
		s.close();
		sf.close();
	}

}
