package com.punithjsp.employee_management_system.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.punithjsp.employee_management_system.exception.DataNotPresent;
import com.punithjsp.employee_management_system.exception.LoginException;
import com.punithjsp.employee_management_system.util.ResponseStructure;

@RestControllerAdvice
public class MyExceptionHandler {

	ResponseStructure<String> structure = new ResponseStructure<String>();

	@ExceptionHandler(DataNotPresent.class)
	public ResponseEntity<ResponseStructure<String>> dataNotPresent(DataNotPresent dataNotPresent) {
		structure.setMsg("Data Not Found");
		structure.setData(dataNotPresent.getMessage());
		structure.setStatusCode(HttpStatus.NOT_IMPLEMENTED.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_IMPLEMENTED);
	}
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<ResponseStructure<String>> loginException(LoginException loginException) {
		structure.setMsg("Login Un successfull");
		structure.setData(loginException.getMessage());
		structure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_ACCEPTABLE);
	}
	
	

}
