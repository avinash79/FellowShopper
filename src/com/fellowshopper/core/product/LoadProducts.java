package com.fellowshopper.core.product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.semantics3.api.Products;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

public class LoadProducts {

	
	private static String NO_DATA = "NO_DATA";
	
	public void loadFromCSV(String apiKey, String apiSecret){
		
		
		
	}
	
	public void loadFromTXT(String apiKey, String apiSecret){
		
	List<String> upcList = readListofUPCsFromFile();
	System.out.println(upcList);
	System.out.println(upcList.size());
	Map<String,Map<String,String>> semanticResultMapforUPCs = createResultMapforUpcs(apiKey, apiSecret, upcList);
		
	printResults(semanticResultMapforUPCs);
	
	
	}

	private void printResults(Map<String, Map<String, String>> semanticResultMapforUPCs) {
		
		for(Map.Entry<String, Map<String,String>> entry : semanticResultMapforUPCs.entrySet()){
			
			System.out.println("Results retreived for the UPC: "+entry.getKey());
			
			System.out.println();
			System.out.println();
			
			System.out.println(entry.getValue());
			
			System.out.println();
			System.out.println();
			
			System.out.println("****************************************************");
		}
		
	}

	private Map<String, Map<String, String>> createResultMapforUpcs(String apiKey, String apiSecret,
			List<String> upcList) {
		
		
		Map<String,String> reaultsMapforUPC;
		Map<String, Map<String, String>> finalResultsMap = new HashMap<String, Map<String, String>>();
		
		Products products = new Products(
			    "SEM3EED4214AB9CC96CBBFA19B199BE07C4A",
			    "NjI5ZWY3NDNmNjMwODc0M2VjN2MxMzRkYmEwOWI0YmM"
			);
		
		
		for(String str: upcList){
				
			products
		    .productsField( "upc", str )
		    .productsField( "fields", "name","gtins" );
			
			
			/* Make the Request */
			try {
				JSONObject results;
				JSONArray actualResults;
				
				results = products.getProducts();
				actualResults = results.getJSONArray("results");
				
				if (actualResults != null && actualResults.length() > 0){
					
					reaultsMapforUPC = getResultMapforUPC(actualResults);
					
					finalResultsMap.put(str, reaultsMapforUPC);
					
				}else {
					reaultsMapforUPC = new HashMap<String,String>();
					reaultsMapforUPC.put(str,NO_DATA);
					
					finalResultsMap.put(str,reaultsMapforUPC );
				}
				
				
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
			
		}
				
		return finalResultsMap;
	}

	private Map<String, String> getResultMapforUPC(JSONArray actualResults) {
	
		List<String> keyStrings = Arrays.asList("name", "upc", "category", "manufacturer", "brand");
		
		JSONObject finalResult = actualResults.getJSONObject(0);
		
		Map<String,String> reaultsMapforUPC = new HashMap<String,String>();
		
		for(String str: keyStrings){
			
		try{
				
			if (finalResult.getString(str) != null){
				reaultsMapforUPC.put(str, finalResult.getString(str));
			}else {
				reaultsMapforUPC.put(str, NO_DATA);
			}
			
			}catch (JSONException e) {
				reaultsMapforUPC.put(str, NO_DATA);
				continue;
			}
		}
		
	System.out.println(reaultsMapforUPC);
		return reaultsMapforUPC;
	}

	

	private List<String> readListofUPCsFromFile() {
		
		String csvFile = "C:\\Users\\avutukuri\\Documents\\FS_Docs\\product_catalogue.csv";
		BufferedReader br = null;
		List<String> upcList = null;
		String splitBy = ",";

		try {

			String sCurrentLine;
			br = new BufferedReader(new FileReader(csvFile));
			upcList= new ArrayList<String>();
			
			while ((sCurrentLine = br.readLine()) != null) {	
				
				String[] afterSplit = sCurrentLine.split(splitBy);
				upcList.add(afterSplit[0].trim());
				 	
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	
		
		return upcList;
	}
	
}
