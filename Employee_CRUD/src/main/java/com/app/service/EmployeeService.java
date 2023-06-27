package com.app.service;

import java.util.List;

import javax.validation.Valid;

import com.app.dto.EmployeeDTO;
import com.app.entities.Employee;

public interface EmployeeService {
	List<Employee> getEmpDetails();
	Employee saveEmployee(Employee emp);
	EmployeeDTO signUp(@Valid EmployeeDTO emp);
	EmployeeDTO update(EmployeeDTO emp);
	String deleteEmp(Long empId);
	Employee getEmpById(Long EmpId);
	
}
