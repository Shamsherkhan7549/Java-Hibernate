package com.hibernate.hibernate_basic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.hibernate_basic.entity.Students;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {
    	// 1. Configure Hibernate
    	Configuration cfg = new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	cfg.addAnnotatedClass(Students.class);
    	
    	// 2. Create SessionFactory
    	SessionFactory sf = cfg.buildSessionFactory();
    	
    	// 3. Open Session
    	Session s = sf.openSession();
    	
    	// 4. Begin Transaction
    	Transaction tx = s.beginTransaction();
    	

    	// 5. Save object
    	//Save Student info
    	Students student = new Students();
    	student.setId(4);
    	student.setName("casey");
    	student.setEmail("casey123'@gmail.com");
    	
    	
//    	//int id = (int) s.save(student);  // use to save data
//    	s.saveOrUpdate(student);   // use save and update
//    	tx.commit();
//    	//System.out.println("Response : " + id);
    	
    	// Fetch Student Info
    	Students studentInfo = s.get(Students.class, 1);
    	System.out.println("Student Id : " + studentInfo.getId());
    	System.out.println("Student Name : " + studentInfo.getName());
    	System.out.println("Student Email : " + studentInfo.getEmail());
    	
    	// Update Student Info
//    	student.setId(1);
//    	student.setEmail("sahil123@gmail.com");
//    	s.update(student);
//    	tx.commit();
    	
    	// Delete Student Info
//    	student.setId(2);
//    	s.delete(student);
//    	tx.commit();
    	
    	s.close();
    	sf.close();    	
    	

    }
}
