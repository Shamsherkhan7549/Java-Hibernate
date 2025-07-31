package com.example.onetomany.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.onetomany.entity.Course;
import com.example.onetomany.entity.Student;



public class StudentDao {
	Configuration cfg;
	SessionFactory sf;
	Session s;
	Transaction tx;
	boolean status = false;
	
	public boolean configure() {
		try {
			cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			cfg.addAnnotatedClass(Student.class);
			cfg.addAnnotatedClass(Course.class);
			sf = cfg.buildSessionFactory();
			s = sf.openSession();
			
			status = true;
			
		}catch(Exception ex) {
			System.out.println("Exception in configuration  : " + ex);
			status = false;
		}
		return status;
	}
	
	public boolean insertStudent(Student student) {
		try {
			tx = s.beginTransaction();
			s.save(student);
			tx.commit();
			return true;
		}catch(Exception ex) {
			System.out.println("Exception in insertStudent()  : " + ex);
			return false;
		}
	}
	
	
	
	
	

}
