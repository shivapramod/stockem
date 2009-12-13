package com.stockem.utils;

import org.apache.log4j.Logger;

public class Logging {

	private static org.apache.log4j.Logger log;
	
	public static org.apache.log4j.Logger getLogger(Class className)
	{
		log = Logger.getLogger(className.getClass());
		return Logging.log;
	}
}
