package com.punithjsp.employee_management_system.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.punithjsp.employee_management_system.dto.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	public Employee findByEmail(String email);
}
