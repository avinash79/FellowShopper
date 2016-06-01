package com.fellowshopper.core.product;

public class LoadProductsfromUPCs {
	
	
	private static String apiKey = "SEM3EED4214AB9CC96CBBFA19B199BE07C4A";
	private static String apiSecret = "NjI5ZWY3NDNmNjMwODc0M2VjN2MxMzRkYmEwOWI0YmM";

	public static void main(String[] args) {
			
		
		LoadProducts loadProducts = new LoadProducts();
		
		loadProducts.loadFromTXT(apiKey, apiSecret);
	}

}
