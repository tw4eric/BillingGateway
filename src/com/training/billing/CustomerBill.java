package com.training.billing;


//PAIR 5 -> Customer monthly bill. Create an api that returns total billamount for a customer.
//Have a CustomerBill class that has a method revenue(customerId). It reads from file (in common format) and returns the total bill.

public class CustomerBill {

	CommonFormatService myMockCommonFormatService ; 
	public CustomerBill(int CustomerId, String FilePath, CommonFormatService mockCommonFormatService) {
		// TODO Auto-generated constructor stub
		myMockCommonFormatService = mockCommonFormatService ; 
	}
	
	public Boolean doesFileExist()
	{
		return myMockCommonFormatService.doesFileExist();
	}
	
	

}
