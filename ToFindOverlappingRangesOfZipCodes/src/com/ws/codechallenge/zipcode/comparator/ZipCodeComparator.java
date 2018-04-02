package com.ws.codechallenge.zipcode.comparator;

import java.util.Comparator;

import com.ws.codechallenge.zipcode.ZipCode;
/**
 * This Comparator class will compare two provided ZipCode objects and sort them by lower range 
 * of zipcode.
 * @author Ruchi
 *
 */
public class ZipCodeComparator implements Comparator<ZipCode>{

	/**
	 * Sorts 2 Zipcodes object in order ascending order of lower range of zipcode.
	 */
	@Override
	public int compare(ZipCode zipCode1, ZipCode zipCode2) {
		int lowerRange1 = 0;
		int lowerRange2 = 0;
		
		if(zipCode1 != null && zipCode2 != null ) {
			lowerRange1 = zipCode1.getLowerRange();
			lowerRange2 = zipCode2.getLowerRange();
		}
		return  lowerRange1 - lowerRange2 ;
	}

}
