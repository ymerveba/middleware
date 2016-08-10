package com.ServiceProvider.DAO;

import java.sql.Connection;
import java.sql.DriverManager;




public class Connection1 {
	
	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/serviceprovider";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "";
	   
	   public static Connection getConnection() throws Exception{
	   java.sql.Connection conn = null;
	   
	  
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	  
	   return conn;
	   }
}	   