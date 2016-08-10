/*package com.webApp.Products;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.webApp.DAO.Transaction;


public class InsertProductData {

	public static void main(String[]args){
		Product_Info t=new Product_Info();
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session  = sessionFactory.openSession();
		session.beginTransaction();
		int price=20;
		String
		while(){
			t.setPrice(price);
			t.setProductName(productName);
		session.save(t);
		price=price+20;
		}
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
	}
}
*/