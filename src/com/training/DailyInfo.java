package com.training;

public class DailyInfo {
	
	int callDuration;
	double revenue;
	
	
	public DailyInfo(int callDuration, double cost) {
		this.callDuration = callDuration;
		this.revenue = callDuration * cost;
	}
	
	public void update(int aCallDuation, double cost){
		callDuration += aCallDuation;
		revenue += aCallDuation * cost;
	}

}
