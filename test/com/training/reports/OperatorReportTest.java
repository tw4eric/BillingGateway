package com.training.reports;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

//Common format - source,customerId,date,time,billingCost(Rs)
//AIRTEL,123,23/7/2011,11:30,15
//VODAFONE,123,23/7/2011,11:30,15
//SPICE,123,23/7/2011,11:30,15

public class OperatorReportTest {
	
	
	
	OperatorReport myOperatorReport = null;
	@Before
	public void init()
	{
		myOperatorReport = new OperatorReport();
	}
	
	@Test
	public void throwsExceptionIfFileDoesNotExist()
	{
		try {
			myOperatorReport.generateOperatorReport("","AIRTEL");
			Assert.fail("");
		} catch (Exception e) {
			
		}
		
	}
	
	@Test
	public void TotalAirtelRevenueIs170FromCommonFormat()
	{
		
	}

}
