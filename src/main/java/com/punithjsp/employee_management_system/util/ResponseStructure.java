package com.punithjsp.employee_management_system.util;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ResponseStructure<T> {

	private String msg;
	private T data;
	private LocalDateTime localDateTime=LocalDateTime.now();
	private int statusCode;
}
