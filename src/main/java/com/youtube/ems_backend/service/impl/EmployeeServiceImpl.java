package com.youtube.ems_backend.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youtube.ems_backend.dto.EmployeeDto;
import com.youtube.ems_backend.entity.Employee;
import com.youtube.ems_backend.exception.ResourceNotFoundException;
import com.youtube.ems_backend.mapper.EmployeeMapper;
import com.youtube.ems_backend.repository.EmployeeRepository;
import com.youtube.ems_backend.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service // this annotation make the spring bean for the EmployeeImpl class

@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Override
	@Transactional
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
//		System.out.println(employee);
		try {

			Employee savedEmployee = employeeRepository.save(employee);
			return EmployeeMapper.mapToEmployeeDto(savedEmployee);
		} catch (Exception e) {
			// Handle conflict resolution
			// throw new CustomException("The record has been modified by another user.
			// Please refresh and try again.");
			return null;
		}

	}

	@Override
	public EmployeeDto findEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee is not present with given id: " + employeeId));
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee with given id is not present : " + employeeId));
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setEmail(employeeDto.getEmail());
		Employee savedEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public void deleteEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee with given id is not present : " + employeeId));
		employeeRepository.delete(employee);

	}

}
