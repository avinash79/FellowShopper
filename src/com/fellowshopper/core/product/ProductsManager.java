package com.fellowshopper.core.product;

import java.util.List;

import com.fellowshopper.core.Product;

public interface ProductsManager {

	
	void addProduct(Product product);
	
	void modifyProduct(Product product);
	
	void deleteProduct(Product product);
	
	List<Product> getProducts();
	
	
}
