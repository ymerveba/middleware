package com.middleware.spring.ServiceProvider;

import java.sql.Connection;
import java.sql.DriverManager;




public class Connection1 {
	
	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/middleware";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "";
	   
	   public static Connection getConnection(){
	   java.sql.Connection conn = null;
	   
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	   }
	   catch(Exception e){
		   e.printStackTrace();
	   }
	   return conn;
	   }
	      //STEP 4: Execute a query
	      /*System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT id, first, last, age FROM Employees";
	      ResultSet rs = stmt.executeQuery(sql);

	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	         int id  = rs.getInt("id");
	         int age = rs.getInt("age");
	         String first = rs.getString("first");
	         String last = rs.getString("last");

	         //Display values
	         System.out.print("ID: " + id);
	         System.out.print(", Age: " + age);
	         System.out.print(", First: " + first);
	         System.out.println(", Last: " + last);
	      }
	      //STEP 6: Clean-up environment
	      rs.close();
	      stmt.close();
	      conn.close();
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
	}//end main
	}//end FirstExample
*/}
	   