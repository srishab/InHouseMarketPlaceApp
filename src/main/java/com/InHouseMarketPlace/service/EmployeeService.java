package com.InHouseMarketPlace.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.InHouseMarketPlace.entity.Employee;
import com.InHouseMarketPlace.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private  EmployeeRepository employeeRepository;
	
	public ResponseEntity<?> addEmployee(Employee employee)
	{
		Employee e = employeeRepository.findByEmployeeId(employee.getEmpId());
		if(Objects.nonNull(e))
		{
			return new ResponseEntity("Employee already exists", HttpStatus.BAD_REQUEST);
		}
		 
		else
		{
			employeeRepository.save(employee);
			return new ResponseEntity("Employee with " +employee.getEmpId()+ " added",HttpStatus.OK);
		}
	}
	
	public ResponseEntity<?> editEmployee(Employee employee) 
	{
		//int a = employee.getEmpId();
		Employee e = employeeRepository.findByEmployeeId(employee.getEmpId());
		if(Objects.isNull(e))
		{
			return new ResponseEntity("No such Employee exists", HttpStatus.BAD_REQUEST);
		}
		else {
			
		     employeeRepository.save(employee);
		     return new ResponseEntity("Employee with " +employee.getEmpId()+ " updated",HttpStatus.OK);
		}

		
	}
	
	public Employee getEmployee(int empId) {
		return employeeRepository.findByEmployeeId(empId);
	}
	
}