package com.punithjsp.employee_management_system.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.punithjsp.employee_management_system.dao.EmployeeDao;
import com.punithjsp.employee_management_system.dto.Employee;
import com.punithjsp.employee_management_system.exception.DataNotPresent;
import com.punithjsp.employee_management_system.exception.LoginException;
import com.punithjsp.employee_management_system.util.MyEmailService;
import com.punithjsp.employee_management_system.util.ResponseStructure;
import com.punithjsp.employee_management_system.util.ResponseStructureList;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao dao;
	@Autowired
	private MyEmailService emailService;
	ResponseStructure<Employee> structure = new ResponseStructure<Employee>();

	public ResponseEntity<ResponseStructure<Employee>> register(Employee employee) {
		structure.setMsg("Registered");
		structure.setData(dao.register(employee));
		structure.setStatusCode(HttpStatus.CREATED.value());
		emailService.sendMail(employee.getEmail());
		return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Employee>> selectEmployee(int eid) {
		Employee employee = dao.selectEmployee(eid);
		if (employee != null) {
			structure.setMsg("Data selected");
			structure.setData(dao.selectEmployee(eid));
			structure.setStatusCode(HttpStatus.FOUND.value());
			emailService.sendMail(employee.getEmail());
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.FOUND);
		} else
			throw new DataNotPresent();
	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(Employee employee) {
		Employee emp = dao.updateEmployee(employee);
		if (emp != null) {
			structure.setMsg("Updated");
			structure.setData(emp);
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
//			emailService.sendMail(employee.getEmail());
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.ACCEPTED);
		} else
			throw new DataNotPresent();
	}

	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(int eid) {
		Employee empdb = dao.deleteEmployee(eid);
		if (empdb != null) {
			structure.setMsg("Displayed Data deleted");
			structure.setData(dao.deleteEmployee(eid));
			structure.setStatusCode(HttpStatus.GONE.value());
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.GONE);
		} else {
			throw new DataNotPresent("Data not present");
		}
	}

	public ResponseEntity<ResponseStructureList<Employee>> selectAllEmployee() {
		ResponseStructureList<Employee> structure=new ResponseStructureList<Employee>();
		List<Employee> empList = dao.selectAllEmployees();
		if (!empList.isEmpty()) {
			structure.setMsg("Data displayed");
			structure.setLdata(empList);
			structure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructureList<Employee>>(structure, HttpStatus.FOUND);
		} else {
			throw new DataNotPresent("Data not present");
		}

	}

	public ResponseEntity<ResponseStructure<Employee>> updateImg(int eid,MultipartFile file) throws IOException {
		Employee employee = dao.selectEmployee(eid);
		if (employee.getImg() == null || employee.getImg() != null) {
			employee.setEid(eid);
			employee.setImg(file.getBytes());
			structure.setData(dao.updateEmployee(employee));
			structure.setMsg("Image uploaded");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.ACCEPTED);
		} else {
			throw new DataNotPresent("Data not present");
		}
	}
	public ResponseEntity<byte[]> getImg(int eid) {
		Employee employee = dao.selectEmployee(eid);
		if(employee!=null) {
			byte[] img=employee.getImg();
			HttpHeaders headers=new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_PNG);
			
			return new ResponseEntity<byte[]>(img,headers,HttpStatus.FOUND);
		}
		else {
			throw new DataNotPresent();
		}
		
	}
	public ResponseEntity<ResponseStructure<Employee>> changeImg(int eid,MultipartFile file) throws IOException {
		Employee employee = dao.selectEmployee(eid);
		System.out.println(file.getSize());
		if (employee.getImg() != null) {
			employee.setEid(eid);
			employee.setImg(file.getBytes());
			structure.setData(dao.updateEmployee(employee));
			structure.setMsg("Image uploaded");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.ACCEPTED);
		} else {
			throw new DataNotPresent("Data not present");
		}
	}

	public ResponseEntity<ResponseStructure<Employee>> loginEmployee(String email, String pw) {
		Employee employee=dao.loginEmployee(email, pw);
		if(employee!=null) {
			if(employee.getPassword().equals(pw)) {
				structure.setMsg("login successfully");
				structure.setData(dao.loginEmployee(email,pw));
				structure.setStatusCode(HttpStatus.CREATED.value());
				return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.CREATED);
			}
			else {
				throw new LoginException("Incorrect password");
			}
		}
		else {
			throw new LoginException("Incorrect email");
		}
	}

	public ResponseEntity<ResponseStructure<Employee>> sendOtp(int eid) {
		long phnoe=dao.sendOtp(eid);
		
		return null;
	}
}
