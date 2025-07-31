package com.project.student_management;

import java.util.Scanner;

import com.project.student_management.entity.Admin;
import com.project.student_management.services.AdminDao;
import com.project.student_management.services.CourseDao;

public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
    	
       
    	
    	// Admin
        System.out.println("Enter 1 to Signup  as Admin");
        System.out.println("Enter 2 to Signin  as Admin");
        
        //Student
        System.out.println("Enter 3 to Signup  as Student");
        System.out.println("Enter 4 to Signup  as Student");
        
        //Check Login
        boolean isAdminLogin = false;       
        
        System.out.println("Enter Option : ");
        int option = sc.nextInt();
        
        //AdminDao
        AdminDao adminDao = new AdminDao();
        boolean isConfigure = adminDao.isConfigureAdmin();
        if(!isConfigure) {
        	System.out.println("Problem in Adminn Configuration");
        	return;
        }
        
        if(option == 1) {
        	System.out.println("Enter Admin Passcode");
        	String passcode = sc.next();
        	
        	if(passcode.equals("adminpasscode")) {        		
        		boolean isAdminRegistered = adminDao.insertAdmin();
        		if(isAdminRegistered) {
        			isAdminLogin = true;
        		}
        	}
        }else if(option == 2) {
        	System.out.println("Enter Username");
        	String username = sc.next();
        	
        	System.out.println("Enter Password");
        	String password = sc.next();
        	Admin isExist = adminDao.isAdminExist(username,password);
        	if(isExist != null) {
        		isAdminLogin = true;
        	}else {
        		isAdminLogin = false;
        	}	
        	
        }
        
        
        //CourseDao
        CourseDao courseDao = new CourseDao();
        
        while(isAdminLogin) {
        	System.out.println("Enter 1 to View Course");       	
        	System.out.println("Enter 2 to Add Course");
        	System.out.println("Enter 3 to Update Course");      
        	System.out.println("Enter 4 to Delete Course");    
        	
        	System.out.println("Enter 5 to View Students");      
        	System.out.println("Enter 6 to Add Student");      	
        	System.out.println("Enter 7 to Update Student");
        	
        	System.out.println("Enter Option");
        	int opt = sc.nextInt();
        	
        	if(!courseDao.isConfigureCourse()) {
        		System.out.println("Problem in configuration");
        		return;
        	}
        	
        	switch(opt) {
        	
        	case 1:
        		courseDao.fetchAllCourse();
        		break;
        		
        	case 2:
        		courseDao.insertcourse();
        		break;
        		
        	case 3:
        		courseDao.updateCourse();
        		break;
        		
        	case 4:
        		courseDao.deleteCourese();
        		break;
        		
        	case 5:
        		break;
        		
        	case 6:
        		break;
        		
        	case 7:
        		break;
        		
        	 default:
         		System.out.println("Enter A Valid key");
        	}
        	
        	System.out.println("Do you want to Signout y/n ? ");
        	char per = sc.next().charAt(0);
        	if(per == 'y') {
        		isAdminLogin = false;
        	}
        	
        
        	
        }
        
        System.out.println("You are Signout");
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }   
}
