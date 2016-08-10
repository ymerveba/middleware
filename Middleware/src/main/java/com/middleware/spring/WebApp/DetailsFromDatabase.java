package com.middleware.spring.WebApp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.log4j.Logger;
import com.middleware.spring.ServiceProvider.Connection1;
import com.middleware.spring.ServiceProvider.LoginForm;

public class DetailsFromDatabase {
	private static Statement stmt;
	private static final Logger logger = Logger
			.getLogger(DetailsFromDatabase.class);

	public static DiscountObject getDiscountDetails(String userID,
			LoginForm webAppId) {
		DiscountObject DObject = new DiscountObject();
		
		Connection conn = Connection1.getConnection();

		String sql;
		/*try {
			stmt = conn.createStatement();
			sql = "SELECT * FROM `transaction_details` WHERE `email_id`="
					+"'"+ userID+"'" + " and `ecommerce_id`=" + webAppId.getId();
			logger.info(sql);
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {

				DObject.setSpNumberOfTransaction(rs.getInt(3));
				DObject.setSpTotalTransactionAMount(rs.getFloat(4));
			}
			// logger.info(rs.getString(1));
		} catch (Exception e) {
			logger.info("Exception Inside transaction_details", e);
		}*/
		try {
			stmt = conn.createStatement();
			sql = "SELECT * FROM `rating` WHERE `email_id`=" +"'"+ userID+"'";
			logger.info(sql);
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {

				DObject.setNum_of_people(rs.getInt(2));
				DObject.setAvg_rating(rs.getFloat(4));
			}
		} catch (Exception e) {
			logger.info("Error inside rating", e);
		}
		/*try {

			sql = "select sum(total_transactions),sum(total_value) FROM `transaction_details` WHERE `ecommerce_id`="
					+ webAppId.getId();
			logger.info(sql);
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			logger.info(rs+"Here123");
			//if(rs!=null&&null!=rs.getString(1)){
			if (rs.next()) {
				logger.info("No exception");
				DObject.setSpNumberOfTransaction(rs.getInt(1));
				DObject.setSpTotalTransactionAMount(rs.getFloat(2));
			}
			else{
				return new DiscountObject();
			}//}
		} catch (Exception e) {
			logger.info("Error inside rating", e);
			return null;
		}*/
		return DObject;
	}

	public static LoginForm authenticate(LoginForm login) {
		Connection conn = Connection1.getConnection();

		String sql;
		try {
			stmt = conn.createStatement();
			sql = "SELECT * FROM `registered_ecommerce` WHERE `ecommerce_name`="
					+ "'"+login.getEmail_id()+"'" + " and password=" + "'"+login.getPassword()+"'";
			logger.info(sql);
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				login.setId(rs.getInt(1));
				login.setEmail_id(rs.getString(2));
			}
			// logger.info(rs.getString(1));
		} catch (Exception e) {
			logger.info("Exception Inside transaction_details", e);
		}

		return login;
	}

}
