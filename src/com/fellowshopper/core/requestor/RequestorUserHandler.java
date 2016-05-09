package com.fellowshopper.core.requestor;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fellowshopper.core.DBConnection;
import com.fellowshopper.core.Product;
import com.fellowshopper.core.Requestor;
import com.fellowshopper.core.User;
import com.semantics3.api.Products;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

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
	//	Product product = new Product();
		
		Products products = new Products(
			    "SEM3EED4214AB9CC96CBBFA19B199BE07C4A",
			    "NjI5ZWY3NDNmNjMwODc0M2VjN2MxMzRkYmEwOWI0YmM"
			);
		/* Build the Request */
//		products
//		    .productsField( "search", "tomatoes" );
		
		products
	    .productsField( "upc", "00044100105401" )
	    .productsField( "fields", "name","gtins" );

		try {	
		/* Make the Request */
		JSONObject results, newResults;
		JSONArray actualResults;
		
			results = products.getProducts();
			actualResults = results.getJSONArray("results");
			
			newResults = actualResults.getJSONObject(0);
			/* View the results of the Request */
			
			System.out.println(results);
			System.out.println(newResults);
			System.out.println(actualResults.length());
			System.out.println(newResults.getString("name"));
		System.out.println(actualResults);
		} catch (OAuthMessageSignerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OAuthExpectationFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OAuthCommunicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	//	listManager.addProductToList(product, requestorUser);
		
	}



}
