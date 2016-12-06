package test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import beans.Employee;

public class Criteria_Select2AndMoreRestrictions {

	public static void main(String[] args) {

Configuration cfg = new Configuration();
		
		cfg.configure("resources/mysql.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session= sf.openSession();
		
		Criteria c= session.createCriteria(Employee.class);
		
		Criterion cr=Restrictions.gt("salary", Float.parseFloat("6000"));
		
		c.add(cr);
		
		List<Employee> employees = c.list();
		
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
