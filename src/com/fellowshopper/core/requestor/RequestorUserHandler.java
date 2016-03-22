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
	
	
	ShoppingListManager listManager ;
	
	public void handleUser(Requestor requestorUser){
		
		
		System.out.println("Handling a new user: "+ requestorUser.getFirstName() + " , " + requestorUser.getLastName() + " , " + requestorUser.getUserName()
							+ " , " + requestorUser.getUID());
		
		System.out.println("Welcome: "+ requestorUser.getFirstName() + " , " + requestorUser.getLastName() +"\n"
				+ "Select from the below Options \n"
				+ "1. Show my current List \n"
				+ "2. Add a Product to my List \n"
				+ "3. Delete a Product from my List\n");
		
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		
		switch(input){
		
		case 1: 
		System.out.println("My Current List: "+ requestorUser.getMyShoppingList());
		break;
		
		case 2: 
			addProduct(requestorUser);
			break;
			
		case 3:
			deletProduct();
			break;
			
		}
		in.close();
	}

	private void deletProduct() {
		// TODO Auto-generated method stub
		
	}

	private void addProduct(Requestor requestorUser) {
		listManager = new ShoppingListManagerImpl();
		Product product = new Product();
		listManager.addProductToList(product, requestorUser);
		
	}



}
