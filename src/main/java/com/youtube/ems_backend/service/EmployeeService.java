package com.youtube.ems_backend.service;

import java.util.List;

import com.youtube.ems_backend.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	EmployeeDto findEmployeeById(Long employeeId);
	
	List<EmployeeDto> getAllEmployees();
	
	EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto);
	
	void deleteEmployeeById(Long employeeId);
}
