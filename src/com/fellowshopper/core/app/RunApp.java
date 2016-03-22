package com.fellowshopper.core.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fellowshopper.core.DBConnection;
import com.fellowshopper.core.Requestor;
import com.fellowshopper.core.User;
import com.fellowshopper.core.requestor.RequestorUserHandler;
import com.fellowshopper.core.user.UserManager;
import com.fellowshopper.core.user.UserManagerImpl;

public class RunApp {

	public static void main(String[] args) {
		
		
	
		if (checkUsers() == 1) {
			
			System.out.println("No of requestors is 1 " );
			Requestor requestorUser =	getUserDetails();
			RequestorUserHandler reqHandler = new RequestorUserHandler();
			reqHandler.handleUser(requestorUser);
			
		}
		
		//creating a new user
if (checkUsers() == 0) {
			
	User user = new Requestor("Avinash", "Vutukuri", "avinash79", "718-309-2875");
	
	UserManager usrMngr = new UserManagerImpl();
	
	usrMngr.addUser(user);
			
		}
	
		

	}

	private static  int checkUsers() {
		
		
		Connection conn = DBConnection.getConnection();
		
		Statement stmt= null;
		ResultSet resultSet = null;
		
		try {
			stmt = conn.createStatement();
			
			String sql = "Select * from user where user_type = 'Requestor' ";
			
			resultSet = stmt.executeQuery(sql);
			  
			 if (resultSet == null) {
			        return 0;
			    }
			  
			        resultSet.last();
			        return resultSet.getRow();
			    } catch (SQLException exp) {
			        exp.printStackTrace();
			    } finally {
			        try {
			            resultSet.beforeFirst();
			        } catch (SQLException exp) {
			            exp.printStackTrace();
			        }
			    }
			    return 0;	
	}

	
	
	private static Requestor getUserDetails() {
		
		Requestor user = new Requestor();
		
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
