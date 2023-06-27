package com.app.controller;

import java.net.http.HttpResponse;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.resource.HttpResource;

import com.app.dto.ApiResponse;
import com.app.dto.EmployeeDTO;
import com.app.entities.Employee;
import com.app.service.EmployeeService;

import io.swagger.v3.core.model.ApiDescription;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService empService;
	
	public EmployeeController() {
		System.out.println("in constr of "+getClass());
	}
	@GetMapping
	public List<Employee> getAllEmployee(){
		System.out.println("in method of "+getClass());
		return empService.getEmpDetails();
	}
//	@PostMapping
//	public ResponseEntity<?> saveEmpDetails(@RequestBody Employee transientEmp){
//		return new ResponseEntity<>(empService.saveEmployee(transientEmp),HttpStatus.CREATED);
//		
//	}
	@PostMapping("/signup")
	public EmployeeDTO signUp(@RequestBody @Valid EmployeeDTO emp) {
		return empService.signUp(emp);
		
	}
	@PutMapping
	public EmployeeDTO updateEmp(@RequestBody EmployeeDTO emp) {
		return empService.update(emp);
		
	}
	@DeleteMapping("/{empID}")
	public ApiResponse deleteEmp(@PathVariable Long empID) {
		return new ApiResponse(empService.deleteEmp(empID));	
	}
	@GetMapping("/{empID}")
	public Employee getEmpDetails(@PathVariable Long empID) {
		return empService.getEmpById(empID);
		
	}

}
