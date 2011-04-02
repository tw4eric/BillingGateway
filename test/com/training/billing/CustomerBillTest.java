package com.training.billing;

import junit.framework.Assert;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

//Common format - source,customerId,date,time,billingCost(Rs)
//AIRTEL,123,23/7/2011,11:30,15
//VODAFONE,123,23/7/2011,11:30,15
//SPICE,123,23/7/2011,11:30,15

public class CustomerBillTest {

	@Test
	public void ReturnCustomerBillCheckFileExist() {
		CommonFormatService	mockCommonFormatService = Mockito.mock(CommonFormatService.class);
		CustomerBill customerBill = new CustomerBill("1256","CommonFormat.txt", mockCommonFormatService);		
		customerBill.CalculateBill();
		Mockito.verify(mockCommonFormatService).doesFileExist("CommonFormat.txt");	
	}
	
	@Test
	public void ReturnCustomerBillWhenCustomerIdIs1256AndBillingCostis25() {
		CommonFormatService	mockCommonFormatService = Mockito.mock(CommonFormatService.class);
		CustomerBill customerBill = new CustomerBill("1256","CommonFormat.txt", mockCommonFormatService);		
		Mockito.stub(mockCommonFormatService.doesFileExist("CommonFormat.txt")).toReturn(true);
		Mockito.stub(mockCommonFormatService.OpenFile("CommonFormat.txt")).toReturn(true);
		Mockito.stub(mockCommonFormatService.next()).toReturn("AIRTEL,1256,23/7/2011,11:30,25");
		
		Assert.assertEquals(25.0, customerBill.CalculateBill());
	}
	
	@Test
	public void ReturnCustomerBillWhenCustomerIdIs126AndBillingCostis75() {
		CommonFormatService	mockCommonFormatService = Mockito.mock(CommonFormatService.class);
		CustomerBill customerBill = new CustomerBill("126","CommonFormat.txt", mockCommonFormatService);
		Mockito.stub(mockCommonFormatService.doesFileExist("CommonFormat.txt")).toReturn(true);
		Mockito.stub(mockCommonFormatService.OpenFile("CommonFormat.txt")).toReturn(true);
		Mockito.stub(mockCommonFormatService.next()).toReturn(null);
		Mockito.stub(mockCommonFormatService.next()).toReturn("AIRTEL,125,23/7/2011,11:30,25");
		Mockito.stub(mockCommonFormatService.next()).toReturn("AIRTEL,126,23/7/2011,11:30,75");
		
		Assert.assertEquals(75.0, customerBill.CalculateBill());
	}
	
	
}
