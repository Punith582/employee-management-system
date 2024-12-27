package com.punithjsp.employee_management_system.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;
@Entity
@Data //for auto generated setter and getter
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	private String ename;
	private double sal;
	@Column(unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	private long contact;
	@Lob //large object
	@Column(columnDefinition = "longblob", length=999999999) //size
	private byte img[];
	
}
