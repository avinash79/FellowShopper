package com.fellowshopper.core.requestor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.fellowshopper.core.DBConnection;
import com.fellowshopper.core.Product;
import com.fellowshopper.core.Requestor;
import com.fellowshopper.core.User;

public class RequestorUserHandler {
	
	Requestor requestorUser;
	ShoppingListManager listManager ;
	
	public void handleUser(){
		
		
		requestorUser =	getUserDetails();
		
		System.out.println("Handling a new user: "+ requestorUser.getFirstName() + " , " + requestorUser.getLastName() + " , " + requestorUser.getUserName()
							+ " , " + requestorUser.getUID());
		
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		
		switch(input){
		
		case 1: 
		System.out.println("My Current List: "+ requestorUser.getMyShoppingList());
		break;
		
		case 2: 
			addProduct();
			break;
			
		case 3:
			deletProduct();
			break;
		
		
		
		}
	}

	private void deletProduct() {
		// TODO Auto-generated method stub
		
	}

	private void addProduct() {
		listManager = new ShoppingListManagerImpl();
		Product product = new Product();
		listManager.addProductToList(product, requestorUser);
		
	}

	private Requestor getUserDetails() {
		
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
