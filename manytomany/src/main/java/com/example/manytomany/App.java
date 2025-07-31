package com.example.manytomany;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.manytomany.entity.Course;
import com.example.manytomany.entity.Student;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration();
    	cfg.addAnnotatedClass(Student.class);
    	cfg.addAnnotatedClass(Course.class);
    	cfg.configure("hibernate.cfg.xml");
    	
    	SessionFactory factory = cfg.buildSessionFactory();
    	
    	Session session = factory.openSession();
    	
    	try {
    		Transaction transaction = session.beginTransaction();
    		
    		//Course
    		Course math = new Course();
    		math.setCourse_name("mathemetics");
    		
    		Course sci = new Course();
    		sci.setCourse_name("science");
    		
    		//Student
    		Student s = new Student();
    		s.setName("John");
    		s.getCourses().add(sci);
    		s.getCourses().add(math);
    		
    		Student s2 = new Student();
    		s2.setName("Bob");
    		s2.getCourses().add(sci);
   
    		
    		session.persist(math);
    		session.persist(sci);
    		session.persist(s);
    		session.persist(s2);
    		
    		transaction.commit();
    		
    		Course c = session.get(Course.class, 1);
    		System.out.println("id : " + c.getCourse_id() + " name : " + c.getCourse_name());
    		
    		Set<Student> students = c.getStudent();
    		
    		for(Student student : students) {
    			System.out.println(" student_name : " + student.getName() );
    		}
    		
    		
    	}catch(Exception ex) {
    		System.out.println(ex);
    		ex.printStackTrace();
    	}finally {
    		session.close();
    	}
    }
}
