package com.cleaningmanagement.exception;

public class UsernameAndPasswordInvalid extends Exception {
    @Override
	public String getMessage() {
		return "UserName and PasssWord Invalid";
		
	}
}
