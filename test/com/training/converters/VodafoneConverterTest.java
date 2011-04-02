package com.training.converters;

import junit.framework.Assert;

import org.junit.Test;
import org.mockito.Mockito;

//Common format - source,customerId,date,time,billingCost(Rs)
//AIRTEL,123,23/7/2011,11:30,15
//VODAFONE,123,23/7/2011,11:30,15
//SPICE,123,23/7/2011,11:30,15

public class VodafoneConverterTest {
	@Test
	public void isCallCost20_If_LocalRateIs1_And_DurationIs20() {
		String vodafoneInput [] = {"Vodafone","123","23/7/2011","11:30","20","true","1","2"};
		VodafoneConverter vodafoneConverter = new VodafoneConverter();
		Assert.assertEquals(20.0,vodafoneConverter.calculateCallCost(vodafoneInput));
	}
	
	@Test
	public void isInvalidArgumentPassed() throws Exception {
		
		String vodafoneInput [] = {"Airtel","123","23/7/2011","11:30","20","true","1","2"};
		VodafoneConverter vodafoneConverter = new VodafoneConverter();
		try{
			String outputPath = "abc";
			vodafoneConverter.convertRecord(vodafoneInput,outputPath );
			Assert.fail();
		}catch (IllegalArgumentException illegalArgumentException){
			
		}
	}
}
