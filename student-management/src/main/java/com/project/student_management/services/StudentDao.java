package com.project.student_management.services;



import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.project.student_management.entity.Admin;
import com.project.student_management.entity.Course;
import com.project.student_management.entity.Student;



public class StudentDao {
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

	public Student singupStudent() {
		
		try {
			Student student = new Student();			
			
			System.out.println("Enter Student Username");
			String username = sc.next();
			
			System.out.println("Enter Student Email");
			String email = sc.next();
			
			System.out.println("Enter Student Password");
			String password = sc.next();
		
			
			//Student exist or not			
			String hql = "FROM Student WHERE username= :uname AND email= :umail";
			Query<Student> query = session.createQuery(hql,Student.class);
			query.setParameter("uname", username);
			query.setParameter("umail", email);
			List<Student> result = query.list();
			if(!result.isEmpty()) {
				System.out.println("Student Alread Registered With This Username or Email");
				return null;
			}
			
			student.setUsername(username);
			student.setEmail(email);
			student.setPassword(password);
			session.save(student);
			transaction.commit();
			return student;
		}catch(Exception ex) {
			if(transaction != null) transaction.rollback();
			ex.printStackTrace();
			System.out.println("Exception In signupStudent() : " + ex);
			return null;
		}
	}
	
	
	
}
