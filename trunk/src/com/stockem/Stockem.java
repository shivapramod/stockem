package com.stockem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.stockem.app.actions.Authenticate;

public class Stockem {
	
	public static Properties appProps = new Properties();
	private static Logger log = Logger.getLogger(Stockem.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		 
		    try {
		    	appProps.load(new FileInputStream("properties/app.prop"));
		    }
		    catch(FileNotFoundException e)
		    {
		    	log.fatal("app.prop Not Found");
		    }
		    catch (IOException e) {
		    	log.fatal("IO Exception");
		    	
		    }
	}

}
