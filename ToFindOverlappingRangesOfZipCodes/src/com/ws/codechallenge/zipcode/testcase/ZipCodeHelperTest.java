package com.ws.codechallenge.zipcode.testcase;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

import com.ws.codechallenge.helper.ZipCodeHelper;
import com.ws.codechallenge.zipcode.ZipCode;
import com.ws.codechallenge.zipcode.testcase.helper.TestHelper;

public class ZipCodeHelperTest {

	@Test
	public void mergeOverlappingZipCodeTest() {
		List<ZipCode> l = TestHelper.getListOfZipCode();	
		Stack<ZipCode> overlappingZipCodes = ZipCodeHelper.mergeOverlappingZipCode(l);
		assertNotNull(overlappingZipCodes);
		Iterator<ZipCode> iter = overlappingZipCodes.iterator();
		while(iter.hasNext()) {
			ZipCode mergeZP = overlappingZipCodes.pop();
			assertEquals(mergeZP.getLowerRange(),95630);
			assertEquals(mergeZP.getUpperRange(), 96000);
		}
	}
	
	@Test
	public void mergeOverlappingZipCodeNullCheckTest() {
		List<ZipCode> l = null;	
		Stack<ZipCode> overlappingZipCodes = ZipCodeHelper.mergeOverlappingZipCode(l);
		assertEquals(overlappingZipCodes.size(),0);
	}
}
