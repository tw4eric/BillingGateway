package com.training;

import java.util.Date;
import java.util.HashMap;

public abstract class TelecomOperator {
	Operator operator;
	HashMap<Date, DailyInfo> myDailyInfo;
	
	public void addRecord(Record aRecord){
		if ( myDailyInfo.containsKey(aRecord.getCalldate()))
			myDailyInfo.get(aRecord.getCalldate()).update(aRecord.getCallDuration(), aRecord.getCost());
		else
			myDailyInfo.put(aRecord.getCalldate(), new DailyInfo(aRecord.getCallDuration(), aRecord.getCost()));
	}
}
