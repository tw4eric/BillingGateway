package com.training;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Understands how to verify a Converter
 * User: mujir
 * Date: 26/3/11
 * Time: 2:43 PM
 */
public class ConverterTest {
    @Test
    public void convertAirtelToCommonFormat() {
        try {
        	String currentPath = new java.io.File(".").getCanonicalPath();

            new Converter().convert( currentPath + "/AirtelInput.txt", currentPath + "/CommonFormat.txt");
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }
}
