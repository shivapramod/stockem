package com.stockem.modules;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.stockem.data.retrieve.UsersReader;
import com.stockem.services.AuthenticateUsersService;

public class UsersModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(AuthenticateUsersService.class).to(UsersReader.class);
	}
}
