package com.stockem.app.actions;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.stockem.utils.Logging;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.stockem.data.retrieve.PropertiesReader;
import com.stockem.modules.AppPropertiesModule;
import com.stockem.modules.TXTReaderModule;
import com.stockem.modules.UsersModule;
import com.stockem.services.AuthenticateUsersService;
import com.stockem.services.ReaderService;

public class Authenticate {
	
	private static Logger log = Logger.getLogger(Authenticate.class);
	
	public boolean isAuthenticated()
	{
		ReaderService reader = getReaderService();
		log.trace("Authentication File = " + getUserDetailsFile());
		return reader.getData(getUserDetailsFile()).isDataValid();
	}
	
	private ReaderService getReaderService()
	{
		Injector injector = Guice.createInjector(new TXTReaderModule());
		ReaderService readerService = injector.getInstance(ReaderService.class);
		return readerService;
	}
	
	private String getUserDetailsFile()
	{
		Injector injector = Guice.createInjector(new UsersModule());
		AuthenticateUsersService authService = injector.getInstance(AuthenticateUsersService.class);		
		return authService.getUserFile();
	}
	
	public static void main(String[] args)
	{
		Authenticate at = new Authenticate();
		at.isAuthenticated();
		
	}
}
