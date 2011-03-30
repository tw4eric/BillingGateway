package com.training;

public class DailyInfo {
	
	int callDuration;
	double revenue;
	
	
	public DailyInfo(int callDuation, double revenue) {
		this.callDuration = callDuation;
		this.revenue = revenue;
	}
	
	public void update(int aCallDuation, double aRevenue){
		callDuration += aCallDuation;
		revenue += aRevenue;
	}

}
