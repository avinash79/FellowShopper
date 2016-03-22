package com.fellowshopper.core.product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fellowshopper.core.DBConnection;
import com.fellowshopper.core.Product;

public class ProductsManagerImpl implements ProductsManager {

	@Override
	public void addProduct(Product product) {
		
		
		Connection conn = null;
		Statement stmt = null;
		
	//	User user = new Requestor("Avinash", "Vutukuri", "718-309-2875");
		conn = DBConnection.getConnection();
		
		try {
			stmt = conn.createStatement();
			
			String sql = "INSERT INTO product (name,type,category) " +
	                   "VALUES ( '" + product.getName() +"', '" + product.getType() +"', '" + product.getCategory() +")";
			
			System.out.println("Query: "+sql);
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void modifyProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> getProducts() {
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		
	//	User user = new Requestor("Avinash", "Vutukuri", "718-309-2875");
		
		List<Product> products = new ArrayList<Product>();
		try {
			stmt = conn.createStatement();
			
			String sql = "select * from product";
			
			System.out.println("Query: "+sql);
			ResultSet rs = stmt.executeQuery(sql);
			
			 products = getProductsFromResultSet(rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
		
	}

	private List<Product> getProductsFromResultSet(ResultSet rs) {
		
		
		List<Product> products = new ArrayList<Product>();
		
		 try {
			 
		while(rs.next()) {
			   Product product = new Product();      
			  
				product.setName(rs.getString("name"));
			    product.setType(rs.getString("type"));
			    product.setCategory(rs.getString("category"));
			    
			   products.add(product);
			} 
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return products;
	}

}
