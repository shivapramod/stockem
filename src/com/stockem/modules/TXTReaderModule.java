package com.stockem.modules;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.stockem.data.retrieve.TXTReader;
import com.stockem.services.ReaderService;

public class TXTReaderModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(ReaderService.class).to(TXTReader.class);
	}

}
