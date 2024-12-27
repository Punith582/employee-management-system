package com.punithjsp.employee_management_system.exception;


public class DataNotPresent extends RuntimeException{
	
	String s="Data Not Present";

	public DataNotPresent() {
		
	}

	public DataNotPresent(String s) {
		this.s = s;
	}
	
	@Override
	public String getMessage() {
		return s;
	}
}
