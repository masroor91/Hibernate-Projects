package test;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class Client {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		
		cfg.configure("resources/mysql.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session= sf.openSession();
		
		Transaction t = session.beginTransaction();
		
		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		Validator v= vf.getValidator();
		
		Student s= new Student();
		s.setId(110);
//		s.setName("Masroor");
//		s.setEmail("mas@gmail.com");
//		s.setAddress("Varanasi");
		
		Set<ConstraintViolation<Student>> seterror= v.validate(s);
		
		if (!seterror.isEmpty()) {
			
			for (ConstraintViolation<Student> error : seterror) {
					System.out.println(error.getPropertyPath()+ ":======:" + error.getMessage()); //fieldname: error Message
			}
			
		}
		else{
			
			session.save(s);
			t.commit();
			
		}	

	}

}
