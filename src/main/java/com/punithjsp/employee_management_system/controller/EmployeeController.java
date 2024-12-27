package com.punithjsp.employee_management_system.controller;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.punithjsp.employee_management_system.dto.Employee;
import com.punithjsp.employee_management_system.service.EmployeeService;
import com.punithjsp.employee_management_system.util.ResponseStructure;
import com.punithjsp.employee_management_system.util.ResponseStructureList;
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.PATCH})
@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@PostMapping("/register")
	public ResponseEntity<ResponseStructure<Employee>> register(@RequestBody Employee employee) {
		return service.register(employee);
	}
	@GetMapping("/select/{eid}")
	public ResponseEntity<ResponseStructure<Employee>> selectEmployee(@PathVariable int eid) {
		return service.selectEmployee(eid);
	}
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestBody Employee employee) {
		return service.updateEmployee(employee);
	}
	@GetMapping("/selectall")
	public ResponseEntity<ResponseStructureList<Employee>> selectAllEmployee() {
		return service.selectAllEmployee();
	}
	@PutMapping("/updateimg/{eid}")
	public ResponseEntity<ResponseStructure<Employee>> updateImg(@PathVariable int eid,@RequestBody MultipartFile img) throws IOException {
		return service.updateImg(eid, img);
	}
	@GetMapping("/getimg/{eid}")
	public ResponseEntity<byte[]> getImg(@PathVariable int eid) {
		return service.getImg(eid);
	}
	@PutMapping("/changeimg/{eid}")
	public ResponseEntity<ResponseStructure<Employee>> changeImg(@PathVariable int eid,@RequestBody MultipartFile img) throws IOException {
		return service.changeImg(eid, img);
	}
	@GetMapping("/login/{email}/{pw}")
	public ResponseEntity<ResponseStructure<Employee>> loginEmployee(@PathVariable String email,@PathVariable String pw) {
		return service.loginEmployee(email,pw);
	}
	@GetMapping("/loginotp/{eid}")
	public ResponseEntity<ResponseStructure<Employee>> sendOtp(int eid) {
		return null;
	}
	@DeleteMapping("/delete/{eid}")
	public ResponseEntity<ResponseStructure<Employee>> delete(@PathVariable int eid){
		return service.deleteEmployee(eid);
	}
}
