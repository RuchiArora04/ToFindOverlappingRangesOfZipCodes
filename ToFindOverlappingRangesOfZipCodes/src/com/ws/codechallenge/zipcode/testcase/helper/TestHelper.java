package com.ws.codechallenge.zipcode.testcase.helper;

import java.util.ArrayList;
import java.util.List;

import com.ws.codechallenge.zipcode.ZipCode;

public class TestHelper {

	public static List<ZipCode> getListOfZipCode(){
		ZipCode zp1 = new ZipCode(95630,95633);
		ZipCode zp2 = new ZipCode(95632,96000);
	
		
		List<ZipCode> list = new ArrayList<ZipCode>();
		list.add(zp1);
		list.add(zp2);
	//	list.add(zp3);
		
		return list;
		
	}

}
