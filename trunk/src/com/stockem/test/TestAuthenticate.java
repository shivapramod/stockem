package com.stockem.test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.stockem.modules.TXTReaderModule;
import com.stockem.services.ReaderService;

import junit.framework.TestCase;

import org.apache.log4j.PropertyConfigurator;

public class TestAuthenticate extends TestCase {

	public void testAuthenticated()
	{
		PropertyConfigurator.configure("log4j.xml");
		
		Injector injector = Guice.createInjector(new TXTReaderModule());
		ReaderService readerService = injector.getInstance(ReaderService.class);
		assertEquals(true, readerService.getData("kashi.stm").isDataValid());
	}
}
