package com.ServiceProvider.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.ui.Model;

import com.ServiceProvider.Domain.ProviderAndService;
import com.ServiceProvider.Domain.Services;
import com.ServiceProvider.Domain.UserServices;
import com.ServiceProvider.Rating.RatingResponseObject;
import com.ServiceProvider.Rating.RequestBuilder;
import com.ServiceProvider.login.LoginForm;

public class DetailsFromDatabase {
	private static Statement stmt = null;
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	@SuppressWarnings("unchecked")
	public static List<Services> getServices()throws Exception {
		List<Services> list1 = new ArrayList<Services>();
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		/*
		 * SessionFactory sessionfactory = new
		 * Configuration().configure().buildSessionFactory();
		 */
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		list1 = (List<Services>) session.createQuery("from Services").list();
		return list1;

	}

	public static List<ProviderAndService> getProvidersFromDB(int service_id) throws Exception {
		List<ProviderAndService> list1 = new ArrayList<ProviderAndService>();
		java.sql.Connection conn = Connection1.getConnection();
		List<String> sp=new ArrayList<String>();
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT s.id,s.service_id,s.sp_id,p.first_name,p.email_id FROM `providerandservice` as s,`users` as p where s.service_id="
					+ service_id + " " + "and s.sp_id=p.id";
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				ProviderAndService p = new ProviderAndService();
				p.setId(rs.getInt(1));
				p.setService_id(rs.getInt(2));
				p.setSp_id(rs.getInt(3));
				p.setServiceProvider(rs.getString(4));
				p.setServiceProviderEmail(rs.getString(5));
				sp.add(p.getServiceProviderEmail());
				list1.add(p);
			}
			if(sp.size()!=0){
			RatingResponseObject response;
			response= RequestBuilder.buildRequestToGetRatings(sp);
			if(null==response.getRating()){
				return null; 
			}else
			if(list1.size()==sp.size()){
			for(int i=0;i<list1.size();i++){
				
				if(list1.get(i).getServiceProviderEmail().equals(response.getRating().get(i).getSP_email()))
			    {list1.get(i).setRating(response.getRating().get(i).getRating());
			    list1.get(i).setNumberOfRating(response.getRating().get(i).getNumberOfRatings());
			    System.out.println(response.getRating().get(i).getNumberOfRatings());
			    }
			    }
			return list1;
			}
			else{
		return null;
			}}return null;
	}

	public static Boolean requestService(int serviceID, int providerID,
			LoginForm userDetails) throws Exception {
		Boolean CONFIRMATION=false;
		java.sql.Connection conn = Connection1.getConnection();
		
		stmt = conn.createStatement();
		String sql;
		sql = "insert into `user_services` (`service_used`, `serviceprovider`,`user_id`, `status`)  values "+
				"("+serviceID+","+providerID+","+userDetails.getId()+","+0+")" ;
		System.out.println(sql);
		int rs = stmt.executeUpdate(sql);
	if(rs==1)
		CONFIRMATION=true;
		System.out.println(rs);
		
				return CONFIRMATION;
		
		
	}

	public static Map<String,List<UserServices>> getServiceOptedAndStatus(LoginForm userDetails) throws Exception {
		List<UserServices> completed = new ArrayList<UserServices>();
		List<UserServices> notCompleted = new ArrayList<UserServices>();
		List<UserServices> rated = new ArrayList<UserServices>();
		java.sql.Connection conn = Connection1.getConnection();
		
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * from user_services as us,users as sp,services as s where us.service_used=s.id and "
					+ "us.serviceprovider=sp.id and us.user_id="+userDetails.getId();
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				UserServices p = new UserServices();
				p.setService_id(rs.getInt(3));
				p.setUser_id(rs.getInt(2));
				p.setId(rs.getInt(1));
				p.setServiceProvider_id(rs.getInt(4));
				p.setStatus(rs.getString(5).charAt(0));
				p.setSpEmail(rs.getString(7));
				p.setSpName(rs.getString(8));
				p.setServiceName(rs.getString(12));
				if(p.getStatus()=='0')
				notCompleted.add(p);
				else if(p.getStatus()=='1') completed.add(p);
				else rated.add(p);
			}
	
			Map<String,List<UserServices>> map =new HashMap<String,List<UserServices>>();
			  map.put("completed",completed);
			  map.put("incompleted",notCompleted);
			  map.put("rated", rated);
			  return map;
		
	}
	
	public static LoginForm authenticate(LoginForm loginobj, HttpSession session)throws Exception {
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

	public static void updateService(UserServices userServiceUpdate) throws Exception{
		Session session2;
		
			Configuration configuration = new Configuration();
			configuration.configure();
			serviceRegistry = new ServiceRegistryBuilder().applySettings(
					configuration.getProperties()).buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			session2 = sessionFactory.openSession();
			
			session2.beginTransaction();
			//session2.delete(rating);
			session2.update(userServiceUpdate);
			session2.getTransaction().commit();		
	}
	public static Map<String,List<UserServices>> getRequests(LoginForm userDetails) throws Exception {
		List<UserServices> completed = new ArrayList<UserServices>();
		List<UserServices> notCompleted = new ArrayList<UserServices>();
		List<UserServices> rated = new ArrayList<UserServices>();
		java.sql.Connection conn = Connection1.getConnection();
		
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * from user_services as us,users as sp,services as s where us.service_used=s.id and "
					+ "us.user_id=sp.id and us.serviceprovider="+userDetails.getId();
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				UserServices p = new UserServices();
				p.setService_id(rs.getInt(3));
				p.setUser_id(rs.getInt(2));
				p.setId(rs.getInt(1));
				p.setServiceProvider_id(rs.getInt(4));
				p.setStatus(rs.getString(5).charAt(0));
				p.setSpEmail(rs.getString(7));
				p.setSpName(rs.getString(8));
				p.setServiceName(rs.getString(12));
				if(p.getStatus()=='0')
				notCompleted.add(p);
				else if(p.getStatus()=='1') completed.add(p);
				else rated.add(p);
			}
	
			Map<String,List<UserServices>> map =new HashMap<String,List<UserServices>>();
			  map.put("completed",completed);
			  map.put("incompleted",notCompleted);
			  map.put("rated", rated);
			  return map;
		
	}
	
}
