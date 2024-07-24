package com.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main 
{
    public static void main( String[] args )
    {
//      Logger logger = LogManager.getLogger();
//		logger.error("this is an info message");
//		logger.fatal("asdf");
//		logger.info("this is actually an info message");
//		logger.trace("this will not show up");
//		
//		MyClass mc = new MyClass();
//		mc.myMethod();
		
		System.out.println(returnTaxableRate("100"));
		System.out.println(returnTaxableRate("10000.56"));
		System.out.println(returnTaxableRate("-100"));
		System.out.println(returnTaxableRate("0"));
		System.out.println(returnTaxableRate("100000000000"));
		System.out.println(returnTaxableRate("hello"));
		
    }
    
    public static double returnTaxableRate(String salaryString) {
    	
    	double salary = 0.0;
    	double taxableRate = 0.2;
    	Logger logger = LogManager.getLogger();
    	
    	try {
    		salary = Double.valueOf(salaryString);
    		
    		if (salary < 0) {
        		logger.error("ERROR - salary {} is negative", salaryString);
        	} else if (salary == 0) {
        		logger.warn("WARN - salary {} is zero", salaryString);
        	} else if (salary >= 1000000) {
        		logger.debug("DEBUG - salary {} >= 1,000,000", salaryString);
        	} else if (salary >= 1 && salary <= 500000) {
        		logger.info("INFO - salary {} between 1-500,000 - OK", salaryString);
        		return salary * taxableRate;
        	}
    		
    	} catch (NumberFormatException e) {
    		logger.fatal("FATAL - salary {} does not contain a number", salaryString);
    	}
		return salary;
	}
}
