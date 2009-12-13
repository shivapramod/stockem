package com.stockem.data.retrieve;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.stockem.Stockem;
import com.stockem.utils.Constants;

public class PropertiesReader {

	public static Properties appProps = new Properties();
	private static Logger log = Logger.getLogger(PropertiesReader.class);
	
	public  Properties readAppProperties()
	{		
		 try {
		    	appProps.load(new FileInputStream("properties/"+Constants.APP_PROPS));
		    }
		    catch(FileNotFoundException e)
		    {
		    	log.fatal("app.prop Not Found");
		    }
		    catch (IOException e) {
		    	log.fatal("IO Exception");
		    	
		    }
		    
		return appProps;
	}
}
