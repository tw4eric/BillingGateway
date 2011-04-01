package com.training;

import java.io.*;

// File has monthly data

// Common format - source,customerId,date,time,billingCost(Rs)
// AIRTEL,123,23/7/2011,11:30,15
// VODAFONE,123,23/7/2011,11:30,15
// SPICE,123,23/7/2011,11:30,15

// PAIR 1 (refactor) -> Airtel format - source customerId date time callduration(secs) isHomeLocation homeRate(Rs) visitorRate(Rs)
//  airtel  123 23/7/2011 11:30 30 true .5 2
// first step is to use a factory to return AirtelConverter or VodafoneConverter. move funct. to AirtelConverter
// second step is to have mock tests and introduce abstract for file operation

// PAIR 2 (write a new file parser to convert) -> Vodafone format - source customerId date time callduration(mins) 
//  vodafone 123 23/7/2011 11:30  30 
// fixed price of 50 paise per min
// VodafoneConverter (takes a string). You can ask it to return data in the common record.

// PAIR 3 (write a new file parser to convert) -> Spice format - source,customerId,date,time,callduration(mins),homecity,citycallwasmadein,homerate (paise),visitorRate(paise) 
//  spice,123,23/7/2011,11:30,30,1,Mumbai,Mumbai,.5,2 
// SpiceConverter (takes a string). You can ask it to return data in the common record.

// PAIR 4 -> Reports. Create API that returns monthly revenue for a operator
// Have a OperatorReport class that has a method revenue(). It reads from file (in common format) and returns the total revenue.

// PAIR 5 -> Customer monthly bill. Create an api that returns total billamount for a customer.
// Have a CustomerBill class that has a method revenue(customerId). It reads from file (in common format) and returns the total bill.

// PAIR 6 -> 
public class Converter {

	// Convert to Common format
    public void convert(String inputFileName, String outputFileName) throws IOException {
        BufferedReader fileReader = null;
        BufferedWriter fileWriter = null;
        try {
        	// open the files
            fileReader = new BufferedReader(new FileReader(inputFileName));
            fileWriter = new BufferedWriter(new FileWriter(outputFileName));

            String aLine;
            // parse the file
            while ((aLine = fileReader.readLine()) != null) {
                String[] words = aLine.split("\\s+");
                
                double callCost = 0;
                // For airtel do the conversion
                if (words[3].equals("airtel")) {
                    if (Boolean.parseBoolean(words[5]) == true) {
                        callCost = Double.parseDouble(words[4]) * Double.parseDouble(words[6]);
                    } else {
                        callCost = Double.parseDouble(words[4]) * Double.parseDouble(words[7]);
                    }

                    // write to the file
                    fileWriter.write("AIRTEL" + "," + words[0] + "," + words[1] + "," + words[2] + "," + callCost + "\n");
                }
            }
        } finally {
        	// close the files
            if (fileWriter != null) {
                fileWriter.close();
            }
            if (fileReader != null) {
                fileReader.close();
            }
        }


    }
}