package com.middleware.spring.ServiceProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;





public class DetailsFromDatabase {
	
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	private static Session session2;
	private static final Logger logger = Logger
			.getLogger(DetailsFromDatabase.class);
public static Rating getRating(String emailID){
	Rating login1=new Rating();
	Statement stmt;
	try{
		Connection conn = Connection1.getConnection();
		
		stmt = conn.createStatement();
		
		String sql;
		sql = "SELECT * FROM `rating` WHERE email_id="+"'"+emailID+"'";
		logger.info(sql);
		System.out.println(sql);
		ResultSet rs = stmt.executeQuery(sql);
		//logger.info(rs.getString(1));
		
	if(rs.next()){
		
			logger.info("NotEmpty");
			System.out.println("Not Empty");
			login1.setNumberOfRatings(rs.getInt(2));
			login1.setRating(rs.getFloat(4));
			login1.setSP_email(rs.getString(1));
			login1.setId(rs.getInt(3));
			logger.info(rs.getString(1));
		}
		else{
			new Rating();
			logger.info("Empty");
		}
	}catch(Exception e){
		logger.info("Exception1", e);
		new Rating();
		
	}
	
	logger.info(login1.getSP_email()+"here");
	System.out.println(login1.getSP_email());
	return login1;
	
}
public static int setRating(Rating rating) {
	int i=1;
	try{
	Configuration configuration = new Configuration();
	configuration.configure();
	serviceRegistry = new ServiceRegistryBuilder().applySettings(
			configuration.getProperties()).buildServiceRegistry();
	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	session2 = sessionFactory.openSession();
	logger.info("Inside Update");
	logger.info(rating.getNumberOfRatings()+rating.getRating()+rating.getSP_email());
	session2.beginTransaction();
	session2.saveOrUpdate(rating);
	 session2.getTransaction().commit();
	 
	}catch(Exception e){
		logger.info("asda", e);
		return 0;
	}
	finally{
		session2.close();	
	}
	return i;
}
public static int updateRating(Rating rating) {
	int i = 1;
	try{
	Configuration configuration = new Configuration();
	configuration.configure();
	serviceRegistry = new ServiceRegistryBuilder().applySettings(
			configuration.getProperties()).buildServiceRegistry();
	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	session2 = sessionFactory.openSession();
	logger.info(rating.getNumberOfRatings()+rating.getRating()+rating.getSP_email());
	session2.beginTransaction();
	//session2.delete(rating);
	session2.update(rating);
	session2.getTransaction().commit();
	 
	}catch(Exception e){
		logger.info("asda", e);
		return 0;
	}
	finally{
		session2.close();	
	}
	return i;
}
public static LoginForm authenticate(LoginForm loginobj) {
	// boolean result = false;
	Configuration configuration = new Configuration();
	configuration.configure();
	serviceRegistry = new ServiceRegistryBuilder().applySettings(
			configuration.getProperties()).buildServiceRegistry();
	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	/*
	 * SessionFactory sessionfactory = new
	 * Configuration().configure().buildSessionFactory();
	 */
	Session session2 = sessionFactory.openSession();
	session2.beginTransaction();
	LoginForm login1 = (LoginForm) session2.get(LoginForm.class,
			loginobj.getEmail_id());
	if (login1 != null
			&& login1.getPassword().equals(loginobj.getPassword())) {
		// result = true;
		return login1;
	}
	return null;
}
public static void main(String[] args){
	Rating r=new Rating();
	r=getRating("b@email.com");
	r.setRating(3);
	updateRating(r);
}

}
