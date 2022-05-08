package com.neelu.service.impl;

import com.neelu.service.LoginService;

public class LoginServiceImp implements LoginService {

	public boolean isValidUser(String name, String password) {

		return name.equals("riyaz") && password.equals("riyaz");
	}


	
	

}
