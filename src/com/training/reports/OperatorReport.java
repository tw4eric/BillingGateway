package com.training.reports;

//PAIR 4 -> Reports. Create API that returns monthly revenue for a operator
//Have a OperatorReport class that has a method revenue(). It reads from file (in common format) and returns the total revenue.

public class OperatorReport {

	public double generateOperatorReport(String filePath, String string) {

		if(filePath == null || filePath.equals(""))
		{
			throw new IllegalArgumentException("file does not exist");
		}
		return 0.0;
	}

}
