package client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fileprocessors.StockFileData;
import fileprocessors.StockFileReader;

public class StockFileApplication {
	
	public static void main(String args[]) throws IOException{
		StockFileReader fr = new StockFileReader("table.csv");
		
		List<HashMap<String, Double>> dataResult = populateStockFileData(fr.getHeaders(), fr.readFileData());
		StockFileData fileData = new StockFileData();
		fileData.addData(dataResult);
		fileData.printData();
		System.out.println(dataResult.size());
	}
	/**
	 * Complete the method body so that it returns the given structure needed to 
	 * populate the data field in the StockFileData class. 
	 * @param headers
	 * @param lines
	 * @return List
	 */
	public static List<HashMap<String, Double>> populateStockFileData(List<String> headers, List<String> lines){
		List<HashMap<String, Double>> dataResult = new ArrayList<>();
		// So the method takes a List of headers and a List of Lines

		// So the return is a List of HashMaps
		// So first we need to create the HashMaps to insert into the List

		// first loop over the lines of stock data in csv
		for(String line : lines) {
			// make each line an array of comma separated values
			String[] values = line.split(",");
			// count
			int count = 0;
			// define HashMap
			HashMap<String, Double> headerValueMap = new HashMap<>();
			// for all those String values, parse them to Doubles
			for(String value : values) {
				double dval = Double.parseDouble(value);

				// populate a HashMap
				headerValueMap.put(headers.get(count), dval);
				count++;
			}

			dataResult.add(headerValueMap);
		}


		return dataResult;
	}
	
	
}
