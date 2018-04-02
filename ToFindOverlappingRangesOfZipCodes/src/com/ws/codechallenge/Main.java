package com.ws.codechallenge;

import java.util.List;
import java.util.Stack;

import com.ws.codechallenge.helper.FileHelper;
import com.ws.codechallenge.helper.ZipCodeHelper;
import com.ws.codechallenge.zipcode.ZipCode;

public class Main {

	public static void main(String[] args) {
		List<ZipCode> zipCodes = getZipCodes();
		mergeOverlappingZipCode(zipCodes);
	}

	/**
	 * This method will open and read contents given in ZipCode.txt file It will
	 * create ZipCode objects and add them to List
	 * 
	 * @return List<ZipCode>
	 */
	private static List<ZipCode> getZipCodes() {
		FileHelper.openFile();
		List<ZipCode> zipCodes = FileHelper.readFile();
		return zipCodes;
	}

	/**
	 * This method will merge given zipCodes and print them to the console 
	 * @param zipCodes
	 */
	private static void mergeOverlappingZipCode(List<ZipCode> zipCodes) {

		if (zipCodes != null && zipCodes.size() >= 1) {

			Stack<ZipCode> st = ZipCodeHelper.mergeOverlappingZipCode(zipCodes);

			for (ZipCode zipCode : st) {
				System.out.println(
						"Merged ZipCode " + "[" + zipCode.getLowerRange() + "," + zipCode.getUpperRange() + "]");
			}
		}
	}

}
