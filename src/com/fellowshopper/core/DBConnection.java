package com.fellowshopper.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	
	  // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/fellow_shopper";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	   
	   public static Connection getConnection(){
		   Connection conn = null;
		   Statement stmt = null;
		   
		   try {
			Class.forName("com.mysql.jdbc.Driver");
			
			  //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		return conn;
		   
	   }
	   
	
}
