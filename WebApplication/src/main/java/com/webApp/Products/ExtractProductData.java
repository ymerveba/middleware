package com.webApp.Products;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.webApp.DAO.Transaction;
import com.webApp.DAO.TransactionDetails;
import com.webApp.Domain.*;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.webApp.Login.LoginForm;



@SuppressWarnings("deprecation")
public class ExtractProductData {
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	private static Session session2;
	@SuppressWarnings("unchecked")
	public static List<Items> getProductInfo() throws Exception{
		List<Items> list  = new ArrayList<Items>();
		List<Product_Info> list1  = new ArrayList<Product_Info>();
		
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		
		 
		list1 = (List<Product_Info>)session.createQuery("from Product_Info").list();
		//session1.setAttribute("products", list1);
		for (Product_Info product_Info : list1) {
			
			list.add(new Items(product_Info.getPrice(),product_Info.getProductName(),product_Info.getProductID()));
		}		
		return list;
		
	}
	public static Transaction getTotalTransactions(LoginForm userID) throws Exception{
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session2 = sessionFactory.openSession();
	
		
		session2.beginTransaction();
		Transaction transaction;
		try{
		 transaction = (Transaction) session2.get(Transaction.class, userID.getUserID());}
		catch(NullPointerException e){
			transaction =new Transaction();
			transaction.setUser_id(userID.getUserID());
		}
		return transaction;
		
	}
	public static void putTransactionDetails(List<Items> details,Transaction trans) throws Exception{
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session2 = sessionFactory.openSession();
	TransactionDetails trandet;
	
		
		session2.beginTransaction();
		for(int i =0;i<details.size();i++){
			trandet=new TransactionDetails();
			trandet.setItem_id(details.get(i).getProductID());
			trandet.setUser_id(trans.getUser_id());
		session2.save(trandet);
		}
		trans.setNumberOfTransactions(trans.getNumberOfTransactions()+1);

		session2.saveOrUpdate(trans);
		session2.getTransaction().commit();
		session2.close();
		sessionFactory.close();
		
		
	}
	
}
