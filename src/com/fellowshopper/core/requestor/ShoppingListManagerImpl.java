package com.fellowshopper.core.requestor;

import java.util.List;

import com.fellowshopper.core.Product;
import com.fellowshopper.core.Requestor;

public class ShoppingListManagerImpl implements ShoppingListManager {


	@Override
	public String addProductToList(Product product, Requestor user) {

	List<Product> currentListofProducts	=user.getMyShoppingList();
	currentListofProducts.add(product);
	
	return null;
	}

	@Override
	public String modifyProductinList(Product product, Requestor user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteProductFromList(Product product, Requestor user) {
		// TODO Auto-generated method stub
		return null;
	}

}
