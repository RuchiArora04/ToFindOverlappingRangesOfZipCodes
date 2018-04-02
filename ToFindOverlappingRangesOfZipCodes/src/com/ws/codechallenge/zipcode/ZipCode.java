package com.ws.codechallenge.zipcode;
/**
 * This class is place holder for ZipCode.
 * @author Ruchi
 *
 */
public class ZipCode {

	int lowerRange;
	int upperRange;
	
	public ZipCode(){
		lowerRange = 0;
		upperRange = 0;
	}
	
	public ZipCode(int lowerRange, int upperRange){
		 this.lowerRange = lowerRange;
		 this.upperRange = upperRange;
	}
	

	public int getLowerRange() {
		return lowerRange;
	}

	public void setLowerRange(int lowerRange) {
		this.lowerRange = lowerRange;
	}

	public int getUpperRange() {
		return upperRange;
	}

	public void setUpperRange(int upperRange) {
		this.upperRange = upperRange;
	}
	
	
}
