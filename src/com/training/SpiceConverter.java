package com.training;

public class SpiceConverter
{
	private String mySpiceLine, myCommonLine;
	
	private String Source;
	private String custID;
	private String City;
	private int Minutes;
	private boolean isHome;
	private int homeRate;
	private int visitorRate;
	private String Date;
	private String Time;
	private double callRate;
	
	public String getCustID() {
		return custID;
	}

	public String getCity() {
		return City;
	}

	public int getMinutes() {
		return Minutes;
	}

	public boolean getIsHome() {
		return isHome;
	}

	public int getHomeRate() {
		return homeRate;
	}

	public int getVisitorRate() {
		return visitorRate;
	}

	public String getDate() {
		return Date;
	}

	public String getTime() {
		return Time;
	}


	
	public SpiceConverter()
	{
		mySpiceLine = "";
		myCommonLine = "";
	}
	
	public String convert(String aSpiceLine)
	{
		mySpiceLine = aSpiceLine;
		if (mySpiceLine != null) 
		{
            String[] words = mySpiceLine.split("\\s+");
            assignRecordValues(words);
            calculateCallRate();
        }
		
        // Common format - source:customerId:date:time:billingCost(Rs)
        // SPICE,123,23/7/2011,11:30,15

        // Spice format - source custID city callduration(min) isHome homeRate(p) visitorRate(p) date Time
        // spice 123 delhi 30 true 50 200 23/7/2011 11:30
		
		
		return "";
	}

	private void calculateCallRate() {
		if(isHome)
		{
			callRate = (homeRate * Minutes)/100;
		}
		else
		{
			callRate = (visitorRate * Minutes)/100;
		}
		
	}

	private void assignRecordValues(String[] Words) {
		Source = Words[0];
		custID = Words[1];
		City = Words[2];
		Minutes = Integer.parseInt(Words[3]);
		isHome = Boolean.parseBoolean(Words[4]);
		homeRate = Integer.parseInt(Words[5]);
		visitorRate = Integer.parseInt(Words[6]);
		Date = Words[7];
		Time = Words[8];
	}

	public String getSource() {
		// TODO Auto-generated method stub
		return Source;
	}

	public double getCallRate() {
		
		return callRate;
	}
}
