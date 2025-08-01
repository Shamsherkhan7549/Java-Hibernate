package com.hibernate.hibernate_basic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.hibernate_basic.entity.Employees;


public class EmployeeMain {

	public static void main(String[] args) {
		
		// Configure Hibernate
		Configuration cfg = new Configuration().configure();
		cfg.configure("hibernate.cfg.xml");
    	cfg.addAnnotatedClass(Employees.class);
    	
    	// Create SessionFactory
		SessionFactory sf = cfg.buildSessionFactory();
		
		// Open Session
		Session session = sf.openSession();
		
		// Begin Transaction
		Transaction tx = session.beginTransaction();
		
		Employees employee = new Employees();
		employee.setName("Raj");
		employee.setSalary(95000);
		
		session.saveOrUpdate(employee);
		tx.commit();
		
		
		session.close();

		System.out.println("Data saved successfully");
	
	}

}
