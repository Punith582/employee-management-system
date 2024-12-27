package com.punithjsp.employee_management_system.exception;

public class LoginException extends RuntimeException{
	
	String s="Login un successfull";
	public LoginException() {
		
	}
	public LoginException(String s) {
		this.s=s;
	}
	
	@Override
	public String getMessage() {
		return s;
	}

}
