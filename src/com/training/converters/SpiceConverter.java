package com.training.converters;

//PAIR 3 (write a new file parser to convert) -> Spice format - source,customerId,date,time,callduration(mins),homecity,citycallwasmadein,homerate (paise),visitorRate(paise) 
//spice,123,23/7/2011,11:30,30,1,Mumbai,Mumbai,.5,2 
//SpiceConverter (takes a string). You can ask it to return data in the common record.

public class SpiceConverter {

	public boolean isSpiceRecord(String aRecord)
	{
		String[] words = aRecord.split("\\s+");
		System.out.println(words[0]);
		if(words[0].equals("SPICE"))			
			return true;
		
		return false;
	}
}
