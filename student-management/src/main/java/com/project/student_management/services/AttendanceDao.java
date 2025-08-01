package com.project.student_management.services;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.project.student_management.entity.Admin;
import com.project.student_management.entity.Course;
import com.project.student_management.entity.Student;

public class AttendanceDao {
	Configuration cfg;
	SessionFactory factory;
	Session session;
	Transaction transaction;
	boolean status = false;
	Scanner sc = new Scanner(System.in);
	
	public boolean isConfigure() {
		
		try {
			cfg = new Configuration().configure("hibernate.cfg.xml");
			cfg.addAnnotatedClass(Student.class);
			cfg.addAnnotatedClass(Course.class);
			cfg.addAnnotatedClass(Admin.class);
			
			factory = cfg.buildSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			status = true;
		}catch(Exception ex) {
			System.out.println("Exception in Configuration : " + ex);
			status = false;
		}
		
		return status;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
