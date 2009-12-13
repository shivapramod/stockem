package com.stockem.provider;

import com.google.inject.Provider;
import com.stockem.data.retrieve.PropertiesReader;

public class AppPropertiesProvider  implements Provider<PropertiesReader> {

	@Override
	public PropertiesReader get() {
		PropertiesReader propReader = new PropertiesReader();
		return propReader;
	}

}
