package com.training.converters;

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
                if (words[0].equals("airtel")) {
                    if (Boolean.parseBoolean(words[5]) == true) {
                        callCost = Double.parseDouble(words[4]) * Double.parseDouble(words[6]);
                    } else {
                        callCost = Double.parseDouble(words[4]) * Double.parseDouble(words[7]);
                    }

                    // write to the file
                    fileWriter.write("AIRTEL" + "," + words[1] + "," + words[2] + "," + words[3] + "," + callCost + "\n");
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