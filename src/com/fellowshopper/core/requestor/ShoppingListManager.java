package com.fellowshopper.core.requestor;

import com.fellowshopper.core.Product;
import com.fellowshopper.core.Requestor;

public interface ShoppingListManager {

	String addProductToList(Product product, Requestor user);
	
	String modifyProductinList(Product product, Requestor user);
	
	String deleteProductFromList(Product product, Requestor user);
	
}
