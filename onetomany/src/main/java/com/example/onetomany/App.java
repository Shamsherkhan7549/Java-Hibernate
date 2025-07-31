package com.example.onetomany;

import java.util.ArrayList;
import java.util.List;

import com.example.onetomany.entity.Course;
import com.example.onetomany.entity.Student;
import com.example.onetomany.services.CourseDao;
import com.example.onetomany.services.StudentDao;

public class App 
{
    public static void main( String[] args )
    {
       CourseDao courseDao = new CourseDao();
       
       
       boolean isConfigure = courseDao.configure();
       if(!isConfigure) {
    	   System.out.println("Hibernate configuration of CourseDao failed");
    	   return;
       }
       
//       StudentDao studentDao = new StudentDao();
//       boolean isConfigure2 = studentDao.configure();
//       if(!isConfigure2) {
//    	   System.out.println("Hibernate configuration of StudentDao failed");
//    	   return;
//       }
       
       // insert course
       Course c = new Course();
       c.setName("C++");
       
       
       // insert Student
       Student s = new Student();
       s.setName("John");
       s.setCourse(c);
       Student s2 = new Student();
       s2.setName("Bob");
       s2.setCourse(c);
       
       List<Student> list = new ArrayList<>();
       list.add(s);
       list.add(s2);
       
       c.setStudent(list);
       
       courseDao.insertCourse(c);
       
       
   
       
    }
}
