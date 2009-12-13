package com.stockem.data.retrieve;

import java.util.Properties;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.stockem.modules.AppPropertiesModule;
import com.stockem.services.AuthenticateUsersService;
import com.stockem.utils.Constants;
import com.stockem.utils.Constants.Environment;

public class UsersReader extends  AuthenticateUsersService{

	@Override
	public String getUserFile() {
		String environment = getEnvironment();
		if(Environment.DEV.toString().equalsIgnoreCase(environment))
		{
			return Constants.AUTHENTICATOR;
		}
		else if(Environment.STAGE.toString().equalsIgnoreCase(environment))
		{
			return Constants.AUTHENTICATOR;
		}
		else if(Environment.PROD.toString().equalsIgnoreCase(environment))
		{
			return Constants.AUTHENTICATOR;
		}
		else
		{
			return Constants.AUTHENTICATOR;
		}
		
	}
	
	private Properties getAppProperties()
	{
		Injector injector = Guice.createInjector(new AppPropertiesModule());
		PropertiesReader pr = injector.getInstance(PropertiesReader.class);
		
		Properties  appProps = pr.readAppProperties();
		return appProps;
		
	}
	
	private String getEnvironment()
	{
		Properties appProps =  getAppProperties();
		String propEnviron = appProps.getProperty("environment", "PROD");
		return propEnviron;
	}

}
