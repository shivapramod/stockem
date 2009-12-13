package com.stockem.modules;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.stockem.data.retrieve.PropertiesReader;
import com.stockem.provider.AppPropertiesProvider;

public class AppPropertiesModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(PropertiesReader.class).toProvider(AppPropertiesProvider.class);
	}

}
