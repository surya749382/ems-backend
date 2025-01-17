package com.youtube.ems_backend.mapper;

import com.youtube.ems_backend.dto.EmployeeDto;
import com.youtube.ems_backend.entity.Employee;

public class EmployeeMapper {
	public static EmployeeDto mapToEmployeeDto(Employee employee) {
		return new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail()

		);
	}
	public static Employee mapToEmployee(EmployeeDto employeeDto) {
		return new Employee(
				//employeeDto.getId(), // we are not passing the id field from the postman and it will 
				//give null NullPointerException 
				employeeDto.getFirstName(),
				employeeDto.getLastName(),
				employeeDto.getEmail()
				);
	}


}
