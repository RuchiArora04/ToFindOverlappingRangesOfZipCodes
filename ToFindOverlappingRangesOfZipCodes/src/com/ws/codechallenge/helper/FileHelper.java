package com.ws.codechallenge.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ws.codechallenge.zipcode.ZipCode;

public  class FileHelper {
	private static BufferedReader br;

	/**
	 * This method will open ZipCode.txt file
	 */
	public static void openFile() {
		try {
			File file = new File("ZipCode.txt");
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file");
		}
	}
	
	/**
	 * This helper method will read ZipCode.txt file and 
	 * creates ZipCode object and add them to the List
	 * @return List<ZipCode>
	 */
	public static List<ZipCode> readFile() {
		List<ZipCode> zp = new ArrayList<ZipCode>();
		if (br != null) {
			String line = null;
			try {
				while ((line = br.readLine()) != null) {
					int lowerRange = Integer.parseInt( line.substring(1, 6));
					int upperRange = Integer.parseInt( line.substring(7, 12));
					ZipCode zipCode = new ZipCode(lowerRange,upperRange);
					zp.add(zipCode);
				}
			} catch (NumberFormatException | IOException e) {
				
			}
		}
		return zp;

	}
}
