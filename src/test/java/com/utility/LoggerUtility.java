package com.utility;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {
	
	 private LoggerUtility() {
	        // Private constructor to prevent instantiation
	    }

	    public static Logger getLogger(Class<?> clazz) {
	        return LogManager.getLogger(clazz);
	    }
		
	




	
}
