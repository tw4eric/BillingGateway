package com.training.billing;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

//Common format - source,customerId,date,time,billingCost(Rs)
//AIRTEL,123,23/7/2011,11:30,15
//VODAFONE,123,23/7/2011,11:30,15
//SPICE,123,23/7/2011,11:30,15

public class CustomerBillTest {

	@Test
	public void ReturnCustomerBillWhenCustomerIdIs1256AndBillingCostis25() {
		CommonFormatService	mockCommonFormatService = Mockito.mock(CommonFormatService.class);
		CustomerBill customerBill = new CustomerBill(1256,"CommonFormat.txt", mockCommonFormatService);
		
		customerBill.doesFileExist();
		Mockito.verify(mockCommonFormatService).doesFileExist();	
	}
}
