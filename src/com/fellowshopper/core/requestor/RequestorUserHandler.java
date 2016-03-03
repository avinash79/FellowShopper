package com.fellowshopper.core.requestor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fellowshopper.core.DBConnection;
import com.fellowshopper.core.Requestor;
import com.fellowshopper.core.User;

public class RequestorUserHandler {
	
	User requestorUser;
	
	public void handleUser(){
		
		
		User user =	getUserDetails();
		
		System.out.println("Handling a new user: "+ user.getFirstName() + " , " + user.getLastName() + " , " + user.getUserName()
							+ " , " + user.getUID());
		
		
	}

	private User getUserDetails() {
		
		User user = new Requestor();
		
		Connection conn = DBConnection.getConnection();
		
		Statement stmt= null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			
			String sql = "Select * from user where user_type = 'Requestor'";
			
			rs = stmt.executeQuery(sql);
			rs.next();
			
			user.setUserName(rs.getString("username"));
			user.setFirstName(rs.getString("first_name"));
			user.setLastName(rs.getString("last_name"));
			user.setPhoneNumber(rs.getString("phone_num"));
			user.setUID(rs.getString("id"));
			
			} catch (SQLException exp) {
			        exp.printStackTrace();
			    } 
		return user;
	}

}
