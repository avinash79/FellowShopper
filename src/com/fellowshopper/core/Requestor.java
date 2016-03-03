package com.fellowshopper.core;

import java.util.List;

public class Requestor extends User {
	
	
	private List<Product> myShoppingList;

	public Requestor(String firstname, String lastname,String username, String phone) {
		super(firstname, lastname, username, phone);
	
	}

	public List<Product> getMyShoppingList() {
		return myShoppingList;
	}

	public void setMyShoppingList(List<Product> myShoppingList) {
		this.myShoppingList = myShoppingList;
	}
	
	

}
