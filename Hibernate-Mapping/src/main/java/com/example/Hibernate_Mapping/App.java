package com.example.Hibernate_Mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.Hibernate_Mapping.entity.OneToManyDepartment;
import com.example.Hibernate_Mapping.entity.OneToManyEmployee;
import com.example.Hibernate_Mapping.entity.OneToOneAddress;
import com.example.Hibernate_Mapping.entity.OneToOneStudent;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// Create configuraion
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        //one to one anntaion
        cfg.addAnnotatedClass(OneToOneStudent.class);
        cfg.addAnnotatedClass(OneToOneAddress.class);
        
        // one to many and many to one annotation
        cfg.addAnnotatedClass(OneToManyDepartment.class);
        cfg.addAnnotatedClass(OneToManyEmployee.class);
        
        // Create Session Factory
        SessionFactory sessionFectory = cfg.buildSessionFactory();
        
        //Create Session
        Session session = sessionFectory.openSession();
        
        // Create Transaction
        Transaction transaction = session.beginTransaction();
        
        // one to one
        OneToOneAddress address = new OneToOneAddress();
        address.setState("Maharashtra");
        address.setDistrict("Nagpur");
        address.setLocality("Manish Nagar");
        //session.save(address);
        
        OneToOneStudent student = new OneToOneStudent();
        student.setName("Shahrukh"); 
        address.setId(1); // because for id = 1 already saved that is called one to one relationship
        student.setOneToOneAddress(address);
        //session.save(student);
        
        // one to many and many to one
        
        // many to one
        OneToManyDepartment department = new OneToManyDepartment();
        department.setDepartment_name("fullstack developer");
        //session.save(department);
        
        // one to many
        OneToManyEmployee employee = new OneToManyEmployee();
        employee.setName("Rahul");
        department.setId(2);
        employee.setDepartment(department);
        //session.save(employee);
        
        
        
        
        
        
        
        
        transaction.commit();
        session.close();
        session.close();
        
        System.out.println("Data added success fully");
        
        
    }
}
