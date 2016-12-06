package test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.Employee;

public class HQL_SelectAll {

	public static void main(String[] args) {

Configuration cfg = new Configuration();
		
		cfg.configure("resources/mysql.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session= sf.openSession();
		
		String hql= "from Employee";	 
		
		Query q=session.createQuery(hql);
		
		List<Employee> employees = q.list();
		
		System.out.println("\n forloop using iterator");
		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			
			System.out.println("ID:" + employee.getId());
			System.out.println("Name:" + employee.getName());
			System.out.println("Email:" + employee.getEmail());
			System.out.println("Salary:" + employee.getSalary());
		}
		
		System.out.println("\nUsing froeach loop");
		
		for (Employee employee : employees) {
			System.out.println("ID:" + employee.getId());
			System.out.println("Name:" + employee.getName());
			System.out.println("Email:" + employee.getEmail());
			System.out.println("Salary:" + employee.getSalary());
		}
		
		session.close();
		sf.close();

	}

}
