package com.training;

import java.io.*;

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
            while ((aLine = fileReader.readLine()) != null) {
                String[] words = aLine.split("\\s+");

                // Common format - source:customerId:date:time:billingCost(Rs)
                // AIRTEL,123,23/7/2011,11:30,15

                // Airtel format - customerId date time source callduration(secs) isHomeLocation homeRate(Rs) visitorRate(Rs)
                //  123 23/7/2011 11:30 airtel  30 true .5 2

                double callCost = 0;
                if (words[3].equals("airtel")) {
                    if (Boolean.parseBoolean(words[5]) == true) {
                        callCost = Double.parseDouble(words[4]) * Double.parseDouble(words[6]);
                    } else {
                        callCost = Double.parseDouble(words[4]) * Double.parseDouble(words[7]);
                    }

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