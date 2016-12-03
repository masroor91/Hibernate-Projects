package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class Client {

	public static void main(String[] args) {


		try{
			Configuration cfg = new Configuration();
			cfg.configure("resources/hibernate.cfg.xml");
		
			SessionFactory sf = cfg.buildSessionFactory();
			System.out.println("tables created");
		
			try{
				Thread.sleep(1000*10);
				
			}
			catch(Exception e){
				
				e.printStackTrace();
			}
		
			sf.close();
			System.out.println("Drop all tables");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		

	}

}
