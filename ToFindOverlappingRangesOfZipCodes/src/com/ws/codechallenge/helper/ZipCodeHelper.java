package com.ws.codechallenge.helper;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

import com.ws.codechallenge.zipcode.ZipCode;
import com.ws.codechallenge.zipcode.comparator.ZipCodeComparator;
/**
 * Helper class to provide methods to manipulate zipCodes.
 * @author Ruchi
 *
 */
public class ZipCodeHelper {

	/**
	 * Helper method to merge overlapping zipCodes
	 * 
	 * @param zipCodes
	 * @return Stack<ZipCode>
	 */
	public static Stack<ZipCode> mergeOverlappingZipCode(List<ZipCode> zipCodes) {

		Stack<ZipCode> st = new Stack<ZipCode>();
		//Get list of valid zipcodes . This is required only if the possibility of having
		//lowerRange greater than upperRange is true.
		if (zipCodes != null && zipCodes.size() != 0) {
			for(int i = 0; i <= zipCodes.size() - 1; i++) {
				if (!ZipCodeHelper.isValid(zipCodes.get(i))) {
					int lowerRange = zipCodes.get(i).getLowerRange();
					zipCodes.get(i).setLowerRange(zipCodes.get(i).getUpperRange());
					zipCodes.get(i).setUpperRange(lowerRange);

				}
			}
			// sort the List using comparator
			Collections.sort(zipCodes, new ZipCodeComparator());
			//Use stack to merge zip code ranges
			st.push(zipCodes.get(0));
			for (int i = 1; i <= zipCodes.size() - 1; i++) {
				// Check if stack's top element upper range is greater than
				// incoming zipCode lowerRange
				// Then we will merge these two ranges of zipCodes
				if (st.peek().getUpperRange() > zipCodes.get(i).getLowerRange()) {
					ZipCode top = st.pop();
					top.setUpperRange(zipCodes.get(i).getUpperRange());
					st.push(top);
				} else {
					st.push(zipCodes.get(i));
				}
			}
		}
		return st;
	}

	/**
	 * Helper method to check whether zipcode is valid or not. A zipCode is valid if
	 * lower range of zipcode is lesser than higher range.
	 * 
	 * @param zp
	 * @return
	 */
	public static boolean isValid(ZipCode zp) {
		boolean isValid = true;
		if (zp != null) {
			if (zp.getLowerRange() > zp.getUpperRange()) {
				isValid = false;
			}
		}
		return isValid;
	}


}
