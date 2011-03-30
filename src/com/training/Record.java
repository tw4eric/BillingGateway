package com.training;

import java.util.Date;

public class Record {
	private String source;
	private String custID;
	private int  callDuration;
	private Date calldate;
	private double cost;

	public int getCallDuration() {
		return callDuration;
	}
	public Date getCalldate() {
		return calldate;
	}
	public double getCost() {
		return cost;
	}
}
