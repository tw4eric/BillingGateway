package com.training;

import java.util.Date;
import java.util.HashMap;

public class OperatorAirtel extends TelecomOperator{
	
	public OperatorAirtel() {
		this.operator = Operator.AIRTEL;
		myDailyInfo = new HashMap<Date, DailyInfo>();
	}
	
}
