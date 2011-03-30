package com.training;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class Record {
	private String source;
	private String custID;
	private int  callDuration;
	private Date calldate;
	private double cost;

	public Record(String source, String custID, String callDuration, String calldate, String callTime, double cost) throws ParseException {
		this.source = source;
		this.custID = custID;
		this.callDuration = Integer.parseInt(callDuration);
		this.calldate = DateFormat.getDateInstance().parse(calldate);
		this.cost = cost;
	}
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
