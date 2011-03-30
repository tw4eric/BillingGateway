/**
 * *********************************************************************
 * <p/>
 * Copyright (c) 1999-2007 Ericsson AB, Sweden.
 * All rights reserved.
 * The Copyright to the computer program(s) herein is the property of
 * Ericsson AB, Sweden.
 * The program(s) may be used and/or copied with the written permission
 * from Ericsson AB or in accordance with the terms and conditions 
 * stipulated in the agreement/contract under which the program(s) 
 * have been supplied.
 * <p/>
 * ********************************************************************
 */

package com.training;
import java.util.Date;
/**
 * public class GenReport{ } 
 * TODO: Correct JavaDoc is missing!
 *
 * @author  euxyabd
 * @date    Mar 30, 2011       
 * JOB: 
 */
public interface GenReport
{
    public void revenueReport(Operator theOperator , Date from , Date To);
    public void callDurationReport();
    public void topOperator();
}

