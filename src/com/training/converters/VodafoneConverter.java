package com.training.converters;

//PAIR 2 (write a new file parser to convert) -> Vodafone format - source customerId date time callduration(mins) 
//vodafone 123 23/7/2011 11:30  30 
//fixed price of 50 paise per min
//VodafoneConverter (takes a string). You can ask it to return data in the common record.

public class VodafoneConverter {

	public double calculateCallCost(String[] vodafoneInput) {
	if (Boolean.parseBoolean(vodafoneInput[5]) == true) {
			return Double.parseDouble(vodafoneInput[4])
					* Double.parseDouble(vodafoneInput[6]);
		} else {
			return Double.parseDouble(vodafoneInput[4])
					* Double.parseDouble(vodafoneInput[7]);
		}
	}

	public void convertRecord(String[] vodafoneInput, String outputPath) {
		if(!vodafoneInput[0].equals("Vodafone")){
			throw new IllegalArgumentException("Invalid record passed.");
		}
		if(vodafoneInput.length != 8){
			throw new IllegalArgumentException("Invalid no of fields in record.");
		}
			
		calculateCallCost(vodafoneInput);
	}

}
