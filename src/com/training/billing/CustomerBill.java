package com.training.billing;


//PAIR 5 -> Customer monthly bill. Create an api that returns total billamount for a customer.
//Have a CustomerBill class that has a method revenue(customerId). It reads from file (in common format) and returns the total bill.

public class CustomerBill {

	CommonFormatService myMockCommonFormatService ;
	private String myCustomerId; 
	public CustomerBill(String CustomerId, String FilePath, CommonFormatService mockCommonFormatService) {
		// TODO Auto-generated constructor stub
		myMockCommonFormatService = mockCommonFormatService ; 
		myCustomerId = CustomerId;
	}
	
	public double CalculateBill()
	{
		String FileReadString;
		if(myMockCommonFormatService.doesFileExist())
		{
			FileReadString = myMockCommonFormatService.ReturnFile();
			String wordString[] = FileReadString.split(",");
			if(myCustomerId.equals(wordString[1]))
			{
				return Double.parseDouble(wordString[4]);
			}
		}
		return 0;
	}
	
	

}
