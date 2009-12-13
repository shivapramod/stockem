package com.stockem.services;

import com.stockem.bean.Data;

public abstract class ReaderService {
	public abstract Data getData(String fileName);
}
