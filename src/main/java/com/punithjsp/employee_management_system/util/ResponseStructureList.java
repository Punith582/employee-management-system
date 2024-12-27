package com.punithjsp.employee_management_system.util;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;


@Data
public class ResponseStructureList<T> {

	private String msg;
	private List<T> Ldata;
	private LocalDateTime localDateTime=LocalDateTime.now();
	private int statusCode;
}
