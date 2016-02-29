package com.fellowshopper.core;

import java.util.List;

public class Requestor extends User {
	
	
	private List<Product> myShoppingList;

	public Requestor(String firstname, String lastname, String phone) {
		super(firstname, lastname, phone);
		int totalCount = this.getTotalRequestors() + 1;
		this.setUID(String.valueOf(totalCount));
		
	}

	public List<Product> getMyShoppingList() {
		return myShoppingList;
	}

	public void setMyShoppingList(List<Product> myShoppingList) {
		this.myShoppingList = myShoppingList;
	}
	
	

}
