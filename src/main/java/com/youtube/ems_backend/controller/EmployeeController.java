package com.youtube.ems_backend.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.youtube.ems_backend.dto.EmployeeDto;
import com.youtube.ems_backend.entity.Employee;
import com.youtube.ems_backend.service.EmployeeService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping( "/api/employees")
public class EmployeeController {

//	@Autowired
	private EmployeeService employeeService;
	
	// build Add Employee REST API
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
		
		 System.out.println("Received Employee: " + employeeDto);
		EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}
	// Build get Employeee REST API 
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
		EmployeeDto employeeDto = employeeService.findEmployeeById(employeeId);
		return ResponseEntity.ok(employeeDto);
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		List<EmployeeDto> employees =  employeeService.getAllEmployees();
		
		return ResponseEntity.ok(employees);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,@RequestBody EmployeeDto employeeDto){
		EmployeeDto updatedEmployeeDto=employeeService.updateEmployee(employeeId, employeeDto);
		return ResponseEntity.ok(updatedEmployeeDto);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity deleteEmployeeById(@PathVariable("id") Long employeeId){
		employeeService.deleteEmployeeById(employeeId);
		return ResponseEntity.ok("Employee deleted successfully");
	}
	
}
