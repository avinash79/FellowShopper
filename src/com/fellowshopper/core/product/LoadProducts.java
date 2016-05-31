package com.fellowshopper.core.product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadProducts {

	
	public void loadFromCSV(String apiKey, String apiSecret){
		
		
		
	}
	
	public void loadFromTXT(String apiKey, String apiSecret){
		
	List<String>	upcList = readListofUPCsFromFile();
		
	}

	private List<String> readListofUPCsFromFile() {
		
		BufferedReader br = null;
		List<String> upcList = null;

		try {

			String sCurrentLine;
			List<String> modules = new ArrayList<>();
			br = new BufferedReader(new FileReader("C:\\Users\\avutukuri\\Documents\\upc.txt"));

			while ((sCurrentLine = br.readLine()) != null) {
				
				
				String trimmedLine= sCurrentLine.trim();
		
				
				
				
//				String[] currentLineArr = sCurrentLine.trim().split("\\W");
//			//	System.out.println(sCurrentLine.replaceAll("\\W", " "));
//				for(String s: currentLineArr){
//					System.out.println(s);
//				}
			
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
