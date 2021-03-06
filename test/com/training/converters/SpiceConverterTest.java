package com.training.converters;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;


//Common format - source,customerId,date,time,billingCost(Rs)
//AIRTEL,123,23/7/2011,11:30,15
//VODAFONE,123,23/7/2011,11:30,15
//SPICE,123,23/7/2011,11:30,15


public class SpiceConverterTest {
	@Test
	public void IfSpiceObjectIsNotNull() {
	
       SpiceConverter	aSpiceConverter = new SpiceConverter();
       Assert.assertNotNull(aSpiceConverter);
	 
	}
	
	@Test
	public void IfRecordContainsSpiceThenReturnTrue()
	{
		String aRecord = "SPICE 123,23/7/2011 11:30 2 DELHI DELHI 50 100";
		SpiceConverter	aSpiceConverter = new SpiceConverter();
		Assert.assertTrue(aSpiceConverter.isSpiceRecord(aRecord));
	}
	
	@Test
	public void IfHomeCallThenCheckCallCost()
	{
		String aRecord = "SPICE 123 23/7/2011 11:30 2 DELHI DELHI 50 100";
		String aConvertedRecord = "SPICE,123,23/7/2011,11:30,1.0";
		SpiceConverter	aSpiceConverter = new SpiceConverter();
		
		Assert.assertEquals(aConvertedRecord, aSpiceConverter.convert(aRecord));
		
	}
	
	@Test
	public void IfRoamingCallThenCheckCallCost()
	{
		String aRecord = "SPICE 123 23/7/2011 11:30 2 DELHI GURGAON 50 100";
		String aConvertedRecord = "SPICE,123,23/7/2011,11:30,2.0";
		SpiceConverter	aSpiceConverter = new SpiceConverter();
		
		Assert.assertEquals(aConvertedRecord, aSpiceConverter.convert(aRecord));
		
	}
	@Test
	public void writeRecordToFile()
	{
		SpiceConverter	aSpiceConverter = new SpiceConverter();
		String aRecord = "SPICE 123 23/7/2011 11:30 2 DELHI DELHI 50 100";
		try{
		aSpiceConverter.writeRecordToFile(aRecord);
		}catch(IOException ioException)
		{
			Assert.fail("Unable to write record");
		}
		Assert.assertTrue(true);
	}
}
