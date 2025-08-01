package com.hibernate.hibernate_basic;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.hibernate_basic.entity.Products;

public class ProductMain {

	public static void main(String[] args) {
		//Create configuration
		Configuration cfg = new Configuration().configure();
		
		// Create SessionFactory 
		SessionFactory sf = cfg.buildSessionFactory();
		
		// Create Session
		Session session = sf.openSession();
		
		// Begin Transaction
		Transaction tx = session.beginTransaction();
		
		Products product = new Products();
		product.setId(1);
		product.setName("Shoes");
		product.setQuantity(5);

		session.save(product);
		tx.commit();
		session.close();
		System.out.println("Data inserted successfully");
		
	}

}
