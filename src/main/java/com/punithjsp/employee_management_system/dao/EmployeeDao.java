package com.punithjsp.employee_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.punithjsp.employee_management_system.dto.Employee;
import com.punithjsp.employee_management_system.repository.EmployeeRepo;

@Repository
public class EmployeeDao{
	@Autowired
	private EmployeeRepo repo;

	public Employee register(Employee employee) {
		return repo.save(employee);
	}

	public Employee selectEmployee(int eid) {
		Optional<Employee> employee = repo.findById(eid);
		if (employee.isPresent()) {
			return employee.get();
		} else
			return null;
	}

	public Employee updateEmployee(Employee employee) {
		Optional<Employee> emp = repo.findById(employee.getEid());
		if (emp.isPresent()) {
			return repo.save(employee);
		} else
			return null;
	}

	public Employee deleteEmployee(int eid) {
		Optional<Employee> emp = repo.findById(eid);
		if (emp.isPresent()) {
			repo.deleteById(eid);
			return emp.get();
		}
		return null;
	}
	public List<Employee> selectAllEmployees(){
		List<Employee> empList=repo.findAll();
		if(!empList.isEmpty()) {
			return empList;
		}
		else {
			return null;
		}
	}
	
	public Employee loginEmployee(String email, String pw) {
		Employee employee=repo.findByEmail(email);
		if(employee!=null) {
			return employee;
		}
		else {
			return null;
		}
		
	}
	
	public long sendOtp(int eid) {
		Optional<Employee> employee=repo.findById(eid);
		return employee.get().getContact();
	}
}
