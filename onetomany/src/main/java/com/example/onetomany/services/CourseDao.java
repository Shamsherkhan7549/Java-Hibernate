package com.example.onetomany.services;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.onetomany.entity.Course;
import com.example.onetomany.entity.Student;



public class CourseDao {
	Configuration cfg;
	SessionFactory factory;
	Session session;
	Transaction transaction;
	boolean status = false;
	public boolean configure() {
		try {
			cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			cfg.addAnnotatedClass(Course.class);
			cfg.addAnnotatedClass(Student.class);
			
			factory = cfg.buildSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			status = true;
		}catch(Exception ex) {
			status = false;
			System.out.println("Exception in configuration : " + ex);
			
		}
		return status;
	}
	
	
	public boolean insertCourse(Course course) {
		try {
			session.save(course);
			transaction.commit();
			return true;
		}catch(Exception ex) {
			System.out.println("Data not saved!");
			System.out.println("Exception in insertCourse() : " + ex);
			return false;
		}
		 
	}
	
	
	
	
	
}
