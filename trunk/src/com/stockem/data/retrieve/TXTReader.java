package com.stockem.data.retrieve;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.stockem.app.actions.Authenticate;
import com.stockem.bean.Data;

import com.stockem.services.ReaderService;
import com.stockem.utils.Constants;

public class TXTReader extends ReaderService {

	private static Logger log = Logger.getLogger(TXTReader.class);
	
	@Override
	public Data getData(String fileName) {
		
		
		return retrieveData(fileName);
		//return null;
	}
	
	private Data retrieveData(String fileName) {
		
		File aFile = new File(fileName);
		
		String fileContents = readFile(aFile);
		
		log.trace(fileContents);
		
		Data d = new Data();
		d.setDataValid(true);
		return d;
	}
	
	private String readFile(File aFile) {
		StringBuilder contents = new StringBuilder();
	    
	    try {
	      //use buffering, reading one line at a time
	      //FileReader always assumes default encoding is OK!
	      BufferedReader input =  new BufferedReader(new FileReader(aFile));
	      try {
	        String line = null; //not declared within while loop
	        /*
	        * readLine is a bit quirky :
	        * it returns the content of a line MINUS the newline.
	        * it returns null only for the END of the stream.
	        * it returns an empty String if two newlines appear in a row.
	        */
	        while (( line = input.readLine()) != null){
	          contents.append(line);
	          contents.append("^");
	        }
	      }
	      finally {
	        input.close();
	      }
	    }
	    catch (IOException ex){
	      ex.printStackTrace();
	    }
	    
	    return contents.toString();
	}
}
