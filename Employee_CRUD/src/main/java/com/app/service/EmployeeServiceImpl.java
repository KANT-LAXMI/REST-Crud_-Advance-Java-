package com.app.service;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.EmployeeDTO;
import com.app.entities.Employee;
import com.app.repository.EmployeeRepository;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
	private EmployeeRepository empRepo;
    @Autowired
    private ModelMapper mapper;
	@Override
	public List<Employee> getEmpDetails() {
		
		return empRepo.findAll();
	}
	@Override
	public Employee saveEmployee(Employee emp) {
		
		return empRepo.save(emp);
	}
//	@Override
//	public EmployeeDTO signUP(@Valid EmployeeDTO emp) {
//		Employee employee=mapper.map(emp, Employee.class);
//		Employee persistentEntity=empRepo.save(employee);
//		return mapper.map(persistentEntity, EmployeeDTO.class);
//	}
	@Override
	public EmployeeDTO signUp(@Valid EmployeeDTO emp) {
		Employee employee = mapper.map(emp, Employee.class);
		return mapper.map(empRepo.save(employee), EmployeeDTO.class);
	}

	@Override
	public EmployeeDTO update(EmployeeDTO emp) {
		Employee employee = mapper.map(emp, Employee.class);
		return mapper.map(empRepo.save(employee), EmployeeDTO.class);
	}
	@Override
	public String deleteEmp(Long empId) {
		String mesg="deletion failed";
		if(empRepo.existsById(empId)) {
			empRepo.deleteById(empId);
			mesg="deletion successfully";
		}
		return mesg;
	}
	@Override
	public Employee getEmpById(Long EmpId) {
		
		return empRepo.findById(EmpId)
				.orElseThrow(()->new ResourceNotFoundException
						("Employee with such id does not exists"));
	}
		
	}
	
	


